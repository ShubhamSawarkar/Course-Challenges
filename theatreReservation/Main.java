package com.theatreReservation;

public class Main {
	
	public static void main(String argv[])
	{
		Theatre theatre = new Theatre("Carnival Cinema", 8, 12);
		theatre.printSeats();
		theatre.reserveSeat("A06");
		theatre.reserveSeat("A03");
		theatre.reserveSeat("D01");
		theatre.reserveSeat("D12");
		theatre.reserveSeat("C02");
		theatre.reserveSeat("C08");
		theatre.reserveSeat("E07");
		theatre.reserveSeat("B04")
		theatre.reserveSeat("M05");

		System.out.println("\t\t\t\t\t ****AFTER RESERVATION**** \t\t");
		theatre.printSeats();
	}
	
}
