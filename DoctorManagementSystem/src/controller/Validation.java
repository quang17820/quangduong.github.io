/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Validation {

    public boolean checkName(String text) {
        if (!Character.isUpperCase(text.charAt(0))) {
            return false;
        }

        for (int i = 0; i < text.length(); i++) {
            if (!Character.isLetter(text.charAt(i))) {
                return false;
            }
        }
        return !(text.length() < 2 || text.length() > 50);
    }

    public boolean checkDateOfBirthFormat(String text) {
        if (text.length() != 10) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date testDate = null;

        // we will now try to parse the string into date form
        try {
            testDate = sdf.parse(text);
        } // if the format of the string provided doesn't match the format we
        // declared in SimpleDateFormat() we will get an exception
        catch (ParseException e) {
            return false;
        }

        // dateformat.parse will accept any date as long as it's in the format
        // you defined, it simply rolls dates over, for example, december 32
        // becomes jan 1 and december 0 becomes november 30
        // This statement will make sure that once the string
        // has been checked for proper formatting that the date is still the
        // date that was entered, if it's not, we assume that the date is
        // invalid
        if (!sdf.format(testDate).equals(text)) {
            return false;
        }

        // if we make it to here without getting an error it is assumed that
        // the date was a valid one and that it's in the proper format
        return true;

    }

  

    public boolean checkSpecialization(String text) {
        if (!Character.isUpperCase(text.charAt(0))) {
            return false;
        }

        return !(text.length() < 10 || text.length() > 255);
    }

    public boolean checkEmailFormat(String text) {
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        return text.matches(EMAIL_PATTERN);
    }

    public boolean checkPhoneNumberFormat(String text) {

        return text.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}");
    }
}
