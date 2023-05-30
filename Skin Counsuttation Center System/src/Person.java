public class Person {
    private String name,surname, mobileNumber;
    private String dateOfBirth;

    public Person() {
    }

    public Person(String name, String surname,
                  String mobileNumber, String dateOfBirth){
        this.name = name;
        this.surname = surname;
        this.mobileNumber = mobileNumber;
        this.dateOfBirth =  dateOfBirth ;


    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public String getSurname(){
        return surname;
    }
    public void setMobileNumber(String mobileNumber){
        this.mobileNumber = mobileNumber;
    }
    public String getMobileNumber(){
        return mobileNumber;
    }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth =dateOfBirth; }
    public String getDateOfBirth() { return dateOfBirth; }

    public String toString(){

        return this.name+"\n" + this.surname+"\n"+this.mobileNumber+"\n"+ this.dateOfBirth+ "\n"  ;
    }
}
