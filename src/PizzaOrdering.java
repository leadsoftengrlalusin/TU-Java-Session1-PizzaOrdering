import java.util.ArrayList;
import java.util.Scanner;

public class PizzaOrdering {

    private static void initialMessage() {
        System.out.println("Pizza Ordering System:");
        System.out.println("1. Add Order");
        System.out.println("2. Update Order");
        System.out.println("3. Remove Order");
        System.out.println("4. View Orders");
        System.out.println("5. Exit");
    }

    public static void main(String[] args) {
        ArrayList<String> pizzas = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        initialMessage();

        while (running) {
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Pizza type: ");
                    String pizzaType = scanner.nextLine();
                    System.out.print("Quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.println();
                    addOrder(pizzas, quantities, pizzaType, quantity);
                    break;
                case 2:
                    System.out.print("Order number to update: ");
                    int updateIndex = scanner.nextInt();
                    updateIndex--;
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    updateOrder(quantities, updateIndex, newQuantity);
                    break;
                case 3:
                    System.out.print("Order number to remove: ");
                    int removeIndex = scanner.nextInt();
                    removeIndex--;
                    removeOrder(pizzas, quantities, removeIndex);
                    break;
                case 4:
                    printOrders(pizzas, quantities);
                    break;
                case 5:
                    running = false;
                    System.out.println("---Thank you!---");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    public static void addOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, String pizzaType, int quantity) {
        if (quantity > 0) {
            pizzas.add(pizzaType);
            quantities.add(quantity);
        } else {
            System.out.println("Quantity must be positive");
        }
    }

    public static void updateOrder(ArrayList<Integer> quantities, int index, int newQuantity) {
        if (index >= 0 && index < quantities.size()) {
            if (newQuantity > 0) {
                quantities.set(index, newQuantity);
            } else {
                System.out.println("Quantity must be positive");
            }
        }
        System.out.println();
    }

    public static void removeOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, int index) {
        if (index >= 0 && index < pizzas.size() && index < quantities.size()) {
            pizzas.remove(index);
            quantities.remove(index);
        } else {
            System.out.println("Invalid index");
        }
        System.out.println();
    }

    public static void printOrders(ArrayList<String> pizzas, ArrayList<Integer> quantities) {
        if (pizzas.isEmpty() || quantities.isEmpty()) {
            System.out.println("\n---No Current Orders ---");
        } else {
            System.out.println("\n--- Current Orders ---");
            for (int i = 0; i < pizzas.size(); i++) {
                System.out.println((i + 1) + ". " + pizzas.get(i) + " x " + quantities.get(i));
            }
        }
        System.out.println();
    }
}
