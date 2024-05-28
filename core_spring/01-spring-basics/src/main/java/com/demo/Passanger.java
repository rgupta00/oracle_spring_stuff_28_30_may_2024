package com.demo;
//if i have a new choice of vehicle i have to change the code of passanger class
//god or bad

//Passanger----> bike
//				car
//				bus
//rather then passanger looks for name and vehicle it should be injected
//spring added to the project?

//how spring come to know that passanger need vehicle
//config file: 
	//xml, annotation, java configuration


public class Passanger {
	
	private String name;
	
	private Vehicle vehicle;
	
	public void setName(String name) {
		this.name = name;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public void travel() {
		System.out.println("name of the passanger : "+ name);
		vehicle.move();
	}

}
