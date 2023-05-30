import java.io.IOException;

public interface SkinConsultationManager {

    //add a new doctor
    void addNewDoctor(Doctor doctor);
    //delete a doctor
    void deleteDoctor(String medicalLicenceNumber);

    void printDoctors() throws IOException;

    //print list of the doctors
    void saveFile();

    //save the file


}



