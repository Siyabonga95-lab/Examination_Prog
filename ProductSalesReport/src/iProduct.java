/**
 * Question 1
 * Student Number:ST10488360
 * Student Name:Siyabonga Msimango
 */

// This is the interface that defines what methods the sales calculator must have
// It's like a contract that the ProductsSales class promises to follow
public interface iProduct {
    
    // This method will calculate total sales from a 2D array
    int TotalSales(int[][] productSales);
    
    // This method will calculate average sales
    double AverageSales(int[][] productSales);
    
    // This method will find the highest sale value
    int MaxSale(int[][] productSales);
    
    // This method will find the lowest sale value
    int MinSale(int[][] productSales);
}