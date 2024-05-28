package com.demo;

public class Main {
	
	public static void main(String[] args) {
	
		Vehicle vehicle=new Bike();
		
		Passanger passanger=new Passanger();
		
		passanger.setName("ram");
		passanger.setVehicle(vehicle);
		
		passanger.travel();
	}

}
