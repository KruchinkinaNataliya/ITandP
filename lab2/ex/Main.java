package lab2.ex;

public class Main {
    public static void main(String[] args) {
        //Создание экземпляров классов по-умолчанию
        Fridge fridge = new Fridge();
        Dishwasher dishwasher = new Dishwasher();
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        Appliances appliances = new Appliances();

        //Создание экземпляра классов не по-умолчанию
        Fridge newFridge = new Fridge(300,false,1);
        Appliances newAppliances = new Appliances("Pink","USA",25);
        VacuumCleaner newVacuum = new VacuumCleaner("Blue","Russia",10,2.5,3000,"Standart");
        Dishwasher newWasher = new Dishwasher("Metalic","Germany",20,"25x10x30",2.5,"A++",20,11,3);

        //Работа get-методов
        System.out.println(fridge.getCountry());
        System.out.println(dishwasher.getColor());
        System.out.println(appliances.getWeight());
        System.out.println(vacuumCleaner.getPowerConsumption());
        System.out.println();

        //Работа set-методов
        fridge.setCountry("Russia");
        dishwasher.setColor("Blue");
        vacuumCleaner.setPowerConsumption("A");
        appliances.setWeight(26);

        //Работа метода printInfo()
        fridge.printInfo();
        dishwasher.printInfo();
        vacuumCleaner.printInfo();
        appliances.printInfo();

        //Вывод работы счетчика
        System.out.println(appliances.getCountObject());
    }
}
