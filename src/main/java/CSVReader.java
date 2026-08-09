import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static List<Car> readCars(String filePath) {

        List<Car> cars = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            // Skip header
            reader.readLine();

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");

                try {

                    /*
                     * data[0] = row index
                     * data[1] = car_name
                     * data[2] = brand
                     * data[3] = model
                     * data[4] = vehicle_age
                     * data[5] = km_driven
                     * data[6] = seller_type
                     * data[7] = fuel_type
                     * data[8] = transmission_type
                     * data[9] = mileage
                     * data[10] = engine
                     * data[11] = max_power
                     * data[12] = seats
                     * data[13] = selling_price
                     */

                    if (data.length < 14) {
                        continue;
                    }

                    Car car = new Car(
                            data[1].trim(),
                            data[2].trim(),
                            data[3].trim(),
                            Integer.parseInt(data[4].trim()),
                            Integer.parseInt(data[5].trim()),
                            data[6].trim(),
                            data[7].trim(),
                            data[8].trim(),
                            Double.parseDouble(data[9].trim()),
                            Double.parseDouble(data[10].trim()),
                            Double.parseDouble(data[11].trim()),
                            Integer.parseInt(data[12].trim()),
                            Double.parseDouble(data[13].trim())
                    );

                    cars.add(car);

                } catch (NumberFormatException e) {

                    System.out.println("Skipping invalid row:");
                    System.out.println(line);
                }
            }

        } catch (Exception e) {

            System.out.println("Could not read the dataset.");
            e.printStackTrace();
        }

        return cars;
    }
}