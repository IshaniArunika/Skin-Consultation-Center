import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AvailableDoctors extends JFrame {

    JTextArea jt;
    AvailableDoctors(){



        // Set the title and size of the frame
        setTitle("My Frame");
        setSize(400, 300);

        // Create a panel and add a scrollable text area to it
        JPanel panel = new JPanel();
        jt = new JTextArea( 30,50);
        jt.setLineWrap(true);
        jt.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(jt);
        panel.setPreferredSize(new Dimension(250, 350));
        panel.setBounds(50,40,670,350);
        panel.setBackground(new Color(205,153,255));

        JButton exsit = new JButton("Exsit");
        exsit.setBounds(100,160,20,40);
        exsit.setFocusable(false);
        exsit.setPreferredSize(new Dimension(50,50) );
        exsit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();


            }
        });
        JButton back = new JButton("Back to menu");
        back.setBounds(100,160,20,40);
        back.setFocusable(false);
        back.setPreferredSize(new Dimension(50,50) );
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                GUIMenu v = null;
                try {
                    v = new GUIMenu();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                v.setVisible(true);


            }
        });
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout( new GridLayout(1,2));
        btnPanel.add(exsit);
        btnPanel.add(back)   ;

        this.setTitle("Current Appointment");
        this.setVisible(true);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    static void checkAvailable(){
        int count =0;
        for(Consultation consultation : CreateConsultation.consultations){
            count++;
            if(consultation.getDrMediLNo().equals(consultation.drMediLNo)  ) {
                if (consultation.getStartTime().equals(consultation.startTime));
                    JOptionPane.showMessageDialog(null,"Doctor Not Available! ","Title",1);
                    int x = CreateConsultation.consultations.indexOf(Doctor.getMedicalLicenceNumber());
                //    if (!(x == Doctor.doctor.getMedicalLicenceNumber))
            }


        }
    }


}
