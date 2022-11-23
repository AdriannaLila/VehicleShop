package org.makerminds.jcoaching.finalexam.model;

/**
 * class for vehicle objects.
 * 
 * @author <Adriana Lila>
 *
 */
public class Vehicle {
	
	// TODO Vehicle implementation
	// TODO add attributes and Getters / Setters
	
	@Override
	public String toString() {
		return "Vehicle [ID=" + ID + ", manufacturer=" + manufacturer + ", model=" + model + ", velocity=" + velocity
				+ ", price=" + price + ", color=" + color + ", kilometers=" + kilometers + ", productionYear="
				+ productionYear + ", fuelType=" + fuelType + ", transmission=" + transmission + "]";
	}
	private int ID;
	private Manufacturer manufacturer;
	private String model;
	private int velocity;
    private double price;
	private Color color;
	private int kilometers;
	private int productionYear;
	
	

	public Vehicle(int iD, Manufacturer manufacturer, String model, int velocity, double price, Color color,
			int kilometers, int productionYear, FuelType fuelType, Transmission transmission) {
		super();
		ID = iD;
		this.manufacturer = manufacturer;
		this.model = model;
		this.velocity = velocity;
		this.price = price;
		this.color = color;
		this.kilometers = kilometers;
		this.productionYear = productionYear;
		this.fuelType = fuelType;
		this.transmission = transmission;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Manufacturer getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getVelocity() {
		return velocity;
	}
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getKilometers() {
		return kilometers;
	}
	public void setKilometers(int kilometers) {
		this.kilometers = kilometers;
	}
	public int getProductionYear() {
		return productionYear;
	}
	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}
	public FuelType getFuelType() {
		return fuelType;
	}
	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}
	public Transmission getTransmission() {
		return transmission;
	}
	public void setTransmission(Transmission transmission) {
		this.transmission = transmission;
	}
	private FuelType fuelType;
	private Transmission transmission;
	
}
