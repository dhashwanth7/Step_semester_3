package string.assigment_problems;

public class Cart {

    private final String cartId;
    private final double[] prices;
    private int itemCount;

    public Cart(String cartId, int maxItems) {
        if (cartId == null || cartId.trim().isEmpty()) {
            throw new IllegalArgumentException("Cart ID cannot be empty.");
        }

        if (maxItems <= 0) {
            throw new IllegalArgumentException(
                "Maximum items must be positive."
            );
        }

        this.cartId = cartId;
        this.prices = new double[maxItems];
        this.itemCount = 0;
    }

    public void addItem(double price) {
        if (price < 0) {
            System.out.println("Price cannot be negative.");
            return;
        }

        if (itemCount < prices.length) {
            prices[itemCount] = price;
            itemCount++;
        } else {
            System.out.println("Cart is full.");
        }
    }

    public double getTotal() {
        double total = 0;

        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }

        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getCartId() {
        return cartId;
    }
}