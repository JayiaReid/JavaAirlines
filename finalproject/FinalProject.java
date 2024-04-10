/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package finalproject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author joshg
 */
public class FinalProject {

    /**
     * @param args the command line arguments
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        int i = 0;
        Flight[] flights = new Flight[50];
        while(i < 50){

        Random random = new Random();
        Reader reader = new Reader();
        //read destination data
        String[] Destinations = reader.read("C://Users//joshg//fileread//Destinations.txt");
        String destination = Destinations[random.nextInt(Destinations.length)];
        //read airline data
        String[]  Airlines= reader.read("C://Users//joshg//fileread//Airlines.txt");
        String airline = Airlines[random.nextInt(Airlines.length)];
        //read time data
        String Times[] = reader.read("C://Users//joshg//fileread//FlightTimes.txt");
        String time = Times[random.nextInt(Times.length)];

        Flight flight = new Flight(airline, destination, time);
        flight.viewFlight();
            flights[i] = flight;
            i++;
        }

        try{
            FileWriter availableFlight = new FileWriter("C://Users//joshg//fileread//AvailableFlights.txt", true);
            int j = 0;
            while(j < 50){
                availableFlight.append("Airline: "+ flights[j].Airline + "\nDestination: "+flights[j].Destination+"\nDeparture Time: "+flights[j].Time + "\n" + "Class: "+ flights[j].flightClass + "\n" + "Price: $"+flights[j].Price + "\n" + "Passenger Limit: "+flights[j].passengerLimit + "\n\n" );//appending to file
                j++;
            }
            
            availableFlight.close();
        } catch(IOException e){
            System.out.println("Error in registering: "+ e.getMessage());
                
        } 

        User user = new User();
        Ticket ticket = new Ticket(flights[2], user);
        ticket.bookTicket();
    }
    
    
}
