/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package finalproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author joshg
 */
public class FinalProject {

    /**
     * @param args the command line arguments
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException{

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

      Sysup system = new Sysup();
      system.main();

      Flight[] flights = system.getFlights();

      ImageIcon icon = new ImageIcon("C://Users//joshg//fileread//airline.jpeg");
      Image image = icon.getImage();
      Image newImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
      icon = new ImageIcon(newImage);

      JLabel label = new JLabel();
      label.setText("Java Airlines");
      label.setIcon(icon);
      Font customfont = new Font("Poppins", Font.PLAIN, 45);
      label.setFont(customfont);
      label.setHorizontalAlignment(JLabel.CENTER);
     

      
      
   

      JPanel panel1 = new JPanel();
      panel1.setBackground(Color.GRAY);
      panel1.setPreferredSize(new Dimension(screenWidth, 200));
      panel1.setLayout(new BorderLayout());
      panel1.add(label);


      JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.ORANGE);
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));  // Center buttons horizontally
        buttonsPanel.setPreferredSize(new Dimension(screenWidth, 100));

        JButton booking = new JButton("Book a Flight");  // Set preferred size

        JButton tickets = new JButton("Your Tickets");

        JButton deposit = new JButton("Deposit Money");

        JButton account = new JButton("Account");

        buttonsPanel.add(booking);
        buttonsPanel.add(tickets);
        buttonsPanel.add(deposit);
        buttonsPanel.add(account);
      
      

      JPanel panel2 = new JPanel();
      panel2.setBackground(Color.DARK_GRAY);
      panel2.setLayout(new GridLayout(15, 4, 20, 20));
      
      
      
      
      
      for (int i = 0; i < flights.length; i++) {
        JPanel flightPanel = new JPanel();
        flightPanel.setLayout(new BorderLayout()); // Or a suitable layout manager
        flightPanel.setBackground(Color.WHITE);
        flightPanel.setPreferredSize(new Dimension(150, 150));

        JLabel uiFlight = new JLabel("<html>"+flights[i].Airline + "<br>" + flights[i].Destination + "<br>$" + flights[i].Price + "<br>" + flights[i].Time + "<br>"+ flights[i].availableSeats+"/"+flights[i].passengerLimit+"<br><br></html>"); // Flight info
    
        JButton book = new JButton("Book Flight");
    
        flightPanel.add(uiFlight, BorderLayout.CENTER);
        flightPanel.add(book, BorderLayout.SOUTH); // Example placement
    
        panel2.add(flightPanel);
    }
    
      
      
      JScrollPane scrollPane = new JScrollPane(panel2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
      
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new BorderLayout());
      frame.setSize(screenWidth,screenHeight);
      frame.add(panel1, BorderLayout.NORTH);
      frame.add(buttonsPanel, BorderLayout.SOUTH);
      frame.add(scrollPane, BorderLayout.CENTER);

      frame.setVisible(true);
    }
    
    
}
