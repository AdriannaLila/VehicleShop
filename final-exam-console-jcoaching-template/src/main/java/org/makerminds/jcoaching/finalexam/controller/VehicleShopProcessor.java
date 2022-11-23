package org.makerminds.jcoaching.finalexam.controller;

import java.util.Iterator;
import java.util.List;

import org.makerminds.jcoaching.finalexam.model.Vehicle;

/**
 * responsible for processing business processes.
 * 
 * @author <Adriana Lila>
 *
 */
public class VehicleShopProcessor {
	
	/**
	 * responsible to sell a specified vehicle by id
	 * @param vehiclesList
	 * @param vehicleChosenId
	 */
	public void sellVehicle(List<Vehicle> vehiclesList, int vehicleChosenId) {
		// TODO selling a vehicle means to remove it from the available vehicle list
		// Hint: use while loop to safely remove an object from a lst
		
		Iterator<Vehicle> iterateInVehicleList=vehiclesList.iterator();
		while(iterateInVehicleList.hasNext()) {
			Vehicle vehicle=iterateInVehicleList.next();
			if(vehicle.getID()==vehicleChosenId) {
		iterateInVehicleList.remove();
		}
	}
		if(vehicleChosenId>vehiclesList.size())
		throw new IllegalArgumentException("No valid ID provided!");
   }
}