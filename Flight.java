/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;
import java.util.Random;

/**
 *
 * @author joshg
 */
public class Flight {
    double[] prices = {250, 300, 325, 400, 550, 600, 800, 975, 1200};
    String Airline;
    String Time;
    String Destination;
    String[] classes = {"Economy", "First Class", "Business Class"};
    int[] passengerCount = {250, 300, 350, 400, 500, 550, 600, 800};
    String flightClass;
    double Price;
    int passengerLimit;
    int availableSeats;

    Random random = new Random();


        public Flight(String Airlines, String Destinations, String Time){
            this.Airline = Airlines;
            this.Destination = Destinations;
            this.Time = Time;
            this.flightClass = classes[random.nextInt(classes.length)];
            this.Price = prices[random.nextInt(prices.length)];
            this.passengerLimit = passengerCount[random.nextInt(passengerCount.length)];
            this.availableSeats = random.nextInt(passengerLimit);
        }

        public void viewFlight(){
            System.out.println("Airline: "+this.Airline + "\n" +"Destination: "+ this.Destination + "\n" +"Flight Departure: "+ this.Time + "\n" + "Class: "+ this.flightClass + "\n" + "Price: $"+this.Price + "\n"+"Available Seats: "+availableSeats + "\nPassenger Limit: "+this.passengerLimit + "\n");
        }

    
}
