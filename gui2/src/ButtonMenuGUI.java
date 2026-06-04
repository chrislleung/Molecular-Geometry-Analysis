import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class ButtonMenuGUI extends JFrame {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JButton button13;


    public ButtonMenuGUI() {
        // Set up the JFrame
        setTitle("Button Menu");
        setSize(450, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the buttons
        button1 = new JButton(".xyz Combiner");
        button2 = new JButton(".xyz Decombiner");
        button3 = new JButton(".xyz to .gjf");
        button4 = new JButton("Coordinate Increments (.xyz)");
        button5 = new JButton(".log Formatter (orca)");
        button6 = new JButton(".xyz to .inp");
        button7 = new JButton("Angle Calculator");
        button8 = new JButton("Critical Point Extractor");
        button9 = new JButton("Center Alignment");
        //button10 = new JButton("Geometric Center");
        button11 = new JButton("Pyrene Projection");
        //button12 = new JButton("Ring Distance Calculator");     //this is a fucking nightmare
        button13 = new JButton("Pyramidal Differential");


        // Create the action listeners for the buttons
        ActionListener button1Listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    XYZComb subMenu = new XYZComb();
                    subMenu.setVisible(true);
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
                    XYZDecomb subMenu = new XYZDecomb();
                    subMenu.setVisible(true);
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
                    XYZtoGJF subMenu = new XYZtoGJF();
                    subMenu.setVisible(true);
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
                    CoordsInc subMenu = new CoordsInc();
                    subMenu.setVisible(true);
                }catch(Exception IOExpcetion){
                    System.out.println("Cry");
                }
            }
        };
        button4.addActionListener(button4Listener);

        ActionListener button5Listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    logFormatter subMenu = new logFormatter();
                    subMenu.setVisible(true);
                }catch(Exception IOExpcetion){
                    System.out.println("Cry");
                }
            }
        };
        button5.addActionListener(button5Listener);

        ActionListener button7Listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    AngleCalculator subMenu = new AngleCalculator();
                    subMenu.setVisible(true);
                }catch(Exception IOExpcetion){
                    System.out.println("mald");
                }
            }
        };
        button7.addActionListener(button7Listener);

        ActionListener button8Listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    CPE subMenu = new CPE();
                    subMenu.setVisible(true);
                }catch(Exception IOExpcetion){
                    System.out.println("mald");
                }
            }
        };
        button8.addActionListener(button8Listener);

        ActionListener button9Listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    CenterAlignment subMenu = new CenterAlignment();
                    subMenu.setVisible(true);
                }catch(Exception IOExpcetion){
                    System.out.println("mald");
                }
            }
        };
        button9.addActionListener(button9Listener);

//        ActionListener button10Listener = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try{
//                    GeometricCenter subMenu = new GeometricCenter();
//                    subMenu.setVisible(true);
//                }catch(Exception IOExpcetion){
//                    System.out.println("mald");
//                }
//            }
//        };
//        button10.addActionListener(button10Listener);

        ActionListener button11Listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Pyramidal subMenu = new Pyramidal();
                    subMenu.setVisible(true);
                }catch(Exception IOExpcetion){
                    System.out.println("mald");
                }
            }
        };
        button11.addActionListener(button11Listener);

//        ActionListener button12Listener = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try{
//                    //TODO
//                    PyreneProjection subMenu = new PyreneProjection();
//                    subMenu.setVisible(true);
//                }catch(Exception IOExpcetion){
//                    System.out.println("mald");
//                }
//            }
//        };
//        button12.addActionListener(button12Listener);

        ActionListener button13Listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Pyramidal subMenu = new Pyramidal();
                    subMenu.setVisible(true);
                }catch(Exception IOExpcetion){
                    System.out.println("mald");
                }
            }
        };
        button13.addActionListener(button13Listener);

        // Add buttons to the JFrame
        Container container = getContentPane();
        container.setLayout(new GridLayout(8, 2));
        container.add(new JLabel("     File Modifier"));
        container.add(new JLabel());
        container.add(button1);
        container.add(button2);
        container.add(button3);
        container.add(button4);
        container.add(button5);
        container.add(button6);
        container.add(button9);
        container.add(button11);
        //container.add(new JLabel());
        container.add(new JLabel("     Data Manipulation"));
        container.add(new JLabel());
        container.add(button7);
        container.add(button8);
        //container.add(button10);
        //container.add(button12);
        container.add(button13);


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

