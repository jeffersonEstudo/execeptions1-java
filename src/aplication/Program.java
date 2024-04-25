package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner user = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Room number: ");
			int number = user.nextInt();
			System.out.println("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(user.next());
			System.out.println("Check-Out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(user.next());
	       
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.printf("Reservation: %s", reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.println("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(user.next());
			System.out.println("Check-Out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(user.next());
			
			
			
			
			reservation.updateDates(checkIn, checkOut);
			System.out.printf("Reservation: %s", reservation);
		}
        catch(ParseException e) {
        	System.out.println("Invalid date format");
        }	  
		catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch(RuntimeException e ) {
			System.out.println("Unexécted error");
		}
		
	user.close();
	}

}
