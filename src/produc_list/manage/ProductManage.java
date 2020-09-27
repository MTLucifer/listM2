package produc_list.manage;

import produc_list.manage.IProduct;
import produc_list.model.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductManage implements IProduct<Product> {
    static List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product("Ram", 1, 400000));
        products.add(new Product("Mouse", 2, 200000));
        products.add(new Product("Keyboard", 3, 250000));
        products.add(new Product("Monitor", 4, 3000000));
        products.add(new Product("Case", 5, 500000));
    }


    @Override
    public void add(Product object) {
        boolean flag = true;
        for (int i = 0; i < products.size(); i++) {
            if (object.getId() == products.get(i).getId()) {
                flag = true;
                break;
            }
        }
        if (flag) {
            products.add(object);
        }
    }

    @Override
    public void update(Integer id, Product newObject) {
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                products.set(i, newObject);
            }
        }
    }

    @Override
    public void delete(Integer id) {
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                products.remove(products.get(i));
            }
        }
    }

    public boolean isNameExits(String name) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(name)) {
                return true;
            }
        }return false;
    }

    @Override
    public Product findById(Integer id) {
        Product result = new Product();
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                result = products.get(i);
            }
        }
        return result;
    }

    public boolean isIdExist(Integer id) {
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(name)) {
                productList.add(products.get(i));
            }
        }
        return productList;
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext())
            productList.add(iterator.next());
        return productList;
    }
}
