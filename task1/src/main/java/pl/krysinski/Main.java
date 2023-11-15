package pl.krysinski;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers of integers seperated by a space: ");

        String input = scanner.nextLine();
        String[] numbers = input.split(" ");

        int[] integerArray = getIntegerArray(numbers);

        Set<Integer> sortedWithOutDistinctList = getSortedDistinctNumbers(integerArray);
        if (!sortedWithOutDistinctList.isEmpty()) {
            System.out.println(sortedWithOutDistinctList);
            System.out.println("count: " + integerArray.length);
            System.out.println("distinct: " + sortedWithOutDistinctList.size());
            System.out.println("min: " + Collections.min(sortedWithOutDistinctList));
            System.out.println("max: " + Collections.max(sortedWithOutDistinctList));
        }


        scanner.close();
    }

    public static Set<Integer> getSortedDistinctNumbers(int[] integerArray) {
        if (integerArray.length == 0) {
            return new HashSet<>();
        }
        Set<Integer> distinctElements = new TreeSet<>();
        for (int num : integerArray) {
            distinctElements.add(num);
        }
        return distinctElements;
    }

    public static int[] getIntegerArray(String[] numbers) {
        try {
            return Arrays.stream(numbers)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } catch (NumberFormatException e) {
            System.out.println("Error: Only integers!");
            System.out.println(e.getMessage());
        }
        return new int[]{};
    }
}