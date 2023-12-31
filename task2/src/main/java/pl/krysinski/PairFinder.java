package pl.krysinski;

import java.util.*;
import java.util.stream.Collectors;


public class PairFinder {

    private static final int TARGET_NUMBER = 13;

    public PairFinder(String[] numbers) {
    }

    public PairFinder() {
    }

    List<String> getAllPairsThatSumUpToTarget(String[] numbers) {
        Map<Integer, Integer> integerOccurenceMap = getIntegerOccurenceMap(getIntegerArray(numbers));
        return findPairs(integerOccurenceMap);
    }

    Map<Integer, Integer> getIntegerOccurenceMap(int[] integerArray) {
        Map<Integer, Integer> integerOccurenceMap = new HashMap<>();

        for (int number : integerArray) {
            if (integerOccurenceMap.containsKey(number)) {
                integerOccurenceMap.put(number, integerOccurenceMap.get(number) + 1);
            } else {
                integerOccurenceMap.put(number, 1);
            }
        }

        return integerOccurenceMap;
    }

    int[] getIntegerArray(String[] numbers) {
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

    List<String> findPairs(Map<Integer, Integer> integerOccurrenceMap) {
        List<String> result = new ArrayList<>();
        Set<Integer> checkedNumbers = new HashSet<>();

        for (int num : integerOccurrenceMap.keySet()) {
            int complement = TARGET_NUMBER - num;
            if (!checkedNumbers.contains(num) && integerOccurrenceMap.containsKey(complement)) {
                int numOccurrence = integerOccurrenceMap.get(num);
                int complementOccurrence = integerOccurrenceMap.getOrDefault(complement, 1);
                int allOccurrence = numOccurrence * complementOccurrence;
                for (int i = 0; i < allOccurrence; i++) {
                    int smaller = Math.min(num, complement);
                    int larger = Math.max(num, complement);
                    result.add(smaller + " " + larger);
                }
                checkedNumbers.add(num);
                checkedNumbers.add(complement);
            }
        }
        return result;
    }

    List<String> getSortedPairsList(List<String> result) {
        return result.stream().sorted().collect(Collectors.toList());
    }
}
