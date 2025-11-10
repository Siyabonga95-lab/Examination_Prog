/**
 * Question 1
 * Student Number:ST10488360
 * Student Name:Siyabonga Msimango
 */

// This is the main class that runs the program
// It creates the sales data and uses the ProductsSales class to do calculations
public class SalesReportApp {

    // This is where the program starts running
    public static void main(String[] args) {
        
        // Here we create the sales data from the question as a 2D array
        // First row is Year 1: Q1=300, Q2=150, Q3=700
        // Second row is Year 2: Q1=250, Q2=200, Q3=600
        int[][] salesData = {
            {300, 150, 700},
            {250, 200, 600}
        };
        
        // Create a calculator object that can do the sales calculations
        ProductsSales calculator = new ProductsSales();
        
        // Use the calculator to get all the values I need
        int total = calculator.TotalSales(salesData);
        double average = calculator.AverageSales(salesData);
        int max = calculator.MaxSale(salesData);
        int min = calculator.MinSale(salesData);
        
        // Now print out the final sales report
        System.out.println("PRODUCT SALES REPORT - 2025");
        System.out.println("---");
        System.out.println("Total sales: " + total);
        System.out.println("Average sales: " + (int) average); // convert to whole number
        System.out.println("Maximum sale: " + max);
        System.out.println("Minimum sale: " + min);
    }
}