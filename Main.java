/******************************************************************************

Eura Pulliam
3.3.2026
Assessment: Car Data Analyzer

*******************************************************************************/
import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Car> cars = CarDataLoader.loadCars("Car_Data.csv");

        ArrayList<Car> working = new ArrayList<>(cars.subList(0, 2000));

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Project C Menu ---");
            System.out.println("1. Sort by Model");
            System.out.println("2. Search by Model (contains)");
            System.out.println("3. Show Stats");
            System.out.println("4. Exit");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    selectionSortByModel(working);
                    System.out.println("First 10 cars after sort:");
                    for (int i = 0; i < 10 && i < working.size(); i++) {
                        System.out.println(working.get(i));
                    }
                    break;

                case 2:
                    System.out.print("Enter model keyword: ");
                    String keyword = scanner.nextLine().toLowerCase();
                    searchContains(working, keyword);
                    break;

                case 3:
                    showStats(working);
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    break;
            }

        } while (choice != 4);

        scanner.close();
    }

    // SELECTION SORT
    public static void selectionSortByModel(ArrayList<Car> list) {

        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getModel()
                        .compareToIgnoreCase(list.get(minIndex).getModel()) < 0) {
                    minIndex = j;
                }
            }

            Car temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
    }

    // BINARY SEARCH (exact model match)
    public static Car binarySearchModel(ArrayList<Car> list, String target) {

        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int comparison = list.get(mid).getModel()
                    .compareToIgnoreCase(target);

            if (comparison == 0)
                return list.get(mid);
            else if (comparison < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return null;
    }

    // CONTAINS SEARCH
    public static void searchContains(ArrayList<Car> list, String keyword) {

        boolean found = false;

        for (Car car : list) {
            if (car.getModel().toLowerCase().contains(keyword)) {
                System.out.println(car);
                found = true;
            }
        }

        if (!found)
            System.out.println("No matches found.");
    }

    // STATS
    public static void showStats(ArrayList<Car> list) {

        double totalMileage = 0;

        HashMap<String, Integer> fuelCounts = new HashMap<>();

        for (Car car : list) {

            totalMileage += car.getMileage();

            String fuel = car.getFuelType();
            fuelCounts.put(fuel, fuelCounts.getOrDefault(fuel, 0) + 1);
        }

        System.out.println("Average mileage: " + (totalMileage / list.size()));

        System.out.println("Fuel counts:");
        for (String fuel : fuelCounts.keySet()) {
            System.out.println(fuel + ": " + fuelCounts.get(fuel));
        }
    }
}
