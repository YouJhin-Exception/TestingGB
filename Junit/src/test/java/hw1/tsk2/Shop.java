package hw1.tsk2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Shop {
    private List<Product> products;

    public Shop() {
        this.products = new ArrayList<>();
    }

    public Shop(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void sortProductsByPrice() {
        products.sort(Comparator.comparingDouble(Product::getCost));

    }

    public Product getMostExpensiveProduct() {
        if (products.isEmpty()) return null;
        return Collections.max(products, Comparator.comparingDouble(Product::getCost));
    }

    @Override
    public String toString() {
        return "Shop{" +
                "products=" + products +
                '}';
    }
}
