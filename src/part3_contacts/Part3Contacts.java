package part3_contacts;

import java.util.Scanner;

/**
 * Part 3. Contacts Database
 *
 * The program stores contacts in an array of Strings.
 *
 * Available operations:
 * 1. Add contacts
 * 2. Show contacts
 * 3. Search in contacts
 * 4. Edit contact
 * 5. Delete contact
 * 6. Delete all contacts
 * 7. Add sample contacts
 * 0. Exit
 */
public class Part3Contacts {

    // Scanner for user input
    static Scanner scanner = new Scanner(System.in);

    // Maximum number of contacts
    static final int MAX_CONTACTS = 100;

    // Array for storing contacts
    static String[] contacts = new String[MAX_CONTACTS];

    // Actual number of contacts
    static int contactCount = 0;

    public static void main(String[] args) {

        // ============================================================
        // Part 3. Main Menu
        // ============================================================

        boolean running = true;

        System.out.println("======================================");
        System.out.println("       CONTACTS DATABASE");
        System.out.println("======================================");

        while (running) {

            showMenu();

            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    addContacts();
                    break;

                case "2":
                    showContacts();
                    break;

                case "3":
                    searchContacts();
                    break;

                case "4":
                    editContact();
                    break;

                case "5":
                    deleteContact();
                    break;

                case "6":
                    deleteAllContacts();
                    break;

                case "7":
                    addSampleContacts();
                    break;

                case "0":
                    running = false;
                    System.out.println("\nGoodbye!");
                    break;

                default:
                    System.out.println(
                            "\nInvalid option. Please choose a number from 0 to 7."
                    );
            }
        }

