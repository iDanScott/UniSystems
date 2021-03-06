/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package loaning;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import car.Car;
import people.Staff;

/**
 * Long Loan class which holds the Long Term Loan information.
 * @author Craig Banyard, Daniel Scott, Najim Mazidi
 */
public class LongLoan extends Loan{
    private Date startDate;
    private Date endDate;
    
    /**
     * Constructor for a long loan object.
     * @param loaner staff member to loan the car.
     * @param car car to be loaned.
     * @param startDate start date of the loan.
     * @param endDate expected return date of the loan.
     */
    public LongLoan(Staff loaner, Car car, Date startDate, Date endDate){
        super(loaner, car);
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    /**
     * Gets the start date of the long term loan.
     * @return Date object
     */
    public Date getStartDate() {
        return startDate;
    }
    
    /**
     * Gets the end date of the long term loan.
     * @return Date object
     */
    public Date getEndDate() {
        return endDate;
    }
    
    /**
     * Gets the difference between the start and the end date of the loan.
     * @param unit The time units that you want from the calculation
     * @return TimeUnit object
     */
    public long getDuration(TimeUnit unit) {
        return unit.convert(endDate.getTime() - startDate.getTime(), TimeUnit.MILLISECONDS);
    }
}
