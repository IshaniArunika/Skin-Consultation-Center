public class Patient extends Person{

    static int nextId = 1;
    public static String patientId;



    public Patient(String name, String surname,
                   String mobileNumber, String dateOfBirth, String patientId){
        super(name,surname, mobileNumber, dateOfBirth);
        this.patientId = String.valueOf(nextId++);

    }



    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String toString(){
        return super.toString()+"\n"+ this.patientId;

    }

}
