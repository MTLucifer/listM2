package produc_list;

import produc_list.model.Product;
import produc_list.manage.ProductManage;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void display(List<Product> customers) {
        Iterator<Product> iterator = customers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {

        ProductManage productManage = new ProductManage();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Find All: ");
        List<Product> products;
        products = productManage.findAll();
        display(products);

        System.out.println("Add Product: ");
        Product addNew = new Product("Chip", 9, 3000000);
        productManage.add(addNew);
        products = productManage.findAll();
        display(products);

//        System.out.println("Delete Product: ");
//        System.out.println("Input id: ");
//        int id = scanner.nextInt();
//        productManage.delete(id);
//        products = productManage.findAll();
//        display(products);

//        System.out.println("Change Information: ");
//        System.out.println("Input id: ");
//        int id = scanner.nextInt();
//        if (productManage.isIdExist(id)) {
//            System.out.println("Input new name:");
//            String newName = scanner.next();
//            System.out.println("Input new price: ");
//            long newPrice = scanner.nextLong();
//            Product changeNew = new Product(newName, id, newPrice);
//            productManage.update(id,changeNew);
//        }else {
//            System.out.println("Id not exist.");
//        }
//        products = productManage.findAll();
//        display(products);

        System.out.println("Find by name: ");
        System.out.println("Input name:");
        String newName = scanner.next();
        if (productManage.isNameExits(newName)) {
            display(productManage.findByName(newName));
        } else {
            System.out.println("Name not exits");
        }
    }
}
