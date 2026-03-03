/******************************************************************************

Eura Pulliam
3.3.2026
Assessment: Car Data Analyzer

*******************************************************************************/
public class Car {

    private String carID;
    private String brand;
    private String model;
    private int year;
    private String fuelType;
    private String color;
    private double mileage;

    public Car(String carID, String brand, String model, int year,
               String fuelType, String color, double mileage) {
        this.carID = carID;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        this.color = color;
        this.mileage = mileage;
    }

    public String getCarID() { return carID; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public String getFuelType() { return fuelType; }
    public String getColor() { return color; }
    public double getMileage() { return mileage; }

    @Override
    public String toString() {
        return carID + " | " + brand + " | " + model + " | " +
               year + " | " + fuelType + " | " + color + " | " + mileage;
    }
}
