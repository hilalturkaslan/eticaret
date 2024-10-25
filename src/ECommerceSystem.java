import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ECommerceSystem {
    private List<Product> products;
    private List<Customer> customers;

    public ECommerceSystem() {
        products = new ArrayList<>();
        customers = new ArrayList<>();
    }


    public void addProduct(Product product) {
        products.add(product);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }


    public void loadProducts(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length < 3) {
                    System.err.println("Geçersiz ürün formatı: " + line);
                    continue;
                }
                String name = data[0];
                double price = Double.parseDouble(data[1]);
                int stock = Integer.parseInt(data[2]);
                addProduct(new Product(name, price, stock));
            }
        } catch (IOException e) {
            System.err.println("Ürün dosyası okunamadı: " + filename);
        }
    }



    public void loadCustomers(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length < 2) {
                    System.err.println("Geçersiz müşteri formatı: " + line);
                    continue;
                }
                String name = data[0];
                String email = data[1];
                addCustomer(new Customer(name, email));
            }
        } catch (IOException e) {
            System.err.println("Müşteri dosyası okunamadı: " + filename);
        }
    }




    public Product findProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }


    public Customer findCustomerByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }


    public void processOrder(Order order) throws InsufficientStockException {
        if (order.getProduct() == null || order.getCustomer() == null) {
            throw new NullPointerException("Ürün veya müşteri nesnesi null olamaz.");
        }
        order.getProduct().decreaseStock(order.getQuantity());
        System.out.println("Sipariş işleme alındı: " + order);
    }
}



