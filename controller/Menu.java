package controller;

import java.util.Map;

import model.Doctor;
import model.DoctorData;
import view.View;

public class Menu {
    private DoctorData model = new DoctorData();
    private View view;

    public Menu(View view) {
        this.model = new DoctorData();
        this.view = view;
    }

    public void run() {
        while (true) {
            int choice = view.getChoice();
            switch (choice) {
                case 1:
                    addDoctor();
                    break;
                case 2:
                    updateDoctor();
                    break;
                case 3:
                    deleteDoctor();
                    break;
                case 4:
                    searchDoctor();
                    break;
                case 5:
                    System.out.println("Exiting the program..");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void addDoctor() {
        try {
            System.out.println("--------- Add Doctor ----------");
            Doctor doctor = view.getDoctorInfo();
            model.addDoctor(doctor);
            System.out.println("Doctor added successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateDoctor() {
        try {
            Doctor doctor = view.getDoctorInfo();
            model.updateDoctor(doctor);
            System.out.println("Doctor's info updated successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteDoctor() {
        try {
            System.out.println("--------- Delete Doctor ----------");
            String code = view.getSearchText();
            model.deleteDoctor(code);
            System.out.println("Doctor deleted successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void searchDoctor() {
        try {
            System.out.println("--------- Search Doctor ----------");
            String searchTerm = view.getSearchText();
            Map<String, Doctor> Result = model.searchDoctor(searchTerm);
            view.displayDoctors(Result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
