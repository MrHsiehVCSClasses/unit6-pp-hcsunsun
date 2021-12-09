package u6pp;

public class Deck
{
    private Card[] deck;
    private int undealt = 51;


    //constructor
    public Deck(){
        deck = new Card[52];
        int ind = 0;
        for(String currSuit : Card.SUITS)
        {
            for(String currValue : Card.VALUES)
            {
                deck[ind] = new Card(currSuit, currValue);
                ind++;
            }
        }
        ind--;
    }

    //fucntions
    public int numLeft()
    {
        return undealt + 1;
    }


    public Card deal()
    {

        Card temp = deck[undealt];
        undealt--;
        return temp;
        

    }

    public void shuffle()
    {
        int now = 0;
        for(int i = 0; i < deck.length; i++)
        {
            int toGo = (int)(Math.random() * (52 - now)) + now;
            Card temp = deck[toGo];
            deck[toGo] = deck[i];
            deck[i] = temp;
            now++;
            undealt = 51;
        }
    }

}