package pl.krysinski;

import java.util.*;
import java.util.stream.Collectors;

public class App {

    private static final int TARGET_NUMBER = 13;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers of integers seperated by a space: ");
        String input = scanner.nextLine();

        String[] numbers = input.split(" ");
        int[] integerArray = getIntegerArray(numbers);
        List<String> result = findPairs(integerArray);
        getSortedPairsList(result).forEach(System.out::println);
        scanner.close();
    }

    public static int[] getIntegerArray(String[] numbers) {
        try {
            return Arrays.stream(numbers)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } catch (NumberFormatException e) {
            System.out.println("Error: Only integers!");
            System.out.println(e.getMessage());
            return new int[]{};
        }
    }

    static List<String> findPairs(int[] numbersArray) {
        List<String> result = new ArrayList<>();
        Set<Integer> checkedNumbers = new HashSet<>();
        for (int num : numbersArray) {
            int complement = TARGET_NUMBER - num;
            if (checkedNumbers.contains(complement)) {
                int smaller = Math.min(num, complement);
                int larger = Math.max(num, complement);
                result.add(smaller + " " + larger);
            }
            checkedNumbers.add(num);
        }
        return result;
    }

    static List<String> getSortedPairsList(List<String> result) {
        return result.stream().sorted().collect(Collectors.toList());
    }
}