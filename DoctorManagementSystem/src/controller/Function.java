/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Doctor;

/**
 *
 * @author ASUS
 */
public class Function {

    DoctorInformation di = new DoctorInformation();

    public void createDoctor(ArrayList<Doctor> list) {
        System.out.println("-------Create Doctor---------");
        int id = di.getID(list);
        String name = di.getName();
        Date dob = di.getDateOfBirth();
        String spec = di.getSpecialization();
        int availability = di.getAvailability();
        String email = di.getEmail();
        String phone = di.getPhoneNumber();
        Doctor d = new Doctor(id, name, dob, spec, availability, email, phone);
        list.add(d);
    }
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

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

    public void editDoctor(ArrayList<Doctor> list) {
        System.out.print("Input the ID of the doctor you want to edit: ");
        int id = getInt(0, list.size());
        list.remove(getThePosOfTheID(list, id));
        String name = di.getName();
        Date dob = di.getDateOfBirth();
        String spec = di.getSpecialization();
        int availability = di.getAvailability();
        String email = di.getEmail();
        String phone = di.getPhoneNumber();
        Doctor d = new Doctor(id, name, dob, spec, availability, email, phone);
        list.add(d);
    }

    public int getThePosOfTheID(ArrayList<Doctor> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (id == list.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    public int getThePosOfTheName(ArrayList<Doctor> list, String name) {
        for (int i = 0; i < list.size(); i++) {
            if (name == list.get(i).getName()) {
                return i;
            }
        }
        return -1;
    }

    public void deleteDoctor(ArrayList<Doctor> list) {
        System.out.println("Input the ID of the doctor you want to delete: ");
        int id = getInt(1, list.size());
        delete(list, id);

    }
    public void delete(ArrayList<Doctor> list,int id){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == id){
                list.remove(i);
                return;
            }
        }
    }

    public void searchDoctor(ArrayList<Doctor> list) {
        System.out.println("-------Search----------");
        System.out.println("1.Search by ID");
        System.out.println("2.Search by Name");
        switch (getInt(1, 2)) {
            case 1:
                
                System.out.print("Input the ID you want to search: ");
        int id = getInt(1, list.size());
                System.out.println(searchByID(list, id));
        
                break;
            case 2:
                searchByName(list);
                break;
        }

    }
    public String searchByName(ArrayList<Doctor> list,String name) {
        
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().equals(name)){
                return list.get(i).toString();
            }
        }
        return null;
        
    }

    public String searchByID(ArrayList<Doctor> list,int id) {
        
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == id){
                return list.get(i).toString();
            }
        }
        return null;
        
    }
    public void showTheDoctorByID(int id,ArrayList<Doctor> list){
        System.out.println(list.get(getThePosOfTheID(list, id)).toString());
    }
    

    public void searchByName(ArrayList<Doctor> list) {
        System.out.print("Input the name you want to search: ");
        try {
            String name = in.readLine();
            for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().equals(name)){
                System.out.println(list.get(i).toString());
            }
        }
        } catch (IOException ex) {
            Logger.getLogger(Function.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String sortDoctor(ArrayList<Doctor> list) {
        Collections.sort(list);
        String result = "";
        for (Doctor doctor : list) {
            System.out.println(doctor.toString());
            result+= doctor.toString();
        }
        return result;
        
        
    }
    public String showAllDoctor(ArrayList<Doctor> list){
        String result = "";
        for (Doctor doctor : list) {
            result+= doctor.toString();
        }
        return result;
    }

    public void showTheDoctor(Doctor d) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("----------Information-----------");
        System.out.println("ID: " + d.getId());
        System.out.println("Name: " + d.getName());
        System.out.println("Date of Birth: " + sdf.format(d.getDateOfBirth()));
        System.out.println("Specialization: " + d.getSpecialization());
        System.out.println("Availability: " + d.getAvailability());
        System.out.println("Email: " + d.getEmail());
        System.out.println("Mobile: " + d.getMobile());
        
    }

    public void run(ArrayList<Doctor> list) {
        System.out.println("---------MENU-------------");
        System.out.println("1. Create a Doctor\n"
                + "2. Edit a Doctor Information\n"
                + "3. Delete a Doctor\n"
                + "4. Search doctor by ID and by Name\n"
                + "5. Sort doctor by DateOfBirth");
        System.out.println("6. Exit");
        System.out.print(">>Choose: ");
        switch(getInt(1, 6)){
            case 1: createDoctor(list);break;
            case 2: editDoctor(list);break;
            case 3: deleteDoctor(list);break;
            case 4: searchDoctor(list);break;
            case 5: sortDoctor(list);break;
            case 6: System.exit(0);
        }
    }
}
