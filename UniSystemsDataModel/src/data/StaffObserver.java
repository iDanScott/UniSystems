/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import data.StaffMembers;

/**
 *
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class StaffObserver implements IObserver {
    StaffMembers staffMembers = StaffMembers.getInstance();
    public StaffObserver() {
        System.out.println(staffMembers.loadFromDisk());
    }
    
    @Override
    public void update() {
        System.out.println(staffMembers.saveToDisk());
    }
}