//xyz combiner
class XYZComb extends JFrame{
    private JTextField numberField;
    private JButton saveButton;
    private int savedNumber;

    public XYZComb() throws IOException {
        // Set up the JFrame
        setTitle("Number Input");
        setSize(600, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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

// xyz decombiner
class XYZDecomb extends JFrame {
    private JTextField textField;
    private JButton saveButton;
    private String savedString;

    public XYZDecomb() {
        // Set up the JFrame
        setTitle("String Input");
        setSize(300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
            JOptionPane.showMessageDialog(this, "Invalid input!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                XYZDecomb stringInput = new XYZDecomb();
                stringInput.setVisible(true);
            }
        });
    }
}

// xyz to gjf
class XYZtoGJF extends JFrame {
    private JTextArea textArea;
    private JTextField numberField;
    private JButton saveButton;
    private String savedText;
    private int savedNumber;

    public XYZtoGJF() {
        // Set up the JFrame
        setTitle("Text and Number Input");
        setSize(700, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
            GJFFormatter f = new GJFFormatter(savedText, savedNumber);
        }catch(Exception IOException){
            System.out.println("IOException !!!");
            JOptionPane.showMessageDialog(this, "Invalid input!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                XYZtoGJF inputGUI = new XYZtoGJF();
                inputGUI.setVisible(true);
            }
        });
    }
}

// coordinate increments
class CoordsInc extends JFrame {
    private JTextField stringField1;
    private JTextField stringField2;
    private JTextField doubleField;
    private JTextField intField;
    private JButton saveButton;
    private String savedString1;
    private String savedString2;
    private double savedDouble;
    private int savedInt;

    public CoordsInc() {
        // Set up the JFrame
        setTitle("Coordinate Increments");
        setSize(550, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the string input fields
        stringField1 = new JTextField();
        stringField2 = new JTextField();
        stringField1.setPreferredSize(new Dimension(200, 30));
        stringField2.setPreferredSize(new Dimension(200, 30));

        // Create the double input field
        doubleField = new JTextField();
        doubleField.setPreferredSize(new Dimension(100, 30));

        // Create the int input field
        intField = new JTextField();
        intField.setPreferredSize(new Dimension(100, 30));

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
        container.setLayout(new GridLayout(5, 2));
        container.add(new JLabel("Enter the file name:"));
        container.add(stringField1);
        container.add(new JLabel("Enter which plane to translate (x, y, or z):"));
        container.add(stringField2);
        container.add(new JLabel("Enter your increments:"));
        container.add(doubleField);
        container.add(new JLabel("Enter how many times you want to increment:"));
        container.add(intField);
        container.add(new JLabel());
        container.add(saveButton);
    }

    private void saveInputs() {
        savedString1 = stringField1.getText();
        savedString2 = stringField2.getText();
        boolean validInput;

        try {
            savedDouble = Double.parseDouble(doubleField.getText());
            savedInt = Integer.parseInt(intField.getText());
            JOptionPane.showMessageDialog(this, "Inputs saved successfully!");
            validInput = true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid number format!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            validInput = false;
        }
        try{
            if (validInput){
                CoordinateIncrements.inc(savedString1, savedString2, savedDouble, savedInt);
            }
        }catch (Exception IOException){
            System.out.println("IOException");
            JOptionPane.showMessageDialog(this, "Invalid input!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CoordsInc inputGUI = new CoordsInc();
                inputGUI.setVisible(true);
            }
        });
    }
}

// log formatter
class logFormatter extends JFrame {
    private JTextField stringField1;
    private JTextField stringField2;
    private JTextField doubleField;
    private JTextField intField;
    private JButton saveButton;
    private String savedString1;
    private String savedString2;

