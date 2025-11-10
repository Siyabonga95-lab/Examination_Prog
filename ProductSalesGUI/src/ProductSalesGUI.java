/*
*Question 2
*Student Number:ST10488360
*Student Name:Siyabonga Msimango
 */

// These imports are needed for file writing and message boxes
// I learned about these from our Java textbook chapter on file handling
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

// This is the main window class for our product sales application
// It extends JFrame which means it creates a window
public class ProductSalesGUI extends javax.swing.JFrame {
    // This creates our calculator object that does all the math
    // We'll use this to get totals, averages, and counts
    private ProductsSales salesCalculator = new ProductsSales();
    
    // This is the constructor - it runs when we create the window
    public ProductSalesGUI() {
        initComponents(); // This sets up all the buttons and labels
        setTitle("Product Sales Application"); // Sets the window title
    }

    // This method runs when the Load button is clicked
    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {
        loadProductData(); // Call our method to load and display data
    }

    // This method runs when the Save button is clicked
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        saveProductData(); // Call our method to save data to file
    }
    
    // This method loads the product data and displays it
    // It gets all the calculated values and shows them on screen
    private void loadProductData() {
        // Get all the calculated values from our calculator
        int total = salesCalculator.GetTotalSales();
        double average = salesCalculator.GetAverageSales();
        int overLimit = salesCalculator.GetSalesOverLimit();
        int underLimit = salesCalculator.GetSalesUnderLimit();
        int years = salesCalculator.GetProductsProcessed();
        
        // Get the actual sales numbers to display
        int[][] data = salesCalculator.GetProductSales();
        
        // Build the text that will show in the text area
        // This creates a nice formatted display of our data
        String displayText = "PRODUCT SALES DATA\n" +
                           "==================\n" +
                           "Year 1: Microphone=" + data[0][0] + 
                           ", Speakers=" + data[0][1] + 
                           ", Mixing Desk=" + data[0][2] + "\n" +
                           "Year 2: Microphone=" + data[1][0] + 
                           ", Speakers=" + data[1][1] + 
                           ", Mixing Desk=" + data[1][2] + "\n\n" +
                           "Total Sales: " + total + "\n" +
                           "Average Sales: " + (int)average + "\n" +
                           "Sales Over 500: " + overLimit + "\n" +
                           "Sales Under 500: " + underLimit + "\n";
        
        // Put the text into the text area so user can see it
        txtAreaDisplay.setText(displayText);
        
        // Update all the labels with the calculated values
        lblTotal.setText("Total Sales: " + total);
        lblAverage.setText("Average Sales: " + (int)average);
        lblOverLimit.setText("Sales over limit: " + overLimit);
        lblUnderLimit.setText("Sales under limit: " + underLimit);
        lblYears.setText("Years Processed: " + years);
    }
    
    // This method saves the data to a text file
    // It uses file writing which we learned in class
    private void saveProductData() {
        try {
            // Create a file writer for data.txt
            // This part was helped by Java documentation on file handling
            // Reference: https://docs.oracle.com/javase/tutorial/essential/io/file.html
            FileWriter writer = new FileWriter("data.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            
            // Write all the data to the file with nice formatting
            bufferedWriter.write("DATA LOG");
            bufferedWriter.newLine();
            bufferedWriter.write("Total Sales: " + salesCalculator.GetTotalSales());
            bufferedWriter.newLine();
            bufferedWriter.write("Average Sales: " + (int)salesCalculator.GetAverageSales());
            bufferedWriter.newLine();
            bufferedWriter.write("Sales over Limit: " + salesCalculator.GetSalesOverLimit());
            bufferedWriter.newLine();
            bufferedWriter.write("Sales under Limit: " + salesCalculator.GetSalesUnderLimit());
            bufferedWriter.newLine();
            bufferedWriter.write("***************************************************************");
            bufferedWriter.newLine();
            
            // Important: always close the file when done writing
            bufferedWriter.close();
            
            // Show a success message to the user
            JOptionPane.showMessageDialog(this, "Data saved to data.txt!");
            
        } catch (IOException e) {
            // If something goes wrong, show an error message
            JOptionPane.showMessageDialog(this, "Error saving file: " + e.getMessage());
        }
    }

    // Menu item methods - these work the same as the buttons
    private void menuLoadActionPerformed(java.awt.event.ActionEvent evt) {
        loadProductData(); // Same as load button
    }

    private void menuSaveActionPerformed(java.awt.event.ActionEvent evt) {
        saveProductData(); // Same as save button
    }

    // This clears the display and resets the years label
    private void menuClearActionPerformed(java.awt.event.ActionEvent evt) {
        txtAreaDisplay.setText(""); // Clear text area
        lblYears.setText("Years Processed: 0"); // Reset years count
    }

    // This closes the application when Exit is clicked
    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0); // This stops the program
    }

    // This is the main method - where the program starts
    // Every Java application needs a main method
    public static void main(String args[]) {
        // This part makes the application look like other programs on your computer
        // I found this code in our NetBeans textbook examples
        try {
            javax.swing.UIManager.setLookAndFeel(
                javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // This creates and shows our window
        // The EventQueue stuff ensures it runs on the right thread
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductSalesGUI().setVisible(true); // Create window and make it visible
            }
        });
    }

    // Variables declaration - DO NOT MODIFY
    // These are all the buttons, labels, and menus on our form
    // NetBeans automatically creates these when you design the form
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSave;
    private javax.swing.JTextArea txtAreaDisplay;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblAverage;
    private javax.swing.JLabel lblOverLimit;
    private javax.swing.JLabel lblUnderLimit;
    private javax.swing.JLabel lblYears;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenu menuTools;
    private javax.swing.JMenuItem menuLoad;
    private javax.swing.JMenuItem menuSave;
    private javax.swing.JMenuItem menuClear;
    // End of variables declaration

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // This method sets up all the visual components on the form
    // NetBeans automatically generates this code when you design the form
    // I used the NetBeans drag-and-drop designer to create the layout
    private void initComponents() {

        // Create the Load button
        btnLoad = new javax.swing.JButton();
        btnLoad.setText("Load Product Data");
        // This connects the button click to our method
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        // Create the Save button
        btnSave = new javax.swing.JButton();
        btnSave.setText("Save Product Data");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        // Create the text area with scroll bars
        txtAreaDisplay = new javax.swing.JTextArea();
        txtAreaDisplay.setColumns(20);  // Set width
        txtAreaDisplay.setRows(5);      // Set height
        // Put the text area in a scroll pane so we can scroll if needed
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setViewportView(txtAreaDisplay);

        // Create all the labels for displaying results
        lblTotal = new javax.swing.JLabel();
        lblTotal.setText("Total Sales: 0");

        lblAverage = new javax.swing.JLabel();
        lblAverage.setText("Average Sales: 0");

        lblOverLimit = new javax.swing.JLabel();
        lblOverLimit.setText("Sales over limit: 0");

        lblUnderLimit = new javax.swing.JLabel();
        lblUnderLimit.setText("Sales under limit: 0");

        lblYears = new javax.swing.JLabel();
        lblYears.setText("Years Processed: 0");

        // Create the menu bar and menus
        menuBar = new javax.swing.JMenuBar();
        
        // File menu
        menuFile = new javax.swing.JMenu();
        menuFile.setText("File");

        // Exit menu item
        menuExit = new javax.swing.JMenuItem();
        menuExit.setText("Exit");
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitActionPerformed(evt);
            }
        });
        menuFile.add(menuExit);

        menuBar.add(menuFile);

        // Tools menu
        menuTools = new javax.swing.JMenu();
        menuTools.setText("Tools");

        // Load menu item
        menuLoad = new javax.swing.JMenuItem();
        menuLoad.setText("Load Product Data");
        menuLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLoadActionPerformed(evt);
            }
        });
        menuTools.add(menuLoad);

        // Save menu item
        menuSave = new javax.swing.JMenuItem();
        menuSave.setText("Save Product Data");
        menuSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSaveActionPerformed(evt);
            }
        });
        menuTools.add(menuSave);

        // Clear menu item
        menuClear = new javax.swing.JMenuItem();
        menuClear.setText("Clear");
        menuClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClearActionPerformed(evt);
            }
        });
        menuTools.add(menuClear);

        menuBar.add(menuTools);

        // Set the menu bar for the window
        setJMenuBar(menuBar);

        // This part uses GroupLayout to arrange all components on the form
        // NetBeans automatically generates this layout code
        // I learned about layouts from our GUI programming textbook chapter
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLoad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotal)
                            .addComponent(lblAverage)
                            .addComponent(lblOverLimit)
                            .addComponent(lblUnderLimit)
                            .addComponent(lblYears))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoad)
                    .addComponent(btnSave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAverage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOverLimit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUnderLimit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblYears)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack(); // This sizes the window to fit all components
    }
}