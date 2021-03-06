/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package people;

import java.util.Date;
import car.Car;

/**
 *
 * @author Craig Banyard, Daniel Scott, Najim Mazidi
 */
public class Staff extends Person {
    protected String staffRefNumb;
    protected Position position;
    protected Faculty faculty;
    protected String officeRoom;
    protected String workNumb;
    protected Address address;
    
    /**
     * Default constructor of a staff member
     */
    public Staff() {
        super();
        this.staffRefNumb = "UNKNOWN";
        this.position = null;
        this.faculty = null;
        this.officeRoom = "UNKNOWN";
        this.workNumb = "UNKNOWN";
        this.address = null;
    }
    
    /**
     * Constructor for a Staff Object
     * @param staffRefNumb the reference number of the staff member
     * @param position the position of the staff member
     * @param faculty the faculty of the staff member
     * @param officeRoom the office room of the staff member
     * @param workNumb the work number of the staff member
     * @param address the address of the staff member
     * @param title the title of the staff member
     * @param forename the forename of the staff member
     * @param surname the surname of the staff member
     * @param dateOfBirth the date of birth of the staff member
     * @param gender the gender of the staff member
     * @param phoneNumber the phone number of the staff member
     * @param emailAddress the email address of the staff member.
     */
    public Staff(String staffRefNumb, Position position, Faculty faculty, 
                 String officeRoom, String workNumb, Address address, 
                 String title, String forename, String surname, 
                 Date dateOfBirth, String gender, String phoneNumber, 
                 String emailAddress) {
        super(title, forename, surname, dateOfBirth, gender, phoneNumber, emailAddress);
        this.staffRefNumb = staffRefNumb;
        this.position = position;
        this.faculty = faculty;
        this.officeRoom = officeRoom;
        this.workNumb = workNumb;
        this.address = address;
    }

    /**
     * Gets the reference number of the staff object.
     * @return String
     */
    public String getRefNumb() {
        return staffRefNumb;
    }

    /* Staff reference number should never change once creared - Dan
    public void setStaffRefNumb(String staffRefNumb) {
        this.staffRefNumb = staffRefNumb;
    }*/

    /**
     * Gets the position of the staff member
     * @return Position enum
     */
    public Position getPosition() {
        return position;
    }
    
    /**
     * Sets the position of the staff member and notifies observers.
     * @param position position of the staff member.
     */
    public void setPosition(Position position) {
        this.position = position;
        this.notifyObservers();
    }

    /**
     * Gets the faculty of the staff member.
     * @return Faculty enum.
     */
    public Faculty getFaculty() {
        return faculty;
    }

    /**
     * Sets the faculty of the staff member.
     * @param faculty faculty of the staff member.
     */
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
        this.notifyObservers();
    }

    /**
     * Gets the office room of the staff member
     * @return String 
     */
    public String getOfficeRoom() {
        return officeRoom;
    }

    /**
     * Sets the office room of the staff member.
     * @param officeRoom office room of the staff member.
     */
    public void setOfficeRoom(String officeRoom) {
        this.officeRoom = officeRoom;
        this.notifyObservers();
    }

    /**
     * Gets the work number of the staff member
     * @return String
     */
    public String getWorkNumb() {
        return workNumb;
    }

    /**
     * Sets the work number of the staff member.
     * @param workNumb work number of the staff member.
     */
    public void setWorkNumb(String workNumb) {
        this.workNumb = workNumb;
        this.notifyObservers();
    }

    /**
     * Gets the address of the staff member
     * @return Address object.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the address of the staff member.
     * @param address the address of the staff member.
     */
    public void setAddress(Address address) {
        this.address = address;
        this.notifyObservers();
    }
}
