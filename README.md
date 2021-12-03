# Unit 6 Programming Project

For this project, you will be writing three different classes: `Deck`, `Blackjack`, and `Yahtzee`. Make sure to properly JavaDoc your code and to use proper data encapsulation.

## GRADING BREAKDOWN

- Attempted code in all required sections: 20 points
- Code is DRY and follows good method decomposition: 20 points
- Correctly JavaDoc'ed all Code: 20 points
- Passed all Test Cases: 30 points
- Manual testing of gameplay: 10 points
Total: 100 points

- Extra Credit for a Yahtzee AI that regularly ties or beats Mr. Hsieh: 5 points
- Extra Credit for making full Blackjack/full Yahtzee: 5 points each

## PART A - `Deck.java`

In Unit 5, you figured out how to make a `Card`. A `Card` class has been provided for you in this project. In **PART A** you are going to use the `Card`s to create a `Deck`. A `Deck` contains 52 unique `Card`s. The potential values are `[2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace]` and the potential suits are `[Clubs, Spades, Diamonds, Hearts]`. Your `Deck` class must include the following:

### PART A Required Methods

1. `public Deck()`: Default constructor. Creates 52 unique `Card`s based on the potential values and suits
2. `public int numLeft()`: Returns how many "undealt" cards are in `Deck`
3. `public Card deal()`: Takes a card off the "top" of the `Deck` and returns it.
4. `public void shuffle()`: Restores the `Deck` to "full" and randomizes the order of the `Card`s to be dealt

You may include any other `private` methods and instance variables you think applicable. You should have nothing else that is `public` than what is listed above.

## PART B - `Blackjack.java`

For **Part B** you are going to use your newly made `Deck` to play a basic version of the game `Blackjack`.

### Simplified Blackjack Gameplay

The goal of the game is to get as close as possible to 21 points without going over. `[2-10]` are worth their face value as points, `[Jack, Queen, King]` are worth 10 points. To simplify the game, `[Ace]` is worth 11 points.

There are two *Players*, the *User* and the *Dealer*. Each are dealt two `Card`s, alternatiing with the *User* getting the first `Card` dealt.

If either *Player* scores 21 points in the opening hand, the game is over because they have scored a *Blackjack*. If both *Players* score a *Blackjack*, the game ends in a *Push* or tie.

If neither *Player* has *Blackjack*, then the *User* gets to choose to *Hit* or *Stay*. If they choose to *Hit* they are dealt another `Card` from the top of the `Deck`. If the new `Card` makes their points go over 21, they *Bust* and the game ends in their defeat. If they have 21 or less, they are prompted again to *Hit* or *Stay*. This continues until either the *User* *Bust*s or *Stay*s.

If the *User* *Stay*s, the *Dealer* now must *Hit* until their score is greater than or equal to 17, or they *Bust*. If they *Bust* the game is over and the *User* wins. Otherwise, if their score is 17 or higher, the `Card`s are flipped.

When the `Card`s are flipped, the *User* and the *Dealer*'s scores are compared. Whoever has the higher score wins. In the case of a tie, the game ends in a *Push*.

When the game ends, be sure to print the result *Blackjack*, *Bust*, *Win*, *Lose*, or *Push*. Then, prompt the *User* to play again. If they select yes, **do not** shuffle the `Deck` and start over. If not, thank them for their time and end the program. Only shuffle the `Deck` if the `Deck` runs out of `Card`s during gameplay.

### PART B Required Methods

1. `public Blackjack()`: This should instaniate any instance variables you have, especially your `Deck`. Don't forget, you are interacting with a *User* so you may need a `Scanner`.
2. `public void play()`: The method to be called to actually play a game. This is where you implement the flow of the **Gameplay**.
3. `public static int calcPoints(Card[] hand)`: This method takes an array of `Card`s and returns the amount of points that hand is worth. Does not alter parameters.
4. `public static String determineResult(Card[] userHand, Card[] dealerHand)`: Returns a `String` in one of the following formats: `"User Wins"`, `"User Loses"`, or `"User Pushes"`. Does not alter parameters.
5. `public static boolean isBust(Card[] hand)`: returns `true` if the hand is a *Bust*, `false` otherwise. Does not alter parameters.
6. `public static boolean isBlackjack(Card[] hand)`: returns `true` if the hand is a *Blackjack*, `false` otherwise. Does not alter parameters.
7. `public static boolean dealerKeepHitting(Card[] hand)`: return `true` if the dealer should keep hitting (score of hand is 16 or less), `false` otherwise. Does  not alter parameters.

