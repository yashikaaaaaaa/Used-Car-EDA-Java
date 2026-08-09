import java.util.ArrayList;
import java.util.List;

public class EDAAnalysis {

    public static void generateSummary(List<Car> cars) {

        System.out.println();
        System.out.println("================================================================================");
        System.out.println("                         STATISTICAL SUMMARY");
        System.out.println("================================================================================");

        System.out.printf(
                "%-25s %12s %12s %12s %12s %15s%n",
                "Variable",
                "Mean",
                "Median",
                "Minimum",
                "Maximum",
                "Std. Dev."
        );

        System.out.println("--------------------------------------------------------------------------------");

        printStatistics(
                "Vehicle Age (years)",
                getVehicleAge(cars)
        );

        printStatistics(
                "KM Driven",
                getKmDriven(cars)
        );

        printStatistics(
                "Mileage (km/l)",
                getMileage(cars)
        );

        printStatistics(
                "Engine (CC)",
                getEngine(cars)
        );

        printStatistics(
                "Max Power (bhp)",
                getMaxPower(cars)
        );

        printStatistics(
                "Selling Price (INR)",
                getSellingPrice(cars)
        );

        System.out.println("================================================================================");
    }

    private static void printStatistics(
            String variableName,
            List<Double> values) {

        System.out.printf(
                "%-25s %12.2f %12.2f %12.2f %12.2f %15.2f%n",
                variableName,
                Statistics.mean(values),
                Statistics.median(values),
                Statistics.minimum(values),
                Statistics.maximum(values),
                Statistics.standardDeviation(values)
        );
    }

    private static List<Double> getVehicleAge(List<Car> cars) {

        List<Double> values = new ArrayList<>();

        for (Car car : cars) {
            values.add((double) car.getVehicleAge());
        }

        return values;
    }

    private static List<Double> getKmDriven(List<Car> cars) {

        List<Double> values = new ArrayList<>();

        for (Car car : cars) {
            values.add((double) car.getKmDriven());
        }

        return values;
    }

    private static List<Double> getMileage(List<Car> cars) {

        List<Double> values = new ArrayList<>();

        for (Car car : cars) {
            values.add(car.getMileage());
        }

        return values;
    }

    private static List<Double> getEngine(List<Car> cars) {

        List<Double> values = new ArrayList<>();

        for (Car car : cars) {
            values.add(car.getEngine());
        }

        return values;
    }

    private static List<Double> getMaxPower(List<Car> cars) {

        List<Double> values = new ArrayList<>();

        for (Car car : cars) {
            values.add(car.getMaxPower());
        }

        return values;
    }

    private static List<Double> getSellingPrice(List<Car> cars) {

        List<Double> values = new ArrayList<>();

        for (Car car : cars) {
            values.add(car.getSellingPrice());
        }

        return values;
    }
}