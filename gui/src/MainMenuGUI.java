import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


//DROPPED FOR ButtonMenuGUI
public class MainMenuGUI extends JFrame {
    private JComboBox<String> menuComboBox;

    public MainMenuGUI() {
        // Set up the JFrame
        setTitle("Main Menu");
        setSize(500, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the greeting label
        JLabel greetingLabel = new JLabel("Welcome to the Main Menu!");
        greetingLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Create the explanation label
        JLabel explanationLabel = new JLabel("Please select a program from the menu:");
        explanationLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Create the menu options
        String[] options = {"XYZ Combiner", "XYZ Decombiner", "Option 3"};
        menuComboBox = new JComboBox<>(options);


        // Create the action listener for the menu
        ActionListener menuActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String selectedOption = (String) menuComboBox.getSelectedItem();
                    openSubMenu(selectedOption);
                }
                catch(Exception IOException) {
                    System.out.println("error !");
                }

            }
        };
        menuComboBox.addActionListener(menuActionListener);

        // Add components to the JFrame
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(greetingLabel, BorderLayout.NORTH);
        container.add(explanationLabel, BorderLayout.CENTER);
        container.add(menuComboBox, BorderLayout.SOUTH);
    }

    private void openSubMenu(String selectedOption) throws IOException{
        if (selectedOption.equals("XYZ Combiner")) {
            SubMenuGUI1 subMenu1 = new SubMenuGUI1();
            subMenu1.setVisible(true);
        } else if (selectedOption.equals("XYZ Decombiner")) {
            SubMenuGUI2 subMenu2 = new SubMenuGUI2();
            subMenu2.setVisible(true);
        } else if (selectedOption.equals("Option 3")) {
            SubMenuGUI3 subMenu3 = new SubMenuGUI3();
            subMenu3.setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainMenuGUI mainMenu = new MainMenuGUI();
                    mainMenu.setVisible(true);
                }
                catch(Exception e) {
                    System.out.println("error !");
                }

            }
        });
    }
}

// Sub-menu 1
class SubMenuGUI1 extends JFrame{
    private JTextField numberField;
    private JButton saveButton;
    private int savedNumber;

    public SubMenuGUI1() throws IOException{
        // Set up the JFrame
        setTitle("Number Input");
        setSize(600, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the number input field
        numberField = new JTextField();
        numberField.setPreferredSize(new Dimension(100, 30));

        // Create the save button
        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    saveNumber();
                }
                catch(Exception IOException) {
                    System.out.println("error !");
                }

            }
        });

        // Add components to the JFrame
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        container.add(new JLabel("Enter how many files you want to combine (make sure file names are sorted from 0-n): "));
        container.add(numberField);
        container.add(saveButton);

        //debug
        //System.out.println(savedNumber);
    }

    private void saveNumber() throws IOException{
        String input = numberField.getText();
        try {
            savedNumber = Integer.parseInt(input);
            JOptionPane.showMessageDialog(this, "Combined!");

            //debug
            //System.out.println(savedNumber);
            XYZCombiner c = new XYZCombiner(savedNumber);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid number format!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) throws IOException{
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    SubMenuGUI1 numberInput = new SubMenuGUI1();
                    numberInput.setVisible(true);
                }
                catch(Exception IOException) {
                    System.out.println("error !");
                }

            }
        });
    }
    
}

// Sub-menu 2
class SubMenuGUI2 extends JFrame {
    private JTextField textField;
    private JButton saveButton;
    private String savedString;

    public SubMenuGUI2() {
        // Set up the JFrame
        setTitle("String Input");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the text input field
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 30));

        // Create the save button
        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveString();
            }
        });

        // Add components to the JFrame
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        container.add(new JLabel("Enter the file name:"));
        container.add(textField);
        container.add(saveButton);
    }

    private void saveString() {
        savedString = textField.getText();
        JOptionPane.showMessageDialog(this, "String saved successfully!");
        try{
            Decombiner d = new Decombiner(savedString);
            d.print();
        }catch(Exception IOexception){
            System.out.println("IOException!!!");
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SubMenuGUI2 stringInput = new SubMenuGUI2();
                stringInput.setVisible(true);
            }
        });
    }
}

// Sub-menu 3
class SubMenuGUI3 extends JFrame {
    public SubMenuGUI3() {
        // Set up the JFrame
        setTitle("Sub-menu 3");
        setSize(300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Add components to the JFrame
        JLabel label = new JLabel("This is Sub-menu 3");

        label.setHorizontalAlignment(SwingConstants.CENTER);
        Container container = getContentPane();
        container.add(label);
    }
}

// Sub-menu 4
class SubMenuGUI4 extends JFrame {
    public SubMenuGUI4() {
        // Set up the JFrame
        setTitle("Sub-menu 3");
        setSize(300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Add components to the JFrame
        JLabel label = new JLabel("This is Sub-menu 3");

        label.setHorizontalAlignment(SwingConstants.CENTER);
        Container container = getContentPane();
        container.add(label);
    }
}

