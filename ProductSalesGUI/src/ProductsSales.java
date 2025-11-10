/*
*Question 2
*Student Number:ST10488360
*Student Name:Siyabonga Msimango
 */

// This class does all the sales calculations
// It implements the IProductSales interface we created
public class ProductsSales implements IProductSales {
    
    // This array stores our sales data from the question
    private int[][] salesData = {
        {300, 150, 700}, // Year 1: Microphone, Speakers, Mixing Desk
        {250, 200, 600}  // Year 2: Microphone, Speakers, Mixing Desk
    };
    
    // Returns the sales data array
    @Override
    public int[][] GetProductSales() {
        return salesData;
    }
    
    // Calculates total by adding all sales numbers
    @Override
    public int GetTotalSales() {
        int total = 0;
        // Loop through each year
        for (int i = 0; i < salesData.length; i++) {
            // Loop through each product in that year
            for (int j = 0; j < salesData[i].length; j++) {
                total = total + salesData[i][j];
            }
        }
        return total;
    }
    
    // Counts sales over 500
    @Override
    public int GetSalesOverLimit() {
        int count = 0;
        for (int i = 0; i < salesData.length; i++) {
            for (int j = 0; j < salesData[i].length; j++) {
                if (salesData[i][j] > 500) {
                    count++;
                }
            }
        }
        return count;
    }
    
    // Counts sales under 500
    @Override
    public int GetSalesUnderLimit() {
        int count = 0;
        for (int i = 0; i < salesData.length; i++) {
            for (int j = 0; j < salesData[i].length; j++) {
                if (salesData[i][j] < 500) {
                    count++;
                }
            }
        }
        return count;
    }
    
    // Returns number of years processed
    @Override
    public int GetProductsProcessed() {
        return salesData.length; // 2 years
    }
    
    // Calculates average sales
    @Override
    public double GetAverageSales() {
        int total = GetTotalSales();
        int numberOfSales = salesData.length * salesData[0].length; // 2 years * 3 products
        return (double) total / numberOfSales;
    }
}