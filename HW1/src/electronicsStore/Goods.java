package electronicsStore;


public class Goods {

    private String name;

    private double price;

    private double weight;

    private Color color;

    public Goods(String name, double price, double weight, Color color) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toLowerCase().trim();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    static public enum Color {

        RED(), BLUE(), GREEN(), BLACK(), WHITE();

        private int amount;

        Color() { this.amount = 0; }

        public void increment() { amount++; }

        public int getAmount() { return amount; }

    }

    @Override
    public String toString() {
        return name;
    }
}
