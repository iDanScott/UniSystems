/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import data.Loans;
/**
 * Loans wrapper class
 * @author Craig Banyard, Daniel Scott, Najim Mazidi
 */
public class LoansObserver implements IObserver {
    private Loans loans = Loans.getInstance();
    public LoansObserver() { }
    
    /**
     * Saves the loans to disk.
     */
    @Override 
    public void update() {
        System.out.println(loans.saveToDisk());
    }
}
