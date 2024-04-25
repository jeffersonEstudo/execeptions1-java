package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner user = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Room number: ");
		int number = user.nextInt();
		System.out.println("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(user.next());
		System.out.println("Check-Out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(user.next());
       
		if(!checkOut.after(checkIn)) {
	  System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
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
		
		user.close();
	}

}