    public logFormatter() {
        // Set up the JFrame
        setTitle(".log Formatter");
        setSize(550, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the string input fields
        stringField1 = new JTextField();
        stringField2 = new JTextField();
        stringField1.setPreferredSize(new Dimension(200, 30));
        stringField2.setPreferredSize(new Dimension(200, 30));

        // Create the double input field
        doubleField = new JTextField();
        doubleField.setPreferredSize(new Dimension(100, 30));

        // Create the int input field
        intField = new JTextField();
        intField.setPreferredSize(new Dimension(100, 30));

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
        container.setLayout(new GridLayout(3, 2));
        container.add(new JLabel("Enter the file name:"));
        container.add(stringField1);
        container.add(new JLabel("Enter the new file name (without the file type):"));
        container.add(stringField2);
        container.add(new JLabel());
        container.add(saveButton);
    }

    private void saveInputs() {
        /*
        savedString1 = stringField1.getText();
        savedString2 = stringField2.getText();
        boolean validInput;

        try{
            thelogFormatter.formatLog(savedString1, savedString2);
        }catch (Exception IOException){
            System.out.println("IOException");
        }
        */

        savedString1 = stringField1.getText();
        savedString2 = stringField2.getText();
        boolean validInput;

        try {
            Double.parseDouble(doubleField.getText());
            Integer.parseInt(intField.getText());
            JOptionPane.showMessageDialog(this, "Inputs saved successfully!");
            validInput = true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            validInput = false;
        }
        try{
            if (validInput){
                thelogFormatter.formatLog(savedString1, savedString2);
            }
        }catch (Exception IOException){
            System.out.println("IOException");
            JOptionPane.showMessageDialog(this, "Invalid input!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                logFormatter inputGUI = new logFormatter();
                inputGUI.setVisible(true);
            }
        });
    }
}

// xyz to inp
class XYZtoINP extends JFrame {
    public XYZtoINP() {
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

//angle calculator
class AngleCalculator extends JFrame {
    private JTextField[] numberFields;
    private JTextField stringField;
    private JButton saveButton;
    private int[] savedNumbers;
    private String savedString;

    private JLabel filename;
    private JLabel[] points;

    //private JButton loadButton;


    public AngleCalculator() {
        // Set up the JFrame
        setTitle("Input");
        setSize(300, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
        filename = new JLabel("Enter the file name: ");
        container.add(filename);
        container.add(stringField);
        //loadButton = new JButton("load");
        //container.add(loadButton);

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
                AngleCalculator inputGUI = new AngleCalculator();
                inputGUI.setVisible(true);
            }
        });
    }
}

//critical point extractor
class CPE extends JFrame {
    private JTextField stringField;
    private JTextField intField;
    private JButton saveButton;
    private ArrayList<Integer> savedIntegers;
    private String filename;

    public CPE() {
        // Set up the JFrame
        setTitle("Input");
        setSize(300, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the string input field
        stringField = new JTextField();
        stringField.setPreferredSize(new Dimension(200, 30));

        // Create the int input field
        intField = new JTextField();
        intField.setPreferredSize(new Dimension(100, 30));

        // Create the save button
        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveInputs();
                try{
                    CPExtractor c = new CPExtractor(filename, savedIntegers);
                }catch (Exception IOException){
                    System.out.println("IOException !!!");
                }

            }
        });

        // Add components to the JFrame
        Container container = getContentPane();
        container.setLayout(new GridLayout(5, 1));
        container.add(new JLabel("Enter the file name:"));
        container.add(stringField);
        container.add(new JLabel("Enter the number of points:"));
        container.add(intField);
        container.add(saveButton);
    }

    private void saveInputs() {
        filename = stringField.getText();
        int i = 0;
        try {
            i = Integer.parseInt(intField.getText());
            if (i <= 0) {
                JOptionPane.showMessageDialog(this, "Please enter a positive integer greater than 0!",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid number format!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        savedIntegers = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            String input = JOptionPane.showInputDialog(this, "Enter integer " + (j + 1) + ":");
            try {
                int num = Integer.parseInt(input);
                savedIntegers.add(num);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number format!",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "filename: " + filename + "\namount of cp: " + i +
                "\npoints: " + savedIntegers.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CPE inputGUI = new CPE();
                inputGUI.setVisible(true);
            }
        });
    }
}

