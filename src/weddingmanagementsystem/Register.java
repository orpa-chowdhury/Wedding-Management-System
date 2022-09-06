
package weddingmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Orpa, Nushrat, Nur;
 */
public class Register extends JFrame {
    JPasswordField p1;
    JTextField t1, t2;
    JLabel l,l1,l2;
    JButton b1;
    Register(){
        super("NNO Wedding Management System");
        l = new JLabel("User Registration");
        l.setFont(new Font("Times New Roman", Font.BOLD, 30));
        l.setForeground(Color.BLACK);
        l.setBounds(350, 10, 1000, 100);
        add(l);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //ImageIcon i1 = new ImageIcon("C:/Users/User/Documents/NetBeansProjects/WeddingManagementSystem/Wedding4.jpg");
        //JLabel l1 = new JLabel(i1);
        //l1.setBounds(0,0,1000,600);
        //add(l1);
        ImageIcon i1 = new ImageIcon("C:/Users/User/Documents/NetBeansProjects/WeddingManagementSystem/Profile1.jpg");
        Image q1 = i1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(q1);
        JLabel l3 = new JLabel(i2);
        l3.setBounds(380,100,800,300);
        add(l3);
        getContentPane().setBackground(Color.PINK);
        l1 = new JLabel("Username");
        l2 = new JLabel("Password");
        l1.setBounds(100,200,100,30);
        l2.setBounds(100,250,100,30);
        add(l1);
        add(l2);
        t1 = new JTextField();
        t1.setBounds(200,200,150,30);
        add(t1);
        
        t2 = new JPasswordField();
        t2.setBounds(200,250,150,30);
        add(t2);

        b1 = new JButton("Register");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(100,360,100,30);

        add(b1);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){

                try{
                   FileWriter fw = new FileWriter("login.txt", true);
                   fw.write(t1.getText()+"\t" + t2.getText() + "\n");
                   fw.close();
                   Frame f = new JFrame();
                   JOptionPane.showMessageDialog(f, "Registration Completed");
                   setVisible(false);
                   new WeddingManagementSystem().setVisible(true);

                }catch (Exception e) {
                    System.out.println(e);
                }


            }
        });
        JButton b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(230,360,100,30);
       
	b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    setVisible(false);
                    //new WeddingManagementSystem().setVisible(true);
                    new Login1("customer").setVisible(true);
                
                
                }catch(Exception e ){
                    System.out.println(e);
                }
                
            }
        });
	
	add(b2);
        
        setLayout(null);
        setBounds(500,300,1000,600);
        setVisible(true);
             
    }
    public static void main(String args[]){
        Register r = new Register();
    }
    
}