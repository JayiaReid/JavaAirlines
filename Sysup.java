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
public class Sysup {
  Flight[] flights = new Flight[50];  

    public void main() throws IOException{
        int i = 0;
    
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

    //generate flights and store in array
    Flight flight = new Flight(airline, destination, time);
    flight.viewFlight();
        flights[i] = flight;
        i++;
    }
//write the flights made to a text file for later use
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
    
//ticket developement testing
    User user = new User(1);
    Ticket ticket = new Ticket(flights[2], user);
    ticket.bookTicket();
    }

    public Flight[] getFlights(){
        return flights;
    }
    
    
}
