/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package unisystems.people;

/**
 *
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class Address {
    
    private String lineOne;
    private String lineTwo;
    private String city;
    private String county;
    private String postCode;
    
    public String getAddressString() {
        
        String address = lineOne;
        address += ", ";
        address += lineTwo;
        address += ", ";
        address += city;
        address += ", ";
        address += county;
        address += ", ";
        address += postCode;
        
        return address;
    }
}
