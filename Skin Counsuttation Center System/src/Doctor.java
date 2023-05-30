public class Doctor extends Person  {
    public static Object doctor;
    static String medicalLicenceNumber;
    static private String specialisation ;



    public  Doctor(String name, String surname, String mobileNumber ,
                   String dateOfBirth, String medicalLicenceNumber,
                   String specialisation){

        super(name,surname, mobileNumber, String.valueOf(dateOfBirth));

        this.medicalLicenceNumber = medicalLicenceNumber;
        this.specialisation = specialisation;
    }




    public static String getMedicalLicenceNumber() {
        return medicalLicenceNumber;
    }

    public void setMedicalLicenceNumber(String medicalLicenceNumber) {
        this.medicalLicenceNumber = medicalLicenceNumber;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public String toString(){

        return super.toString()+"\n"+this.medicalLicenceNumber+"\n"+this.specialisation;
    }



}