package part1_arrays;

public class Part1Arrays {

    public static void main(String[] args) {

    
        int[] numbers = new int[10];

        
        int size = 5;
        int[] values = new int[size];

        
        int[] literalArray = {1, 4, 2, 8, 10};

        
        int[] intArray = {1, 2, 3};
        double[] doubleArray = {1.5, 2.5, 3.5};
        String[] stringArray = {"Java", "Arrays", "Programming"};
        char[] charArray = {'A', 'B', 'C'};
        boolean[] booleanArray = {true, false, true};

        
        System.out.println("Array length: " + literalArray.length);

        System.out.println("Integer array length: " + intArray.length);
        System.out.println("Double array length: " + doubleArray.length);
        System.out.println("String array length: " + stringArray.length);
        System.out.println("Char array length: " + charArray.length);
        System.out.println("Boolean array length: " + booleanArray.length);

        int[] a = new int[10];

        
        a[4] = 45;

        
        System.out.println("5th element value: " + a[4]);


        int[] traversalArray = {10, 20, 30, 40, 50};

       
        System.out.println("\nTraversal using for loop:");

        for (int i = 0; i < traversalArray.length; i++) {
            System.out.println("Element " + i + ": " + traversalArray[i]);
        }

       
        System.out.println("\nTraversal using enhanced for loop:");

        for (int value : traversalArray) {
            System.out.println("Value: " + value);
        }

        System.out.println("\nTraversal using while loop:");

        int i = 0;

        while (i < traversalArray.length) {
            System.out.println("Element " + i + ": " + traversalArray[i]);
            i++;
        }
    }
}