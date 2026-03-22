import java.util.*;

// Abstract Class
abstract class LibraryItem {
    private final String itemId;
    private String title;
    protected boolean isReserved;

    LibraryItem(String itemId, String title) {
        this.itemId = itemId;
        this.title = title;
        this.isReserved = false;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public void showDetails() {
        System.out.println("ID: " + itemId + " | Title: " + title + " | Reserved: " + isReserved);
    }

    abstract void processLoan();
}

// TextBook Class
class TextBook extends LibraryItem {

    TextBook(String itemId, String title) {
        super(itemId, title);
    }

    @Override
    void processLoan() {
        if (isReserved) {
            System.out.println("Error: '" + getTitle() + "' is already on loan.");
        } else {
            isReserved = true;
            System.out.println("Textbook '" + getTitle() + "' issued for 14 days.");
        }
    }
}

// ResearchPaper Class
class ResearchPaper extends LibraryItem {

    ResearchPaper(String itemId, String title) {
        super(itemId, title);
    }

    @Override
    void processLoan() {
        System.out.println("Generating secure PDF download link...");
    }
}

// Main Class
public class DigitalLibrary {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<LibraryItem> items = new ArrayList<>();

    public static void main(String[] args) {

        // Preloaded data
        items.add(new TextBook("B101", "Java Core"));
        items.add(new TextBook("B102", "Data Structures"));
        items.add(new ResearchPaper("R201", "AI Ethics"));

        int choice;

        do {
            System.out.println("\n===== DIGITAL LIBRARY MENU =====");
            System.out.println("1. Show All Items");
            System.out.println("2. Borrow Item");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    showAllItems();
                    break;

                case 2:
                    borrowItem();
                    break;

                case 3:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);
    }

    // Show all items
    static void showAllItems() {
        System.out.println("\n--- Library Items ---");
        for (LibraryItem item : items) {
            item.showDetails();
        }
    }

    // Borrow item
    static void borrowItem() {
        System.out.print("Enter Item ID: ");
        String id = sc.nextLine();

        for (LibraryItem item : items) {
            if (item.getItemId().equalsIgnoreCase(id)) {
                item.processLoan(); // polymorphism
                return;
            }
        }

        System.out.println("Item not found!");
    }
}