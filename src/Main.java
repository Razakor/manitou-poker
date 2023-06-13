import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter number of cards");
//        int count = scanner.nextInt();
        int count = 8;
        Hand hand = new Hand();
        for (int i = 0; i < 100; i++) {
            hand.pickCards(count);
            System.out.println(hand.getCards());
            System.out.println(hand.getJokers());
        }
    }
}