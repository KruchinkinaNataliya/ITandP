package lab2.ex;

public abstract class Technic {
    private String size;
    private double warrantyPeriod;
    private String powerConsumption;

    public Technic() {
        size = "10x10x10";
        warrantyPeriod = 1.5;
        powerConsumption = "A+";
    }

    public Technic(String size, double warrantyPeriod, String powerConsumption) {
        this.size = size;
        this.warrantyPeriod = warrantyPeriod;
        this.powerConsumption = powerConsumption;
    }

    public String getSize() {
        return this.size;
    }

    public double getWarrantyPeriod() {
        return this.warrantyPeriod;
    }

    public String getPowerConsumption() {
        return this.powerConsumption;
    }

    public void setSize(String s) {
        this.size = s;
    }

    public void setWarrantyPeriod(double period) {
        this.warrantyPeriod = period;
    }

    public void setPowerConsumption(String power) {
        this.powerConsumption = power;
    }

    public abstract void printInfo();

}
