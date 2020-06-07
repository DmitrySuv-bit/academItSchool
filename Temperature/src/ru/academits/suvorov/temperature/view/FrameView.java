package ru.academits.suvorov.temperature.view;

import ru.academits.suvorov.temperature.model.ConvertTemperature;
import ru.academits.suvorov.temperature.model.TemperatureScale;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class FrameView implements View {
    private final double TEXT_MAX_LENGTH = 14;
    private JTextField inputTemperature;
    private JButton convertButton;
    private JTextField outputTemperature;
    private JComboBox<TemperatureScale> inputTemperatureList;
    private JComboBox<TemperatureScale> outputTemperatureList;
    private JButton resetButton;
    private static TemperatureScale inputScale;
    private static TemperatureScale outputScale;
    private final TemperatureScale[] scalesArray;

    public FrameView(TemperatureScale[] converter) {
        this.scalesArray = converter;
    }

    @Override
    public void startApplication() {
        SwingUtilities.invokeLater(() -> {
            createFrame();
            addTemperatureScales(scalesArray);
            initEvents();
        });
    }

    private void initEvents() {
        inputTemperatureList.addActionListener(e -> inputScale =
                (TemperatureScale) inputTemperatureList.getSelectedItem());

        outputTemperatureList.addActionListener(e -> outputScale =
                (TemperatureScale) outputTemperatureList.getSelectedItem());

        resetButton.addActionListener(e -> {
            inputTemperature.setText("");
            outputTemperature.setText("");
        });

        convertButton.addActionListener(e -> {
            try {
                if (inputTemperature.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter a value in the input field");

                    return;
                }
                if (inputTemperature.getText().length() > TEXT_MAX_LENGTH) {
                    JOptionPane.showMessageDialog(null, "Entered a long value in the input field");

                    return;
                }

                double temperature = Double.parseDouble(inputTemperature.getText());

                String temperatureOutputFormat = new DecimalFormat("#0.00").
                        format(ConvertTemperature.convert(temperature, inputScale, outputScale));


                if (temperatureOutputFormat.length() > TEXT_MAX_LENGTH) {
                    outputTemperature.setText("");

                    JOptionPane.showMessageDialog(null, "Output: "
                                    + temperatureOutputFormat + " " + outputTemperatureList.getSelectedItem(),
                            "Result", JOptionPane.PLAIN_MESSAGE);

                    return;
                }

                outputTemperature.setText(temperatureOutputFormat);
            } catch (NumberFormatException v) {
                JOptionPane.showMessageDialog(null, "The value entered is not a number!!!",
                        "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    private void createFrame() {
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
        JLabel heading = new JLabel("Temperature converter from Suvorova", JLabel.CENTER);
        container.add(heading, constraints1);

        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.fill = GridBagConstraints.HORIZONTAL;
        constraints2.insets = new Insets(5, 5, 5, 5);
        constraints2.gridwidth = 1;
        constraints2.gridx = 0;
        constraints2.gridy = 1;
        JLabel inputText = new JLabel("Input");
        container.add(inputText, constraints2);

        GridBagConstraints constraints3 = new GridBagConstraints();
        constraints3.fill = GridBagConstraints.HORIZONTAL;
        constraints3.insets = new Insets(5, 5, 5, 5);
        constraints3.gridwidth = 1;
        constraints3.gridx = 1;
        constraints3.gridy = 1;
        constraints3.ipadx = 100;
        constraints3.ipady = 0;
        inputTemperature = new JTextField();
        container.add(inputTemperature, constraints3);

        GridBagConstraints constraints4 = new GridBagConstraints();
        constraints4.fill = GridBagConstraints.HORIZONTAL;
        constraints4.insets = new Insets(5, 5, 5, 5);
        constraints4.gridwidth = 1;
        constraints4.gridx = 2;
        constraints4.gridy = 2;
        convertButton = new JButton("Convert");
        container.add(convertButton, constraints4);

        GridBagConstraints constraints5 = new GridBagConstraints();
        constraints5.fill = GridBagConstraints.HORIZONTAL;
        constraints5.insets = new Insets(5, 5, 5, 5);
        constraints5.gridwidth = 1;
        constraints5.gridx = 3;
        constraints5.gridy = 1;
        JLabel outputText = new JLabel("Output");
        container.add(outputText, constraints5);

        GridBagConstraints constraints6 = new GridBagConstraints();
        constraints6.fill = GridBagConstraints.HORIZONTAL;
        constraints6.insets = new Insets(5, 5, 5, 5);
        constraints6.gridwidth = 1;
        constraints6.gridx = 4;
        constraints6.gridy = 1;
        constraints6.ipadx = 100;
        constraints6.ipady = 0;
        outputTemperature = new JTextField();
        outputTemperature.setEditable(false);
        container.add(outputTemperature, constraints6);

        GridBagConstraints constraints7 = new GridBagConstraints();
        constraints7.fill = GridBagConstraints.HORIZONTAL;
        constraints7.insets = new Insets(5, 5, 5, 5);
        constraints7.gridwidth = 1;
        constraints7.gridx = 1;
        constraints7.gridy = 2;
        inputTemperatureList = new JComboBox<>();
        container.add(inputTemperatureList, constraints7);
        inputTemperatureList.setEditable(false);

        GridBagConstraints constraints8 = new GridBagConstraints();
        constraints8.fill = GridBagConstraints.HORIZONTAL;
        constraints8.insets = new Insets(5, 5, 5, 5);
        constraints8.gridwidth = 2;
        constraints8.gridx = 4;
        constraints8.gridy = 2;
        outputTemperatureList = new JComboBox<>();
        container.add(outputTemperatureList, constraints8);
        outputTemperatureList.setEditable(false);

        GridBagConstraints constraints9 = new GridBagConstraints();
        constraints9.fill = GridBagConstraints.HORIZONTAL;
        constraints9.insets = new Insets(5, 5, 5, 5);
        constraints9.gridwidth = 1;
        constraints9.gridx = 2;
        constraints9.gridy = 1;
        resetButton = new JButton("Reset");
        container.add(resetButton, constraints9);

        GridBagConstraints constraints10 = new GridBagConstraints();
        constraints10.fill = GridBagConstraints.HORIZONTAL;
        constraints10.insets = new Insets(5, 5, 5, 5);
        constraints10.gridwidth = 1;
        constraints10.gridx = 0;
        constraints10.gridy = 2;
        JLabel fromText = new JLabel("From");
        container.add(fromText, constraints10);

        GridBagConstraints constraints11 = new GridBagConstraints();
        constraints11.fill = GridBagConstraints.HORIZONTAL;
        constraints11.insets = new Insets(5, 5, 5, 5);
        constraints11.gridwidth = 1;
        constraints11.gridx = 3;
        constraints11.gridy = 2;
        JLabel toText = new JLabel("To");
        container.add(toText, constraints11);
    }

    private void addTemperatureScales(TemperatureScale[] scalesArray) {
        for (TemperatureScale t : scalesArray) {
            inputTemperatureList.addItem(t);
            outputTemperatureList.addItem(t);
        }

        inputScale = (TemperatureScale) inputTemperatureList.getSelectedItem();
        outputScale = (TemperatureScale) outputTemperatureList.getSelectedItem();
    }
}