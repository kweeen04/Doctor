package view;

import java.util.Map;
import java.util.Scanner;

import model.Doctor;

public class View {
    private Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    public int getChoice() {
        System.out.println("========= Doctor Management ==========");
        System.out.println("1. Add Doctor");
        System.out.println("2. Update Doctor");
        System.out.println("3. Delete Doctor");
        System.out.println("4. Search Doctor");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public Doctor getDoctorInfo() {
        scanner.nextLine();
        System.out.print("Enter Code: ");
        String code = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();
        System.out.print("Enter Availability: ");
        int availability = scanner.nextInt();
        return new Doctor(code, name, specialization, availability);
    }

    public String getSearchText() {
        scanner.nextLine();
        System.out.print("Enter text: ");
        return scanner.nextLine();
    }

    public void displayDoctors(Map<String, Doctor> doctors) {
        if (doctors.isEmpty()) {
            System.out.println("Doctor not found.");
        } else {
            System.out.println("--------- Result ------------");
            System.out.println("Code\tName\tSpecialization\tAvailability");
            for (Doctor doctor : doctors.values()) {
                System.out.println(doctor.getCode() + "\t" + doctor.getName() + "\t" +
                        doctor.getSpecialization() + "\t" + doctor.getAvailability());
            }
        }
    }
}
