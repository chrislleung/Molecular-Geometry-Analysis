import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ButtonMenuGUI extends JFrame {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    public ButtonMenuGUI() {
        // Set up the JFrame
        setTitle("Button Menu");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the buttons
        button1 = new JButton("XYZ Combiner");
        button2 = new JButton("XYZ Decombiner");
        button3 = new JButton("XYZ to GJF");
        button4 = new JButton("Angle Calculator");

        // Create the action listeners for the buttons
        ActionListener button1Listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    SubGUI1 subMenu1 = new SubGUI1();
                    subMenu1.setVisible(true);
                }catch(Exception IOExpcetion){
                    System.out.println("Cry");
                }
            }
        };
        button1.addActionListener(button1Listener);

        ActionListener button2Listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    SubGUI2 subMenu2 = new SubGUI2();
                    subMenu2.setVisible(true);
                }catch(Exception IOExpcetion){
                    System.out.println("Cry");
                }
            }
        };
        button2.addActionListener(button2Listener);

        ActionListener button3Listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    SubGUI3 subMenu3 = new SubGUI3();
                    subMenu3.setVisible(true);
                }catch(Exception IOExpcetion){
                    System.out.println("Cry");
                }
            }
        };
        button3.addActionListener(button3Listener);

        ActionListener button4Listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    SubGUI4 subMenu4 = new SubGUI4();
                    subMenu4.setVisible(true);
                }catch(Exception IOExpcetion){
                    System.out.println("mald");
                }
            }
        };
        button4.addActionListener(button4Listener);

        // Add buttons to the JFrame
        Container container = getContentPane();
        container.setLayout(new GridLayout(3, 2));
        container.add(button1);
        container.add(button2);
        container.add(button3);
        container.add(button4);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ButtonMenuGUI buttonMenu = new ButtonMenuGUI();
                buttonMenu.setVisible(true);
            }
        });
    }
}

class SubGUI1 extends JFrame{
    private JTextField numberField;
    private JButton saveButton;
    private int savedNumber;

    public SubGUI1() throws IOException {
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
class SubGUI2 extends JFrame {
    private JTextField textField;
    private JButton saveButton;
    private String savedString;

    public SubGUI2() {
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
                SubGUI2 stringInput = new SubGUI2();
                stringInput.setVisible(true);
            }
        });
    }
}

// Sub-menu 3
class SubGUI3 extends JFrame {
    private JTextArea textArea;
    private JTextField numberField;
    private JButton saveButton;
    private String savedText;
    private int savedNumber;

    public SubGUI3() {
        // Set up the JFrame
        setTitle("Text and Number Input");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create Prompt
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        container.add(new JLabel("Enter the first 8 lines of the GJF file: "));

        // Create the text area
        textArea = new JTextArea(10, 50);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Create the number input field
        numberField = new JTextField();
        numberField.setPreferredSize(new Dimension(150, 30));

        // Create the save button
        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveInputs();
            }
        });

        // Add components to the JFrame
        container = getContentPane();
        //container.setLayout(new BorderLayout());
        container.add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(new JLabel("Enter the number of files to combine (make sure the files are ordered 0-n.xyz): "));
        inputPanel.add(numberField);
        inputPanel.add(saveButton);

        container.add(inputPanel, BorderLayout.SOUTH);
    }

    private void saveInputs() {
        savedText = textArea.getText();

        String numberInput = numberField.getText();
        try {
            savedNumber = Integer.parseInt(numberInput);
            JOptionPane.showMessageDialog(this, "Inputs saved successfully!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid number format!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        //debug
        /*
        System.out.println(savedText);
        System.out.println(savedNumber);
         */
        try {
            Formatter f = new Formatter(savedText, savedNumber);
        }catch(Exception IOException){
            System.out.println("IOException !!!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SubGUI3 inputGUI = new SubGUI3();
                inputGUI.setVisible(true);
            }
        });
    }
}

// Sub-menu 4
class SubGUI4 extends JFrame {
    private JTextField[] numberFields;
    private JTextField stringField;
    private JButton saveButton;
    private int[] savedNumbers;
    private String savedString;

    private JLabel filename;
    private JLabel[] points;

    public SubGUI4() {
        // Set up the JFrame
        setTitle("Input");
        setSize(300, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the number input fields
        numberFields = new JTextField[6];
        for (int i = 0; i < numberFields.length; i++) {
            numberFields[i] = new JTextField();
            numberFields[i].setPreferredSize(new Dimension(100, 30));
        }

        // Create the string input field
        stringField = new JTextField();
        stringField.setPreferredSize(new Dimension(200, 30));

        // Create the save button
        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveInputs();
            }
        });

        // Add components to the JFrame
        Container container = getContentPane();
        container.setLayout(new GridLayout(8, 1));
        filename = new JLabel("Enter the file name:");
        container.add(filename);
        container.add(stringField);

        points = new JLabel[numberFields.length];
        for (int i = 0; i < numberFields.length; i++) {
            points[i] = new JLabel("Enter point " + (i + 1) + ":");
            container.add(points[i]);
            container.add(numberFields[i]);
        }
        container.add(saveButton);

    }

    private void saveInputs() {
        savedNumbers = new int[numberFields.length];
        boolean validInput = true;

        for (int i = 0; i < numberFields.length; i++) {
            String input = numberFields[i].getText();
            try {
                savedNumbers[i] = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                validInput = false;
                break;
            }
        }

        savedString = stringField.getText();

        if (validInput) {
            JOptionPane.showMessageDialog(this, "Inputs saved successfully!");
            AngleCalc a;
            try {
                a = new AngleCalc(savedString, savedNumbers[0], savedNumbers[1], savedNumbers[2], savedNumbers[3], savedNumbers[4], savedNumbers[5]);
                openResult(a.getAngle(), a.getRadians());
            } catch (Exception IOException) {
                System.out.println("you are stupid.");
            }
            ;
        } else {
            JOptionPane.showMessageDialog(this, "Invalid number format!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void openResult(double angle, double radians) {

        JFrame guil = new JFrame("Result");
        guil.setTitle("Sub-menu 3");
        setSize(500, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Add components to the JFrame
        String result = "The angle is " +angle +" degrees ( " + radians +" radians)";
        JLabel blankLabel = new JLabel("");
        JLabel label = new JLabel(result);


        label.setHorizontalAlignment(SwingConstants.CENTER);

        Container container = getContentPane();
        container.remove(filename);
        container.remove(stringField);
        for (int i = 0; i < numberFields.length; i++) {
            container.remove(points[i]);
            container.remove(numberFields[i]);
        }
        container.remove(saveButton);
        container.add(label);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SubGUI4 inputGUI = new SubGUI4();
                inputGUI.setVisible(true);
            }
        });
    }
}