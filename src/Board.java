public class Board {
    private String instructions;

    public Board() {
        instructions = "";
    }

    public String getInstructions() {
        return instructions;
    }

    public void printP1Board() {
        System.out.println("Player 1's Trail");
        System.out.println(FinishLine.getP1List());
    }

    public void printP2Board() {
        System.out.println("Player 2's Trail");
        System.out.println(FinishLine.getP2List());
    }

    public void printInstructions() {
        instructions = "It is " + FinishLine.calculatePlayersTurn() + "'s turn. Type \"r\" to roll 2 dices:";
        System.out.println(instructions);
    }

    public void printResults() {
        System.out.println("You rolled a " + FinishLine.getDice1() + " and " + FinishLine.getDice2() + "!");
    }

    public void printCannotGo() {
        System.out.println("Unfortunately, this is not enough to go.");
    }
    public void printCanGo() {
        System.out.println("You proceeded to the next value.");
    }
    public void printP1Wins() {
        System.out.println("Player 1 Wins!");
    }
    public void printP2Wins() {
        System.out.println("Player 2 Wins!");
    }
}
