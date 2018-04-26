package com.brevitaz.model;


public class SalaryIncomeComponent {

    private String id;
    private String displayName;
    private String name;
    private Type type;
    private double value;
    private double amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "SalaryIncomeComponent{" +
                "id='" + id + '\'' +
                ", displayName='" + displayName + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", value=" + value +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalaryIncomeComponent that = (SalaryIncomeComponent) o;

        if (Double.compare(that.value, value) != 0) return false;
        if (!id.equals(that.id)) return false;
        if (!displayName.equals(that.displayName)) return false;
        if (!name.equals(that.name)) return false;
        return type == that.type;
    }

}