        scanner.close();
    }

    // ================================================================
    // Part 3.1. Main Menu
    // ================================================================

    /**
     * Displays the main program menu.
     */
    public static void showMenu() {

        System.out.println("\n--------------------------------------");
        System.out.println("              MAIN MENU");
        System.out.println("--------------------------------------");
        System.out.println("1. Add contacts");
        System.out.println("2. Show contacts");
        System.out.println("3. Search in contacts");
        System.out.println("4. Edit contact");
        System.out.println("5. Delete contact");
        System.out.println("6. Delete all contacts");
        System.out.println("7. Add sample contacts");
        System.out.println("0. Exit");
        System.out.println("--------------------------------------");
    }

    // ================================================================
    // Part 3.2. Add Contacts
    // ================================================================

    /**
     * Adds new contacts to the array.
     *
     * The user enters one contact per line.
     * An empty line finishes the operation.
     */
    public static void addContacts() {

        System.out.println("\n======================================");
        System.out.println("             ADD CONTACTS");
        System.out.println("======================================");

        System.out.println(
                "Enter contacts one per line."
        );
        System.out.println(
                "Press ENTER on an empty line to finish."
        );

        while (contactCount < MAX_CONTACTS) {

            System.out.print("New contact: ");
            String contact = scanner.nextLine();

            // Empty input finishes adding contacts
            if (contact.isEmpty()) {
                break;
            }

            contacts[contactCount] = contact;
            contactCount++;

            System.out.println("Contact added.");
        }

        if (contactCount == MAX_CONTACTS) {
            System.out.println(
                    "Contact database is full."
            );
        }

        System.out.println("Returning to main menu...");
    }

    // ================================================================
    // Part 3.3. Show Contacts
    // ================================================================

    /**
     * Displays all contacts stored in the array.
     */
    public static void showContacts() {

        System.out.println("\n======================================");
        System.out.println("             ALL CONTACTS");
        System.out.println("======================================");

        if (contactCount == 0) {
            System.out.println("There are no contacts.");
            return;
        }

        boolean foundContact = false;

        for (int i = 0; i < contactCount; i++) {

            if (contacts[i] != null && !contacts[i].equals("")) {

                System.out.println(
                        (i + 1) + ". " + contacts[i]
                );

                foundContact = true;
            }
        }

        if (!foundContact) {
            System.out.println("There are no active contacts.");
        }
    }

    // ================================================================
    // Part 3.4. Search in Contacts
    // ================================================================

    /**
     * Searches contacts using String.contains().
     */
    public static void searchContacts() {

        System.out.println("\n======================================");
        System.out.println("           SEARCH CONTACTS");
        System.out.println("======================================");

        if (contactCount == 0) {
            System.out.println("There are no contacts to search.");
            return;
        }

        System.out.print("Enter search phrase: ");
        String searchPhrase = scanner.nextLine();

        boolean found = false;

        for (int i = 0; i < contactCount; i++) {

            if (contacts[i] != null
                    && contacts[i].contains(searchPhrase)) {

                System.out.println(
                        (i + 1) + ". " + contacts[i]
                );

                found = true;
            }
        }

        if (!found) {
            System.out.println(
                    "No contacts contain: " + searchPhrase
            );
        }
    }

    // ================================================================
    // Part 3.5. Edit Contact
    // ================================================================

    /**
     * Allows the user to select a contact by number
     * and replace it with a new value.
     */
    public static void editContact() {

        System.out.println("\n======================================");
        System.out.println("              EDIT CONTACT");
        System.out.println("======================================");

        if (contactCount == 0) {
            System.out.println("There are no contacts to edit.");
            return;
        }

        showContacts();

        System.out.print("\nEnter contact number to edit: ");

        int number;

        try {
            number = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number.");
            return;
        }

        // Convert user number to array index
        int index = number - 1;

        if (index < 0 || index >= contactCount) {
            System.out.println("Contact number does not exist.");
            return;
        }

        if (contacts[index] == null
                || contacts[index].equals("")
                || contacts[index].equals("DELETED")) {

            System.out.println("This contact is not available.");
            return;
        }

        System.out.println(
                "Current contact: " + contacts[index]
        );

        System.out.print("Enter new contact value: ");
        String newContact = scanner.nextLine();

        if (newContact.isEmpty()) {
            System.out.println(
                    "Contact was not changed because the value is empty."
            );
            return;
        }

        contacts[index] = newContact;

        System.out.println("Contact successfully edited.");
    }

    // ================================================================
    // Part 3.6. Delete Contact
    // ================================================================

    /**
     * Deletes a contact by replacing its value with "DELETED".
     *
     * The physical array element remains in the array.
     */
    public static void deleteContact() {

        System.out.println("\n======================================");
        System.out.println("             DELETE CONTACT");
        System.out.println("======================================");

        if (contactCount == 0) {
            System.out.println("There are no contacts to delete.");
            return;
        }

        showContacts();

        System.out.print("\nEnter contact number to delete: ");

        int number;

        try {
            number = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number.");
            return;
        }

        int index = number - 1;

        if (index < 0 || index >= contactCount) {
            System.out.println("Contact number does not exist.");
            return;
        }

        if (contacts[index] == null
                || contacts[index].equals("")
                || contacts[index].equals("DELETED")) {

            System.out.println("This contact is already unavailable.");
            return;
        }

        contacts[index] = "DELETED";

        System.out.println("Contact deleted.");
    }

    // ================================================================
    // Part 3.7. Delete All Contacts
    // ================================================================

    /**
     * Makes all contact array elements empty.
     */
    public static void deleteAllContacts() {

        System.out.println("\n======================================");
        System.out.println("           DELETE ALL CONTACTS");
        System.out.println("======================================");

        for (int i = 0; i < contacts.length; i++) {
            contacts[i] = "";
        }

        contactCount = 0;

        System.out.println("All contacts have been deleted.");
    }

    // ================================================================
    // Part 3.8. Add Sample Contacts
    // ================================================================

    /**
     * Adds prepared sample contacts to the database.
     *
     * This method is useful for testing and debugging.
     */
    public static void addSampleContacts() {

        System.out.println("\n======================================");
        System.out.println("           SAMPLE CONTACTS");
        System.out.println("======================================");

        String[] sampleContacts = {
                "John Smith - +380 67 123 4567",
                "Anna Johnson - +380 93 234 5678",
                "Michael Brown - +380 50 345 6789",
                "Emma Wilson - +380 63 456 7890",
                "David Miller - +380 66 567 8901"
        };

        int added = 0;

        for (String contact : sampleContacts) {

            if (contactCount >= MAX_CONTACTS) {
                break;
            }

            contacts[contactCount] = contact;
            contactCount++;
            added++;
        }

        System.out.println(
                added + " sample contacts added."
        );
    }
}
