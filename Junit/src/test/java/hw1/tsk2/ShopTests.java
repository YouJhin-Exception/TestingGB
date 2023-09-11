package hw1.tsk2;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopTests {
    @Test
    void testSortProductsByPrice() {
        Shop shop = new Shop();
        shop.addProduct(new Product(2.2, "Apple"));
        shop.addProduct(new Product(5.2, "Orange"));
        shop.addProduct(new Product(4.2, "Kiwi"));
        shop.addProduct(new Product(7.2, "Grape"));

        shop.sortProductsByPrice();

        Assertions.assertThat(shop.getProducts()).extracting(Product::getCost).containsExactly(2.2, 4.2, 5.2, 7.2);
    }

    @Test
    void testGetMostExpensiveProduct() {
        Shop shop = new Shop();
        shop.addProduct(new Product(2.2, "Apple"));
        shop.addProduct(new Product(5.2, "Orange"));
        shop.addProduct(new Product(4.2, "Kiwi"));
        shop.addProduct(new Product(7.2, "Grape"));

        Product mostExpensive = shop.getMostExpensiveProduct();

        Assertions.assertThat(mostExpensive).isNotNull().extracting(Product::getTitle).isEqualTo("Grape");

        Assertions.assertThat(mostExpensive).isNotNull().extracting(Product::getCost).isEqualTo(7.2);
    }
}
