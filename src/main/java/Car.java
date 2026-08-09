public class Car {

    private String carName;
    private String brand;
    private String model;
    private int vehicleAge;
    private int kmDriven;
    private String sellerType;
    private String fuelType;
    private String transmissionType;
    private double mileage;
    private double engine;
    private double maxPower;
    private int seats;
    private double sellingPrice;

    public Car(
            String carName,
            String brand,
            String model,
            int vehicleAge,
            int kmDriven,
            String sellerType,
            String fuelType,
            String transmissionType,
            double mileage,
            double engine,
            double maxPower,
            int seats,
            double sellingPrice) {

        this.carName = carName;
        this.brand = brand;
        this.model = model;
        this.vehicleAge = vehicleAge;
        this.kmDriven = kmDriven;
        this.sellerType = sellerType;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        this.mileage = mileage;
        this.engine = engine;
        this.maxPower = maxPower;
        this.seats = seats;
        this.sellingPrice = sellingPrice;
    }

    public String getCarName() {
        return carName;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getVehicleAge() {
        return vehicleAge;
    }

    public int getKmDriven() {
        return kmDriven;
    }

    public String getSellerType() {
        return sellerType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public double getMileage() {
        return mileage;
    }

    public double getEngine() {
        return engine;
    }

    public double getMaxPower() {
        return maxPower;
    }

    public int getSeats() {
        return seats;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    @Override
    public String toString() {
        return carName + " | " +
                brand + " | " +
                model + " | Age: " +
                vehicleAge + " | Price: ₹" +
                sellingPrice;
    }
}