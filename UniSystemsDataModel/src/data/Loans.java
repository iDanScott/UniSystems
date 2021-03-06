/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package data;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import loaning.Loan;

/**
 * Loans list wrapper class
 * @author Craig
 */
public class Loans extends Observed implements ISerialisable{
    private ArrayList<Loan> loanList;
    private static final Loans loans = new Loans();
    
    private Loans() { }
    
    /**
     * Gets the singleton instance of the loans wrapper.
     * @return the loans object.
     */
    public static Loans getInstance(){
        return loans;
    }   
    
    /**
     * Loads loans from disk
     * @return string displaying whether there was an error or if it succeeded.
     */
    public String loadFromDisk() {
        File objFile = new File("data//Loans.dat");
        try {
            objFile.createNewFile();
        } catch (IOException ex) {
            return ("error: " + ex.getMessage().toString());
        }
        if (objFile.exists() && objFile.canRead()) {
            try (ObjectInputStream objIn = new ObjectInputStream(
                  new BufferedInputStream(
                  new FileInputStream(objFile)))) {
                Object objData = objIn.readObject();
                ArrayList<Loan> newLoanList = (ArrayList)objData;
                if (newLoanList != null) {
                    loanList = newLoanList;
                    LoansObserver loansObserver = new LoansObserver();
                    for (Loan loan : loanList) {
                        loan.registerObserver(loansObserver);
                    }
                    this.registerObserver(loansObserver);
                }    
                return ("Successfully loaded " + getLoans().size() + " loans");
            } catch (Exception ex) {
                return("Data file could not be read " + ex.getMessage());
            }
        } else {
            return ("Data file could not be found");
        }
    }
    
    /**
     * Saves the Loans to disk
     * @return a string to say whether it succeeded or not.
     */
    @Override
    public String saveToDisk() {
        File objFile = new File("data//Loans.dat");
        try (ObjectOutputStream objOut = new ObjectOutputStream(
                new BufferedOutputStream(
                new FileOutputStream(objFile)))) {
            
            objOut.writeObject(loanList);
            
            return ("Successfully saved " + getLoans().size() + " loans");
        } catch (IOException ex) {
            return ("error: " + ex.getMessage());
        }
    }
    
    /**
     * Gets the array of loans.
     * @return Array list of loans.
     */
    public ArrayList<Loan> getLoans() {
        if (loanList == null) return new ArrayList<Loan>();
        ArrayList<Loan> temp = new ArrayList<Loan>();
        
        for (Loan loan : loanList) {
            temp.add(loan);
        }
        return temp;
    }
    
    /**
     * Adds a loan to list and then saves to disk.
     * @param loan loan to add.
     */
    public void addLoan(Loan loan) {
        if (loanList == null) {
            loanList = new ArrayList<Loan>();
        }
        loanList.add(loan);
        notifyObservers();
    }
    
    /**
     * Removes a loan from the list.
     * @param loan loan to remove.
     */
    public void removeLoan(Loan loan) {
        if (loanList == null) return;
        loanList.remove(loan);
        notifyObservers();
    }
}

