package pl.krysinski;

import java.util.*;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] numbers = input.split(" ");
        int[] integerArray = getIntegerArray(numbers);
        List<String> result = findPairs(integerArray);
        result.stream().sorted().forEach(System.out::println);
        scanner.close();
    }

    public static int[] getIntegerArray(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static List<String> findPairs(int[] numbersArray) {
        List<String> result = new ArrayList<>();
        Set<Integer> checkedNumbers = new HashSet<>();
        for (int num : numbersArray) {
            int complement = 13 - num;
            if (checkedNumbers.contains(complement)) {
                int smaller = Math.min(num, complement);
                int larger = Math.max(num, complement);
                result.add(smaller + " " + larger);
            }
            checkedNumbers.add(num);
        }
        return result;
    }
}