package lab2.ex;

public class Fridge extends Appliances {
    private int volume;
    private boolean isFreezerExist;
    private int countDoor;

    public Fridge() {
        super();
        volume = 200;
        isFreezerExist = true;
        countDoor = 2;
    }

    public Fridge(int volume, boolean isFreezerExist, int countDoor) {
        super();
        this.volume = volume;
        this.isFreezerExist = isFreezerExist;
        this.countDoor = countDoor;
    }

    public Fridge(String color, String country, int weight, int volume, boolean isFreezerExist, int countDoor) {
        super(color, country, weight);
        this.volume = volume;
        this.isFreezerExist = isFreezerExist;
        this.countDoor = countDoor;
    }

    public Fridge(String color, String country, int weight, String size, double period, String power, int volume, boolean isFreezerExist, int countDoor) {
        super(color, country, weight, size, period, power);
        this.volume = volume;
        this.isFreezerExist = isFreezerExist;
        this.countDoor = countDoor;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isFreezerExist() {
        return isFreezerExist;
    }

    public void setFreezerExist(boolean freezerExist) {
        isFreezerExist = freezerExist;
    }

    public int getCountDoor() {
        return countDoor;
    }

    public void setCountDoor(int countDoor) {
        this.countDoor = countDoor;
    }

    @Override
    public void printInfo() {
        System.out.println("Экземпляр класса ");
        System.out.println("Fridge{" + '\n' +
                "volume=" + volume + '\n' +
                ", isFreezerExist=" + isFreezerExist + '\n' +
                ", countDoor=" + countDoor + '\n' +
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
