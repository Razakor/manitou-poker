package razakor.poker;

import razakor.poker.enums.Joker;

import java.util.*;

public class Hand {

    private final LinkedList<Card> cards;
    private final List<Joker> jokers;

    public Hand() {
        this.cards = new LinkedList<>();
        this.jokers = new ArrayList<>();
    }

    public void pickCards(int count) {
        cards.clear();
        jokers.clear();
        Set<Integer> randoms = getCardRandoms(count);
        System.out.println(randoms);
        if (randoms.contains(53)) {
            jokers.add(Joker.BLACK);
            randoms.remove(53);
        }
        if (randoms.contains(54)) {
            jokers.add(Joker.RED);
            randoms.remove(54);
        }
        for (int random : randoms) {
            cards.add(new Card(random));
        }
        sortCards();
    }

    private Set<Integer> getCardRandoms(int size) {
        Set<Integer> randoms = new HashSet<>();

        while (randoms.size() < size) {
            randoms.add(getRandomInt(1, 54));
        }

        return randoms;
    }

    public int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max + 1 - min) + min;
    }

    public LinkedList<Card> getCards() {
        return cards;
    }

    public List<Joker> getJokers() {
        return jokers;
    }

    private void sortCards() {
        Comparator<Card> rankComparator = Comparator.comparing(card -> card.getRank().getValue());
        Comparator<Card> suitComparator = Comparator.comparing(card -> card.getSuit().getValue());
        Comparator<Card> cardComparator = rankComparator.thenComparing(suitComparator);
        cards.sort(cardComparator);
    }
}