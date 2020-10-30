/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import model.Doctor;

/**
 *
 * @author ASUS
 */
public class DoctorInformation {

    Validation v = new Validation();
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public int getID(ArrayList<Doctor> list) {
        if (list.size() == 0) {
            return 1;
        } else {
            return (list.size() + 1);
        }
    }

    public String getName() {
        String name;
        while (true) {
            try {
                System.out.print("Input the name of the doctor : ");
                name = in.readLine();
                if (!v.checkName(name)) {
                    throw new Exception();
                }
                return name;
            } catch (Exception e) {
                System.out.println("Name is a string which is not longer than 50 characters.");
            }
        }
    }

    public Date getDateOfBirth() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dob;
        while (true) {
            try {
                System.out.print("Input Date Of Birth: ");
                String date = in.readLine();
                if (!v.checkDateOfBirthFormat(date)) {
                    throw new Exception();
                }
                dob = sdf.parse(date);
                return dob;

            } catch (Exception ex) {
                System.out.println("DateOfBirth is a string which conforms “dd/MM/yyyy” format.");
            }
        }
    }

    public String getSpecialization() {
        String spec;
        while (true) {
            try {
                System.out.print("Input the Specialization: ");
                spec = in.readLine();

                if (!v.checkSpecialization(spec)) {
                    throw new Exception();
                }
                return spec;
            } catch (Exception e) {
                System.out.println("Specialization is a string which is not longer than 255 characters.");
            }
        }
    }

    public int getInt(int min, int max) {
        int number;
        while (true) {
            try {

                number = Integer.parseInt(in.readLine());
                if (number < min || number > max) {
                    throw new NumberFormatException();
                }
                return number;
            } catch (Exception e) {
                System.out.println("Wrong input! >> Input again");
            }
        }
    }

    public int getAvailability() {

        System.out.println("Choose the Availability: ");
        System.out.println("0.In vacation");
        System.out.println("1.Available");
        System.out.println("2.Busy in emergency");
        System.out.println("3.Diagnosing");
        System.out.print(">> Availability: ");
        return  getInt(0, 3);
        
        

    }
    
    

    

    public String getEmail() {
        String email;
        while (true) {
            try {
                System.out.print("Input the email: ");
                email = in.readLine();
                if (!v.checkEmailFormat(email)) {
                    throw new Exception();
                }
                return email;
            } catch (Exception e) {
                System.out.println("Wrong input!");
            }
        }
    }

    public String getPhoneNumber() {
        String phone;
        while (true) {
            try {
                System.out.print("Input the phone number conforming (000)-000-0000 format: ");
                phone = in.readLine();
                if (!v.checkPhoneNumberFormat(phone)) {
                    throw new Exception();
                }
                return phone;
            } catch (Exception e) {
                System.out.println("Wrong format");
            }
        }
    }

}
