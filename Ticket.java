/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author joshg
 */
public class Ticket {
    Flight flight;
    User user;
    int ticketID;
    String seat;
    double totalPrice;
    String[] seatFile = {"N", "B", "A", "C", "F", "D", "J", "T", "M", "N"};
    Random random = new Random();
    public Ticket(Flight flight, User user){
        this.flight = flight;
        this.user = user;
        ticketID++;
    }
    public void bookTicket(){
        if(flight.availableSeats < flight.passengerLimit){
            seat = "" + seatFile[random.nextInt(seatFile.length)] + random.nextInt(flight.availableSeats);
            totalPrice = (flight.Price * 0.13) + flight.Price;
            if(User.Balance > totalPrice){
                User.Balance = User.Balance - totalPrice;
        try{
            FileWriter bookticket = new FileWriter("C://Users//joshg//fileread//Tickets.txt", true);
            bookticket.append("Airline: "+ flight.Airline + "\nDestination: "+flight.Destination+"\n\tDeparture Time: "+flight.Time + "\n\t" + "Class: "+ flight.flightClass + "\n\t" + "Total Price: $"+totalPrice + "\n\t" + "TicketID: "+ticketID + "\n\tSeat: "+seat +"\n"+"User ID: "+user.id+"\n\n");//appending to file
            bookticket.close();
            flight.availableSeats++;
            System.out.println("Booking success: heres your ticket id incase of cancelation "+ticketID);
        } catch(IOException e){
            System.out.println("Error in registering: "+ e.getMessage());
                
        } 
        } else{
            System.out.println("Insufficient Funds.");
        }
      } else{
        System.out.println("Cannot book ticket. Flight already at maximum capacity.");
      }
    }
    public void cancelTicket(int ticketID) throws IOException{
        String id = "" + ticketID;
        Reader reader = new Reader();
        String[] tickets = reader.read("C://Users//joshg//fileread//Tickets.txt");
        for (int z = 0; z < tickets.length; z++){
            if(tickets[z].contains(id)){
                User.Balance += totalPrice;
                System.out.println("Cancellation Success you have been refunded.");
            }
        }
        

    }
    // private void paymentMethod(){
        
    // }
}
