package electronicsStore;


public class TV extends Goods {

    public double diagonal;

    TV(String name, double price, double weight, Color color, double diagonal) {
        super(name, price, weight, color);
        this.diagonal = diagonal;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }
}
