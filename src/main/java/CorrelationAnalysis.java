import java.util.ArrayList;
import java.util.List;

public class CorrelationAnalysis {

    public static void analyze(List<Car> cars) {

        System.out.println();
        System.out.println("==============================================================");
        System.out.println("                  CORRELATION ANALYSIS");
        System.out.println("==============================================================");

        List<Double> sellingPrice = getSellingPrice(cars);

        analyzeVariable(
                "Vehicle Age",
                getVehicleAge(cars),
                sellingPrice
        );

        analyzeVariable(
                "KM Driven",
                getKmDriven(cars),
                sellingPrice
        );

        analyzeVariable(
                "Mileage",
                getMileage(cars),
                sellingPrice
        );

        analyzeVariable(
                "Engine",
                getEngine(cars),
                sellingPrice
        );

        analyzeVariable(
                "Max Power",
                getMaxPower(cars),
                sellingPrice
        );

        System.out.println("==============================================================");
    }

    private static void analyzeVariable(
            String variableName,
            List<Double> x,
            List<Double> y) {

        double correlation = calculatePearsonCorrelation(x, y);

        System.out.printf(
                "%-25s : %8.4f  (%s)%n",
                variableName,
                correlation,
                interpretCorrelation(correlation)
        );
    }

    public static double calculatePearsonCorrelation(
            List<Double> x,
            List<Double> y) {

        if (x.size() != y.size() || x.isEmpty()) {
            return 0;
        }

        double meanX = mean(x);
        double meanY = mean(y);

        double numerator = 0;
        double denominatorX = 0;
        double denominatorY = 0;

        for (int i = 0; i < x.size(); i++) {

            double differenceX = x.get(i) - meanX;
            double differenceY = y.get(i) - meanY;

            numerator += differenceX * differenceY;
            denominatorX += differenceX * differenceX;
            denominatorY += differenceY * differenceY;
        }

        double denominator =
                Math.sqrt(denominatorX * denominatorY);

        if (denominator == 0) {
            return 0;
        }

        return numerator / denominator;
    }

    private static double mean(List<Double> values) {

        double sum = 0;

        for (double value : values) {
            sum += value;
        }

        return sum / values.size();
    }

    private static String interpretCorrelation(double correlation) {

        double absoluteValue = Math.abs(correlation);

        if (absoluteValue >= 0.7) {
            return correlation > 0
                    ? "Strong Positive"
                    : "Strong Negative";
        }

        if (absoluteValue >= 0.3) {
            return correlation > 0
                    ? "Moderate Positive"
                    : "Moderate Negative";
        }

        return "Weak/Very Weak";
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