import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutlierAnalysis {

    public static void analyze(List<Car> cars) {

        List<Double> prices = new ArrayList<>();

        for (Car car : cars) {
            prices.add(car.getSellingPrice());
        }

        if (prices.isEmpty()) {
            System.out.println("No selling price data available.");
            return;
        }

        Collections.sort(prices);

        double minimum = prices.get(0);
        double maximum = prices.get(prices.size() - 1);

        double q1 = calculatePercentile(prices, 25);
        double median = calculatePercentile(prices, 50);
        double q3 = calculatePercentile(prices, 75);

        double iqr = q3 - q1;

        double lowerBound = q1 - (1.5 * iqr);
        double upperBound = q3 + (1.5 * iqr);

        int outlierCount = 0;

        for (double price : prices) {

            if (price < lowerBound || price > upperBound) {
                outlierCount++;
            }
        }

        double outlierPercentage =
                (outlierCount * 100.0) / prices.size();

        System.out.println();
        System.out.println("==============================================================");
        System.out.println("                    OUTLIER ANALYSIS");
        System.out.println("==============================================================");

        System.out.printf(
                "%-25s INR %,.2f%n",
                "Minimum Price",
                minimum
        );

        System.out.printf(
                "%-25s INR %,.2f%n",
                "Q1",
                q1
        );

        System.out.printf(
                "%-25s INR %,.2f%n",
                "Median Price",
                median
        );

        System.out.printf(
                "%-25s INR %,.2f%n",
                "Q3",
                q3
        );

        System.out.printf(
                "%-25s INR %,.2f%n",
                "Maximum Price",
                maximum
        );

        System.out.println("--------------------------------------------------------------");

        System.out.printf(
                "%-25s INR %,.2f%n",
                "IQR",
                iqr
        );

        System.out.printf(
                "%-25s INR %,.2f%n",
                "Lower Bound",
                lowerBound
        );

        System.out.printf(
                "%-25s INR %,.2f%n",
                "Upper Bound",
                upperBound
        );

        System.out.println("--------------------------------------------------------------");

        System.out.printf(
                "%-25s %d%n",
                "Potential Outliers",
                outlierCount
        );

        System.out.printf(
                "%-25s %.2f%%%n",
                "Outlier Percentage",
                outlierPercentage
        );

        System.out.println("==============================================================");
    }

    private static double calculatePercentile(
            List<Double> values,
            double percentile) {

        if (values.isEmpty()) {
            return 0;
        }

        double index =
                (percentile / 100.0) * (values.size() - 1);

        int lower = (int) Math.floor(index);
        int upper = (int) Math.ceil(index);

        if (lower == upper) {
            return values.get(lower);
        }

        double weight = index - lower;

        return values.get(lower)
                + weight * (
                values.get(upper)
                        - values.get(lower)
        );
    }
}