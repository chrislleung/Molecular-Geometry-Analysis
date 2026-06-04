import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TextEditorGUI extends JFrame {
    private JTextArea textArea;
    private JButton saveButton;

    public TextEditorGUI() {
        // Set up the JFrame
        setTitle("Text Editor");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the text area
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Create the save button
        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToFile();
            }
        });

        // Add components to the JFrame
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(scrollPane, BorderLayout.CENTER);
        container.add(saveButton, BorderLayout.SOUTH);
    }

    private void saveToFile() {
        JFileChooser fileChooser = new JFileChooser();
        int choice = fileChooser.showSaveDialog(this);
        if (choice == JFileChooser.APPROVE_OPTION) {
            try {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
                writer.write(textArea.getText());
                writer.close();
                JOptionPane.showMessageDialog(this, "File saved successfully!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error saving the file: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TextEditorGUI editor = new TextEditorGUI();
                editor.setVisible(true);
            }
        });
    }
}
