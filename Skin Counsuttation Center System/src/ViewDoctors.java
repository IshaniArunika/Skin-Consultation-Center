import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class ViewDoctors extends JFrame {

    JTable table1;
    static JFrame frame;
    JLabel title;
    JButton sortbtn;
    JButton backButton;
    JPanel panel2;
    JPanel panel1;
    ViewDoctors() {

        table1 = new JTable();
        table1.setModel(new  javax.swing.table.DefaultTableModel(
                new Object[][]{},
                // table headers
                new String [] {"Name","Surname","Mobile Number","Date of Birth","Medical Licence Number","Specialisation"}
        ));


        title = new JLabel("Doctors Details");
        title.setFont(new Font("Consolas",Font.PLAIN,16));


        sortbtn = new JButton("Sort Names");
        sortbtn.setBounds(0,0,10,10);
        sortbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                table1.setAutoCreateRowSorter(true);
            }
        });

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


        panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.add(title,BorderLayout.CENTER);
        panel2.add(sortbtn,BorderLayout.EAST);
        panel2.setBackground(new Color(202,153,255));



        panel1 = new JPanel();
        panel1.setBounds(50,40,670,350);
        panel1.setBackground(new Color(205,153,255));
        panel1.setLayout( new BorderLayout());
        panel1.add(table1, BorderLayout.CENTER);
        panel1.add(panel2, BorderLayout.NORTH);
        panel1.add(backButton, BorderLayout.SOUTH);

        this.setTitle("Doctors Details");
        this.setVisible(true);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        add(panel1);

    }
    public void tableDetails(){
        DefaultTableModel dmodel = (DefaultTableModel) table1.getModel();
        Object[] data  = new Object[6];
        for(Doctor doctor :   WestminsterSkinConsultationManager.doctors){
            data[0] = doctor.getName();
            data[1] = doctor.getSurname();
            data[2] = doctor.getMobileNumber();
            data[3] = doctor.getDateOfBirth();
            data[4] = doctor.getMedicalLicenceNumber();
            data[5] = doctor.getSpecialisation();
            dmodel.addRow(data);
        }
    }

    public static void main(String[] args) {
        ViewDoctors viewDoctors = new ViewDoctors();
        viewDoctors.tableDetails();

    }


}
