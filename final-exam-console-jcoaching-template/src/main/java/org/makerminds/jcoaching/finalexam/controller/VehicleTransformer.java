package org.makerminds.jcoaching.finalexam.controller;

import java.util.LinkedList;
import java.util.List;
import org.makerminds.jcoaching.finalexam.model.Color;
import org.makerminds.jcoaching.finalexam.model.FuelType;
import org.makerminds.jcoaching.finalexam.model.Manufacturer;
import org.makerminds.jcoaching.finalexam.model.Transmission;
import org.makerminds.jcoaching.finalexam.model.Vehicle;



/**
 * responsible for transforming vehicle data into {@link Vehicle} objects.
 * 
 * @author <Adriana Lila>
 *
 */
public class VehicleTransformer {
	/**
	 * transforms a data array into a {@link Vehicle} list 
	 * @param vehicle data array
	 * @return list of {@link Vehicle} objects
	 */
	public List<Vehicle> transformDataArrayToVehicleObjects(List<String> vehicleDataArray) {
		//TODO take data from String list and transform to list of vehicle objects
		// TODO call method transformToVehicleObject
		// Hint: use for loop
		List<Vehicle>resultListWithVehicles=new LinkedList<Vehicle>();
		
		for(int i=0; i<vehicleDataArray.size();i++) {
			Vehicle vehicle=transformToVehicleObject(vehicleDataArray.get(i));
			resultListWithVehicles.add(vehicle);
		}
		return resultListWithVehicles;
	}

	/**
	 * transforms a vehicle data record as String into a {@link Vehicle} object
	 * @param vehicle data record as String 
	 * @return {@link Vehicle} object
	 */
	private Vehicle transformToVehicleObject(String vehicleAsString) {
		//TODO transform the vehicle as string into a vehicle object
				// Hint: use the split(String) method of a String to define where to split the 
				// String. In this case split on every comma (;)
		Vehicle vehicle=null;
		String [] carArray=vehicleAsString.split(",");

			int vehicleId=Integer.valueOf(carArray[0]);
			Manufacturer manufacturer=Manufacturer.valueOf(carArray[1]);
			String model=String.valueOf(carArray[2]);
			int velocity=Integer.valueOf(carArray[3]);
			double price=Double.valueOf(carArray[4]);
			Color color=Color.valueOf(carArray[5]);
			int kilometers=Integer.valueOf(carArray[6]);
			int productionYear=Integer.valueOf(carArray[7]);
			FuelType fuelType=FuelType.valueOf(carArray[8]);
			Transmission transmission=Transmission.valueOf(carArray[9]);
		 vehicle=new Vehicle(vehicleId, manufacturer, model, velocity, price, color, kilometers, productionYear, fuelType, transmission);
			return vehicle;
	}
}
