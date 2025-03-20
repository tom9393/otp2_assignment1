import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ShoppingApp {
    public static double calculateItemCost(double cost, int number) {
        return cost * number;
    }

    public static void main(String[] args) {

        System.out.println("Select a language");
        System.out.println("1. Finnish");
        System.out.println("2. Swedish");
        System.out.println("3. English");
        System.out.println("4. Japanese");

        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();

        Locale locale;

        switch (choice) {
            case 1:
                locale = new Locale("fi", "FI");
                break;
            case 2:
                locale = new Locale("sv", "SE");
                break;
            case 3:
                locale = new Locale("en", "US");
                break;
            case 4:
                locale = new Locale("ja", "JP");
                break;
            default:
                System.out.println("Invalid choice, defaulting to English");
                locale = new Locale("en", "US");
        }

        ResourceBundle rb;

        try {
            rb = ResourceBundle.getBundle("messages", locale);
        } catch (MissingResourceException e) {
            System.out.println("Invalid language selection");
            System.out.println(e.getMessage());
            rb = ResourceBundle.getBundle("messages", locale);
        }


        // Ask how many items
        System.out.print(rb.getString("number"));
        int items = scanner.nextInt();
        Cart cart = new Cart(items);

        for (int i = 0; i < cart.getItems(); i++) {
            String q = MessageFormat.format(rb.getString("quantity"), String.format("%d", (i + 1)));
            System.out.println(q);
            int quantity = scanner.nextInt();
            String p = MessageFormat.format(rb.getString("price"), String.format("%d", (i + 1)));
            System.out.println(p);
            double price = scanner.nextDouble();
            cart.addItem(price, quantity);
        }

        // Display the total cost
        String totalMessage = MessageFormat.format(rb.getString("total"), String.format("%f", cart.getTotal()));
        System.out.println(totalMessage);

        scanner.close();
    }
}