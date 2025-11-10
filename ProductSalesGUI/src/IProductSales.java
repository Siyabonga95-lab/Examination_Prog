/*
*Question 2
*Student Number:ST10488360
*Student Name:Siyabonga Msimango
 */

// This is the interface that defines what the sales calculator must do
public interface IProductSales {
    
    // This gets all the sales data as a 2D array
    int[][] GetProductSales();
    
    // This calculates the total of all sales
    int GetTotalSales();
    
    // This counts how many sales are over 500
    int GetSalesOverLimit();
    
    // This counts how many sales are under 500
    int GetSalesUnderLimit();
    
    // This tells us how many years we have data for
    int GetProductsProcessed();
    
    // This calculates the average sales
    double GetAverageSales();
}