package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ProductsDB {
    private List<Product> products;

    public ProductsDB() {
        this.products = new ArrayList<>();
    }

    public boolean addProduct(Product product) {
        if(product == null) return false;
        return products.add(product);
    }

    public Product findProductById(int id) {
        for (Product product : products) {
            if(product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public List<Product> findProductByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if(product.getName().equals(name)) {
                result.add(product);
            }
        }
        return result;
    }

    public List<Product> findProductByCategory(String categoryName) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if(product.getCategory().getName().equals(categoryName)) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsDB data = (ProductsDB) o;
        return Objects.equals(products, data.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }

    @Override
    public String toString() {
        return "Товари{" +  products + '}';
    }
}
