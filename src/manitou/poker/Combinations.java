package manitou.poker;

import manitou.poker.enums.Combination;
import manitou.poker.enums.Rank;
import manitou.poker.enums.Suit;

import java.util.*;
import java.util.stream.Collectors;

import static manitou.poker.enums.Combination.*;
public class Combinations {

    private final Set<Combination> combinations;
    private final Map<Rank, Integer> rankCountMap;
    private final Map<Suit, Integer> suitCountMap;

    public Combinations() {
        this.combinations = new HashSet<>();
        this.rankCountMap = new HashMap<>();
        this.suitCountMap = new HashMap<>();
    }

    public Combination processHand(Hand hand) {
        combinations.clear();
        rankCountMap.clear();
        suitCountMap.clear();

        List<Card> cards = hand.getCards();

        for(Card card: cards){
            Rank rank = card.getRank();
            Suit suit = card.getSuit();
            if(rankCountMap.containsKey(rank)){
                rankCountMap.put(rank, rankCountMap.get(rank) + 1);
            } else {
                rankCountMap.put(rank, 1);
            }

            if(suitCountMap.containsKey(suit)){
                suitCountMap.put(suit, suitCountMap.get(suit) + 1);
            } else {
                suitCountMap.put(suit, 1);
            }
        }



        if (findRoyalFlush(cards)) return ROYAL_FLUSH;
        if (findStraightFlush(cards)) return STRAIGHT_FLUSH;
        if (findFourOfAKind()) return FOUR_OF_A_KIND;
        if (findFullHouse()) return FULL_HOUSE;
        if (findFlush()) return FLUSH;
        if (findStraight(cards)) return STRAIGHT;
        if (findThreeOfAKind()) return THREE_OF_A_KIND;
        if (findTwoPairs()) return TWO_PAIR;
        if (findHighPair()) return HIGH_PAIR;
        if (findPair()) return PAIR;
        if (findAce()) return ACE;


        return HIGH_CARD;
    }

    public boolean findRoyalFlush(List<Card> cards) {
        List<Card> filteredCards = cards.stream().filter(it -> it.getRank().getValue() >= 10).collect(Collectors.toList());
        return findStraightFlush(filteredCards);
    }

    public boolean findStraightFlush(List<Card> cards) {
        Map<Suit, List<Card>> suitCardsMap = cards.stream()
                .collect(Collectors.groupingBy(Card::getSuit, HashMap::new, Collectors.toCollection(ArrayList::new)));

        for (Map.Entry<Suit, List<Card>> entry : suitCardsMap.entrySet()) {
            if(entry.getValue().size() >=5){
                if(findStraight(entry.getValue())) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean findFourOfAKind() {
        return rankCountMap.containsValue(4);
    }

    public boolean findFlush() {
        for (Map.Entry<Suit, Integer> entry : suitCountMap.entrySet()) {
            if(entry.getValue() >= 5){
                return true;
            }
        }
        return false;
    }

    public boolean findFullHouse() {
        return rankCountMap.containsValue(3) && rankCountMap.containsValue(2);
    }

    public boolean findStraight(List<Card> cards) {

        //cards = List.of(new Card(35), new Card(21),new Card(7),new Card(19), new Card(5),new Card(12),new Card(14));
        int straightCount = 1;
        Card previousCard = null;
        for(Card card: cards) {
            if(previousCard == null) {
                previousCard = card;
                continue;
            }
            int cardRank = card.getRank().getValue();
            int previousCardRank = previousCard.getRank().getValue();

            if(previousCardRank == cardRank) {
                continue;
            }

            if(cardRank == previousCardRank - 1){
                straightCount++;

                if(straightCount == 5)
                    return true;
            }
            else {
                straightCount = 1;
            }

            previousCard = card;
        }

        return straightCount == 4 && cards.get(0).getRank().equals(Rank.ACE);
    }

    public boolean findThreeOfAKind() {
        return rankCountMap.containsValue(3);
    }

    public boolean findTwoPairs() {
        int pairCount = 0;
        for (Map.Entry<Rank, Integer> entry : rankCountMap.entrySet()) {
            if(entry.getValue() == 2){
                pairCount++;
                if(pairCount ==2){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean findHighPair() {
        for (Map.Entry<Rank, Integer> entry : rankCountMap.entrySet()) {
            if(entry.getValue() == 2 && entry.getKey().getValue() > Rank.TEN.getValue()){
                return true;
            }
        }
        return false;
    }

    public boolean findPair() {
        return rankCountMap.containsValue(2);
    }

    public boolean findAce() {
        return rankCountMap.containsKey(Rank.ACE);
    }

    public Set<Combination> getCombinations() {
        return combinations;
    }
}
