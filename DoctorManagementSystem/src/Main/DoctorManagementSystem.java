/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import controller.Function;
import java.util.ArrayList;
import model.Doctor;

/**
 *
 * @author ASUS
 */
public class DoctorManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Doctor> list = new ArrayList<>();
        Function f = new Function();
        while (true) {            
            f.run(list);
        }
        
    }
    
}