//Center Alignment
class CenterAlignment extends JFrame {
    private JTextField stringField;
    private JTextField stringField2;
    private JTextField[] intFields;
    private JButton saveButton;
    private String savedString;
    private int[] savedIntegers;
    private String newName;

    public CenterAlignment() {
        // Set up the JFrame
        setTitle("Input");
        setSize(500, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the string input fields
        stringField = new JTextField();
        stringField.setPreferredSize(new Dimension(300, 30));
        stringField2 = new JTextField();
        stringField2.setPreferredSize(new Dimension(300, 30));


        // Create the integer input fields
        intFields = new JTextField[4];
        for (int i = 0; i < intFields.length; i++) {
            intFields[i] = new JTextField();
            intFields[i].setPreferredSize(new Dimension(100, 30));
        }

        // Create the save button
        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveInputs();
                try{
                    AlignCenter.centerAlignment(savedString, savedIntegers, newName);
                }catch (Exception IOException){
                    System.out.println("Cry abt it (IOException)");
                }
            }
        });

        // Add components to the JFrame
        Container container = getContentPane();
        container.setLayout(new GridLayout(7, 2));
        container.add(new JLabel("Enter a filename:"));
        container.add(stringField);
        container.add(new JLabel("Enter the starting line for molecule 1:"));
        container.add(intFields[0]);
        container.add(new JLabel("Enter the ending line for molecule 1:"));
        container.add(intFields[1]);
        container.add(new JLabel("Enter the starting line for molecule 2:"));
        container.add(intFields[2]);
        container.add(new JLabel("Enter the ending line for molecule 2:"));
        container.add(intFields[3]);
        container.add(new JLabel("Enter the new file name:"));
        container.add(stringField2);
        container.add(new JLabel());
        container.add(saveButton);
    }

    private void saveInputs() {
        savedString = stringField.getText();
        savedIntegers = new int[intFields.length];
        boolean validInput = true;

        for (int i = 0; i < intFields.length; i++) {
            String input = intFields[i].getText();
            try {
                savedIntegers[i] = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                validInput = false;
                break;
            }
        }

        newName = stringField2.getText();

        if (validInput) {
            JOptionPane.showMessageDialog(this, "Inputs saved successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid integer format!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CenterAlignment inputGUI = new CenterAlignment();
                inputGUI.setVisible(true);
            }
        });
    }
}

////Geometric Center
//class GeometricCenter extends JFrame {
//    private JTextField stringField;
//    private JTextField stringField2;
//    private JTextField[] intFields;
//    private JButton saveButton;
//    private String savedString;
//    private int[] savedIntegers;
//    private String newName;
//
//    public GeometricCenter() {
//        // Set up the JFrame
//        setTitle("Input");
//        setSize(500, 200);
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        // Create the string input fields
//        stringField = new JTextField();
//        stringField.setPreferredSize(new Dimension(300, 30));
//        stringField2 = new JTextField();
//        stringField2.setPreferredSize(new Dimension(300, 30));
//
//
//        // Create the integer input fields
//        intFields = new JTextField[4];
//        for (int i = 0; i < intFields.length; i++) {
//            intFields[i] = new JTextField();
//            intFields[i].setPreferredSize(new Dimension(100, 30));
//        }
//
//        // Create the save button
//        saveButton = new JButton("Save");
//        saveButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                saveInputs();
//                try{
//                    AlignCenter.centerAlignment(savedString, savedIntegers, newName);
//                }catch (Exception IOException){
//                    System.out.println("Cry abt it (IOException)");
//                }
//            }
//        });
//
//        // Add components to the JFrame
//        Container container = getContentPane();
//        container.setLayout(new GridLayout(6, 2));
//        container.add(new JLabel("Enter the filename:"));
//        container.add(stringField);
//        container.add(new JLabel("Enter the starting line for molecule 1:"));
//        container.add(intFields[0]);
//        container.add(new JLabel("Enter the ending line molecule 1:"));
//        container.add(intFields[1]);
//        //container.add(new JLabel());
//        container.add(new JLabel("Enter the starting line molecule 2:"));
//        container.add(intFields[2]);
//        container.add(new JLabel("Enter the ending line molecule 2:"));
//        container.add(intFields[3]);
//        container.add(new JLabel());
//        container.add(saveButton);
//    }
//
//    private void saveInputs() {
//        savedString = stringField.getText();
//        savedIntegers = new int[intFields.length];
//        boolean validInput = true;
//
//        for (int i = 0; i < intFields.length; i++) {
//            String input = intFields[i].getText();
//            try {
//                savedIntegers[i] = Integer.parseInt(input);
//            } catch (NumberFormatException e) {
//                validInput = false;
//                break;
//            }
//        }
//
//        newName = stringField2.getText();
//
//        if (validInput) {
//            try {
//                GeoCenter.centerAlignment(savedString, savedIntegers[0], savedIntegers[1], savedIntegers[2], savedIntegers[3]);
//            }catch(Exception IOExpcetion){
//                System.out.println("Cry");
//            }
//            JOptionPane.showMessageDialog(this, "Inputs saved successfully!");
//        } else {
//            JOptionPane.showMessageDialog(this, "Invalid integer format!",
//                    "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                GeometricCenter GUI = new GeometricCenter();
//                GUI.setVisible(true);
//            }
//        });
//    }
//}

