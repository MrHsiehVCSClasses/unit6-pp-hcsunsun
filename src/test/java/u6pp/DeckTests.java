package u6pp;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeckTests {

    private static final int DECK_SIZE = Card.VALUES.length * Card.SUITS.length;

    @Test
    void constructorAndNumLeftWorkCorrectly() throws Exception {
        Deck testDeck = new Deck();
        assertEquals(DECK_SIZE, testDeck.numLeft());
    }

    @Test
    void dealAndNumLeftWorkCorrectly() throws Exception {
        Deck testDeck = new Deck();
        int expectedDeckSize = DECK_SIZE;
        for(int j = 0; j < 6; j++) {
            int testTimes = j;
            for(int i = 0; i < testTimes; i++) {
                testDeck.deal();
            }
            expectedDeckSize -= testTimes;
            assertEquals(expectedDeckSize, testDeck.numLeft());
        }
    }

    @Test
    void newDeckDealsOutOnlyUniqueCards() throws Exception {
        Deck testDeck = new Deck();
        ArrayList<Card> dealtCards = DeckTests.dealOutDeck(testDeck);

        assertAll("A new deck deals out all unique combinations of SUITS and VALUES",
            () -> assertEquals(0, testDeck.numLeft()),
            () -> assertTrue(DeckTests.allUnique(dealtCards))
        );
    }

    @Test
    void shuffleRandomizesDeck() throws Exception {
        Deck testDeck = new Deck();
        ArrayList<Card> dealtCards = DeckTests.dealOutDeck(testDeck);
        testDeck.shuffle();
        ArrayList<Card> otherDealtCards = DeckTests.dealOutDeck(testDeck);
        testDeck.shuffle();

        assertAll("A shuffled Deck is full size and different from a previously dealt deck", 
            () -> assertEquals(DECK_SIZE, testDeck.numLeft()),
            () -> assertTrue(DeckTests.areDifferent(dealtCards, otherDealtCards))
        );
    }

    private static ArrayList<Card> dealOutDeck(Deck deck) {
        ArrayList<Card> dealtCards = new ArrayList<Card>();

        for(int i = 0; i < DECK_SIZE; i++) {
            dealtCards.add(deck.deal());
        }

        return dealtCards;
    }

    private static boolean areDifferent(ArrayList<Card> cards, ArrayList<Card> otherCards) {
        if(cards.size() != cards.size()) {
            return false;
        }

        for(int i = 0; i < cards.size(); i++) {
            if(!cards.get(i).equals(otherCards.get(i))) {
                return true;
            }
        }

        return false;
    }

    private static boolean allUnique(ArrayList<Card> dealtCards) {
        for(int i = 0; i < dealtCards.size(); i++) {
            for(int j = i + 1; j < dealtCards.size(); j++) {
                if(dealtCards.get(i).equals(dealtCards.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }
}