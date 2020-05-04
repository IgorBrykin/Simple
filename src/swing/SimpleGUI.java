package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGUI extends JFrame {
    private JButton button = new JButton("Press");
    private JTextField input = new JTextField("", 5);
    private JLabel label = new JLabel("Input:");
    private JCheckBox checkBox = new JCheckBox("Check", false);
    private JRadioButton radioButton1 = new JRadioButton("Select this");
    private JRadioButton radioButton2 = new JRadioButton("Select this two", true);


    public SimpleGUI() {
        super("Simple Example");
        setVisible(true);
        this.setBounds(150, 112, 200, 120);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));
        container.add(label);
        container.add(input);

        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        container.add(radioButton1);
        radioButton1.setSelected(true);
        container.add(radioButton2);
        container.add(checkBox);
        button.addActionListener(new ButtonEventListener());
        container.add(button);

    }

    class ButtonEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String massage = "";
            massage += "Button was pressed\n";
            massage += "Text is" + input.getText() + "\n";
            massage += (radioButton1.isSelected() ? "Radio #1" : "Radio #2") + " is selected!\n";
            massage += "Checkbox is " + ((checkBox.isSelected()) ? "checked " : "unchecked");
            JOptionPane.showMessageDialog(null, massage, "Output", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
