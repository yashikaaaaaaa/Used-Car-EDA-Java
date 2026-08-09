import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class ChartGenerator {

    private static final String OUTPUT_FOLDER = "output";

    public static void generateAllCharts(List<Car> cars) {

        createOutputFolder();

        try {

            generateFuelPriceChart(cars);

            generateTransmissionPriceChart(cars);

            generateSellerPriceChart(cars);

            generateCorrelationChart(cars);

            generateAgeVsPriceChart(cars);

            generateEngineVsPriceChart(cars);

            generatePowerVsPriceChart(cars);

            System.out.println();
            System.out.println("==============================================================");
            System.out.println("                 CHART GENERATION COMPLETE");
            System.out.println("==============================================================");
            System.out.println("Charts saved inside the 'output' folder.");

        } catch (Exception e) {

            System.out.println("Error while generating charts.");
            e.printStackTrace();
        }
    }

    private static void createOutputFolder() {

        File folder = new File(OUTPUT_FOLDER);

        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    // ============================================================
    // 1. FUEL TYPE VS AVERAGE SELLING PRICE
    // ============================================================

    private static void generateFuelPriceChart(List<Car> cars)
            throws Exception {

        Map<String, Double> totalPrices = new HashMap<>();
        Map<String, Integer> counts = new HashMap<>();

        for (Car car : cars) {

            String fuel = car.getFuelType();

            totalPrices.put(
                    fuel,
                    totalPrices.getOrDefault(fuel, 0.0)
                            + car.getSellingPrice()
            );

            counts.put(
                    fuel,
                    counts.getOrDefault(fuel, 0) + 1
            );
        }

        DefaultCategoryDataset dataset =
                new DefaultCategoryDataset();

        for (String fuel : totalPrices.keySet()) {

            double average =
                    totalPrices.get(fuel) / counts.get(fuel);

            dataset.addValue(
                    average,
                    "Average Price",
                    fuel
            );
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Average Selling Price by Fuel Type",
                "Fuel Type",
                "Average Selling Price (INR)",
                dataset
        );

        saveChart(chart, "fuel_price.png", 1000, 650);
    }

    // ============================================================
    // 2. TRANSMISSION VS AVERAGE SELLING PRICE
    // ============================================================

    private static void generateTransmissionPriceChart(
            List<Car> cars) throws Exception {

        Map<String, Double> totalPrices = new HashMap<>();
        Map<String, Integer> counts = new HashMap<>();

        for (Car car : cars) {

            String transmission =
                    car.getTransmissionType();

            totalPrices.put(
                    transmission,
                    totalPrices.getOrDefault(
                            transmission, 0.0)
                            + car.getSellingPrice()
            );

            counts.put(
                    transmission,
                    counts.getOrDefault(
                            transmission, 0) + 1
            );
        }

        DefaultCategoryDataset dataset =
                new DefaultCategoryDataset();

        for (String transmission : totalPrices.keySet()) {

            double average =
                    totalPrices.get(transmission)
                            / counts.get(transmission);

            dataset.addValue(
                    average,
                    "Average Price",
                    transmission
            );
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Average Selling Price by Transmission",
                "Transmission Type",
                "Average Selling Price (INR)",
                dataset
        );

        saveChart(
                chart,
                "transmission_price.png",
                1000,
                650
        );
    }

    // ============================================================
    // 3. SELLER TYPE VS AVERAGE SELLING PRICE
    // ============================================================

    private static void generateSellerPriceChart(
            List<Car> cars) throws Exception {

        Map<String, Double> totalPrices = new HashMap<>();
        Map<String, Integer> counts = new HashMap<>();

        for (Car car : cars) {

            String seller =
                    car.getSellerType();

            totalPrices.put(
                    seller,
                    totalPrices.getOrDefault(
                            seller, 0.0)
                            + car.getSellingPrice()
            );

            counts.put(
                    seller,
                    counts.getOrDefault(
                            seller, 0) + 1
            );
        }

        DefaultCategoryDataset dataset =
                new DefaultCategoryDataset();

        for (String seller : totalPrices.keySet()) {

            double average =
                    totalPrices.get(seller)
                            / counts.get(seller);

            dataset.addValue(
                    average,
                    "Average Price",
                    seller
            );
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Average Selling Price by Seller Type",
                "Seller Type",
                "Average Selling Price (INR)",
                dataset
        );

        saveChart(
                chart,
                "seller_price.png",
                1100,
                650
        );
    }

    // ============================================================
    // 4. CORRELATION WITH SELLING PRICE
    // ============================================================

    private static void generateCorrelationChart(
            List<Car> cars) throws Exception {

        DefaultCategoryDataset dataset =
                new DefaultCategoryDataset();

        List<Double> sellingPrice =
                getSellingPrice(cars);

        dataset.addValue(
                CorrelationAnalysis.calculatePearsonCorrelation(
                        getVehicleAge(cars),
                        sellingPrice),
                "Correlation",
                "Vehicle Age"
        );

        dataset.addValue(
                CorrelationAnalysis.calculatePearsonCorrelation(
                        getKmDriven(cars),
                        sellingPrice),
                "Correlation",
                "KM Driven"
        );

        dataset.addValue(
                CorrelationAnalysis.calculatePearsonCorrelation(
                        getMileage(cars),
                        sellingPrice),
                "Correlation",
                "Mileage"
        );

        dataset.addValue(
                CorrelationAnalysis.calculatePearsonCorrelation(
                        getEngine(cars),
                        sellingPrice),
                "Correlation",
                "Engine"
        );

        dataset.addValue(
                CorrelationAnalysis.calculatePearsonCorrelation(
                        getMaxPower(cars),
                        sellingPrice),
                "Correlation",
                "Max Power"
        );

        JFreeChart chart = ChartFactory.createBarChart(
                "Correlation with Selling Price",
                "Variable",
                "Pearson Correlation",
                dataset
        );

        CategoryPlot plot = chart.getCategoryPlot();

        NumberAxis rangeAxis =
                (NumberAxis) plot.getRangeAxis();

        rangeAxis.setRange(-1.0, 1.0);

        saveChart(
                chart,
                "correlation.png",
                1100,
                650
        );
    }

    // ============================================================
    // 5. VEHICLE AGE VS SELLING PRICE
    // ============================================================

    private static void generateAgeVsPriceChart(
            List<Car> cars) throws Exception {

        XYSeries series =
                new XYSeries("Cars");

        /*
         * To keep the chart readable, we don't need
         * every single point to be displayed.
         */
        int step = Math.max(1, cars.size() / 1500);

        for (int i = 0; i < cars.size(); i += step) {

            Car car = cars.get(i);

            series.add(
                    car.getVehicleAge(),
                    car.getSellingPrice()
            );
        }

        XYSeriesCollection dataset =
                new XYSeriesCollection();

        dataset.addSeries(series);

        JFreeChart chart =
                ChartFactory.createScatterPlot(
                        "Vehicle Age vs Selling Price",
                        "Vehicle Age (Years)",
                        "Selling Price (INR)",
                        dataset
                );

        saveChart(
                chart,
                "age_vs_price.png",
                1000,
                650
        );
    }

    // ============================================================
    // 6. ENGINE VS SELLING PRICE
    // ============================================================

    private static void generateEngineVsPriceChart(
            List<Car> cars) throws Exception {

        XYSeries series =
                new XYSeries("Cars");

        int step = Math.max(1, cars.size() / 1500);

        for (int i = 0; i < cars.size(); i += step) {

            Car car = cars.get(i);

            series.add(
                    car.getEngine(),
                    car.getSellingPrice()
            );
        }

        XYSeriesCollection dataset =
                new XYSeriesCollection();

        dataset.addSeries(series);

        JFreeChart chart =
                ChartFactory.createScatterPlot(
                        "Engine Size vs Selling Price",
                        "Engine (CC)",
                        "Selling Price (INR)",
                        dataset
                );

        saveChart(
                chart,
                "engine_vs_price.png",
                1000,
                650
        );
    }

    // ============================================================
    // 7. MAX POWER VS SELLING PRICE
    // ============================================================

    private static void generatePowerVsPriceChart(
            List<Car> cars) throws Exception {

        XYSeries series =
                new XYSeries("Cars");

        int step = Math.max(1, cars.size() / 1500);

        for (int i = 0; i < cars.size(); i += step) {

            Car car = cars.get(i);

            series.add(
                    car.getMaxPower(),
                    car.getSellingPrice()
            );
        }

        XYSeriesCollection dataset =
                new XYSeriesCollection();

        dataset.addSeries(series);

        JFreeChart chart =
                ChartFactory.createScatterPlot(
                        "Maximum Power vs Selling Price",
                        "Maximum Power (bhp)",
                        "Selling Price (INR)",
                        dataset
                );

        saveChart(
                chart,
                "power_vs_price.png",
                1000,
                650
        );
    }

    // ============================================================
    // SAVE CHART
    // ============================================================

    private static void saveChart(
            JFreeChart chart,
            String fileName,
            int width,
            int height) throws Exception {

        File file =
                new File(OUTPUT_FOLDER, fileName);

        ChartUtils.saveChartAsPNG(
                file,
                chart,
                width,
                height
        );

        System.out.println(
                "Created: " + file.getPath()
        );
    }

    // ============================================================
    // DATA EXTRACTION METHODS
    // ============================================================

    private static List<Double> getVehicleAge(
            List<Car> cars) {

        List<Double> values =
                new ArrayList<>();

        for (Car car : cars) {
            values.add(
                    (double) car.getVehicleAge()
            );
        }

        return values;
    }

    private static List<Double> getKmDriven(
            List<Car> cars) {

        List<Double> values =
                new ArrayList<>();

        for (Car car : cars) {
            values.add(
                    (double) car.getKmDriven()
            );
        }

        return values;
    }

    private static List<Double> getMileage(
            List<Car> cars) {

        List<Double> values =
                new ArrayList<>();

        for (Car car : cars) {
            values.add(
                    car.getMileage()
            );
        }

        return values;
    }

    private static List<Double> getEngine(
            List<Car> cars) {

        List<Double> values =
                new ArrayList<>();

        for (Car car : cars) {
            values.add(
                    car.getEngine()
            );
        }

        return values;
    }

    private static List<Double> getMaxPower(
            List<Car> cars) {

        List<Double> values =
                new ArrayList<>();

        for (Car car : cars) {
            values.add(
                    car.getMaxPower()
            );
        }

        return values;
    }

    private static List<Double> getSellingPrice(
            List<Car> cars) {

        List<Double> values =
                new ArrayList<>();

        for (Car car : cars) {
            values.add(
                    car.getSellingPrice()
            );
        }

        return values;
    }
}