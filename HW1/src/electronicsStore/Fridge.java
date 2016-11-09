package electronicsStore;


public class Fridge extends Goods {

    private int numberCompartment;

    Fridge(String name, double price, double weight, Color color, int numberCompartment) {
        super(name, price, weight, color);
        this.numberCompartment = numberCompartment;
    }

}
