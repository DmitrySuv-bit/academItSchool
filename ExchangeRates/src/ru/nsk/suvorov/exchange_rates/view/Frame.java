package ru.nsk.suvorov.exchange_rates.view;

import ru.nsk.suvorov.exchange_rates.model.MyFile;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class Frame implements View {
    private JComboBox<String> currency;
    private JTextField rate;
    private final Map<String, Double> exchangeRatesMap;

    // gson / jackson json / json-simple

    public Frame(MyFile file) {
        exchangeRatesMap = file.getMap();
    }

    @Override
    public void startApplication() {
        SwingUtilities.invokeLater(() -> {
            createFrame();
            addCurrency();
            initEvents();
        });
    }

    private void initEvents() {
        currency.addActionListener(e -> {
            for (Map.Entry<String, Double> entry : exchangeRatesMap.entrySet()) {
                if (currency.getSelectedItem() == entry.getKey()) {
                    rate.setText(String.valueOf(entry.getValue()));
                }
            }
        });
    }

    private void addCurrency() {
        for (String key : exchangeRatesMap.keySet()) {
            currency.addItem(key);
        }

        currency.setSelectedIndex(-1);
    }

    public void createFrame() {
        JFrame frame = new JFrame("Exchange Rates");

        frame.setVisible(true);
        frame.setSize(300, 150);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = frame.getContentPane();
        container.setLayout(new GridBagLayout());

        GridBagConstraints constraints1 = new GridBagConstraints();
        constraints1.fill = GridBagConstraints.HORIZONTAL;
        constraints1.insets = new Insets(5, 5, 5, 5);
        constraints1.gridwidth = 1;
        constraints1.gridx = 0;
        constraints1.gridy = 0;
        constraints1.ipadx = 50;
        JLabel currencyHeading = new JLabel("Currency", JLabel.CENTER);
        container.add(currencyHeading, constraints1);

        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.fill = GridBagConstraints.HORIZONTAL;
        constraints2.insets = new Insets(5, 5, 5, 5);
        constraints2.gridwidth = 1;
        constraints2.gridx = 0;
        constraints2.gridy = 1;
        currency = new JComboBox<>();
        container.add(currency, constraints2);
        currency.setEditable(false);

        GridBagConstraints constraints3 = new GridBagConstraints();
        constraints3.fill = GridBagConstraints.HORIZONTAL;
        constraints3.insets = new Insets(5, 5, 5, 5);
        constraints3.gridwidth = 1;
        constraints3.gridx = 1;
        constraints3.gridy = 0;
        constraints3.ipadx = 50;
        JLabel rateHeading = new JLabel("Rate", JLabel.CENTER);
        container.add(rateHeading, constraints3);

        GridBagConstraints constraints4 = new GridBagConstraints();
        constraints4.fill = GridBagConstraints.HORIZONTAL;
        constraints4.insets = new Insets(5, 5, 5, 5);
        constraints4.gridwidth = 1;
        constraints4.gridx = 1;
        constraints4.gridy = 1;
        rate = new JTextField();
        rate.setEditable(false);
        container.add(rate, constraints4);
    }
}