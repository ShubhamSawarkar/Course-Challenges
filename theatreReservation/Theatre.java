package com.theatreReservation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Theatre {

	private String theatreName;
	private List<Seat> seats = new LinkedList<Seat>();
	private int seatsPerRow;
	private int totalRows;
;
	
	public Theatre(String name, int seatsPerRow, int totalRows)
	{
		this.theatreName = name;
		this.seatsPerRow = seatsPerRow;
		this.totalRows = totalRows;
		for(int i = 'A'; i <= 'A' + totalRows; i++)
		{
			for(int j = 0; j < seatsPerRow; j++)
			{
				seats.add(new Seat(Character.toString(i) + String.format("%02d", j+1)));
			}
		}
	}
	
	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public void printSeats() {
		List<Seat> reverseSeats = new ArrayList<Seat>(seats);
		Collections.reverse(reverseSeats);
		int count = 0;
		
		System.out.println("\t\t\t\t[FIRST SEAT] : " + Collections.min(reverseSeats).getNumber() + "\n"
						   + "\t\t\t\t [LAST SEAT] : " + Collections.max(reverseSeats).getNumber());
		
		for(Seat seat : reverseSeats)
		{
			if(count == seatsPerRow)
			{
				System.out.println();
				count = 0;
			}
			if(seat.isReserved)
			{
			System.out.print("{");
			}
			System.out.print(seat.getNumber());
			if(seat.isReserved)
			{
			System.out.print("}		");
			}
			else
			{
			System.out.print("		");
			}
			count++;
		}
		System.out.println();
		System.out.println("===================================================================================================================");
		System.out.println("\t\t\t\t\tALL EYES THIS WAY PLEASE\t");
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public boolean reserveSeat(String seatNo)
	{
		Seat requestedSeat = new Seat(seatNo);
		int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
		if(foundSeat >= 0)
		{
			if(seats.get(foundSeat).reserve())
				return true;
			else return false;
		}else
		{
			System.out.println("No such seat with seat no " + seatNo);
			return false;
		}
		/*
		 * for(Seat seat : seats) { if(seat.getNumber().equalsIgnoreCase(seatNo)) {
		 * if(seat.getStatus()) { System.out.println("Seat " + seatNo +
		 * " already reserved!"); return false; }else { seat.reserve(); return true; } }
		 * 
		 * } System.out.println("Incorrect seat number!"); return false;
		 */	
	}
	
	public List<Seat> sortByPrice()
	{
		List<Seat> seatsCopy = new ArrayList<Seat>(seats);
		Comparator<Seat> comparator = new Comparator<Seat>() {
			@Override
			public int compare(Seat seat1, Seat seat2) {
				return seat1.price - seat2.price;
			}};
		Collections.sort(seatsCopy, comparator);
		
		return seatsCopy;
	}
	
	private class Seat implements Comparable<Seat>
	{
		private String number;
		private boolean isReserved;
		private int price;
		
		public Seat(String name) {
			this.number = name;
			this.isReserved = false;
			if(("A00".compareTo(name) > 0) && ("D00".compareTo(name) < 0))
			{
			this.price = 100;
			}else if("F00".compareTo(name) < 0)
			{
				this.price = 150;
			}else 
			{
				this.price = 200;
			}
		}

		public int getPrice() {
			return price;
		}

		public String getNumber() {
			return number;
		}
		
		public boolean reserve()
		{
			if(!this.isReserved) 
			{
			this.isReserved = true;
			System.out.println("Seat " + this.getNumber() + " reserved successfully!");
			return true;
			}
			else 
			{
			System.out.println("Seat already reserved by someone else!");
			return false;
			}
		}
		
		public boolean getStatus()
		{
			return this.isReserved;
		}
		
		@Override
		public int compareTo(Seat seat)
		{
			return this.number.compareToIgnoreCase(seat.getNumber());
		}
	}
}
