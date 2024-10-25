public class Product {
    private String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void decreaseStock(int quantity) throws InsufficientStockException {
        if (stock < quantity) {
            throw new InsufficientStockException("Yetersiz stok: " + name);
        }
        stock -= quantity;
    }

    @Override
    public String toString() {
        return name + " - Fiyat: " + price + " - Stok: " + stock;
    }
}

