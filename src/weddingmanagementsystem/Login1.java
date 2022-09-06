
package weddingmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
/**
 *
 * @author Orpa, Nushrat, Nur;
 */
public class Login1 extends JFrame{
    JLabel l, l1,l2;
    JTextField t1;
    JPasswordField p1;
    JButton b1,b2;
    String type;
    Login1(String s1){
        super("NNO Wedding Management System");
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        l = new JLabel("Login Panel");
        l.setFont(new Font("Times New Roman", Font.BOLD, 30));
        l.setForeground(Color.BLACK);
        l.setBounds(350, 10, 1000, 100);
        add(l);
        this.type = s1;
        System.out.println(s1);
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
        
        p1 = new JPasswordField();
        p1.setBounds(200,250,150,30);
        add(p1);
        
        b1 = new JButton("Login");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(100,360,100,30);
        add(b1);
        b1.addActionListener( new ActionListener(){
                
            public void actionPerformed(ActionEvent ae){
                try{
                    System.out.println("Login Clicked");
                    String u = t1.getText();
                    String p = p1.getText();
                    boolean matched = false;
                    if (type == "admin") {
                        
                        try {
                            FileReader fr = new FileReader("adminLogin.txt"); 
                            BufferedReader br = new BufferedReader(fr);
                            String line;
                            
                            while((line = br.readLine())!=null){
                                
                                if(line.equals(u+"\t"+p)){
                                    matched = true;
                                    break;
                                }
                            }
                            fr.close();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        
                    }
                    else if (type == "customer") {
                        try {
                            FileReader fr = new FileReader("login.txt"); 
                            BufferedReader br = new BufferedReader(fr);
                            String line;
                            while((line = br.readLine())!=null){
                                if(line.equals(u+"\t"+p)){
                                    matched = true;
                                    break;
                                }
                            }
                            fr.close();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }

 
                    if(matched) { 
                        if (type == "admin") {
                            System.out.println("Logged in");
                            new Dashboard().setVisible(true);
                        }
                            // 
                        else if (type == "customer") {
                            System.out.println("Logged in customer");
                            new Dashboard2().setVisible(true);
                        }
                        

                        setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "Invalid login");
                        new WeddingManagementSystem().setVisible(true);
                        setVisible(false);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
        
            }
        });
        
        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(210,360,100,30);
        add(b2);
        b2.addActionListener(new ActionListener(){
                
              public void actionPerformed(ActionEvent ae){
                  new WeddingManagementSystem().setVisible(true);
//                  System.exit(0);
              }
        
        } );
        
        
        setLayout(null);
        setBounds(500,300,1000,600);
        setVisible(true);       
        if (type == "customer"){
            Customer();
            
        }
        
    }
    void Customer(){
        JButton b3 = new JButton("Register");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(320,360,100,30);
        add(b3);
        b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                new Register().setVisible(true);
                //System.out.println("Register clicked");
            }
              
        });
        
    }
}