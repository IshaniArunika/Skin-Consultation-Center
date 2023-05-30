import java.io.*;
import java.util.*;

public class WestminsterSkinConsultationManager  implements SkinConsultationManager   {
    static WestminsterSkinConsultationManager manager = new WestminsterSkinConsultationManager();

    final static Scanner scanner = new Scanner(System.in);

    private static final int MAX_DOCTORS = 10;

    public static ArrayList<Doctor> doctors = new ArrayList<>();

    static Doctor doctor;


    public static void main(String[] args) throws IOException, ClassNotFoundException {

      //  WestminsterSkinConsultationManager.manager.loadData();

        boolean exit = false;
        while (!exit) {
            int choice = 0;
            try {
                System.out.println("");
                System.out.println("------------Select the Options------------");
                System.out.println("  1. Add a new doctor");
                System.out.println("  2. Delete a doctor");
                System.out.println("  3. Print list of doctors");
                System.out.println("  4. Save and exit");
                System.out.println("  5. Run GUI");
                System.out.println("  5. Exsit");
                System.out.println("------------------------------------------");
                System.out.print("  Enter a number (1-5): ");

                choice = WestminsterSkinConsultationManager.scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wrong Input please try again");
            }

            WestminsterSkinConsultationManager.scanner.nextLine();
            switch (choice) {
                case 1:
                    manager.addNewDoctor();
                    break;
                case 2:
                    manager.deleteDoctor();
                    break;
                case 3:
                    manager.printDoctors();
                    break;
                case 4:
                    manager .saveFile();
                    break;
                case 5:
                    manager.opengui();
                    break;
                case 6:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }
        WestminsterSkinConsultationManager.scanner.close();


    }

    private void openGui() {
    }

    public static void addNewDoctor() {

        if (doctors.size() < MAX_DOCTORS) {

            System.out.println("Name: ");
            String name = scanner.next();

            System.out.println("Surname: ");
            String surName = scanner.next();

            System.out.println("Mobile Number: ");
            String mobileNumber = scanner.next();

            System.out.println("Date Of Birth (YYYY/MM/DD): ");
            String dateOfBirth = scanner.next();

            System.out.println("Medical Licence Number: ");
            String medicalLicenceNumber = scanner.next();

            System.out.println("Specialisation: ");
            String specialisation = scanner.next();


            doctor = new Doctor(name, surName, mobileNumber, dateOfBirth, medicalLicenceNumber, specialisation);
            doctor.setName(name);
            doctor.setSurname(surName);
            doctor.setMobileNumber(mobileNumber);
            doctor.setDateOfBirth(dateOfBirth);
            doctor.setMedicalLicenceNumber(medicalLicenceNumber);
            doctor.setSpecialisation(specialisation);

            manager.addNewDoctor(doctor);
        } else {
            System.out.println("Error: Cannot add more than " + MAX_DOCTORS + " doctors.");
        }


    }

    public static void deleteDoctor() {
        System.out.println("Enter Doctor's Medical License Number");
        String medicalLicenseNumber = scanner.next();
        manager.deleteDoctor(medicalLicenseNumber);


    }


    @Override
    public void addNewDoctor(Doctor doctor) {

        if (doctors.size() < MAX_DOCTORS) {
            this.doctors.add(doctor);
        } else if (doctors.contains(doctor.getMedicalLicenceNumber())) {
            System.out.println(doctor.getMedicalLicenceNumber() + " Already Exsist !");
        }

    }
    public  void opengui() throws IOException {
        GUIMenu n= new GUIMenu();
        n.setVisible(true);
    }

    @Override
    public void deleteDoctor(String medicalLicenseNumber) {
        Doctor doctorToDelete = null;
        for (Doctor doctor : this.doctors) {
            if (doctor.getMedicalLicenceNumber().equals(medicalLicenseNumber)) {
                doctorToDelete = doctor;
                break;
            }
        }
        if (doctorToDelete != null) {
            this.doctors.remove(doctorToDelete);
            System.out.println("Doctor with medical license number " + medicalLicenseNumber + " has been deleted.");
            System.out.println("Total number of doctors in the centre: " + this.doctors.size());
        } else {
            System.out.println("Error: Doctor with medical license number " + medicalLicenseNumber + " not found.");
        }

    }
    @Override
    public void printDoctors() {
        int doctorsCount = 0;
        doctors.sort(Comparator.comparing(Doctor::getName));
        if (doctors.size()!=0) {
            for (Doctor doctor : doctors) {
                doctorsCount += 1;
                System.out.print(   "Doctor  " + doctorsCount + "\n" + "\t" +
                        "Name                     :" + doctor.getName() + "\n" + "\t" +
                        "Surname                  :" + doctor.getSurname() + "\n" + "\t" +
                        "Mobile Number            :" + doctor.getMobileNumber() + "\n" + "\t" +
                        "Date of birth            :" + doctor.getDateOfBirth() + "\n" + "\t" +
                        "Medica lLicense Number   :" + doctor.getMedicalLicenceNumber() + "\n" + "\t" +
                        "specialisation           :" + doctor.getSpecialisation() + "\n" + "\t\n\n");
            }
        }else{
            System.out.println("There are no available doctors.");
        }
    }
    @Override
    public void saveFile() {
        try {

            FileWriter writer = new FileWriter("DoctorInformation.ser");
            Iterator<Doctor> i = doctors.iterator();
            while (i.hasNext()) {
                Doctor doctor = i.next();

                writer.write("Name                     :" + doctor.getName() + "\n" );
                writer.write("Surname                  :" + doctor.getSurname() + "\n"  );
                writer.write( "Mobile Number            :" + doctor.getMobileNumber() + "\n");
                writer.write( "Date of birth            :" + doctor.getDateOfBirth() + "\n");
                writer.write( "specialisation           :" + doctor.getSpecialisation() + "\n" );
                writer.write("\r\n");


            }


            writer.close();
            System.out.println("Successfully written to a file\n");

        } catch (IOException e) {
            e.printStackTrace();

        }
        catch (RuntimeException e){
            e.printStackTrace();
        }
    }
}













