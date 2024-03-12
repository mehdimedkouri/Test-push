package presentation;

import dao.Product;
import services.IProductService;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        Scanner scanner = new Scanner(new File("src/main/config.txt"));
        String sercvice1 = scanner.nextLine();
        Class cservice1 = Class.forName(sercvice1);
        IProductService gp = (IProductService) cservice1.newInstance();  // celle ci est une instantiation Dynamique . la static s'ecrit comme sa : new IProductserviceImpl();

        String sercvice2 = scanner.nextLine();
        Class cservice2 = Class.forName(sercvice2);
        IProductService gp2 = (IProductService) cservice2.newInstance();


        Product p1 = new Product("A123","Ecran",1400,3);
        Product p2 = new Product("B123","Clavier",200,20);
        Product p3 = new Product("C123","Mouse",140,50);

        gp.addProduct(p1);
        gp.addProduct(p2);
        gp.addProduct(p3);

        gp.listAll().forEach(System.out::println);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

        Method updateProduct = cservice1.getDeclaredMethod("updateProduct",new Class[] {String.class, Product.class});
        updateProduct.invoke(gp, new Object[] {"C123",p1}); //Injection de dépendances Dynamique

        Method afficher = cservice2. getDeclaredMethod("afficher", null);
        afficher.invoke(gp2);

        gp.listAll().forEach(System.out::println);
    }
}