//Pyrene Projection
class PyreneProjection extends JFrame {
    private JTextField stringField;
    private JTextField stringField2;
    private JTextField[] intFields;
    private JButton saveButton;
    private String savedString;
    private int[] savedIntegers;

    public PyreneProjection() {
        // Set up the JFrame
        setTitle("Input");
        setSize(500, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the string input fields
        stringField = new JTextField();
        stringField.setPreferredSize(new Dimension(300, 30));
        stringField2 = new JTextField();
        stringField2.setPreferredSize(new Dimension(300, 30));


        // Create the integer input fields
        intFields = new JTextField[4];
        for (int i = 0; i < intFields.length; i++) {
            intFields[i] = new JTextField();
            intFields[i].setPreferredSize(new Dimension(100, 30));
        }

        // Create the save button
        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveInputs();
                try{
                    Pyrene.run(savedString, savedIntegers[0], savedIntegers[1], savedIntegers[2], savedIntegers[3]);
                }catch (Exception IOException){
                    System.out.println("Cry abt it (IOException)");
                }
            }
        });

        // Add components to the JFrame
        Container container = getContentPane();
        container.setLayout(new GridLayout(6, 2));
        container.add(new JLabel("Enter the filename:"));
        container.add(stringField);
        container.add(new JLabel("Please enter the first point number: "));
        container.add(intFields[0]);
        container.add(new JLabel("Please enter the second point number: "));
        container.add(intFields[1]);
        container.add(new JLabel("Please enter the third point number: "));
        container.add(intFields[2]);
        container.add(new JLabel("# of atoms in the pyrene: "));
        container.add(intFields[3]);
        container.add(new JLabel());
        container.add(saveButton);
    }

    private void saveInputs() {
        savedString = stringField.getText();
        savedIntegers = new int[intFields.length];
        boolean validInput = true;

        for (int i = 0; i < intFields.length; i++) {
            String input = intFields[i].getText();
            try {
                savedIntegers[i] = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                validInput = false;
                break;
            }
        }

        if (validInput) {
            JOptionPane.showMessageDialog(this, "Inputs saved successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid integer format!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PyreneProjection inputGUI = new PyreneProjection();
                inputGUI.setVisible(true);
            }
        });
    }
}

