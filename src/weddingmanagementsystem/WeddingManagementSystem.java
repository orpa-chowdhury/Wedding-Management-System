
package weddingmanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Orpa, Nushrat, Nur;
 */

public class WeddingManagementSystem extends JFrame{
    
    WeddingManagementSystem(){
        super("NNO Wedding Management System");
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel l, l2;
        setBounds(500,300,1000,600);
        l = new JLabel("Welcome to our website");
        l.setFont(new Font("Times New Roman", Font.BOLD, 30));
        l.setForeground(Color.WHITE);
        l.setBounds(450, 200, 300, 100);
        add(l);
        l2 = new JLabel("Login as:");
        l2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        l2.setForeground(Color.WHITE);
        l2.setBounds(550, 250, 300, 100);
        add(l2);
        ImageIcon i1 = new ImageIcon("C:/Users/User/Documents/NetBeansProjects/WeddingManagementSystem/Wedding4.jpg");
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0,0,1000,600);
        add(l1);
        
        JButton b1 = new JButton("User");
        b1.setBackground(Color.PINK);
        b1.setForeground(Color.BLACK);
        b1.setBounds(450,350,150,50);
        l1.add(b1);
        b1.addActionListener(new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                new Login1("customer").setVisible(true);
                
                
        }
        });
            
        JButton b2 = new JButton("Admin");
        b2.setBackground(Color.PINK);
        b2.setForeground(Color.BLACK);
        b2.setBounds(610,350,150,50);
        l1.add(b2);
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                new Login1("admin").setVisible(true);
                
                
        }
        
        
        });
        setLayout(null);
        
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        WeddingManagementSystem m = new WeddingManagementSystem();
    }
    
}
