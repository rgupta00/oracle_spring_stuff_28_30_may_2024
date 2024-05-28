package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//<bean id="passanger" class="com.demo.Passanger" scope="prototype" autowire="byType">
//<property name="name" value="ram"/>
//</bean>

@Component(value = "passanger")	
@Scope("prototype")
public class Passanger {
	
	@Value(value = "ram") 
	private String name;
	
	@Autowired	
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
