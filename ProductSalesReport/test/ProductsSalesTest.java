import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the ProductsSales class
 * These tests check if the sales calculations work correctly
 */
public class ProductsSalesTest {
    
    // This is the test data from the question - same as in main application
    private final int[][] testSalesData = {
        {300, 150, 700}, // Year 1: Q1, Q2, Q3
        {250, 200, 600}  // Year 2: Q1, Q2, Q3
    };
    
    /**
     * Test of TotalSales method, of class ProductsSales.
     * This test checks if the total sales calculation is correct
     * Expected: 300+150+700+250+200+600 = 2200
     */
    @Test
    public void CalculateTotalSales_ReturnsTotalSales() {
        System.out.println("Testing TotalSales method...");
        
        // Create an instance of the ProductsSales class
        ProductsSales calculator = new ProductsSales();
        
        // Call the method I want to test
        int result = calculator.TotalSales(testSalesData);
        
        // The expected total from the manual calculation
        int expected = 2200;
        
        // Check if the result matches what I expect
        assertEquals("Total sales should be 2200", expected, result);
        
        System.out.println("TotalSales test passed! Result: " + result);
    }

    /**
     * Test of AverageSales method, of class ProductsSales.
     * This test checks if the average sales calculation is correct
     * Expected: 2200 total / 6 sales entries = 366.666... which we cast to int = 366
     */
    @Test
    public void AverageSales_ReturnsAverageProductsSales() {
        System.out.println("Testing AverageSales method...");
        
        // Create an instance of the ProductsSales class
        ProductsSales calculator = new ProductsSales();
        
        // Call the method I want to test
        double result = calculator.AverageSales(testSalesData);
        
        // The expected average: 2200 / 6 = 366.666...
        // We'll test with a small delta for floating point precision
        double expected = 366.666;
        
        // Check if the result is close to what we expect (within 0.1)
        assertEquals("Average sales should be approximately 366.666", expected, result, 0.1);
        
        System.out.println("AverageSales test passed! Result: " + result);
    }
    
    /**
     * BONUS TEST: Test of MaxSale method
     * This checks if we correctly find the highest sale value
     */
    @Test
    public void testMaxSale() {
        System.out.println("Testing MaxSale method...");
        
        ProductsSales calculator = new ProductsSales();
        int result = calculator.MaxSale(testSalesData);
        int expected = 700; // The highest value in our data
        
        assertEquals("Maximum sale should be 700", expected, result);
        System.out.println("MaxSale test passed! Result: " + result);
    }
    
    /**
     * BONUS TEST: Test of MinSale method  
     * This checks if we correctly find the lowest sale value
     */
    @Test
    public void testMinSale() {
        System.out.println("Testing MinSale method...");
        
        ProductsSales calculator = new ProductsSales();
        int result = calculator.MinSale(testSalesData);
        int expected = 150; // The lowest value in our data
        
        assertEquals("Minimum sale should be 150", expected, result);
        System.out.println("MinSale test passed! Result: " + result);
    }
}