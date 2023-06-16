package manitou.poker;

import manitou.poker.enums.Combination;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {


//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter number of cards");
//        int count = scanner.nextInt();
        int count = 9;
        Hand hand = new Hand();
        Combinations combinations = new Combinations();

        Map<Combination, Integer> combinationMap = new TreeMap<>();

        for (Combination combination : Combination.values()) {
            combinationMap.put(combination, 0);
        }


        int counter = 1000000;

        for (int i = 0; i < counter; i++) {
            hand.pickCards(count);
            System.out.println(hand.getCards());
            System.out.println(hand.getJokers());
            Combination combination = combinations.processHand(hand);
            combinationMap.put(combination, combinationMap.get(combination) + 1);

            System.out.println(combination);

            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println(combinationMap);

        Map<Combination, Double> percentMap = new TreeMap<>();

        for (Map.Entry<Combination, Integer> entry : combinationMap.entrySet()) {
            percentMap.put(entry.getKey(), (double)entry.getValue() / (double)counter * (double)100);
        }
        System.out.println(percentMap);
    }
}