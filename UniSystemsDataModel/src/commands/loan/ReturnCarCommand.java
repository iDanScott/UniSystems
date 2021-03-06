/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands.loan;

import car.Car;
import command.interfaces.ICommandBehaviour;
import loaning.DayLoan;
import loaning.Loan;
import loaning.LongLoan;
import people.Administrator;

/**
 *
 * @author najimmazidi
 */
public class ReturnCarCommand implements ICommandBehaviour {
    
    private Administrator admin = null;
    private Car carToReturn = null;
    private Loan loan = null;

    
    public ReturnCarCommand(Administrator admin, Car car, Loan loan) {
        this.admin = admin;
        this.carToReturn = car;
        this.loan = loan;
        
    }
    /**
     * Do command called when action is done or redone
     * @return boolean to check if action was carried out
     */
    @Override
    public Boolean doCommand() {
        Boolean blnCompleted = false;
        if(this.isValid()){
            this.admin.returnCar(carToReturn, loan);
            blnCompleted = true;
        }
        return blnCompleted;
    }
    /**
     * Undo command called when action is being undone
     * @return boolean to check if action was carried out
     */
    @Override
    public Boolean undoCommand() {
        Boolean blnCompleted = false;
        if(this.isValid()){
            try {
                DayLoan dayLoan = (DayLoan)loan;
                this.admin.assignDayLoan(carToReturn, admin);
            } catch (Exception ex) {}
            try {
                LongLoan longLoan = (LongLoan)loan;
                this.admin.assignLongLoan(carToReturn, admin);
            } catch (Exception ex) {}
            
            blnCompleted = true;
        }
        return blnCompleted;
    }
    /**
     * Checks if operation is allowed to be done 
     * @return Boolean to check if is valid 
     */
    public Boolean isValid(){
        Boolean blnValid = false;
        if(null != this.carToReturn){ 
            blnValid = true;
        }
        return blnValid;
    }
    
    
}
