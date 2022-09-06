
package weddingmanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Orpa, Nushrat, Nur;
 */
public class Dashboard extends JFrame {
    Dashboard() {
        
        super("NNO Wedding Management System");
        setBounds(500,300,1000,600);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        ImageIcon i1 = new ImageIcon("C:/Users/User/Documents/NetBeansProjects/WeddingManagementSystem/Wedding5.jpg");
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0,0,1000,600);
        add(l1);

        JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
        
        
        JMenu jm1 = new JMenu("Menu");
        jm1.setForeground(Color.BLACK);
	menuBar.add(jm1);
        JMenuItem a1 = new JMenuItem("Event List");
	jm1.add(a1);
        a1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                try{
                    String s[] = new String[]{"Name","Venue","Photographer","Caterer","Date","Number of Persons","Total Cost"}; 
                    setVisible(false);
                    System.out.println("Add Venue");
                    new EventList(s).setVisible(true);
                }catch(Exception e ){}
            }
        });
        
        JMenuItem a2 = new JMenuItem("Add Venue");
	jm1.add(a2);
        a2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    String s[] = new String[]{"Name","Image_Url","Price","Capacity","Facilites","Description"}; 
                    setVisible(false);
                    System.out.println("Add Venue");
                    new AddToFile(s,"venue").setVisible(true);
                }catch(Exception e ){}
            }
	});
        JMenuItem a3 = new JMenuItem("Add Photographer");
	jm1.add(a3);
        a3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    String s[] = new String[]{"name","contact_id","price","duration"}; 
                    setVisible(false);
                    System.out.println("Add Photographer");
                    //new addtodb(s,"photographer").setVisible(true);
                    new AddToFile(s,"photographer").setVisible(true);
                }catch(Exception e ){}
            }
	});
        JMenuItem a4 = new JMenuItem("Add Caterer");
	jm1.add(a4);
        a4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    String s[] = new String[]{"Caterer","Menu","Budget/Plate"}; 
                    setVisible(false);
                    System.out.println("Add Caterer");
                    //new addtodb(s,"caterer").setVisible(true);
                    new AddToFile(s,"caterer").setVisible(true);
                }catch(Exception e ){}
            }
	});
        JMenuItem b2 = new JMenuItem("Back");
	b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    setVisible(false);
                    new WeddingManagementSystem().setVisible(true);
                
                
                }catch(Exception e ){}
                
    }
        }
        );
	
	jm1.add(b2);
        
        JMenu jm2 = new JMenu("Wedding MANAGEMENT");
        jm2.setForeground(Color.BLACK);
	menuBar.add(jm2);

        JMenuItem venue = new JMenuItem("Venue");
	jm2.add(venue);
        venue.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    System.out.println("Venue");
                    //new viewdetails("venue").setVisible(true);
                }catch(Exception e ){}
            }
	});
        JMenuItem photographer = new JMenuItem("photographer");
	jm2.add(photographer);
        photographer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    System.out.println("Photographer");
                    //new viewdetails("photographer").setVisible(true);
                }catch(Exception e ){}
            }
	});
        JMenuItem caterer = new JMenuItem("Caterer");
	jm2.add(caterer);
        caterer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    System.out.println("Caterer");
                    //new viewdetails("caterer").setVisible(true);
                }catch(Exception e ){}
            }
	});
          
        setLayout(null);  
        setVisible(true); 
        
}
    public static void main(String args[]){
        Dashboard d = new Dashboard();
        
    }
    
}
