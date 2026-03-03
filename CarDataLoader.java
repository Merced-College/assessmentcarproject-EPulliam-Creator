/******************************************************************************

Eura Pulliam
3.3.2026
Assessment: Car Data Analyzer

*******************************************************************************/
import java.io.*;
import java.util.*;

public class CarDataLoader {

    public static ArrayList<Car> loadCars(String filename) {
        ArrayList<Car> cars = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length != 7) continue; // skip malformed rows

                try {
                    String id = parts[0];
                    String brand = parts[1];
                    String model = parts[2];
                    int year = Integer.parseInt(parts[3]);
                    String fuel = parts[4];
                    String color = parts[5];
                    double mileage = Double.parseDouble(parts[6]);

                    cars.add(new Car(id, brand, model, year, fuel, color, mileage));

                } catch (Exception e) {
                    // skip bad row safely
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        System.out.println("Total cars loaded: " + cars.size());
        return cars;
    }
}
