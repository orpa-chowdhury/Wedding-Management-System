package weddingmanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;


/**
 *
 * @author Orpa, Nushrat, Nur;
 */
public class AddEvent extends JFrame {

    Choice c1;
    JButton b1, b2;
    private JPanel contentPane;
    private JTextField t1, t2;
    private JComboBox comboBox;
    ArrayList<JComboBox> t = new ArrayList<JComboBox>();
    String venue, caterer, photographer, type;

    AddEvent() {
        super("NNO Wedding Management System");
        setBounds(500, 300, 1000, 600);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l = new JLabel("Book The Event :");
        l.setFont(new Font("Times New Roman", Font.BOLD, 30));
        l.setForeground(Color.BLACK);
        l.setBounds(50, 5, 1000, 50);
        contentPane.add(l);
        c1 = new Choice();

        ArrayList<ArrayList<String>> lab = new ArrayList<ArrayList<String>>();
        String[] sw = new String[]{"Event Type", "Venue", "Photographer", "Caterer", "Date", "No. of persons"};

        ArrayList<String> aList = new ArrayList<String>();
        aList.add("Classic");
        aList.add("Elegant");
        aList.add("Elite");
        aList.add("Premier");
        lab.add(aList);


        // Make a list of venue in the arraylist.
        ArrayList<String> venueList = new ArrayList<String>();
        try {
            FileReader fr = new FileReader("venue.txt"); 
            BufferedReader br = new BufferedReader(fr);
            String line;

            while((line = br.readLine())!=null){

                String[] arrOfStr = line.split("\t");
                
                venueList.add(arrOfStr[0] + "-" + arrOfStr[2]);
                
            }
            lab.add(venueList);
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
            
        // Make a list of photographer in the arraylist.
        
        ArrayList<String> photographerList = new ArrayList<String>();
        try {
            FileReader fr = new FileReader("photographer.txt"); 
            BufferedReader br = new BufferedReader(fr);
            String line;

            while((line = br.readLine())!=null){

                String[] arrOfStr = line.split("\t");
                
                photographerList.add(arrOfStr[0] + "-" + arrOfStr[2]);
                
            }
            lab.add(photographerList);
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        // Make a list of caterer in the arraylist.
        
        ArrayList<String> catererList = new ArrayList<String>();
        try {
            FileReader fr = new FileReader("caterer.txt"); 
            BufferedReader br = new BufferedReader(fr);
            String line;

            while((line = br.readLine())!=null){

                String[] arrOfStr = line.split("\t");
                
                catererList.add(arrOfStr[0] + "-" + arrOfStr[2]);
                
            }
            lab.add(catererList);
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        int j = 0;
        Iterator itr = lab.iterator();
        for (int i = 0; i <= 5; i++) {

            JLabel l1 = new JLabel(sw[i]);
            l1.setForeground(new Color(25, 25, 112));
            l1.setFont(new Font("Tahoma", Font.BOLD, 14));
            l1.setBounds(64, 70 + j, 182, 22);
            contentPane.add(l1);
            if (i == 4) {
                
                // Date text field.
                t1 = new JTextField();
                t1.setBounds(170, 70 + j, 202, 20);
                contentPane.add(t1);

            } else if(i == 5) {
                // Number of persons text field.
                t2 = new JTextField();
                t2.setBounds(170, 70 + j, 202, 20);
                contentPane.add(t2);
            } else {
                ArrayList<String> r = new ArrayList<String>();

                r = (ArrayList<String>) itr.next();

                comboBox = new JComboBox(r.toArray());
                comboBox.setBounds(170, 70 + j, 200, 20);
                comboBox.setBackground(Color.BLACK);
                comboBox.setForeground(Color.WHITE);
                contentPane.add(comboBox);
            }
            j += 40;
            t.add(comboBox);

        }

        b1 = new JButton("Add");
//	b1.addActionListener(this);
        b1.setBounds(64, 70 + j, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    setVisible(false);
//                    String type = t4.getText();
                    type = (String) t.get(0).getSelectedItem();
                    venue = (String) t.get(1).getSelectedItem();
                    photographer = (String) t.get(2).getSelectedItem();
                    caterer = (String) t.get(3).getSelectedItem();
                    String date = t1.getText();
                    String numberOfPersons = t2.getText();
                    System.out.println(date);
                    System.out.println(numberOfPersons);
                    
                    String[] arrOfStrVenue = venue.split("-");
                    int venuePrice = Integer.parseInt(arrOfStrVenue[1]);
                    System.out.println(venuePrice);
                    
                    String[] arrOfStrPhotographer = photographer.split("-");
                    int photographerPrice = Integer.parseInt(arrOfStrPhotographer[1]);
                    System.out.println(photographerPrice);
                    
                    String[] arrOfStrCaterer = caterer.split("-");
                    int catererPrice = Integer.parseInt(arrOfStrCaterer[1]);

                    int num =  Integer.parseInt(numberOfPersons);
                    System.out.println(photographerPrice);
                    int totalEventCost = venuePrice + photographerPrice + (catererPrice * num);
                    System.out.println(totalEventCost);
                    
                    try{
                        FileWriter fw = new FileWriter("events.txt", true);
                        fw.write(type + "\t" + venue + "\t" + photographer + "\t" + caterer + "\t" +  date +"\t" + numberOfPersons + "\t" + totalEventCost + "\n");
                        System.out.println(type + "\t" + venue + "\t" + photographer + "\t" + caterer + "\t" +  date +"\t" + numberOfPersons + "\t" + totalEventCost + "\n");
                        fw.close();
                        Frame f = new JFrame();
                        JOptionPane.showMessageDialog(f, "Event added successfully");
                        setVisible(false);
                        new Dashboard2().setVisible(true);

                     }catch (Exception e) {
                         System.out.println(e);
                     }

//                    String str = "INSERT INTO event values( '" + type + "', '" + venue + "', '" + caterer + "','" + photographer + "','" + date + "')";
//                    System.out.print(str);
//                    conn c = new conn();
//                    c.s.executeUpdate(str);
//                    JOptionPane.showMessageDialog(null, str + "Successfully Added");

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error while adding");

                }

            }
        }
        );

        b2 = new JButton("Back");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    setVisible(false);
                    new Dashboard2().setVisible(true);

                } catch (Exception e) {
                }

            }
        }
        );
        b2.setBounds(198, 70 + j, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        contentPane.setBackground(Color.PINK);
        setVisible(true);
    }

    public static void main(String args[]) {
        AddEvent w = new AddEvent();
    }

}
