package advanced.DefiningClasses.SpeedRacing;

public class Car {

	private String model;
	private double fuelAmount;
	private double consumtion;
	private int distance;

	public Car(String model, double fuelAmount, double consumtion) {
		this.model = model;
		this.fuelAmount = fuelAmount;
		this.consumtion = consumtion;
		this.distance = 0;
	}

	public boolean hasEnoughFuel(int km) {
		double fuelNeeded = getFuelNeeded(km);
		return this.getFuelAmount() >= fuelNeeded;
	}

	private double getFuelNeeded(int km) {
		return km * this.getConsumtion();
	}

	public void drive(int km){
		double fuelNeeded = getFuelNeeded(km);
		this.setFuelAmount(this.getFuelAmount() - fuelNeeded);
		this.setDistance(this.getDistance()+km);
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getFuelAmount() {
		return fuelAmount;
	}

	public void setFuelAmount(double fuelAmount) {
		this.fuelAmount = fuelAmount;
	}

	public double getConsumtion() {
		return consumtion;
	}

	public void setConsumtion(double consumtion) {
		this.consumtion = consumtion;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distance);
	}
}
