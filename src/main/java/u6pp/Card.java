package u6pp;

/**
 * A class that represents a standard playing Card 
 * (values are 2 - 10 and Jack - Ace) 
 * (suits are clubs, diamonds, hearts, spades)
 * Do not make any changes to this class
 */
public class Card implements Comparable<Card>{
	
	//Instance variables
	private String suit;
	private String value;
	
	//Constants to represent Card suits and values
    public static final String[] SUITS = {"Clubs", "Spades", "Diamonds", "Hearts"};
    public static final String[] VALUES = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    
	/**
	 * Default Constructor sets the suit to Clubs and the value to 2
	 */
	public Card() {
		this.suit = SUITS[0];
		this.value = VALUES[0];
	}
	
	/**
	 * Constructs a Card based on the parameters
	 * @suit: the suit for the card
	 * @value: the face value of the card
	 */
	public Card(String suit, String value) {
		this.suit = suit;
		this.value = value;
	}
	
	/**
	 * Getter for the suit of the Card. Can be clubs, diamonds, hearts, or spades
	 * @return the suit of the Card
	 */
	public String getSuit() {
		return this.suit;
	}
	
	/**
	 * Getter for the face value of the Card. Is a value from 2 - ACE
	 * @return the face value of the Card
	 */
	public String getValue() {
		return this.value;
	}
	
	/**
	 * Compares two cards and returns true if they share a suit and value
	 * @param c: the Card to compare this to.
	 * @return true if both the suit and value of this and c are the same
	 */
	public boolean equals (Card c) {
		return this.toString().equals(c.toString());
	}
	
	/**
	 * toString for the Card class
	 * @return "<value> of <suit>"
	 */
	public String toString() {
		return this.value + " of " + this.suit;
	}
	
	/**
	 * Implements the Comparable interface.
	 * @param c: a Card to compare with this
	 * @return 1 if the suit or suit and value of this is greater than c, 0 if they are equal and -1 if this is less than c
	 *  The ranking for suits are SPADES > HEARTS > DIAMONDS > CLUBS
	 *	The ranking for values are ACE > KING > QUEEN > JACK > 10 > 9 > 8 > 7 > 6 > 5 > 4 > 3 > 2
	 * Ranking is checked suit first then value
	 */
	public int compareTo (Card c) {
		if(this.equals(c))
			return 0;
			
		if(this.getSuit().equals(c.getSuit())) {
            if(compareValueIndex(c)) {
                return 1;
            }
            return -1;
        }

        if(compareSuitIndex(c)) {
            return 1;
        }
        return -1;
    }

    /**
     * Helper function for compareTo. Requires that this.getSuit and c.getSuit both be in Card.SUITS
     * @return true if this.getSuit()'s index in Card.SUITS is greater than c.getSuit's
     */
    private boolean compareSuitIndex(Card c) {
        return Card.getIndex(Card.SUITS, this.getSuit()) > Card.getIndex(Card.SUITS, c.getSuit());
    }

    /**
     * Helper function for compareTo. Requires that this.getValue and c.getValue both be in Card.VALUES
     * @return true if this.getValue()'s index in Card.VALUES is greater than c.getValue's
     */
    private boolean compareValueIndex(Card c) {
        return Card.getIndex(Card.VALUES, this.getValue()) > Card.getIndex(Card.VALUES, c.getValue());
    }

    /**
     * Finds the index of a String in a String[]
     * @return the first index of the String in the String[] or -1 if it is not found
     */
    public static int getIndex(String[] arr, String str) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].equals(str)) {
                return i;
            }
        }
        return -1;
    } 
}