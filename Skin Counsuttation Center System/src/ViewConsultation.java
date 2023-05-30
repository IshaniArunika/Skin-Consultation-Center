import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Iterator;

public class ViewConsultation extends JFrame {

    JPanel panel1;
    JPanel panel2,panel3;
    static JTextArea detailas;
    JButton exsitbtn,backButton;
    public ViewConsultation() {


        backButton = new JButton("Back tp menu");
        backButton.setBounds(0,0,10,10);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                try {
                    new GUIMenu().setVisible(true);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        detailas = new JTextArea();
        detailas.setPreferredSize(new Dimension(800, 200));
        detailas.setSize(300, 200);
        detailas.setPreferredSize(new Dimension(500,350));
        detailas.setColumns(50);
        detailas.setRows(17);

        JScrollPane scrollPane  = new JScrollPane(detailas);
        scrollPane.setSize(500, 400);

        panel2 = new JPanel();
        panel2.setBackground(new Color(202,153,255));
     //   panel2.add(detailas);
        panel2.add(scrollPane);



        panel1 = new JPanel();
        panel1.setBounds(50,40,670,350);
        panel1.setBackground(new Color(205,153,255));
        panel1.setLayout( new BorderLayout());
        panel1.add(panel2, BorderLayout.CENTER);
        panel1.add(backButton, BorderLayout.SOUTH);

        this.setTitle("Appointment Details");
        this.setVisible(true);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        add(panel1);


    }
    public void viewAppointment(){
        StringBuilder sb = new StringBuilder();
        int count=1;
        for (Consultation consultation : CreateConsultation.consultations) {
          count++;

                sb.append("Consultation Details:\n");
                sb.append("Start Time: " + consultation.getStartTime() + "\n");
                sb.append("End Time: " + consultation.getEndTime() + "\n");
                sb.append("Patient ID: " + consultation.getPatientaid() + "\n");
                sb.append("Doctor: " + consultation.getDrMediLNo() + "\n");
                sb.append("Cost: " + consultation.getCost() + "\n");
                sb.append("Date: " + consultation.getDate() + "\n");
                sb.append("Note: " + consultation.getNote() + "\n\n");

            }
        detailas.setText(sb.toString());


    }

    public void saveConsultationData()throws IOException{

        try {

            FileWriter writer = new FileWriter("ConsultationDeails.txt");
            Iterator<Consultation> i = CreateConsultation.consultations.iterator();
            while (i.hasNext()) {
                Consultation consultation = i.next();

                writer.write("PatientID:       " +consultation.getPatientaid() + "\n" );
                writer.write("DoctorSurname:   " + consultation.getDoctorSurname() + "\n"  );
                writer.write( "Cost:           " + consultation.getCost() + "\n");
                writer.write( "Start Time:     " + consultation.getStartTime() + "\n");
                writer.write( "End Time:       " + consultation.getEndTime() + "\n");
                writer.write( "Date:           " + consultation.getDate()+ "\n" );
                writer.write( "Note:           " + consultation.getNote() + "\n" );
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
    public void loadConsultationadata() throws IOException{

            try {
                FileReader fr = new FileReader("ConsultationDeails.txt");
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    String[] fields = line.split(",");
                    String startTime = fields[0];
                    String endTime = fields[1];
                    String patientId = fields[2];
                    String doctor = fields[3];
                    String date = fields[4];
                    String note = fields[5];
                    double cost = Double.parseDouble(fields[6]);
                    Consultation c = new Consultation(startTime, endTime, patientId, doctor, date, note,cost);
                    CreateConsultation.consultations.add(c);
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    public static void main(String[] args) throws IOException {
        ViewConsultation frame =new ViewConsultation();
        frame.saveConsultationData();
    }
}
