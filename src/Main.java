public class Main {
    public static void main(String[] args) {
        ECommerceSystem ecommerceSystem = new ECommerceSystem();


        ecommerceSystem.loadProducts("products.txt");
        ecommerceSystem.loadCustomers("customers.txt");


        String productName = "Laptop";
        String customerName = "hilal trks";
        int quantity = 1;

        Product product = ecommerceSystem.findProductByName(productName);
        Customer customer = ecommerceSystem.findCustomerByName(customerName);

        if (product != null && customer != null) {
            Order order = new Order(product, customer, quantity);
            try {
                ecommerceSystem.processOrder(order);
            } catch (InsufficientStockException e) {
                System.err.println("Yetersiz stok: " + e.getMessage());
            }
        } else {
            System.err.println("Ürün veya müşteri bulunamadı.");
        }
    }
}

