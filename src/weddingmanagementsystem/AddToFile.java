package weddingmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Orpa, Nushrat, Nur;
 */
public class AddToFile extends JFrame{
    private JPanel contentPane;
    JButton b1,b2,b3;
    ArrayList<String> v = new ArrayList<String>();
    ArrayList<JTextField> t = new ArrayList<JTextField>();
    AddToFile(String s[], String a){
        setBounds(450, 200, 1000, 450);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
        JLabel l10 = new JLabel(a);
        l10.setFont(new Font("Tahoma", Font.BOLD, 18));
	l10.setBounds(194, 10, 120, 22);
	contentPane.add(l10);
        int j =0;
    
        for (int i = 0; i < s.length; i++) {

            JLabel l1 = new JLabel(s[i]);
            l1.setForeground(new Color(25, 25, 112));
            l1.setFont(new Font("Tahoma", Font.BOLD, 14));
            l1.setBounds(64, 70 + j, 102, 22);
            contentPane.add(l1);

            JTextField t4 = new JTextField();
            t4.setBounds(174, 70 + j, 156, 20);
            contentPane.add(t4);
            j = j + 40;
            t.add(t4);
        }

        b1 = new JButton("Add");
//	b1.addActionListener((ActionListener) this);
        b1.setBounds(64, 70 + j, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String q = null;
                for (int i = 0; i < s.length; i++) {
                    v.add(t.get(i).getText());
                }
                System.out.print(v);

                if (a == "venue") {

                    try{
                        FileWriter fw = new FileWriter("venue.txt", true);
                        fw.write(v.get(0)+"\t" + v.get(1)+"\t" + v.get(2)+"\t" + v.get(3)+"\t" + v.get(4)+"\n");
                        fw.close();
                        Frame f = new JFrame();
                        JOptionPane.showMessageDialog(f, "Successfully venue added");
                        setVisible(false);
                        new Dashboard().setVisible(true);

                     }catch (Exception e) {
                         System.out.println(e);
                     }

                }
                if (a == "photographer") {
                    try{
                        FileWriter fw = new FileWriter("photographer.txt", true);
                        fw.write(v.get(0)+"\t" + v.get(1)+"\t" + v.get(2)+"\t" + v.get(3)+"\n");
                        fw.close();
                        Frame f = new JFrame();
                        JOptionPane.showMessageDialog(f, "Successfully photographer added");
                        setVisible(false);
                        new Dashboard().setVisible(true);

                     }catch (Exception e) {
                         System.out.println(e);
                     }
                }
                if (a == "caterer")
                {   
                     try{
                        FileWriter fw = new FileWriter("caterer.txt", true);
                        fw.write(v.get(0)+"\t" + v.get(1)+"\t" + v.get(2)+"\n");
                        fw.close();
                        Frame f = new JFrame();
                        JOptionPane.showMessageDialog(f, "Successfully caterer added");
                        setVisible(false);
                        new Dashboard().setVisible(true);

                     }catch (Exception e) {
                         System.out.println(e);
                     }
                }
                
        
//                try{
//                    c.s.executeUpdate(q);
//                    JOptionPane.showMessageDialog(null, a+"Successfully Added");
//                        setVisible(false);
//
//                }catch (Exception ex) {
//                    JOptionPane.showMessageDialog(null, "error");
//                    //Logger.getLogger(Venue.class.getName()).log(Level.SEVERE, null, ex);
//                }
            }
	});

	b2 = new JButton("Back");
//	b2.addActionListener((ActionListener) this);
	b2.setBounds(198, 70+j, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);
                        
	b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    setVisible(false);
                    new Dashboard().setVisible(true);
                
                
                }catch(Exception e ){}
                
    }
        }
        );
//        b3 = new JButton("Delete");
////	b3.addActionListener((ActionListener) this);
//	b3.setBounds(64, 70+j, 111, 33);
//        b3.setBackground(Color.BLACK);
//        b3.setForeground(Color.WHITE);
//	contentPane.add(b3);
//        b3.

	
        contentPane.setBackground(Color.WHITE);
        setVisible(true);
        }
     public static void main(String args[]){
//         String s[] = new String[]{"id","name","image_url","price","capacity","facilites","description"};
//         addtodb a = new addtodb(s);
     }

    
}