////Ring Distance Calculator
//class RingDistanceCalculator extends JFrame {
//    private JTextField stringField;
//    private JTextField[] intFields;
//    private JButton saveButton;
//    private int numMol;
//    private int numRings;
//    private String filename;
//
//    public RingDistanceCalculator() {
//        // Set up the JFrame
//        setTitle("Input");
//        setSize(500, 300);
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        // Create the string input fields
//        stringField = new JTextField();
//        stringField.setPreferredSize(new Dimension(300, 30));
//
//
//        // Create the integer input fields
//        intFields = new JTextField[4];
//        for (int i = 0; i < intFields.length; i++) {
//            intFields[i] = new JTextField();
//            intFields[i].setPreferredSize(new Dimension(100, 30));
//        }
//
//        // Create the save button
//        saveButton = new JButton("Save");
//        saveButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                saveInputs();
//                try{
//                    //Pyrene.run(savedString, savedIntegers[0], savedIntegers[1], savedIntegers[2], savedIntegers[3]);
//                }catch (Exception IOException){
//                    System.out.println("Cry abt it (IOException)");
//                }
//            }
//        });
//
//        // Add components to the JFrame
//        Container container = getContentPane();
//        container.setLayout(new GridLayout(6, 2));
//        container.add(new JLabel("Enter the filename:"));
//        container.add(stringField);
//        container.add(new JLabel("Please enter the first point number: "));
//        container.add(intFields[0]);
//        container.add(new JLabel("Please enter the second point number: "));
//        container.add(intFields[1]);
//        container.add(new JLabel("Please enter the third point number: "));
//        container.add(intFields[2]);
//        container.add(new JLabel("# of atoms in the pyrene: "));
//        container.add(intFields[3]);
//        container.add(new JLabel());
//        container.add(saveButton);
//    }
//
//    private void saveInputs() {
//        //savedString = stringField.getText();
//        //savedIntegers = new int[intFields.length];
//        boolean validInput = true;
//
//        for (int i = 0; i < intFields.length; i++) {
//            String input = intFields[i].getText();
//            try {
//                //savedIntegers[i] = Integer.parseInt(input);
//            } catch (NumberFormatException e) {
//                validInput = false;
//                break;
//            }
//        }
//
//        if (validInput) {
//            JOptionPane.showMessageDialog(this, "Inputs saved successfully!");
//        } else {
//            JOptionPane.showMessageDialog(this, "Invalid integer format!",
//                    "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                PyreneProjection inputGUI = new PyreneProjection();
//                inputGUI.setVisible(true);
//            }
//        });
//    }

//Pyramidal
class Pyramidal extends JFrame {
    private JTextField stringField;
    private JTextField stringField2;
    private JTextField[] intFields;
    private JButton saveButton;
    private String savedString;
    private int[] savedIntegers;
    private double fin;

    public Pyramidal() {
        // Set up the JFrame
        setTitle("Input");
        setSize(500, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the string input fields
        stringField = new JTextField();
        stringField.setPreferredSize(new Dimension(300, 30));
        stringField2 = new JTextField();
        stringField2.setPreferredSize(new Dimension(300, 30));


        // Create the integer input fields
        intFields = new JTextField[4];
        for (int i = 0; i < intFields.length; i++) {
            intFields[i] = new JTextField();
            intFields[i].setPreferredSize(new Dimension(100, 30));
        }

        // Create the save button
        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveInputs();
                try{
                    fin = pyr.p(savedString, savedIntegers[0], savedIntegers[1], savedIntegers[2], savedIntegers[3]);
                    JFrame frame = new JFrame("Output");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(400, 300);
                    //String stringFin = "" + fin;
                    JLabel label = new JLabel(("Distance: " +fin));
                    frame.getContentPane().add(label);
                    frame.setVisible(true);

                }catch (Exception IOException){
                    System.out.println("Cry abt it (IOException)");
                }
            }
        });

        // Add components to the JFrame
        Container container = getContentPane();
        container.setLayout(new GridLayout(6, 2));
        container.add(new JLabel("Enter the filename:"));
        container.add(stringField);
        container.add(new JLabel("Please enter the first atom number: "));
        container.add(intFields[0]);
        container.add(new JLabel("Please enter the second atom number: "));
        container.add(intFields[1]);
        container.add(new JLabel("Please enter the third atom number: "));
        container.add(intFields[2]);
        container.add(new JLabel("Please enter the comparing atom number: "));
        container.add(intFields[3]);
        container.add(new JLabel());
        container.add(saveButton);
    }

    private void saveInputs() {
        savedString = stringField.getText();
        savedIntegers = new int[intFields.length];
        boolean validInput = true;

        for (int i = 0; i < intFields.length; i++) {
            String input = intFields[i].getText();
            try {
                savedIntegers[i] = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                validInput = false;
                break;
            }
        }

        if (validInput) {
            JOptionPane.showMessageDialog(this, "Inputs saved successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid integer format!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PyreneProjection inputGUI = new PyreneProjection();
                inputGUI.setVisible(true);
            }
        });
    }
}