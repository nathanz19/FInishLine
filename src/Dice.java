public class Dice {
    private static int diceVal = 0;
    public Dice() { }
    public static int getDiceVal() {
        return diceVal;
    }
    public static int rollDice() {
        diceVal = (int)((Math.random() * 6) + 1);
        return diceVal;
    }

}
