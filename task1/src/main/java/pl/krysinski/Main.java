package pl.krysinski;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a list of integers separated by spaces:");
        String input = scanner.nextLine();

        String[] numbers = input.split(" ");

        int[] integerArray = getIntegerArray(numbers);

        Set<Integer> sortedWithOutDistinctList = getSortedDistinctNumbers(integerArray);

        System.out.println(sortedWithOutDistinctList);
        System.out.println("count: " + integerArray.length);
        System.out.println("distinct: " + sortedWithOutDistinctList.size());
        System.out.println("min: " + Collections.min(sortedWithOutDistinctList));
        System.out.println("max: " +  Collections.max(sortedWithOutDistinctList));
    }

    private static Set<Integer> getSortedDistinctNumbers(int[] integerArray) {
        Set<Integer> distinctElements = new TreeSet<>();
        for (int num : integerArray) {
            distinctElements.add(num);
        }
        return distinctElements;
    }

    private static int[] getIntegerArray(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}