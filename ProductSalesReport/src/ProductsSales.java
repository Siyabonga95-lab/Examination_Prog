/**
 * Question 1
 * Student Number:ST10488360
 * Student Name:Siyabonga Msimango
 */

// This class does all the actual calculations for the sales report
// It implements iProduct, meaning it must have all the methods from that interface
public class ProductsSales implements iProduct {

    // This method adds up all the sales numbers
    @Override
    public int TotalSales(int[][] productSales) {
        int total = 0; // start with zero
        
        // Go through each year (each row)
        for (int i = 0; i < productSales.length; i++) {
            // Go through each quarter (each column in that row)
            for (int j = 0; j < productSales[i].length; j++) {
                total = total + productSales[i][j]; // add each sale to total
            }
        }
        return total; // send back the final total
    }

    // This method calculates the average sales
    @Override
    public double AverageSales(int[][] productSales) {
        // Use the TotalSales method we already made to get the sum
        int total = TotalSales(productSales);
        
        // Calculate how many sales numbers the are
        int count = productSales.length * productSales[0].length;
        
        // Calculate average - I use (double) to get decimal places
        double average = (double) total / count;
        return average;
    }

    // This method finds the highest sales number
    @Override
    public int MaxSale(int[][] productSales) {
        // Start by assuming first number is the highest
        int max = productSales[0][0];
        
        // Check every number in the array
        for (int i = 0; i < productSales.length; i++) {
            for (int j = 0; j < productSales[i].length; j++) {
                // If we find a bigger number, it becomes our new max
                if (productSales[i][j] > max) {
                    max = productSales[i][j];
                }
            }
        }
        return max;
    }

    // This method finds the lowest sales number
    @Override
    public int MinSale(int[][] productSales) {
        // Start by assuming first number is the lowest
        int min = productSales[0][0];
        
        // Check every number in the array
        for (int i = 0; i < productSales.length; i++) {
            for (int j = 0; j < productSales[i].length; j++) {
                // If we find a smaller number, it becomes our new min
                if (productSales[i][j] < min) {
                    min = productSales[i][j];
                }
            }
        }
        return min;
    }
}