/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.corba.se.pept.encoding.OutputObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Doctor;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ASUS
 */
public class FunctionTest {

    Function f;
    SimpleDateFormat sdf;

    public FunctionTest() {
        f = new Function();
        sdf = new SimpleDateFormat("dd/MM/yyyy");
    }

    @Test
    public void testSearchByID() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Doctor> list = new ArrayList<>();
        list.add(new Doctor(1, "Quang", sdf.parse("17/08/2000"), "fwqerqewrwqe", 0, "minhquang.17820@gmail.com", "(000)-000-0000"));
        int id = 1;
        String expected = "Doctor{" + "id=" + "1" + ", name=" + "Quang" + ", dateOfBirth=" + "17/08/2000" + ", specialization=" + "fwqerqewrwqe" + ", availability=" + "0" + ", email=" + "minhquang.17820@gmail.com" + ", mobile=" + "(000)-000-0000" + '}';
        String result = f.searchByID(list, id);
        assertEquals(expected, result);
    }

    @Test
    public void testSortDoctor() {
        ArrayList<Doctor> list = new ArrayList<>();
        try {
            list.add(new Doctor(1, "quang", sdf.parse("22/2/2222"), "qrqwer", 0, "quang178@gmail.com", "(000)-000-0000"));
            list.add(new Doctor(2, "nam", sdf.parse("11/1/1111"), "qrqwer", 0, "quang178@gmail.com", "(000)-000-0000"));
            list.add(new Doctor(3, "hiep", sdf.parse("30/3/3333"), "qrqwer", 0, "quang178@gmail.com", "(000)-000-0000"));
            String result = f.sortDoctor(list);
            String expected = "Doctor{id=2, name=nam, dateOfBirth=11/01/1111, specialization=qrqwer, availability=0, email=quang178@gmail.com, mobile=(000)-000-0000}"
                    + "Doctor{id=1, name=quang, dateOfBirth=22/02/2222, specialization=qrqwer, availability=0, email=quang178@gmail.com, mobile=(000)-000-0000}"
                    + "Doctor{id=3, name=hiep, dateOfBirth=30/03/3333, specialization=qrqwer, availability=0, email=quang178@gmail.com, mobile=(000)-000-0000}";
            assertEquals(expected, result );
        } catch (ParseException ex) {
            Logger.getLogger(FunctionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Test
    public void testDeleteDoctor(){
        ArrayList<Doctor> list = new ArrayList<>();
        try {
            list.add(new Doctor(1, "quang", sdf.parse("22/2/2222"), "qrqwer", 0, "quang178@gmail.com", "(000)-000-0000"));
            list.add(new Doctor(2, "nam", sdf.parse("11/1/1111"), "qrqwer", 0, "quang178@gmail.com", "(000)-000-0000"));
            list.add(new Doctor(3, "hiep", sdf.parse("30/3/3333"), "qrqwer", 0, "quang178@gmail.com", "(000)-000-0000"));
            f.delete(list, 3);
            String result = f.showAllDoctor(list);
            String expected = 
                     "Doctor{id=1, name=quang, dateOfBirth=22/02/2222, specialization=qrqwer, availability=0, email=quang178@gmail.com, mobile=(000)-000-0000}"+"Doctor{id=2, name=nam, dateOfBirth=11/01/1111, specialization=qrqwer, availability=0, email=quang178@gmail.com, mobile=(000)-000-0000}";
                   
            assertEquals(expected, result );
        } catch (ParseException ex) {
            Logger.getLogger(FunctionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Test
    public void testSearchDoctorByName(){
        ArrayList<Doctor> list = new ArrayList<>();
        try {
            list.add(new Doctor(1, "quang", sdf.parse("22/2/2222"), "qrqwer", 0, "quang178@gmail.com", "(000)-000-0000"));
            list.add(new Doctor(2, "nam", sdf.parse("11/1/1111"), "qrqwer", 0, "quang178@gmail.com", "(000)-000-0000"));
            list.add(new Doctor(3, "hiep", sdf.parse("30/3/3333"), "qrqwer", 0, "quang178@gmail.com", "(000)-000-0000"));
            
            String result = f.searchByName(list, "quang");
            String expected = 
                     "Doctor{id=1, name=quang, dateOfBirth=22/02/2222, specialization=qrqwer, availability=0, email=quang178@gmail.com, mobile=(000)-000-0000}";
                   
            assertEquals(expected, result );
        } catch (ParseException ex) {
            Logger.getLogger(FunctionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Test
    public void testGetAvailbility(){
        Scanner keyboard = new Scanner(System.in);
        
    }
    

}
