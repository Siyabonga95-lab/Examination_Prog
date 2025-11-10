import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the ProductsSales class
 * These tests check if our sales limit calculations work correctly
 */
public class ProductsSalesTest {
    
    // Test data - same as in our main application
    // Year 1: 300, 150, 700
    // Year 2: 250, 200, 600
    // Sales over 500: 700, 600 = 2 sales
    // Sales under 500: 300, 150, 250, 200 = 4 sales
    
    /**
     * Test for GetSalesOverLimit method
     * This test checks if we correctly count sales over 500
     * We expect 2 sales over 500 (700 and 600)
     */
    @Test
    public void GetSalesOverLimit_ReturnsNumberOfSales() {
        System.out.println("Testing GetSalesOverLimit method...");
        
        // Create our calculator object
        ProductsSales calculator = new ProductsSales();
        
        // Call the method we want to test
        int result = calculator.GetSalesOverLimit();
        
        // We expect 2 because:
        // 700 > 500 and 600 > 500
        int expected = 2;
        
        // Check if the result matches what we expect
        assertEquals("Should find 2 sales over 500", expected, result);
        
        System.out.println("GetSalesOverLimit test passed! Found " + result + " sales over 500");
    }

    /**
     * Test for GetSalesUnderLimit method  
     * This test checks if we correctly count sales under 500
     * We expect 4 sales under 500 (300, 150, 250, 200)
     */
    @Test
    public void GetSalesUnderLimit_ReturnsNumberOfSales() {
        System.out.println("Testing GetSalesUnderLimit method...");
        
        // Create our calculator object
        ProductsSales calculator = new ProductsSales();
        
        // Call the method we want to test
        int result = calculator.GetSalesUnderLimit();
        
        // We expect 4 because:
        // 300 < 500, 150 < 500, 250 < 500, 200 < 500
        int expected = 4;
        
        // Check if the result matches what we expect
        assertEquals("Should find 4 sales under 500", expected, result);
        
        System.out.println("GetSalesUnderLimit test passed! Found " + result + " sales under 500");
    }
    
    /**
     * BONUS TEST: Test for GetTotalSales method
     * This checks if total calculation is correct
     * 300+150+700+250+200+600 = 2200
     */
    @Test
    public void testGetTotalSales() {
        System.out.println("Testing GetTotalSales method...");
        
        ProductsSales calculator = new ProductsSales();
        int result = calculator.GetTotalSales();
        int expected = 2200;
        
        assertEquals("Total should be 2200", expected, result);
        System.out.println("GetTotalSales test passed! Total: " + result);
    }
    
    /**
     * BONUS TEST: Test for GetAverageSales method
     * This checks if average calculation is correct
     * 2200 total / 6 sales = 366.666...
     */
    @Test
    public void testGetAverageSales() {
        System.out.println("Testing GetAverageSales method...");
        
        ProductsSales calculator = new ProductsSales();
        double result = calculator.GetAverageSales();
        double expected = 366.666;
        
        // Use delta for floating point comparison
        assertEquals("Average should be about 366.666", expected, result, 0.1);
        System.out.println("GetAverageSales test passed! Average: " + result);
    }
    
    /**
     * BONUS TEST: Test for GetProductsProcessed method
     * This checks if year count is correct
     * We have 2 years of data
     */
    @Test
    public void testGetProductsProcessed() {
        System.out.println("Testing GetProductsProcessed method...");
        
        ProductsSales calculator = new ProductsSales();
        int result = calculator.GetProductsProcessed();
        int expected = 2;
        
        assertEquals("Should process 2 years", expected, result);
        System.out.println("GetProductsProcessed test passed! Years: " + result);
    }
}