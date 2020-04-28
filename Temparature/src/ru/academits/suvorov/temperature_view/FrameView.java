package ru.academits.suvorov.temperature_view;

import ru.academits.suvorov.model.TemperatureConverter;
import ru.academits.suvorov.view.View;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class FrameView implements View {
    private final JTextField temperatureInput = new JTextField();
    private final JButton convertButton = new JButton();
    private final JTextField temperatureOutput = new JTextField();
    private final JComboBox<String> inputTemperatureList = new JComboBox<>();
    private final JComboBox<String> outputTemperatureList = new JComboBox<>();
    private final JLabel heading = new JLabel();
    private final JLabel inputText = new JLabel();
    private final JLabel outputText = new JLabel();
    private final JButton resetButton = new JButton();
    private final JLabel fromText = new JLabel();
    private final JLabel toText = new JLabel();

    public FrameView() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Temperature converter");

            frame.setVisible(true);
            frame.setSize(440, 200);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Image img = Toolkit.getDefaultToolkit().getImage("icon.png");
            frame.setIconImage(img);

            Container container = frame.getContentPane();
            container.setLayout(new GridBagLayout());

            GridBagConstraints constraints1 = new GridBagConstraints();
            constraints1.fill = GridBagConstraints.HORIZONTAL;
            constraints1.insets = new Insets(5, 0, 20, 0);
            constraints1.gridwidth = 5;
            constraints1.gridx = 0;
            constraints1.gridy = 0;
            heading.setHorizontalAlignment(JLabel.CENTER);
            heading.setText("Конвертер температур от Суворова");
            container.add(heading, constraints1);

            GridBagConstraints constraints2 = new GridBagConstraints();
            constraints2.fill = GridBagConstraints.HORIZONTAL;
            constraints2.insets = new Insets(5, 5, 5, 5);
            constraints2.gridwidth = 1;
            constraints2.gridx = 0;
            constraints2.gridy = 1;
            inputText.setText("Input");
            container.add(inputText, constraints2);

            GridBagConstraints constraints3 = new GridBagConstraints();
            constraints3.fill = GridBagConstraints.HORIZONTAL;
            constraints3.insets = new Insets(5, 5, 5, 5);
            constraints3.gridwidth = 1;
            constraints3.gridx = 1;
            constraints3.gridy = 1;
            constraints3.ipadx = 100;
            constraints3.ipady = 0;
            container.add(temperatureInput, constraints3);

            GridBagConstraints constraints4 = new GridBagConstraints();
            constraints4.fill = GridBagConstraints.HORIZONTAL;
            constraints4.insets = new Insets(5, 5, 5, 5);
            constraints4.gridwidth = 1;
            constraints4.gridx = 2;
            constraints4.gridy = 1;
            constraints4.ipadx = 0;
            constraints4.ipady = 0;
            convertButton.setText("Convert");
            container.add(convertButton, constraints4);

            GridBagConstraints constraints5 = new GridBagConstraints();
            constraints5.fill = GridBagConstraints.HORIZONTAL;
            constraints5.insets = new Insets(5, 5, 5, 5);
            constraints5.gridwidth = 1;
            constraints5.gridx = 3;
            constraints5.gridy = 1;
            outputText.setText("Output");
            container.add(outputText, constraints5);

            GridBagConstraints constraints6 = new GridBagConstraints();
            constraints6.fill = GridBagConstraints.HORIZONTAL;
            constraints6.insets = new Insets(5, 5, 5, 5);
            constraints6.gridwidth = 1;
            constraints6.gridx = 4;
            constraints6.gridy = 1;
            constraints6.ipadx = 100;
            constraints6.ipady = 0;
            temperatureOutput.setEditable(false);
            container.add(temperatureOutput, constraints6);

            GridBagConstraints constraints7 = new GridBagConstraints();
            constraints7.fill = GridBagConstraints.HORIZONTAL;
            constraints7.insets = new Insets(5, 5, 5, 5);
            constraints7.gridwidth = 1;
            constraints7.gridx = 1;
            constraints7.gridy = 2;
            constraints7.ipadx = 0;
            constraints7.ipady = 0;
            container.add(inputTemperatureList, constraints7);
            inputTemperatureList.addItem("Celsius");
            inputTemperatureList.addItem("Fahrenheit");
            inputTemperatureList.addItem("Kelvin");
            inputTemperatureList.setEditable(false);

            GridBagConstraints constraints8 = new GridBagConstraints();
            constraints8.fill = GridBagConstraints.HORIZONTAL;
            constraints8.insets = new Insets(5, 5, 5, 5);
            constraints8.gridwidth = 2;
            constraints8.gridx = 4;
            constraints8.gridy = 2;
            constraints8.ipadx = 0;
            constraints8.ipady = 0;
            container.add(outputTemperatureList, constraints8);
            outputTemperatureList.addItem("Kelvin");
            outputTemperatureList.addItem("Fahrenheit");
            outputTemperatureList.addItem("Celsius");
            outputTemperatureList.setEditable(false);

            GridBagConstraints constraints9 = new GridBagConstraints();
            constraints9.fill = GridBagConstraints.HORIZONTAL;
            constraints9.insets = new Insets(5, 5, 5, 5);
            constraints9.gridwidth = 1;
            constraints9.gridx = 2;
            constraints9.gridy = 2;
            constraints9.ipadx = 0;
            constraints9.ipady = 0;
            resetButton.setText("Reset");
            container.add(resetButton, constraints9);

            GridBagConstraints constraints10 = new GridBagConstraints();
            constraints10.fill = GridBagConstraints.HORIZONTAL;
            constraints10.insets = new Insets(5, 5, 5, 5);
            constraints10.gridwidth = 1;
            constraints10.gridx = 0;
            constraints10.gridy = 2;
            fromText.setText("From");
            container.add(fromText, constraints10);

            GridBagConstraints constraints11 = new GridBagConstraints();
            constraints11.fill = GridBagConstraints.HORIZONTAL;
            constraints11.insets = new Insets(5, 5, 5, 5);
            constraints11.gridwidth = 1;
            constraints11.gridx = 3;
            constraints11.gridy = 2;
            toText.setText("To");
            container.add(toText, constraints11);
        });
    }

    @Override
    public void startApplication() {
        initEvents();
    }

    private void initEvents() {
        final String[] input = new String[1];
        final String[] output = new String[1];

        inputTemperatureList.addActionListener(e -> input[0] = (String) inputTemperatureList.getSelectedItem());

        outputTemperatureList.addActionListener(e -> output[0] = (String) outputTemperatureList.getSelectedItem());

        resetButton.addActionListener(e -> {
            temperatureInput.setText("");
            temperatureOutput.setText("");
        });

        convertButton.addActionListener(e -> {
            try {
                if (temperatureInput.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Введите значение в поле input");
                    return;
                }
                if (temperatureInput.getText().length() > 14) {
                    JOptionPane.showMessageDialog(null, "Введено длинное значение в поле input");
                    return;
                }

                double temperature = Double.parseDouble(temperatureInput.getText());

                String temperatureOutputFormat = new DecimalFormat("#0.00").
                        format(TemperatureConverter.convertTemperature(temperature, input[0], output[0]));

                if (temperatureOutputFormat.length() > 11) {
                    JOptionPane.showMessageDialog(null, "Output: " + temperatureOutputFormat +
                            " " + outputTemperatureList.getSelectedItem(), "Result", JOptionPane.PLAIN_MESSAGE);
                    return;
                }

                temperatureOutput.setText(temperatureOutputFormat);
            } catch (NumberFormatException v) {
                JOptionPane.showMessageDialog(null, "Введеное значение не является числом!!!",
                        "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });
    }
}