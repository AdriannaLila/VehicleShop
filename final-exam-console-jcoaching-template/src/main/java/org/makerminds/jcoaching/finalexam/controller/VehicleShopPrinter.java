package org.makerminds.jcoaching.finalexam.controller;

import java.util.List;

import org.makerminds.jcoaching.finalexam.model.Vehicle;

/**
 * responsible for printing vehicle shop data.
 * 
 * @author <Adriana Lila>
 *
 */
public class VehicleShopPrinter {
	
	public  void printAvailableVehicles(List<Vehicle> vehicleList) {
		for (int i=0; i<vehicleList.size();i++) {
			System.out.println(vehicleList.get(i));
		}
	}

	public  void printVehicleSoldMessage(int vehicleChosenId) {
		// \n in a String will cause a line break
		System.out.println("\n" + "Vehicle with ID " + vehicleChosenId + " was sold.");
	}
	public void printVehicleIdToSellRequest() {
		// \n in a String will cause a line break
		System.out.println("\n\n Please enter the number (ID) of the vehicle you want to sell: ");
	}
}
