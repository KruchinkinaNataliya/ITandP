package lab2.ex;

public class Dishwasher extends Appliances {
    private int waterConsumption;
    private int capacityOfSet;
    private int numberOfWashingPrograms;

    public int getWaterConsumption() {
        return waterConsumption;
    }

    public void setWaterConsumption(int waterConsumption) {
        this.waterConsumption = waterConsumption;
    }

    public int getCapacityOfSet() {
        return capacityOfSet;
    }

    public void setCapacityOfSet(int capacityOfSet) {
        this.capacityOfSet = capacityOfSet;
    }

    public int getNumberOfWashingPrograms() {
        return numberOfWashingPrograms;
    }

    public void setNumberOfWashingPrograms(int numberOfWashingPrograms) {
        this.numberOfWashingPrograms = numberOfWashingPrograms;
    }

    public Dishwasher() {
        super();
        waterConsumption = 10;
        capacityOfSet = 14;
        numberOfWashingPrograms = 6;
    }

    public Dishwasher(int waterConsumption, int capacityOfSet, int numberOfWashingPrograms) {
        super();
        this.waterConsumption = waterConsumption;
        this.capacityOfSet = capacityOfSet;
        this.numberOfWashingPrograms = numberOfWashingPrograms;
    }

    public Dishwasher(String color, String country, int weight, int waterConsumption, int capacityOfSet, int numberOfWashingPrograms) {
        super(color, country, weight);
        this.waterConsumption = waterConsumption;
        this.capacityOfSet = capacityOfSet;
        this.numberOfWashingPrograms = numberOfWashingPrograms;
    }

    public Dishwasher(String color, String country, int weight, String size, double period, String power, int waterConsumption, int capacityOfSet, int numberOfWashingPrograms) {
        super(color, country, weight, size, period, power);
        this.waterConsumption = waterConsumption;
        this.capacityOfSet = capacityOfSet;
        this.numberOfWashingPrograms = numberOfWashingPrograms;
    }

    @Override
    public void printInfo() {
        System.out.println("Экземпляр класса ");
        System.out.println("Dishwasher{" + '\n' +
                "waterConsumption=" + waterConsumption + '\n' +
                ", capacityOfSet=" + capacityOfSet + '\n' +
                ", numberOfWashingPrograms=" + numberOfWashingPrograms + '\n' +
                ", color=" + super.getColor() + '\n' +
                ", country=" + super.getCountry() + '\n' +
                ", weight=" + super.getWeight() + '\n' +
                ", size=" + super.getSize() + '\n' +
                ", power=" + super.getPowerConsumption() + '\n' +
                ", warranty period=" + super.getWarrantyPeriod() + '\n' +
                '}');
        System.out.println();
    }

}