You may include any other `private` methods and instance variables you think applicable. You should have nothing else that is `public` other than what is listed above.

### PART B Sample Run

*Note:* Wording does not have to match the given example exactly (have some fun with it!) but it should go through the same general flow, and account for upper/lowercase, and also for invalid input. Gameplay will be manually graded by Mr. Hsieh. He will try his best to break your game. 

```java
Welcome to Blackjack! What is your name? MrHsieh
Hello MrHsieh! I am Gambletron 5000! Let's play some cards.
Your Hand: Jack of Spades Ace of Clubs 
Dealer's Hand: 2 of Spades 5 of Spades 
Your Hand: Jack of Spades Ace of Clubs 
Dealer's Hand: 2 of Spades 5 of Spades 
Congrats MrHsieh you got a Blackjack!
Result: User Wins
Would you like to play again? (Y)es/(N)o: y
Your Hand: 9 of Hearts Queen of Clubs 
Dealer's Hand: 6 of Clubs 9 of Spades 
Would you like to (H)it or (S)tay: s
Your Hand: 9 of Hearts Queen of Clubs 
Dealer's Hand: 6 of Clubs 9 of Spades 5 of Clubs 
Result: User Loses
Would you like to play again? (Y)es/(N)o: asdoiyufwadsfg
Invalid input, try again
Would you like to play again? (Y)es/(N)o: j8h34r
Invalid input, try again
Would you like to play again? (Y)es/(N)o: Yes
Your Hand: 3 of Clubs 2 of Clubs 
Dealer's Hand: 3 of Hearts 5 of Hearts 
Would you like to (H)it or (S)tay: hit
Your new hand: 3 of Clubs 2 of Clubs 10 of Spades 
Would you like to (H)it or (S)tay: h
Your Hand: 3 of Clubs 2 of Clubs 10 of Spades Ace of Diamonds 
Dealer's Hand: 3 of Hearts 5 of Hearts 
MrHsieh I'm so sorry you busted!
Result: User Loses
Would you like to play again? (Y)es/(N)o: y
Your Hand: 10 of Diamonds King of Hearts 
Dealer's Hand: 8 of Hearts 5 of Diamonds 
Would you like to (H)it or (S)tay: oa;sdf
Invalid input, try again
Would you like to (H)it or (S)tay: stay
Your Hand: 10 of Diamonds King of Hearts 
Dealer's Hand: 8 of Hearts 5 of Diamonds 7 of Hearts 
Result: User Pushes
Would you like to play again? (Y)es/(N)o: no
Thanks for playing MrHsieh! Have a great day!
```

## PART C - `Yahtzee.java`

In Unit 5, you figured out how to make a `Dice`. A `Dice` class has been provided for you in this project. In **PART C** you are going to create a simplified version of the dice game `Yahtzee`.

### Simplified Yahtzee Gameplay

`Yahtzee` is a `Dice` game that allows players to roll 5 six-sided `Dice` in order to try to make sets and/or runs. There are two *Players*: the *User* and the *Computer*. Each *Player* gets 5 rounds. *Players* alternate rounds with the *User* going first. After the 5 rounds, display the total scores and who the winner is. Prompt the *User* to play again. If they decide to, clear the scores and start a new game. If they do not decide to, thank them for their time and end the program.

#### How a *User* round works

The *User* rolls five separate `Dice`. The results are displayed. The *User* can choose any, or none, of the 5 `Dice` to re-roll. If none, the *User* scores. If the *User* selected `Dice` to re-roll, only the selected `Dice` are re-rolled. The *User* may then select once more to re-roll any or no `Dice`. The *User* then scores for the round.

#### How a *Computer* turn works

The *Computer* rolls five separate `Dice`. The *Computer* can then use any logic you choose for deciding how to use its next two re-rolls. The *Computer* then scores for the round. If you are looking for a challenge, maximize the AI so that it regularly beats humans.

#### How scoring works

For our simplified version, a *Player* may have the following possible types of **scores**:

- **Unique**: When all 5 `Dice` are different 
- **Pair**: When any two `Dice` are matching
- **3 of a Kind**: When any 3 `Dice` are matching
- **4 of a Kind**: When any 4 `Dice` are matching
- **Yahtzee**: When all 5 `Dice` are matching

