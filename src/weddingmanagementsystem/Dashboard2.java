package weddingmanagementsystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Orpa, Nushrat, Nur;
 */
public class Dashboard2 extends JFrame {

    Dashboard2() {
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(500, 300, 1000, 600);

        ImageIcon i1 = new ImageIcon("C:/Users/User/Documents/NetBeansProjects/WeddingManagementSystem/Weddings2.jpg");
        Image i2 = i1.getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel NewLabel = new JLabel(i3);
        NewLabel.setBounds(0, 0, 1000, 600);
        add(NewLabel);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu jm1 = new JMenu("Reception");
        jm1.setForeground(Color.BLACK);
        menuBar.add(jm1);

        JMenuItem a1 = new JMenuItem("Add an event");
        jm1.add(a1);
        a1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    System.out.println("Add event clicked");
                    setVisible(false);
                    new AddEvent().setVisible(true);

                } catch (Exception e) {
                }
            }
        });

        JMenuItem b2 = new JMenuItem("Back");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    setVisible(false);
                    new WeddingManagementSystem().setVisible(true);

                } catch (Exception e) {
                }

            }
        }
        );

        jm1.add(b2);

        setLayout(null);

        setVisible(true);

    }

    public static void main(String args[]) {
        Dashboard2 d = new Dashboard2();

    }
}
