/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package loaning;

import car.Car;
import java.util.Date;
import people.Staff;

/**
 *
 * @author Craig Banyard, Daniel Scott Najim Mazidi
 */
public class Loan extends data.Observed implements java.io.Serializable{
    private Staff loaner;
    private Car car;
    private String loanNotes;
    private int fuelLevel;
    private Date returnedDate;
    private int milesDriven;

    public int getMilesDriven() {
        return milesDriven;
    }

    public void setMilesDriven(int milesDriven) {
        this.milesDriven = milesDriven;
    }
    
    public Loan(Staff loaner, Car car){
        this.loaner = loaner;
        this.car = car;
    }
    
    public String getLoanNotes() {
        return this.loanNotes;
    }
    
    public void setLoanNotes(String notes) {
        this.loanNotes = notes;
        this.notifyObservers();
    }
    
    public int getFuelLevel() {
        return this.fuelLevel;
    }
    
    public Staff getLoaner() {
        return loaner;
    }
    
    public Car getCar() {
        return car;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
        this.notifyObservers();
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
        this.notifyObservers();
    }
}
