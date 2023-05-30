import java.awt.*;

public class Consultation {


    public Consultation Consultation;
    private String patientaid;

    public String drMediLNo;
    private String date ;
   public String startTime;
   private String endTime;
    private double cost ;
    private String note;
    private Image image;



    public Consultation(String patientaid, String drMediLNo, String date, String startTime, String endTime, double cost, String note, Image image) {
        this.patientaid = patientaid;
        this.drMediLNo = drMediLNo ;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.cost = cost;
        this.note = note;
        this.image = image;
    }

    public Consultation(String startTime, String endTime, String patientId, String doctor, String date, String note, double cost) {
        this.patientaid = patientaid;
        this.drMediLNo = drMediLNo ;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.cost = cost;
        this.note = note;
    }

    public String getDrMediLNo() {
        return drMediLNo;
    }

    public void setDrMediLNo(String drMediLNo) {
        this.drMediLNo = drMediLNo;
    }

    public String getDoctorSurname() {
        return drMediLNo;
    }

    public void setDoctorSurname(String doctorSurname) {
        this.drMediLNo = doctorSurname;
    }

    public String getPatientaid() {
        return patientaid;
    }

    public void setPatientaid(String patientaid) {
        this.patientaid = patientaid;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public   void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public   void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getNote() {
        return note;
    }

    public  void setNote(String note) {
        this.note = note;
    }

    public double getCost() {
        return cost;
    }

    public  void setCost(double cost) {
        this.cost = cost;
    }

    public String toString(){
        return this.date+"\n"+this.startTime+"\n"+this.endTime+"\n"+this.cost+"\n"+this.note+"\n"+this.image;
    }

}


