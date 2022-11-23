package org.makerminds.jcoaching.finalexam.controller;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import org.makerminds.jcoaching.finalexam.model.Vehicle;

/**
 * managing the file.
 * 
 * @author <Adriana-Lila>
 *
 */
public class VehicleFileManager {
	
	private String filePath;
	public VehicleFileManager(String filePath) {
		this.filePath = filePath;
	}
	public List<String> importVehiclesFromFile(){
		// TODO read vehicle-list-txt and transform to String array(list ?)
		// Hint: use java.nio.file.Files and Paths class
		
		List<String> createdListFromFile=new ArrayList<>();
		    try {
				createdListFromFile=Files.readAllLines(Paths.get(getClass().getResource(filePath).toURI()));
			} catch (IOException | URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(createdListFromFile.toString());
		return createdListFromFile;
		
	}
	public void rewriteFile(List<Vehicle> vehicleList) {
		// TODO write back into vehicle-list-txt and transform to String array
		// TODO call method prepareTheVehicleForRewriting(StringBuffer, Vehicle)
		// Hint: use java.nio.file.Path and java.nio.file.Paths class
	
		StringBuffer vehicleStringForRewrite=new StringBuffer();
		for(Vehicle vehicleItem : vehicleList) {
			prepareTheVehicleForRewriting(vehicleStringForRewrite, vehicleItem);
			vehicleStringForRewrite.append("\r\n");
		}
		try {	
			Path path;
			try {
				path = Paths.get(getClass().getResource(filePath).toURI());
				Files.writeString(path, vehicleStringForRewrite.toString());
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	    //Files.write(Paths.get(filePath),vehicleStringForRewrite.toString().getBytes(),StandardOpenOption.WRITE,StandardOpenOption.TRUNCATE_EXISTING);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	private void prepareTheVehicleForRewriting(StringBuffer vehicleStringForRewrite, Vehicle vehicle) {
		// TODO add vehicle attribute information to StringBuffer
		// Hint: vehicleStringForRewrite.append(String)
		
		vehicleStringForRewrite.append(vehicle.getID());
		vehicleStringForRewrite.append(",");
		vehicleStringForRewrite.append(vehicle.getManufacturer());
		vehicleStringForRewrite.append(",");
		vehicleStringForRewrite.append(vehicle.getModel());
		vehicleStringForRewrite.append(",");
		vehicleStringForRewrite.append(vehicle.getVelocity());
		vehicleStringForRewrite.append(",");
		vehicleStringForRewrite.append(vehicle.getPrice());
		vehicleStringForRewrite.append(",");
		vehicleStringForRewrite.append(vehicle.getColor());
		vehicleStringForRewrite.append(",");
		vehicleStringForRewrite.append(vehicle.getKilometers());
		vehicleStringForRewrite.append(",");
		vehicleStringForRewrite.append(vehicle.getProductionYear());
		vehicleStringForRewrite.append(",");
		vehicleStringForRewrite.append(vehicle.getFuelType());
		vehicleStringForRewrite.append(",");
		vehicleStringForRewrite.append(vehicle.getTransmission());

	}

}
