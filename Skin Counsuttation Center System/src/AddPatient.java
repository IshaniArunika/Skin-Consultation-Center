import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class AddPatient extends JFrame  {

    public static JTextField idField ;

    JFrame frame2 = new JFrame();
    static ArrayList<Patient> patients  =new ArrayList<>();
    static Patient patient ;
    JLabel pdTitle;
    JLabel pID;

    JLabel pName;
    JTextField nameField;
    JLabel pSurname;
    JTextField surnameField;
    JLabel pMobilNo;
    JTextField mobileNoField;
    JLabel pBirthDay;
    JTextField birthDayField;
    JPanel patientdetailspanel;
    JPanel buttonPanel;
    JPanel subPanel;
    JButton b;
    JButton saveBtn;
    JButton clearBtn;
    JButton conbtn;
    AddPatient(){



        pdTitle = new JLabel("Patient Details");
        pdTitle.setFont(new Font("Consolas",Font.PLAIN,19));

        pID = new JLabel("patientId: ");
        pID.setFont(new Font("Consolas",Font.PLAIN,14));
        idField = new JTextField(5);
        idField.setPreferredSize(new Dimension(300,40));


        pName = new JLabel("Name: ");
        pName.setFont(new Font("Consolas",Font.PLAIN,14));
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(300,40));

        pSurname = new JLabel("Surname: ");
        pSurname.setFont(new Font("Consolas",Font.PLAIN,14));
        surnameField = new JTextField();
        surnameField.setPreferredSize(new Dimension(300,40));

        pMobilNo= new JLabel("Mobile Number: ");
        pMobilNo.setFont(new Font("Consolas",Font.PLAIN,14));
        mobileNoField = new JTextField(10);
        mobileNoField.setPreferredSize(new Dimension(300,40));

        pBirthDay = new JLabel("Date Of Birth: ");
        pBirthDay.setFont(new Font("Consolas",Font.PLAIN,14));
        birthDayField = new JTextField(10);
        birthDayField.setPreferredSize(new Dimension(300,40));


        patientdetailspanel = new JPanel();
        patientdetailspanel.setBackground(new Color( 204,153,255));
        patientdetailspanel.setBounds(50,10,500,250);
        patientdetailspanel.setLayout(new BorderLayout());
        patientdetailspanel.add(pdTitle,BorderLayout.NORTH);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,2));

        subPanel = new JPanel();
        subPanel.setBackground(new Color( 229,204,255));
        subPanel.setBounds(0,0,500,200);
        subPanel.setLayout(new GridLayout(5, 2));
        patientdetailspanel.add(subPanel,BorderLayout.CENTER);
        patientdetailspanel.add(buttonPanel,BorderLayout.SOUTH);

        b = new JButton("Table");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PatientTable g = new PatientTable();
                g.setVisible(true);
                g.tableDetails();
            }
        });

        saveBtn  = new JButton("Save Details");
        saveBtn.setBounds(100,160,40,20);
        saveBtn.setFocusable(false);
        buttonPanel.add(saveBtn) ;
        saveBtn.setPreferredSize(new Dimension(200, 50));
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // get text from text field
                String id = idField.getText();
                String name = nameField.getText();
                String surname = surnameField.getText();
                String mobileNo = mobileNoField.getText();
                String dateOdBirth = birthDayField.getText();


                // set values in patient object
                patient = new Patient(id,name,surname,mobileNo,dateOdBirth)  ;
                patient.setPatientId(id);
                patient.setName(id);
                patient.setSurname(surname);
                patient.setMobileNumber(mobileNo);
                patient.setDateOfBirth(dateOdBirth);


                patients.add(patient);




            }
        });
        clearBtn  = new JButton("Clear");
        clearBtn.setBounds(100,160,40,20);
        clearBtn.setFocusable(false);
        clearBtn.setPreferredSize(new Dimension(200, 50));
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear text in text fields
                nameField.setText("");
                surnameField.setText("");
                mobileNoField.setText("");
                birthDayField.setText("");
                idField.setText("");

            }
        });
        buttonPanel.add(clearBtn) ;

        conbtn  = new JButton("Create Consultation");
        conbtn.setBounds(100,160,40,20);
        conbtn.setFocusable(false);
        conbtn.setPreferredSize(new Dimension(200, 50));
        conbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // get text from text field
                String id = idField.getText();
                String name = nameField.getText();
                String surname = surnameField.getText();
                String mobileNo = mobileNoField.getText();
                String dateOdBirth = birthDayField.getText();


                // set values in patient object
                Patient patient = new Patient(id,name,surname,mobileNo,dateOdBirth)  ;
                patient.setPatientId(id);
                patient.setName(id);
                patient.setSurname(surname);
                patient.setMobileNumber(mobileNo);
                patient.setDateOfBirth(dateOdBirth);


                patients.add(patient);




                frame2.dispose();
                CreateConsultation frame = null;
                try {
                    frame = new CreateConsultation();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (BadLocationException ex) {
                    throw new RuntimeException(ex);
                }
                frame.setVisible(true);


            }
        });
        buttonPanel.add(conbtn);


        subPanel.add(pID);
        subPanel.add(idField);
        subPanel.add(pName);
        subPanel.add(nameField);
        subPanel.add(pSurname);
        subPanel.add(surnameField);
        subPanel.add(pMobilNo);
        subPanel.add(mobileNoField);
        subPanel.add(pBirthDay);
        subPanel.add(birthDayField);


        this.setTitle("Add Patient Details");
        this.setVisible(true);
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.add(patientdetailspanel);


    }



    public static void main(String[] args) {
          AddPatient frame2 = new AddPatient();

    }


}
