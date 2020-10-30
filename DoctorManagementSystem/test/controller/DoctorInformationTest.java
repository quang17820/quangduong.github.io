/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Doctor;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ASUS
 */
public class DoctorInformationTest {
    DoctorInformation d;
    public DoctorInformationTest() {
       d = new DoctorInformation();
    }

    @Test
    public void testGetID() {
        ArrayList<Doctor> list = new ArrayList<>();
        int expected = 1;
        int result = d.getID(list);
        assertEquals(expected, result);
    }
    
    

}