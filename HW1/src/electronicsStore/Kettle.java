package electronicsStore;


public class Kettle extends Goods {

    private double maxCapacity;

    Kettle(String name, double price, double weight, Color color, double maxCapacity) {
        super(name, price, weight, color);
        this.maxCapacity = maxCapacity;
    }

}