When a *Player* scores, they gain points equal to the sum of all 5 `Dice`. Once a *Player* uses a type of **score**, they cannot use the same type of **score** again for the rest of that game. To simplify your game, *Players* must take the largest possible match. For example, if I roll a **Yahtzee**, I must score it. On the next turn, if I roll another **Yahtzee**, I cannot use that score toward a **4 of a Kind** or lower, and I just waste the round.


### Required Methods

1. `public Yahtzee()`: This should instaniate any instance variables you have, especially your array of five `Dice`. Don't forget, you are interacting with a *User* so you may need a `Scanner`.
2. `public void play()`: The method to be called to actually play a game. This is where you implement the flow of the **Gameplay**.
3. `public static int getScore(int[] scores)`: Given an array of scores, return the sum of those scores. Do not alter parameters.
4. `public static boolean beenUsed(int[] scores, int scoreIndex)`: Return `true` if the score in `scores[scoreIndex]` has been used (`0` represents an unused score). Each index `scores` corresponds to a unique scoringg category
5. `public static Dice[] rollDice(Dice[] dice, boolean[] toRoll)`: `dice` and `toRoll` are parallel arrays. Return a new array where the `Dice` in `dice` that correspond to `true` in `toRoll` were rolled, and those that correspond to `false` were not. Do not alter parameters.
6. `public static int largestPossibleMatch(Dice[] dice)`: Returns an integer that corresponds to largest possible match of the `Dice`. Do not alter parameters. The expected return values are as folows:
    - **Unique** : 1
    - **Pair** : 2
    - **3 of a kind** : 3
    - **4 of a kind** : 4
    - **Yahtzee** : 5

You may include any other `private` methods and instance variables you think applicable. You should have nothing else that is `public` other than what is listed above. 

### PART C Sample Run

*Note:* Wording does not have to match the given example exactly (have some fun with it!) but it should go through the same general flow, and account for upper/lowercase, and also for invalid input. Gameplay will be manually graded by Mr. Hsieh. He will try his best to break your game. 

