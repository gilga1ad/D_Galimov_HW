package electronicsStore;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    private List<Goods> goods;

    public Warehouse() {
        this.goods = new ArrayList<>();
    }

    public Warehouse(List<Goods> goods) {
        this();
        this.goods.addAll(goods);
    }

    /**
     * Добавить товар
     */
    public void addGoods(Goods g) {
        this.goods.add(g);
    }

    /**
     * Количество товаров
     */
    public int quantityOfGoods() {
        return goods.size();
    }

    /**
     * Список товар
     */
    public String stockList() {
        return goods.toString();
    }

    /**
     * Средний вес всех товаров
     */
    public double meanWeightOfGoods() {
        double quantity = goods.size();
        double totalWeight = 0.0;
        for (Goods g: goods) {
            totalWeight += g.getWeight();
        }
        return totalWeight / quantity;
    }

    /**
     * Статистика по цветам товаров
     */
    public void colorStatistics() {
        for (Goods g: goods) {
            g.getColor().increment();
        }
        for(Goods.Color color: Goods.Color.values()) {
            System.out.printf("[%s - %d]\n", color.toString(), color.getAmount());
        }
    }

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        warehouse.addGoods(new Kettle("Vitek VT7014", 1400, 0.8, Goods.Color.WHITE, 1.7));
        warehouse.addGoods(new TV("LG 32LH530V", 18690, 4.0, Goods.Color.BLACK, 32));
        warehouse.addGoods(new Fridge("Pozis RK-139", 19990, 70.5, Goods.Color.WHITE, 2));
        warehouse.addGoods(new TV("Samsung UE32J6500AU", 26340, 5.6, Goods.Color.BLACK, 31));
        warehouse.addGoods(new Kettle("Tefal KI 150D", 0.9, 20, Goods.Color.RED, 1.7));
        warehouse.addGoods(new Fridge("Liebherr CN 4015", 44990, 100, Goods.Color.WHITE, 2));


        System.out.println(warehouse.stockList());
        System.out.println(warehouse.quantityOfGoods());
        warehouse.colorStatistics();
    }

}