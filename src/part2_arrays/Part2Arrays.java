package part2_arrays;

import java.util.Random;
import java.util.Scanner;


public class Part2Arrays {


    static Scanner scanner = new Scanner(System.in);

    static Random random = new Random();

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("       PART 2. ARRAY HANDLING");
        System.out.println("=================================");


        System.out.print("\nEnter array length for Part 2.1: ");
        int inputLength = scanner.nextInt();

        int[] userArray = inputArray(inputLength);

        System.out.println("Your array:");
        printArray(userArray);



        System.out.print("\nEnter array length for Part 2.2: ");
        int randomLength = scanner.nextInt();

        int[] randomArray = createRandomArray(randomLength);

        System.out.println("Random array:");
        printArray(randomArray);


        System.out.println("\nPart 2.3. Print Array Method:");
        printArray(randomArray);


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


    public static int[] inputArray(int length) {

        int[] array = new int[length];

        System.out.println("Enter " + length + " integer values:");

        for (int i = 0; i < array.length; i++) {
            System.out.print("Element [" + i + "]: ");
            array[i] = scanner.nextInt();
        }

        return array;
    }


    public static int[] createRandomArray(int length) {

        int[] array = new int[length];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        return array;
    }


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

    public static int searchValue(int[] array, int searchedValue) {

        for (int i = 0; i < array.length; i++) {

            if (array[i] == searchedValue) {
                return i;
            }
        }

        return -1;
    }
}