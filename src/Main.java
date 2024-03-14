import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] numbers = input.split(",");
        int[] intNumbers = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            intNumbers[i] = Integer.parseInt(numbers[i]);
        }

        int[] sorted = Mergesort.mergeSortAlgorithm(intNumbers);
        System.out.println(Arrays.toString(sorted));
    }
}
