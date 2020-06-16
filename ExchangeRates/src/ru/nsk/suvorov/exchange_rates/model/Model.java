package ru.nsk.suvorov.exchange_rates.model;

import java.util.Map;

public class Model {
    private final Map<String, Double> rates;

    public Model(Map<String, Double> rates) {
        this.rates = rates;
    }

    public Map<String, Double> getRates() {
        return rates;
    }
}
