package Testing2;

public enum Cards {

    DECK("Total No of Cards",52),
    BLACKJACK("Value of Blackjack", 21),
    BACKSIDE("Backside", 0),
    SPADES("Spades",1),
    HEARTS("Hearts",2),
    DIMONDS("Dimonds",3),
    CLOVERS("Clovers",4),
    CARDSPOSSIBLE("Total Cards possible in hand", 6);

    public final String label;
    public final int value;

    private Cards(String label,int value) {
        this.label = label;
        this.value = value;
    }


}
