import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Introduce una secuencia de números separados por coma: Ej: -5,3,4,-8,6,1,8,8,8,8");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] numbers = input.split(",");
        int[] intNumbers = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            intNumbers[i] = Integer.parseInt(numbers[i]);
        }
        int[] sorted = Mergesort.mergeSortAlgorithm(intNumbers);
        System.out.println(Arrays.toString(sorted));

        intNumbers = new int[]{-5,3,4,-8,6,1,8,8,8,8};
        sorted = Mergesort.mergeSortAlgorithm(intNumbers);
        System.out.println(Arrays.toString(sorted));
    }
}