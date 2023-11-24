package pl.krysinski;

import java.util.*;


public class App {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter numbers of integers seperated by a space: ");
        String input = scanner.nextLine();

        String[] numbers = input.split(" ");
        PairFinder pairFinder = new PairFinder(numbers);
        List<String> result = pairFinder.getAllPairsThatSumUpToTarget(numbers);
        pairFinder.getSortedPairsList(result).forEach(System.out::println);

        scanner.close();
    }
}