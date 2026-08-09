# 🚗 Used Car EDA - Java

> A Java-based Exploratory Data Analysis project that analyzes 15,411 used-car records to uncover pricing patterns, correlations, trends and outliers.

---

## 📊 Project Overview

The **Used Car EDA** project explores a real-world used-car dataset containing information about vehicle age, mileage, engine capacity, maximum power, fuel type, transmission, seller type, brand and selling price.

The project uses **Java** to perform statistical analysis, categorical analysis, correlation analysis and outlier detection.

It also generates visualizations using **JFreeChart** to make the analytical findings easier to understand.

---

## 🎯 Objectives

The main objectives of this project are:

- Analyze a real-world used-car dataset.
- Calculate descriptive statistics.
- Explore categorical variables.
- Compare average selling prices.
- Analyze relationships between vehicle characteristics and price.
- Calculate Pearson correlations.
- Detect potential price outliers using the IQR method.
- Generate analytical charts.
- Summarize meaningful insights from the dataset.

---

## 📁 Dataset

The dataset contains:

**15,411 used-car records**

Important features include:

| Feature | Description |
|---|---|
| `car_name` | Name of the vehicle |
| `brand` | Vehicle manufacturer |
| `model` | Vehicle model |
| `vehicle_age` | Age of the vehicle |
| `km_driven` | Distance driven |
| `seller_type` | Type of seller |
| `fuel_type` | Fuel type |
| `transmission_type` | Manual or Automatic |
| `mileage` | Mileage in km/l |
| `engine` | Engine capacity in CC |
| `max_power` | Maximum power in bhp |
| `seats` | Number of seats |
| `selling_price` | Vehicle selling price |

---

## 🛠️ Technologies Used

- **Java 11**
- **Apache Maven**
- **JFreeChart**
- **CSV**
- **Visual Studio Code**
- **Git & GitHub**

---

## 🔍 Analysis Performed

### 1. Statistical Analysis

The project calculates:

- Mean
- Median
- Minimum
- Maximum
- Standard Deviation

The analysis covers:

- Vehicle Age
- KM Driven
- Mileage
- Engine
- Maximum Power
- Selling Price

---

### 2. Categorical Analysis

The project analyzes:

- Fuel Type
- Transmission Type
- Seller Type
- Vehicle Brand

It also calculates the average selling price for each category.

---

### 3. Correlation Analysis

Pearson correlation is used to measure the relationship between numerical variables and selling price.

| Variable | Correlation |
|---|---:|
| Vehicle Age | -0.2419 |
| KM Driven | -0.0800 |
| Mileage | -0.3055 |
| Engine | 0.5858 |
| Max Power | 0.7502 |

### 🔑 Key Finding

**Maximum Power** has the strongest correlation with selling price:

`r = 0.7502`

This indicates a strong positive relationship between maximum power and vehicle price.

---

### 4. Outlier Detection

The **Interquartile Range (IQR)** method is used to detect potential selling-price outliers.

| Measure | Value |
|---|---:|
| Q1 | INR 385,000 |
| Median | INR 556,000 |
| Q3 | INR 825,000 |
| IQR | INR 440,000 |
| Upper Bound | INR 1,485,000 |
| Potential Outliers | 1,386 |
| Outlier Percentage | 8.99% |

The dataset contains several high-value vehicles, including luxury and premium cars.

---

## 💡 Key Insights

### 🚘 Vehicle Power

Maximum Power has the strongest relationship with selling price.

Higher-powered vehicles generally tend to have higher selling prices.

### ⚙️ Engine Capacity

Engine capacity has a moderate positive relationship with selling price.

### 🔄 Transmission

Automatic vehicles have a significantly higher average selling price than manual vehicles.

### ⛽ Fuel Type

Diesel vehicles have a higher average selling price than petrol vehicles.

Electric vehicles have a high average price, but only four electric vehicles are present in the dataset, so this result should be interpreted cautiously.

### 👤 Seller Type

Dealer-listed vehicles have the highest average selling price among the seller categories.

### 📅 Vehicle Age

Vehicle age has a negative relationship with selling price.

Older vehicles generally tend to have lower prices.

### 📈 Outliers

The dataset contains significant high-price outliers.

The highest recorded selling price is:

**INR 39,500,000**

---

## 📊 Visualizations

The project automatically generates the following charts:

```text
output/
│
├── fuel_price.png
├── transmission_price.png
├── seller_price.png
├── correlation.png
├── age_vs_price.png
├── engine_vs_price.png
└── power_vs_price.png

Project Structure

Used-Car-EDA/
│
├── data/
│   └── cardekho_dataset.csv
│
├── output/
│   ├── fuel_price.png
│   ├── transmission_price.png
│   ├── seller_price.png
│   ├── correlation.png
│   ├── age_vs_price.png
│   ├── engine_vs_price.png
│   └── power_vs_price.png
│
├── src/
│   └── main/
│       └── java/
│           ├── Main.java
│           ├── Car.java
│           ├── CSVReader.java
│           ├── Statistics.java
│           ├── EDAAnalysis.java
│           ├── CategoryAnalysis.java
│           ├── CorrelationAnalysis.java
│           ├── OutlierAnalysis.java
│           └── ChartGenerator.java
│
├── pom.xml
├── README.md
└── REPORT.md
🧠 What I Learned

Through this project, I practiced:

Java file handling
CSV data processing
Object-oriented programming
Statistical calculations
Data aggregation
Pearson correlation
IQR-based outlier detection
Data visualization with JFreeChart
Maven project management
Generating analytical reports
Structuring a data-analysis project for GitHub
🚀 Future Improvements

Possible future extensions include:

Used-car price prediction using Machine Learning
Linear Regression
Random Forest
Gradient Boosting
Feature engineering
Interactive dashboards
Brand-level price prediction
Geographic price analysis
Advanced statistical testing
Web-based price prediction application


## 👩‍💻 About the Author

**Yashika Mohanty** is a Computer Science and Data Science student with an interest in **Data Science, Java, Python, Machine Learning and Data Analytics**.

This project was developed to strengthen practical skills in **Exploratory Data Analysis, statistical analysis, data visualization and Java-based data processing**.

### Skills & Interests

- Java
- Python
- Data Science
- Data Analytics
- Machine Learning
- SQL
- Data Visualization
- Git & GitHub

