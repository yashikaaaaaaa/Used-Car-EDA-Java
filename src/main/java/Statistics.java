import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Statistics {

    public static double mean(List<Double> values) {

        if (values == null || values.isEmpty()) {
            return 0;
        }

        double sum = 0;

        for (double value : values) {
            sum += value;
        }

        return sum / values.size();
    }

    public static double median(List<Double> values) {

        if (values == null || values.isEmpty()) {
            return 0;
        }

        List<Double> sortedValues = new ArrayList<>(values);

        Collections.sort(sortedValues);

        int size = sortedValues.size();

        if (size % 2 == 0) {

            double middle1 = sortedValues.get(size / 2 - 1);
            double middle2 = sortedValues.get(size / 2);

            return (middle1 + middle2) / 2.0;

        } else {

            return sortedValues.get(size / 2);
        }
    }

    public static double minimum(List<Double> values) {

        if (values == null || values.isEmpty()) {
            return 0;
        }

        return Collections.min(values);
    }

    public static double maximum(List<Double> values) {

        if (values == null || values.isEmpty()) {
            return 0;
        }

        return Collections.max(values);
    }

    public static double standardDeviation(List<Double> values) {

        if (values == null || values.size() < 2) {
            return 0;
        }

        double average = mean(values);

        double sum = 0;

        for (double value : values) {

            double difference = value - average;

            sum += difference * difference;
        }

        // Population standard deviation
        return Math.sqrt(sum / values.size());
    }
}