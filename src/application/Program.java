package application;

import entities.Client;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.ZoneId;

public class Program {
    public static void main (String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime momentFMT = LocalDateTime.now();
        String formattedMoment = momentFMT.format(fmt2);

        System.out.println("Enter cliente data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());
        Client client = new Client(name, email, birthDate);
        System.out.println("Enter order data:");
        OrderStatus os1 = OrderStatus.PROCESSING;
        System.out.println(os1);
        System.out.print("How many items to this order? ");
        int itemsQuantity = sc.nextInt();
        sc.nextLine();
        Product[] product = new Product[itemsQuantity];
        OrderItem[] orderItems = new OrderItem[itemsQuantity];
        for (int i = 0 ; i < product.length ; i++) {
            System.out.println("Enter #" + (i + 1) + " item data: ");
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int productQuantity = sc.nextInt();
            product[i] = new Product(productName, productPrice);
            orderItems[i] = new OrderItem(productQuantity, productPrice);
        }

        System.out.println("ORDER SUMMARY: ");
        System.out.println("Order moment: " + formattedMoment);
        System.out.println("Order status: " + OrderStatus.PROCESSING);
        System.out.println("Client: " + client.getName() + " " + "(" + client.getBirthDate() + ")" + " - " + client.getEmail());
        

        sc.close();
    }
}