```java
Welcome to Yahtzee! What is your name? David
Hello David! I am Gametron 8000! Let's play some dice.
Rolled Dice: 1 5 1 6 4 
Would you like to re-roll dice 1 ? (1) (Y)es or (N)o: n
Would you like to re-roll dice 2 ? (5) (Y)es or (N)o: y
Would you like to re-roll dice 3 ? (1) (Y)es or (N)o: n
Would you like to re-roll dice 4 ? (6) (Y)es or (N)o: y
Would you like to re-roll dice 5 ? (4) (Y)es or (N)o: y
Rolled Dice: 1 5 1 5 6 
Would you like to re-roll dice 1 ? (1) (Y)es or (N)o: y
Would you like to re-roll dice 2 ? (5) (Y)es or (N)o: n
Would you like to re-roll dice 3 ? (1) (Y)es or (N)o: y
Would you like to re-roll dice 4 ? (5) (Y)es or (N)o: n
Would you like to re-roll dice 5 ? (6) (Y)es or (N)o: y
Rolled Dice: 5 5 5 5 3 
It's a Four of a Kind! 23 points are going in the Four of a Kind!
My turn!
Rolled Dice: 6 6 1 5 2 
Let's roll them all!
Rolled Dice: 3 1 6 2 1 
Let's roll them all!
Rolled Dice: 1 6 3 5 5 
It's a Pair! 20 points are going in the Pair!
Rolled Dice: 6 5 3 4 5 
Would you like to re-roll dice 1 ? (6) (Y)es or (N)o: YES
Would you like to re-roll dice 2 ? (5) (Y)es or (N)o: NO
Would you like to re-roll dice 3 ? (3) (Y)es or (N)o: yEs
Would you like to re-roll dice 4 ? (4) (Y)es or (N)o: YeS
Would you like to re-roll dice 5 ? (5) (Y)es or (N)o: nOpe
Invalid input, try again
Would you like to re-roll dice 5 ? (5) (Y)es or (N)o: no
Rolled Dice: 2 5 4 4 5 
Would you like to re-roll dice 1 ? (2) (Y)es or (N)o: yes
Would you like to re-roll dice 2 ? (5) (Y)es or (N)o: no
Would you like to re-roll dice 3 ? (4) (Y)es or (N)o: yes
Would you like to re-roll dice 4 ? (4) (Y)es or (N)o: yes
Would you like to re-roll dice 5 ? (5) (Y)es or (N)o: no
Rolled Dice: 1 5 5 4 5 
It's a Three of a Kind! 20 points are going in the Three of a Kind!
My turn!
Rolled Dice: 1 1 5 2 4 
Let's roll them all!
Rolled Dice: 3 3 2 6 2 
Let's roll them all!
Rolled Dice: 5 3 2 1 2 
Oh no! All applicable slots were already used! 13 points are just wasted!
Rolled Dice: 5 1 1 1 2 
Would you like to re-roll dice 1 ? (5) (Y)es or (N)o: n
Would you like to re-roll dice 2 ? (1) (Y)es or (N)o: y
Would you like to re-roll dice 3 ? (1) (Y)es or (N)o: y
Would you like to re-roll dice 4 ? (1) (Y)es or (N)o: y
Would you like to re-roll dice 5 ? (2) (Y)es or (N)o: y
Rolled Dice: 5 1 2 6 2 
Would you like to re-roll dice 1 ? (5) (Y)es or (N)o: n
Would you like to re-roll dice 2 ? (1) (Y)es or (N)o: y
Would you like to re-roll dice 3 ? (2) (Y)es or (N)o: y
Would you like to re-roll dice 4 ? (6) (Y)es or (N)o: y
Would you like to re-roll dice 5 ? (2) (Y)es or (N)o: y
Rolled Dice: 5 2 2 4 3 
It's a Pair! 16 points are going in the Pair!
My turn!
Rolled Dice: 5 3 5 2 5 
Let's roll them all!
Rolled Dice: 2 3 1 3 2 
Let's roll them all!
Rolled Dice: 1 1 3 1 2 
It's a Three of a Kind! 8 points are going in the Three of a Kind!
Rolled Dice: 6 2 1 2 3 
Would you like to re-roll dice 1 ? (6) (Y)es or (N)o: y
Would you like to re-roll dice 2 ? (2) (Y)es or (N)o: y
Would you like to re-roll dice 3 ? (1) (Y)es or (N)o: y
Would you like to re-roll dice 4 ? (2) (Y)es or (N)o: y
Would you like to re-roll dice 5 ? (3) (Y)es or (N)o: y
Rolled Dice: 6 6 6 6 2 
Would you like to re-roll dice 1 ? (6) (Y)es or (N)o: n
Would you like to re-roll dice 2 ? (6) (Y)es or (N)o: n
Would you like to re-roll dice 3 ? (6) (Y)es or (N)o: n
Would you like to re-roll dice 4 ? (6) (Y)es or (N)o: n
Would you like to re-roll dice 5 ? (2) (Y)es or (N)o: YES
Rolled Dice: 6 6 6 6 2 
Oh no! All applicable slots were already used! 26 points are just wasted!
My turn!
Rolled Dice: 2 1 1 6 1 
Let's roll them all!
Rolled Dice: 6 2 1 1 1 
Let's roll them all!
Rolled Dice: 5 6 3 5 5 
Oh no! All applicable slots were already used! 24 points are just wasted!
Rolled Dice: 2 4 5 2 4 
Would you like to re-roll dice 1 ? (2) (Y)es or (N)o: n
Would you like to re-roll dice 2 ? (4) (Y)es or (N)o: n
Would you like to re-roll dice 3 ? (5) (Y)es or (N)o: n
Would you like to re-roll dice 4 ? (2) (Y)es or (N)o: n
Would you like to re-roll dice 5 ? (4) (Y)es or (N)o: n
Oh no! All applicable slots were already used! 17 points are just wasted!
My turn!
Rolled Dice: 6 3 4 6 1 
Let's roll them all!
Rolled Dice: 4 6 2 3 4 
Let's roll them all!
Rolled Dice: 4 1 4 4 1 
Oh no! All applicable slots were already used! 14 points are just wasted!
David's final score: 59
Computer's final score: 28
Congratulations David you win!
Would you like to play again? (Y)es/(N)o: no
Thanks for playing David! Have a great day!
```

## BONUS: Real versions of the games

If you have time and are looking for a challenge, implement the full Blackjack game or the full Yahtzee game.
For blackjack, the main change would be in how scores of hands are calculated (Ace is worth 11 or 1).
For Yahtzee, the scoring methods get a bit more complicated, but the general flow of the game is the same. 
You can find the rules for both games online. 


