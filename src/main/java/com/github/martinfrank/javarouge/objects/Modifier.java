package com.github.martinfrank.javarouge.objects;

public class Modifier {

    private final String operator;
    private final double amount;

    public Modifier(String operator, double amount) {
        this.operator = operator;
        this.amount = amount;
    }

    public String getOperator() {
        return operator;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Modifier{" +
                "operator='" + operator + '\'' +
                ", amount=" + amount +
                '}';
    }
}
