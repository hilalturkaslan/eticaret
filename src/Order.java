public class Order {
    private Product product;
    private Customer customer;
    private int quantity;

    public Order(Product product, Customer customer, int quantity) {
        this.product = product;
        this.customer = customer;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getQuantity() {
        return quantity;
    }

    public double calculateTotal() {
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return "Sipariş: " + product.getName() + " - Müşteri: " + customer.getName() + " - Adet: " + quantity;
    }
}
