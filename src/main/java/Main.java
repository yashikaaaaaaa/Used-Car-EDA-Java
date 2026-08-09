import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println();
        System.out.println("==============================================================");
        System.out.println("                  USED CAR EDA PROJECT");
        System.out.println("==============================================================");

        String filePath = "data/cardekho_dataset.csv";

        try {

            // --------------------------------------------------
            // 1. LOAD DATASET
            // --------------------------------------------------

            System.out.println();
            System.out.println("Loading dataset...");

            List<Car> cars = CSVReader.readCars(filePath);

            if (cars == null || cars.isEmpty()) {
                System.out.println("ERROR: Dataset is empty or could not be loaded.");
                return;
            }

            System.out.println("Dataset loaded successfully!");
            System.out.println("Total records: " + cars.size());


            // --------------------------------------------------
            // 2. STATISTICAL SUMMARY
            // --------------------------------------------------

            EDAAnalysis.generateSummary(cars);


            // --------------------------------------------------
            // 3. CATEGORY ANALYSIS
            // --------------------------------------------------

            CategoryAnalysis.analyze(cars);


            // --------------------------------------------------
            // 4. CORRELATION ANALYSIS
            // --------------------------------------------------

            CorrelationAnalysis.analyze(cars);


            // --------------------------------------------------
            // 5. OUTLIER ANALYSIS
            // --------------------------------------------------

            OutlierAnalysis.analyze(cars);


            // --------------------------------------------------
            // 6. GENERATE CHARTS
            // --------------------------------------------------

            System.out.println();
            System.out.println("==============================================================");
            System.out.println("                    GENERATING CHARTS");
            System.out.println("==============================================================");

            ChartGenerator.generateAllCharts(cars);


            // --------------------------------------------------
            // 7. COMPLETION MESSAGE
            // --------------------------------------------------

            System.out.println();
            System.out.println("==============================================================");
            System.out.println("              EDA ANALYSIS COMPLETED SUCCESSFULLY");
            System.out.println("==============================================================");

            System.out.println();
            System.out.println("Records analyzed : " + cars.size());
            System.out.println("Charts location  : output/");
            System.out.println("Report location  : REPORT.md");

            System.out.println();
            System.out.println("==============================================================");
            System.out.println("                   PROJECT SUCCESSFUL");
            System.out.println("==============================================================");

        } catch (Exception e) {

            System.out.println();
            System.out.println("==============================================================");
            System.out.println("                         ERROR");
            System.out.println("==============================================================");

            System.out.println("Something went wrong while running the project.");
            System.out.println();

            e.printStackTrace();
        }
    }
}