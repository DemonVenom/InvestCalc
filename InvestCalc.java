
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;


public class InvestCalc extends JFrame {

    private JLabel investLabel;
    private JLabel yearsLabel;
    private JLabel annualInterestLabel;
    private JLabel futureValueLabel;

    private JTextField investmentAmount;
    private JTextField years;
    private JTextField annualInterestRate;
    private JTextField outputTextField;

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;

    private JMenuBar menuBar;
    private JMenu menu1;
    private JMenu menu2;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;

    private JButton calculateButton;

    private Component parent = this;



    public InvestCalc() {

        // create a frame and label
        super("Investment Calculator");

        // Set the border layout to default
        setLayout(new BorderLayout());
        // Set the grid layout to have 5 rows
        setLayout(new GridLayout(5, 1));
        // Set the width (450) and height (250) of window
        setSize(450, 250);
        // Set the windows to close when the close button is pressed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Call the createPanel1 method
        createPanel1();
        // Add the panel to the frame
        add(panel1);

        // Call the createPanel2 method
        createPanel2();
        // Add the panel to the frame
        add(panel2);

        // Call the createPanel3 method
        createPanel3();
        // Add the panel to the frame
        add(panel3);

        // Call the createPanel4 method
        createPanel4();
        // Add the panel to the frame
        add(panel4);

        // Call the createPanel5 method
        createPanel5();
        // Add the panel to the frame
        add(panel5);

        // Call the createMenuBar method
        createMenuBar();
        // Add the menu bar to the frame
        add(menuBar);
        setJMenuBar(menuBar);

        // Make the window visible to the user
        setVisible(true);

    }


    // Create method to create MenuBar and attributes

    private void createMenuBar(){

        // Create a MenuBar
        menuBar = new JMenuBar();

        // Create Menu for the Operation tab
        menu1 = new JMenu("Operation");

        // Create MenuItem to calculate the operation
        menuItem1 = new JMenuItem("Calculate");
        // Attach an ActionListener to give it calculation function
        menuItem1.addActionListener(new CalculateHandler());
        // Create MenuItem to exit the program
        menuItem2 = new JMenuItem("Exit");
        // Attach an ActionListener to give it exiting function
        menuItem2.addActionListener(new ExitHandler());

        // Add MenuItem to Menu1
        menu1.add(menuItem1);
        menu1.add(menuItem2);



        // Create Menu for the Help tab
        menu2 = new JMenu("Help");

        // Create MenuItem to display the future value equation
        menuItem3 = new JMenuItem("Future Value");
        // Attach an ActionListener to give it JOption function
        menuItem3.addActionListener(new HelpHandler());

        // Add MenuItems to Menu2
        menu2.add(menuItem3);


        // Add Menu1 and Menu2 to MenuBar
        menuBar.add(menu1);
        menuBar.add(menu2);

    }



    // Create method to make panel1 for investment amount input

    private void createPanel1() {

        // Create a new label, prompting the user to input investment amount number
        investLabel = new JLabel("Investment Amount");
        // Create a new text field, measured at 10 characters long
        investmentAmount = new JTextField(10);
        // Create a new action listener, allows program to start calculation
        investmentAmount.addActionListener(new CalculateHandler());


        // Create a new label, prompting the user to input kilometer value
        annualInterestLabel = new JLabel("Annual Interest Rate");
        // Create a new text field, measured at 10 characters long


        // Create a new panel, using the panel1 reference
        panel1 = new JPanel();

        // Add label, text field, to panel1
        panel1.add(investLabel);
        panel1.add(investmentAmount);

    }


    // Create method to make panel2 for years input

    private void createPanel2() {

        // Create a new label, prompting the user to input years number
        yearsLabel = new JLabel("Years");
        // Create a new text field, measured at 10 characters long
        years = new JTextField(10);
        // Create a new action listener, allows program to start calculation
        years.addActionListener(new CalculateHandler());

        // Create panel2, using the panel2 reference
        panel2 = new JPanel();

        // Add label, text field, to panel2
        panel2.add(yearsLabel);
        panel2.add(years);

    }


    // Create method to make panel3 for annual interest rate

    private void createPanel3() {

        // Create a new label, prompting the user to input interest rate number
        annualInterestRate = new JTextField(10);
        // Create a new action listener, allows program to start calculation
        annualInterestRate.addActionListener(new CalculateHandler());

        // Create panel3, using the panel3 reference
        panel3 = new JPanel();

        // Add label, text field, to panel3
        panel3.add(annualInterestLabel);
        panel3.add(annualInterestRate);

    }


    // Create method to make panel4 for the future value output

    private void createPanel4() {

        // Create a new label, showing user the unit after calculation
        futureValueLabel = new JLabel("Future Value");

        // Create a new text field, measured at 20 characters long
        outputTextField = new JTextField(20);
        // Set attributes to the text field, making it uneditable and gray
        outputTextField.setBackground(Color.LIGHT_GRAY);
        outputTextField.setEditable(false);



        // Create a new panel, using the panel4 reference
        panel4 = new JPanel();

        // Add text field, label, to panel4
        panel4.add(futureValueLabel);
        panel4.add(outputTextField);


    }


    // Create method to make panel5 for the calculation button

    private void createPanel5() {

        // Create a new button, allows user to start calculation
        calculateButton = new JButton("Calculate");
        // Create a new action listener, allows program to start calculation
        calculateButton.addActionListener(new CalculateHandler());

        // Create a new panel, using the panel5 reference
        panel5 = new JPanel();

        // Add button to panel5
        panel5.add(calculateButton);

    }


    // Create class to handle future investment value

    private class CalculateHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            // Create new number format to place commas for large numbers
            NumberFormat myFormat = NumberFormat.getInstance();
            myFormat.setGroupingUsed(true);

            // Assign text field to variable
            double investAmount = Double.parseDouble(investmentAmount.getText());
            // Assign text field to variable after calculation (conversion from annual to monthly)
            double monthlyInterestRate = ((Double.parseDouble(annualInterestRate.getText()) / 100.0) / 12.0);
            // Assign text field to variable
            double calcYears = (Double.parseDouble(years.getText()));

            // Calculate interest rate and assign to variable
            double output = investAmount * Math.pow((1 + monthlyInterestRate), (calcYears * 12));
            // Round interest rate to 2 decimal points
            output = Math.round(output * 100.0) / 100.0;

            // Convert final output to a string with the number format for commas
            String finalOutput = String.format("$%s", (String.valueOf(myFormat.format(output))));

            // Set the output text field to the result
            outputTextField.setText(finalOutput);
        }
    }


    // Create class to end the program

    private class ExitHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            // Exits with status code 0
            System.exit(0);
        }
    }


    private class HelpHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            // Assign message to string
            String results = String.format("%s", "The following formula was used to calculate the future value:\n\nfutureValue = investAmount * (1 + monthlyInterestRate)^(years * 12)");

            // Report to user the formula used in calculation using string
            JOptionPane.showMessageDialog(parent, results);

        }
    }






}
