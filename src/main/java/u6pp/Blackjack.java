package u6pp;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class Blackjack
{
    //scanner
    Scanner sc = new Scanner(System.in);

    //variables
    private Deck deck1 = new Deck();
    private Card[] userHand = new Card[52];
    private Card[] dealerHand = new Card[52];
    private boolean stay = false;
    private boolean anyBlackjack = false;
    private boolean anyBust = false;
    private static int wins = 0;
    private static int ties = 0;
    private static int losses = 0;


    //constructor
    public Blackjack(){
        
    }
       

    //methods
    public void play(){

        
        boolean playing = true; 
        System.out.print("Welcome to Blackjack! What is your name?");
        String name = sc.nextLine();
        System.out.println("Hello " + name + " ! I am Apolo!\nLet's play some cards.");
        

        do {

            deck1.shuffle();
            //initial deal of card and declare
            dealCard(deck1.deal(), userHand);
            dealCard(deck1.deal(), userHand);
            dealCard(deck1.deal(), dealerHand);
            dealCard(deck1.deal(), dealerHand);
            System.out.println("Your hand: " + current(userHand));
            System.out.println("Dealer's hand: " + current(dealerHand));
            

            //blackjack check
            if(isBlackjack(userHand) || isBlackjack(dealerHand))
            {
                anyBlackjack = true;
            }
            

            //bust check
            if(isBust(userHand) || isBust(dealerHand))
            {
                anyBust  = true;
            }
            

            //hit or stay. Precondition: anyblackjack = false, anyBustAtBeginning = false;
            while (!isBust(userHand) && !stay && !anyBlackjack && !anyBust)
            {
                hit(userHand);
            } 

            
            if(!anyBlackjack)
            {
                computerPlay();
            }
            
            // the result
            System.out.println(determineResult(userHand, dealerHand));

            //ask if want to play again
            System.out.print("Would you like to play again? (Y)es or (N)o: ");
            String userInput = sc.nextLine();
            userInput = userInput.toUpperCase();

            if(userInput.equals("N") || userInput.equals("NO"))
            {
                playing = false;
                

            }
            else if(userInput.equals("Y") || userInput.equals("YES"))
            {
                playing = true;
                stay = false;
                anyBlackjack = false;
                anyBust = false;
                setNull(userHand);
                setNull(dealerHand);

               
            }
            else
            {
                while(!(userInput.equals("Y")|| userInput.equals("N") || userInput.equals("YES") || userInput.equals("NO")))
                {
                    System.out.println("Invalid input, please try again");
                    System.out.print("Would you like to play again? (Y)es or (N)o: ");
                    userInput = sc.nextLine();
                    userInput = userInput.toUpperCase();
                    if(userInput.equals("N"))
                    {
                        playing = false;
                    }
                }
            }
             
        } while (playing);
        System.out.println("Thanks for playing MrHsieh! Have a great day!");
    }
        

    public static int calcPoints(Card[] hand)
    {
        int total = 0;
        
        for(Card currCard : hand)
        {
            if(!(currCard == null))
            {
                String value = currCard.getValue();
                if(value.equals("Ace"))
                {
                total += 11;
                }
                else if(value.equals("King") || value.equals("Queen") || value.equals("Jack"))
                {
                    total += 10;
                }
                else
                {
                    total += Integer.valueOf(value);
                }
            }
            else{
                continue;
            }

        }
        return total;
    }

    public static String determineResult(Card[] userHand, Card[] dealerHand)
    {
        int userTotal = calcPoints(userHand);
        int dealerTotal = calcPoints(dealerHand);

        if(userTotal > 21)
        {
            losses++;
            return "User Loses";
        }
        else if(dealerTotal > 21)
        {
            wins++;
            return "User Wins";
        }
        else if(userTotal < dealerTotal)
        {
            losses++;
            return "User Loses";
        }
        else if(userTotal > dealerTotal)
        {
            wins++;
            return "User Wins";
        }
        else
        {
            ties++;
            return "User Pushes";
        }
        

    }

    public static boolean isBust(Card[] hand)
    {
        int total = calcPoints(hand);

        if(total > 21)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean isBlackjack(Card[] hand)
    {
        int total = calcPoints(hand);
        int inHand = 0;
        for(Card curr : hand)
        {
            if(curr != null)
            {
                inHand++;
            }
        }


        if(total == 21 && inHand == 2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean dealerKeepHitting(Card[] hand)
    {
        int total = calcPoints(hand);

        if(total < 17)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //own methods
    private void dealCard(Card toDeal, Card[] toPut)
    {
        int index = 0;
        for(Card current : toPut)
        {
            if(current == null)
            {
                toPut[index] = toDeal;
                break;
            }
            index++;
        }
    }

    private String current(Card[] hand)
    {
        String hold = "";

        for(Card currCard : hand)
        {
            if(currCard != null)
            {
                hold += " " + currCard.getValue() + " of " + currCard.getSuit();
            }
        }

        return hold;
        
    }

    private void hit(Card[] input){
        
        System.out.println("Would you like to (H)it or (S)tay: ");
        String ifHit = sc.nextLine();
                
        //check if its valid input  
        while (!(ifHit.toUpperCase().equals("S") || ifHit.toUpperCase().equals("H") || ifHit.toUpperCase().equals("STAY") || ifHit.toUpperCase().equals("HIT")))
        {
            System.out.println("Invalid input, try again");
            System.out.println("Would you like to (H)it or (S)tay: ");
            ifHit = sc.nextLine();
        }

        //set hit boolean
        if (ifHit.toUpperCase().equals("HIT") || ifHit.toUpperCase().equals("H"))
        {
            dealCard(deck1.deal(), input); 
            System.out.println("Your hand: " + current(userHand));

        }

        //check stay
        if (ifHit.toUpperCase().equals("STAY") || ifHit.toUpperCase().equals("S"))
        {
            stay = true;
        }
        
    }

    

    // AI shit
    private void computerPlay()
    {
        while(dealerKeepHitting(dealerHand))
        {
            dealCard(deck1.deal(), dealerHand);

        }
        System.out.println("Dealer's hand: " + current(dealerHand));
    }

    private void setNull(Card[] toSet)
    {
        for(int i = 0; i < toSet.length; i++)
        {
            toSet[i] = null;

        }
    }
}