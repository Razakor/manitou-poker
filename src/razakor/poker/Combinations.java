package razakor.poker;

import razakor.poker.enums.Combination;
import razakor.poker.enums.Suit;

import java.util.*;
import java.util.stream.Collectors;

public class Combinations {

    private final Set<Combination> combinations;

    public Combinations() {
        this.combinations = new HashSet<>();
    }

    public void processHand(Hand hand) {
        combinations.clear();

        if (findFlush(hand.getCards())) return;

    }

    public boolean findFlush(LinkedList<Card> cards) {
        /*Map<Suit, Integer> suitMap = new HashMap<>();
        suitMap.put(Suit.SPADES, 0);
        suitMap.put(Suit.HEARTS, 0);
        suitMap.put(Suit.DIAMONDS, 0);
        suitMap.put(Suit.CLUBS, 0);
        */

        Map<Suit, List<Card>> suitMap = cards.stream()
                .collect(Collectors.groupingBy(Card::getSuit, HashMap::new, Collectors.toCollection(ArrayList::new)));

        for (Map.Entry<Suit, List<Card>> entry : suitMap.entrySet()) {
            if (entry.getValue().size() == 5) {
                entry.getValue().forEach(card -> card.setUsed(true));
                combinations.add(Combination.FLUSH);
                return true;
            }
        }
        return false;
    }

    public Set<Combination> getCombinations() {
        return combinations;
    }
}
