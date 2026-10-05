package part2_arrays;

import java.util.Random;
import java.util.Scanner;

/**
 * Part 2. Array Handling
 *
 * Contains methods for:
 * 1. Input array
 * 2. Creating an array with random values
 * 3. Printing an array
 * 4. Calculating the sum
 * 5. Finding the largest value
 * 6. Searching for a value
 */
public class Part2Arrays {

    // Scanner for reading user input
    static Scanner scanner = new Scanner(System.in);

    // Random object for generating random numbers
    static Random random = new Random();

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("       PART 2. ARRAY HANDLING");
        System.out.println("=================================");

        // ============================================================
        // Part 2.1. Input Array Method
        // ============================================================

        System.out.print("\nEnter array length for Part 2.1: ");
        int inputLength = scanner.nextInt();

        int[] userArray = inputArray(inputLength);

        System.out.println("Your array:");
        printArray(userArray);

        // ============================================================
        // Part 2.2. Create an array with random values
        // ============================================================

        System.out.print("\nEnter array length for Part 2.2: ");
        int randomLength = scanner.nextInt();

        int[] randomArray = createRandomArray(randomLength);

        System.out.println("Random array:");
        printArray(randomArray);

        // ============================================================
        // Part 2.3. Print Array Method
        // ============================================================

        System.out.println("\nPart 2.3. Print Array Method:");
        printArray(randomArray);

        // ============================================================
        // Part 2.4. Sum of array elements
        // ============================================================

        System.out.println("\nPart 2.4. Sum of array elements");

        System.out.print("Enter array length: ");
        int sumLength = scanner.nextInt();

        int[] sumArray = createRandomArray(sumLength);

        System.out.println("Created array:");
        printArray(sumArray);

        int sum = 0;

        for (int value : sumArray) {
            sum += value;
        }

        System.out.println("Sum of array elements: " + sum);

        // ============================================================
        // Part 2.5. Largest value in an array
        // ============================================================

        System.out.println("\nPart 2.5. Largest value in an array");

        System.out.print("Enter array length: ");
        int largestLength = scanner.nextInt();

        int[] largestArray = createRandomArray(largestLength);

        System.out.println("Created array:");
        printArray(largestArray);

        int largest = largestArray[0];

        for (int value : largestArray) {
            if (value > largest) {
                largest = value;
            }
        }

        System.out.println("Largest value: " + largest);

        // ============================================================
        // Part 2.6. Search value in array method
        // ============================================================

        System.out.println("\nPart 2.6. Search value in array");

        System.out.print("Enter value to search: ");
        int searchValue = scanner.nextInt();

        int index = searchValue(largestArray, searchValue);

        if (index != -1) {
            System.out.println(
                    "Value " + searchValue
                            + " was found at index " + index + "."
            );
        } else {
            System.out.println(
                    "Value " + searchValue
                            + " was not found in the array."
            );
        }

        System.out.println("\n=================================");
        System.out.println("          PROGRAM FINISHED");
        System.out.println("=================================");

        scanner.close();
    }

    // ================================================================
    // Part 2.1. Input Array Method
    // ================================================================

    /**
     * Creates an integer array and fills it with values entered by user.
     *
     * @param length length of the array
     * @return new array filled with user input
     */
    public static int[] inputArray(int length) {

        int[] array = new int[length];

        System.out.println("Enter " + length + " integer values:");

        for (int i = 0; i < array.length; i++) {
            System.out.print("Element [" + i + "]: ");
            array[i] = scanner.nextInt();
        }

        return array;
    }

    // ================================================================
    // Part 2.2. Create an array with random values method
    // ================================================================

    /**
     * Creates an integer array and fills it with random values.
     *
     * Random values are generated from 0 to 99.
     *
     * @param length length of the array
     * @return new array with random values
     */
    public static int[] createRandomArray(int length) {

        int[] array = new int[length];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        return array;
    }

    // ================================================================
    // Part 2.3. Print Array Method
    // ================================================================

    /**
     * Prints all array elements in a user-friendly format.
     *
     * @param array array to print
     */
    public static void printArray(int[] array) {

        System.out.print("[ ");

        for (int i = 0; i < array.length; i++) {

            System.out.print(array[i]);

            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println(" ]");
    }

    // ================================================================
    // Part 2.6. Search Value in Array Method
    // ================================================================

    /**
     * Searches for a value in an array.
     *
     * @param array array where the value should be searched
     * @param searchedValue value to search for
     * @return index of the found element or -1 if value is not found
     */
    public static int searchValue(int[] array, int searchedValue) {

        for (int i = 0; i < array.length; i++) {

            if (array[i] == searchedValue) {
                return i;
            }
        }

        return -1;
    }
}