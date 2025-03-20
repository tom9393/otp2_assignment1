public class Cart {

    private int items;
    private double total;

    public Cart(int items) {
        this.items = items;
        total = 0;
    }

    public void addItem(double cost, int quantity) {
        total += cost * quantity;
    }

    public double getTotal() {
        return total;
    }

    public int getItems() {
        return items;
    }
}
