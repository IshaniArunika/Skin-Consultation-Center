import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class CreateConsultation extends JFrame {

    JPanel mainPanel ;
    JFileChooser fileChooser = new JFileChooser();
    JTextPane textPane = new JTextPane();
    JButton addImButton = new JButton("Add Image Of Skin");

    Image image;
    static String medicalLicenNo ;
    String doctorSurname ;

    static final ArrayList<Consultation> consultations = new ArrayList<>();

    static Consultation consulObject;

    CreateConsultation() throws IOException, BadLocationException {


        JLabel title = new JLabel("Consultation Details");
        title.setFont(new Font("Consolas", Font.PLAIN,19));


        JLabel sTlabel1 = new JLabel("Start time(HH.MM)");
        title.setFont(new Font("Consolas", Font.PLAIN,14));
        JTextField sartTimeF =   new JTextField( );
        sartTimeF.setPreferredSize(new Dimension(30,40));


        JLabel sTlabel2 = new JLabel("End time(HH.MM)");
        title.setFont(new Font("Consolas", Font.PLAIN,14));
        JTextField endTimeF =   new JTextField( );


        // ask patient id
        JLabel patientId = new JLabel("Patient ID ");
        patientId.setFont(new Font("Consolas",Font.PLAIN,14));

        JTextField patientidfeild = new JTextField(  );
        patientidfeild.setPreferredSize(new Dimension(30,40));


        //select doctor from combo box
        JLabel selectDoctor = new JLabel("Doctor ");
        selectDoctor.setFont(new Font("Consolas",Font.PLAIN,14));
        JComboBox<String> comboBox = new JComboBox<>();
        // add data to combo box
        for (Doctor doctor :  WestminsterSkinConsultationManager.doctors) {
              medicalLicenNo = doctor.getMobileNumber();
              doctorSurname = doctor.getSurname();
            comboBox.addItem("Dr "+doctorSurname+"("+medicalLicenNo+")");
        }


        // get date from user
        JLabel  getDAte = new JLabel("Date(dd/MM/yyyy) ");
        getDAte.setFont(new Font("Consolas",Font.PLAIN,14));

        JTextField datetextField = new JTextField();
        datetextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = datetextField.getText();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date date = formatter.parse(text);
                    // use the date here
                } catch (ParseException ex) {
                    //   error message if the date is invalid
                    System.out.println("Invalid Date");
                }
            }
        });
        datetextField.setPreferredSize(new Dimension(30,40));




        JLabel  note = new JLabel("Note ");
        note.setFont(new Font("Consolas",Font.PLAIN,14));
        JTextArea noteFeild = new JTextArea();
        noteFeild.setSize(300, 200);
        noteFeild.setPreferredSize(new Dimension(30,80));

        JScrollPane scrollPane  = new JScrollPane(noteFeild);
        scrollPane.setSize(300, 200);





        addImButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textPane.getText();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Open Image","jpg","jpeg","gif"));
                int returnValue = fileChooser.showOpenDialog(CreateConsultation.this);
                if(returnValue == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    try {
                        // Read the image from the file that added
                        BufferedImage originalImage = ImageIO.read(file);

                        // Set the desired width and height
                        int width = 200;
                        int height = 200;

                        // Create a scaled version of the image
                        Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);

                        // Create a new image icon from the scaled image
                        ImageIcon imageIcon = new ImageIcon(scaledImage);

                        // Insert the scaled image into the text pane
                        textPane.insertIcon(imageIcon);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        JScrollPane scrollPane1 = new JScrollPane(textPane);
        scrollPane1.setSize(300, 200);


        JPanel subPanel = new JPanel();
        subPanel.setPreferredSize(new Dimension(250, 150));
        subPanel.setBackground(new Color( 229,204,255));
        subPanel.setBounds(0,0,500,200);
        subPanel.setLayout(new GridLayout(6, 2,20,10));
        subPanel.add(patientId );
        subPanel.add(patientidfeild );
        subPanel.add(selectDoctor);
        subPanel.add(comboBox);
        subPanel.add(getDAte);
        subPanel.add(datetextField);
        subPanel.add(sTlabel1);
        subPanel.add(sartTimeF);
        subPanel.add(sTlabel2);
        subPanel.add(endTimeF);
        subPanel.add(note);
        subPanel.add(scrollPane);

        JButton exsitbtn = new JButton("Exsit");
        exsitbtn.setBounds(100,160,20,40);
        exsitbtn.setFocusable(false);
        exsitbtn.setPreferredSize(new Dimension(50,50) );
        exsitbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                GUIMenu frame = null;
                try {
                    frame = new GUIMenu();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                frame.setVisible(true);

            }
        });

        JButton saveBtn  = new JButton("Save Appointment");
        saveBtn.setBounds(100,160,40,20);
        saveBtn.setFocusable(false);
        saveBtn.setPreferredSize(new Dimension(200, 50));
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {

                // get text from text field

                String patientId = patientidfeild.getText();

                Patient selectedPatient = null;
                for(Patient patient: AddPatient.patients){
                    if (patient.patientId.equals(selectedPatient)) {
                        selectedPatient = patient;
                        break;
                    }
                }


                String doctorSurname = (String) comboBox.getSelectedItem();
                Doctor selectedDoctor = null;
                for (Doctor doctor :  WestminsterSkinConsultationManager.doctors) {
                    if (doctor.getMedicalLicenceNumber().equals(medicalLicenNo)) {
                        selectedDoctor = doctor;
                        break;
                    }
                }

                String date = datetextField.getText();

                String startTime = sartTimeF.getText();

                String endTime = endTimeF.getText();

                double st =Double.parseDouble(startTime);

                double et = Double.parseDouble(endTime);



                double cost =  25*(et-st);

                String note = noteFeild.getText();

                // Get the root element of the document
                StyledDocument doc = textPane.getStyledDocument();
                Element root = doc.getDefaultRootElement();

                // Get the number of children of the root element
                int numChildren = root.getElementCount();

//                // Iterate through the children of the root element
//                for (int i = 0; i < numChildren; i++) {
//                    Element element = root.getElement(i);
//                    if (element.getName().equals("icon")) {
//                        // This element contains an image
//                        ImageIcon imageIcon = (ImageIcon) element.getAttributes().getAttribute(StyleConstants.IconAttribute);
//                          image = imageIcon.getImage();
//                        // Do something with the image
//                    }
//                }

                consulObject =  new Consultation(patientId, doctorSurname,date ,startTime, endTime,cost,note, image);
                consulObject.setPatientaid(patientId);
                consulObject.setDoctorSurname(doctorSurname);
                consulObject .setDate(date);
                consulObject.setStartTime(startTime);
                consulObject.setEndTime(endTime);
                consulObject.setCost(cost);
                consulObject.setNote(note);
                consulObject.setImage(image);

                consultations.add(consulObject);




            }
        });

        JButton viewConsulBtn = new JButton("View Consultation");
        viewConsulBtn.setBounds(100,160,20,40);
        viewConsulBtn.setFocusable(false);
        viewConsulBtn.setPreferredSize(new Dimension(50,50) );
        viewConsulBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                dispose();
                ViewConsultation c = new ViewConsultation();
                c.setVisible(true);
                c.viewAppointment();


            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,4));
        buttonPanel.add(saveBtn);
        buttonPanel.add(exsitbtn);
        buttonPanel.add(viewConsulBtn);


        JPanel imgPanel = new JPanel();
        imgPanel.setPreferredSize(new Dimension(250, 250));
        imgPanel.setBackground(new Color( 229,204,105));
        imgPanel.setBounds(0,0,500,200);
        imgPanel.setLayout(new BorderLayout());
        imgPanel.add(scrollPane1,BorderLayout.CENTER);
        imgPanel.add(addImButton,BorderLayout.EAST);
        imgPanel.add( buttonPanel,BorderLayout.SOUTH);


        JPanel consultationDetailsPanel = new JPanel();
        consultationDetailsPanel.setBackground(new Color( 204,153,255));
        consultationDetailsPanel.setBounds(50,20,500,550);
        consultationDetailsPanel.setPreferredSize(new Dimension(250, 550));
        consultationDetailsPanel.setLayout(new BorderLayout());
        consultationDetailsPanel.add(title,BorderLayout.NORTH);
        consultationDetailsPanel.add(subPanel,BorderLayout.CENTER);
        consultationDetailsPanel.add( imgPanel,BorderLayout.SOUTH);



        this.setTitle("Create Consultation");
        this.setVisible(true);
        this.setSize(600, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.add(consultationDetailsPanel);



    }




    public static void main(String[] args) throws IOException, BadLocationException {

        new CreateConsultation();

    }
}
