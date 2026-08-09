import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryAnalysis {

    public static void analyze(List<Car> cars) {

        System.out.println();
        System.out.println("==============================================================");
        System.out.println("                  CATEGORICAL ANALYSIS");
        System.out.println("==============================================================");

        analyzeCategory(
                "Fuel Type",
                cars,
                "fuel"
        );

        analyzeCategory(
                "Transmission Type",
                cars,
                "transmission"
        );

        analyzeCategory(
                "Seller Type",
                cars,
                "seller"
        );

        analyzeAveragePrice(
                "Fuel Type",
                cars,
                "fuel"
        );

        analyzeAveragePrice(
                "Transmission Type",
                cars,
                "transmission"
        );

        analyzeAveragePrice(
                "Seller Type",
                cars,
                "seller"
        );

        analyzeBrandPrices(cars);

        System.out.println("==============================================================");
    }

    private static void analyzeCategory(
            String title,
            List<Car> cars,
            String categoryType) {

        Map<String, Integer> counts = new HashMap<>();

        for (Car car : cars) {

            String category = getCategory(car, categoryType);

            counts.put(
                    category,
                    counts.getOrDefault(category, 0) + 1
            );
        }

        System.out.println();
        System.out.println("--- Number of Cars by " + title + " ---");

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {

            System.out.printf(
                    "%-20s : %d%n",
                    entry.getKey(),
                    entry.getValue()
            );
        }
    }

    private static void analyzeAveragePrice(
            String title,
            List<Car> cars,
            String categoryType) {

        Map<String, Double> totalPrices = new HashMap<>();
        Map<String, Integer> counts = new HashMap<>();

        for (Car car : cars) {

            String category = getCategory(car, categoryType);

            totalPrices.put(
                    category,
                    totalPrices.getOrDefault(category, 0.0)
                            + car.getSellingPrice()
            );

            counts.put(
                    category,
                    counts.getOrDefault(category, 0) + 1
            );
        }

        System.out.println();
        System.out.println("--- Average Selling Price by " + title + " ---");

        for (String category : totalPrices.keySet()) {

            double average =
                    totalPrices.get(category) / counts.get(category);

            System.out.printf(
                    "%-20s : ₹%.2f%n",
                    category,
                    average
            );
        }
    }

    private static void analyzeBrandPrices(List<Car> cars) {

        Map<String, Double> totalPrices = new HashMap<>();
        Map<String, Integer> counts = new HashMap<>();

        for (Car car : cars) {

            String brand = car.getBrand();

            totalPrices.put(
                    brand,
                    totalPrices.getOrDefault(brand, 0.0)
                            + car.getSellingPrice()
            );

            counts.put(
                    brand,
                    counts.getOrDefault(brand, 0) + 1
            );
        }

        System.out.println();
        System.out.println("--- Average Selling Price by Brand ---");

        for (String brand : totalPrices.keySet()) {

            double average =
                    totalPrices.get(brand) / counts.get(brand);

            System.out.printf(
                    "%-20s : ₹%.2f (%d cars)%n",
                    brand,
                    average,
                    counts.get(brand)
            );
        }
    }

    private static String getCategory(
            Car car,
            String categoryType) {

        switch (categoryType) {

            case "fuel":
                return car.getFuelType();

            case "transmission":
                return car.getTransmissionType();

            case "seller":
                return car.getSellerType();

            default:
                return "Unknown";
        }
    }
}