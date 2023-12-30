package lab2.ex;

public class VacuumCleaner extends Appliances {
    private double volumeOfTheDustCollector;
    private int suctionPower;
    private String typeOfFilter;

    public VacuumCleaner() {
        super();
        volumeOfTheDustCollector = 0.75;
        suctionPower = 400;
        typeOfFilter = "Microfilter";
    }

    public VacuumCleaner(String color, String country, int weight, double volumeOfTheDustCollector, int suctionPower, String typeOfFilter) {
        super(color, country, weight);
        this.volumeOfTheDustCollector = volumeOfTheDustCollector;
        this.suctionPower = suctionPower;
        this.typeOfFilter = typeOfFilter;
    }

    public VacuumCleaner(String color, String country, int weight, String size, double period, String power, double volumeOfTheDustCollector, int suctionPower, String typeOfFilter) {
        super(color, country, weight, size, period, power);
        this.volumeOfTheDustCollector = volumeOfTheDustCollector;
        this.suctionPower = suctionPower;
        this.typeOfFilter = typeOfFilter;
    }

    public VacuumCleaner(double volumeOfTheDustCollector, int suctionPower, String typeOfFilter) {
        super();
        this.volumeOfTheDustCollector = volumeOfTheDustCollector;
        this.suctionPower = suctionPower;
        this.typeOfFilter = typeOfFilter;
    }

    public double getVolumeOfTheDustCollector() {
        return volumeOfTheDustCollector;
    }

    public void setVolumeOfTheDustCollector(double volumeOfTheDustCollector) {
        this.volumeOfTheDustCollector = volumeOfTheDustCollector;
    }

    public int getSuctionPower() {
        return suctionPower;
    }

    public void setSuctionPower(int suctionPower) {
        this.suctionPower = suctionPower;
    }

    public String getTypeOfFilter() {
        return typeOfFilter;
    }

    public void setTypeOfFilter(String typeOfFilter) {
        this.typeOfFilter = typeOfFilter;
    }

    @Override
    public void printInfo() {
        System.out.println("Экземпляр класса ");
        System.out.println("VacuumCleaner{" + '\n' +
                "volumeOfTheDustCollector=" + volumeOfTheDustCollector + '\n' +
                ", suctionPower=" + suctionPower + '\n' +
                ", typeOfFilter=" + typeOfFilter + '\n' +
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
