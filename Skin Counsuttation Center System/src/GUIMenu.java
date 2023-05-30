import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUIMenu extends JFrame  {

  JButton viewButton = new JButton("View Doctors");

  JButton addPatientbtn = new JButton("Add Patient");
  JButton createConsultationbtn = new JButton("Add Consultation");
  JButton exsitbtn = new JButton("Exsit");
  JPanel buttonPanel;
  JLabel title;
  JPanel panel2;
  JPanel panel1;

   public GUIMenu() throws IOException {



        title = new JLabel("Admin Portal");
        title.setFont(new Font("Consolas",Font.PLAIN,16));

        viewButton.setBounds(100,160,20,40);
        viewButton.setFocusable(false);
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 dispose();
                ViewDoctors viewDoctors = new ViewDoctors();
                viewDoctors.setVisible(true);
                viewDoctors.tableDetails();

            }
        });
        addPatientbtn.setBounds(100,160,20,40);
        addPatientbtn.setFocusable(false);
        addPatientbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AddPatient ap = new AddPatient();
                ap.setVisible(true);
                AddPatient.idField.setText(Integer.toString(Patient.nextId));

            }
        });



        createConsultationbtn.setBounds(100,160,20,40);
        createConsultationbtn.setFocusable(false);
        createConsultationbtn.setPreferredSize(new Dimension(50,50) );
        createConsultationbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 dispose();
                CreateConsultation createConsultation = null;
                try {
                    createConsultation = new CreateConsultation();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (BadLocationException ex) {
                    throw new RuntimeException(ex);
                }
                createConsultation.setVisible(true);

            }
        });


        exsitbtn.setBounds(100,160,20,40);
        exsitbtn.setFocusable(false);
        exsitbtn.setPreferredSize(new Dimension(50,50) );
        exsitbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();


            }
        });


        buttonPanel = new JPanel();
        buttonPanel.setBounds(110,100,450,100);
        buttonPanel.setBackground(new Color(157, 114, 215));
        buttonPanel.setLayout( new GridLayout(1,3,10,100));
        buttonPanel.add(viewButton);
        buttonPanel.add(addPatientbtn);
        buttonPanel.add(createConsultationbtn);

        panel2 = new JPanel();
        panel2.setBounds(108,108,300,350);
        panel2.setBackground(new Color(157, 114, 215));
        panel2.setLayout(null);
        panel2.add(buttonPanel);





        panel1 = new JPanel();
        panel1.setBounds(50,40,670,350);
        panel1.setBackground(new Color(205,153,255));
        panel1.setLayout( new BorderLayout());
        panel1.add(panel2 , BorderLayout.CENTER);
        panel1.add(title, BorderLayout.NORTH);
        panel1.add(exsitbtn, BorderLayout.SOUTH);

        this.setTitle("Westminster Skin Consultation Center");
        this.setVisible(true);
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(204,204,255));
        this.setLayout(null);
        this.add(panel1);



    }
    public static void main(String[] args) throws IOException {
        new GUIMenu();
    }


}
