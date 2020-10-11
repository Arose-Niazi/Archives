package Testing2;

import javafx.scene.Group;
import javafx.scene.control.Alert;

import java.util.Random;

import static Testing2.Cards.*;
import static Testing2.GameStates.*;

public class Working {

    private static boolean gameStarted;
    private boolean dealerStand;
    private boolean playerStand;

    private CardsData cards[] = CardsData.values();
    private boolean cardUsed[] = new boolean[DECK.value];
    private CardsData dealersCard[] = new CardsData[CARDSPOSSIBLE.value];
    private CardsData playersCard[] = new CardsData[CARDSPOSSIBLE.value];

    private Main m;
    Group root = new Group();

    Random rand = new Random();

    public Working(Main m,Group root) {
        this.m = m;
        this.root = root;
    }

    public void startGame()
    {
        m.resetDealersCards();
        m.resetPlayersCards();
        gameStarted=true;
        playerStand=dealerStand = false;
        for(int i=0; i<DECK.value; i++) cardUsed[i]=false;
        for(int i=0; i<2; i++)
        {
            dealersCard[i] = getRandomCard();
            m.addDealersCard(dealersCard[i]);
            playersCard[i] = getRandomCard();
            m.addPlayersCard(playersCard[i]);
        }
    }

    private CardsData getRandomCard()
    {
        CardsData c = cards[rand.nextInt(DECK.value) + 1];
        if(cardUsed[c.ordinal() - 1]) return getRandomCard();
        cardUsed[c.ordinal() - 1] = true;
        return c;
    }

    private int Count(CardsData c[])
    {
        int sum=0,ace=0;
        for(int i=0; i<CARDSPOSSIBLE.value; i++)
        {
            try{
                if(c[i].value == 1) ace++;
                if(c[i].value > 10) sum+=10;
                else sum+=c[i].value;
            }
            catch (NullPointerException e)
            {
                System.out.println("Hue Hue Hue Handled like a boss!");
                break;
            }
        }
        while(ace > 0)
        {
            if(sum+10 > BLACKJACK.value) break;
            sum+=10;
            ace--;
        }
        return sum;
    }

    private void CheckForBlackJack()
    {
        int dsum;
        dsum=Count(dealersCard);
        int psum=Count(playersCard);;
        if(dsum == BLACKJACK.value)
        {
            if(psum == BLACKJACK.value)
            {
                endGame(DRAW);
                return;
            }
            endGame(DEALER_BJ);
            return;
        }
        if(psum == BLACKJACK.value)
        {
            endGame(BJ);
            return;
        }
        if(dsum > BLACKJACK.value)
        {
            if(psum > BLACKJACK.value)
            {
                endGame(BJ);
                return;
            }
            endGame(WIN);
            return;
        }
        if(psum > BLACKJACK.value)
        {
            endGame(BUSTED);
            return;
        }
        if(playerStand == true && dealerStand == true)
        {
            if(psum > dsum)
            {
                endGame(WIN);
                return;
            }
            if(psum == dsum)
            {
                endGame(DRAW);
                return;
            }
            if(psum < dsum)
            {
                endGame(LOST);
                return;
            }
        }
    }

    public void endGame(GameStates condition)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(m.getS());
        switch (condition)
        {

            case DRAW:
            {

                alert.setTitle("Game Over!");
                alert.setHeaderText("Draw!");
                alert.setContentText("OOPS! The match ended with a draw\n\tYour Score: " + Count(playersCard) + "\n\tDealers Score: "+ Count(dealersCard));
                break;
            }
            case WIN:
            {

                alert.setTitle("Game Over!");
                alert.setHeaderText("Victory!");
                alert.setContentText("Congrats You have won the game!\n\tYour Score: " + Count(playersCard) + "\n\tDealers Score: "+ Count(dealersCard));
                break;
            }
            case LOST:
            {
                alert.setTitle("Game Over!");
                alert.setHeaderText("LOOSER!");
                alert.setContentText("OHO! Looks like you were not up to the challenge\n\tYour Score: " + Count(playersCard) + "\n\tDealers Score: "+ Count(dealersCard));
                break;
            }
            case BJ:
            {
                alert.setTitle("Game Over!");
                alert.setHeaderText("BLACKJACK!!!");
                alert.setContentText("WOOHA! You are amazing!\n\tYour Score: BLACKJACK"  + "\n\tDealers Score: "+ Count(dealersCard));
                break;
            }
            case BUSTED:
            {
                alert.setTitle("Game Over!");
                alert.setHeaderText("BUSTED!");
                alert.setContentText("Eh? You can't cross BLACKJACK!\n\tYour Score: " + Count(playersCard) + "\n\tDealers Score: "+ Count(dealersCard));
                break;
            }
            case DEALER_BJ:
            {
                alert.setTitle("Game Over!");
                alert.setHeaderText("BLACKJACK-ED!!");
                alert.setContentText("YOU JUST GOT BLACKJACK-ED!!\n\tYour Score: " + Count(playersCard) + "\n\tDealers Score: BLACKJACK!");
                break;
            }
        }
        m.flipDealersCards(dealersCard);
        m.endGame();
        alert.showAndWait();
        gameStarted=false;
    }

    public void playerCalledHit()
    {
        int i=0;
        for(; i<CARDSPOSSIBLE.value; i++)
        {
            try{
                int v = playersCard[i].value;
            }
            catch (NullPointerException e)
            {
                playersCard[i] = getRandomCard();
                break;
            }
        }
        if(i == CARDSPOSSIBLE.value) playerStand = true;
        else m.addPlayersCard(playersCard[i]);
        dealersTurn();
    }

    private void dealersTurn()
    {

        if(Count(dealersCard) < 13)
        {
            int i=0;
            for(; i<CARDSPOSSIBLE.value; i++)
            {
                try{
                    int v = dealersCard[i].value;
                }
                catch (NullPointerException e)
                {
                    dealersCard[i] = getRandomCard();
                    break;
                }
            }

            if(i == CARDSPOSSIBLE.value) dealerStand=true;
            else m.addDealersCard(dealersCard[i]);
            if(playerStand)
            {
                dealersTurn();
                return;
            }
        }
        else dealerStand=true;
        CheckForBlackJack();
        if(!playerStand && gameStarted) m.playersTurn();
    }

    public static boolean isGameStarted() {
        return gameStarted;
    }

    public void playerStands()
    {
        playerStand=true;
        dealersTurn();
    }

}
