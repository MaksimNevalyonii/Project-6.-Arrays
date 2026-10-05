import java.util.Arrays;
import java.util.Scanner;

public class classwork {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int size = readInt("Enter array size: ");
        while (size <= 0) {
            size = readInt("Size must be greater than 0. Enter array size: ");
        }

        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = readInt("Enter element [" + i + "]: ");
        }

        int choice;
        do {
            printMenu();
            choice = readInt("Your choice: ");

            switch (choice) {
                case 1 -> traverseForward(array);
                case 2 -> traverseBackward(array);
                case 3 -> System.out.println("Min: " + findMin(array));
                case 4 -> System.out.println("Max: " + findMax(array));
                case 5 -> {
                    int target = readInt("Enter value to search: ");
                    int index = linearSearch(array, target);
                    if (index != -1) {
                        System.out.println("Value " + target + " found at index " + index);
                    } else {
                        System.out.println("Value " + target + " not found");
                    }
                }
                case 6 -> System.out.println("Sum: " + calculateSum(array));
                case 7 -> System.out.println("Average: " + calculateAverage(array));
                case 8 -> {
                    bubbleSort(array);
                    System.out.println("Array sorted: " + Arrays.toString(array));
                }
                case 9 -> System.out.println("Array: " + Arrays.toString(array));
                case 0 -> System.out.println("Bye!");
                default -> System.out.println("Unknown operation, try again.");
            }
        } while (choice != 0);
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("===== Array operations =====");
        System.out.println("1. Traversal forward");
        System.out.println("2. Traversal backward");
        System.out.println("3. Find min");
        System.out.println("4. Find max");
        System.out.println("5. Linear search");
        System.out.println("6. Calculate sum");
        System.out.println("7. Calculate average");
        System.out.println("8. Sort array (Bubble sort)");
        System.out.println("9. Display the array");
        System.out.println("0. Exit");
    }

    public static void traverseForward(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void traverseBackward(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static int findMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
    public static long calculateSum(int[] array) {
        long sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

    public static double calculateAverage(int[] array) {
        return (double) calculateSum(array) / array.length;
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static int readInt(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input, enter an integer: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}