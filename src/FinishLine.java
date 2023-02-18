import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class FinishLine {
    private static ArrayList<String> p1List = new ArrayList<String>(Arrays.asList("X", "2", "3", "4", "5", "6", "7", "8", "9", "10", "WIN"));
    private static ArrayList<String> p2List = new ArrayList<String>(Arrays.asList("X", "2", "3", "4", "5", "6", "7", "8", "9", "10", "WIN"));
    private static int player1Idx = 0;
    private static int player2Idx = 0;

    private static boolean players1Turn = false;
    private static int dice1 = 0;
    private static int dice2 = 0;


    public FinishLine() { }

    public static ArrayList<String> getP1List() {
        return p1List;
    }
    public static ArrayList<String> getP2List() {
        return p2List;
    }

    public static int getDice1() {
        return dice1;
    }

    public static int getDice2() {
        return dice2;
    }

    public static void startGame() {
        Scanner s = new Scanner(System.in);
        Board boardObj = new Board();
        while ((player1Idx < 10) && (player2Idx < 10)) {
            //Sets up the board
            boardObj.printP1Board();
            boardObj.printP2Board();
            boardObj.printInstructions();
            //Waits for User Input
            String strIns = boardObj.getInstructions();
            String ans = s.nextLine();
            while (!ans.equals("r")) {
                System.out.println(strIns);
                ans = s.nextLine();
            }
            //Rolls Dice
            dice1 = Dice.rollDice();
            dice2 = Dice.rollDice();
            boardObj.printResults();
            //Condtion
            if (players1Turn) {
                if ((dice1 == player1Idx + 1) || (dice2 == player1Idx + 1) || (dice1 + dice2 == player1Idx +1)) {
                    p1List.set(player1Idx,player1Idx+1 + "");
                    p1List.set(player1Idx+1,"X");
                    player1Idx++;
                    boardObj.printCanGo();
                } else {
                    boardObj.printCannotGo();
                }
            } else {
                if ((dice1 == player2Idx + 1) || (dice2 == player2Idx + 1) || (dice1 + dice2 == player2Idx +1)) {
                    p2List.set(player2Idx,player2Idx+1 + "");
                    p2List.set(player2Idx+1,"X");
                    player2Idx++;
                    boardObj.printCanGo();
                } else {
                    boardObj.printCannotGo();
                }
            }

        }
        if (player1Idx > 9) {
            boardObj.printP1Wins();
        } else if (player2Idx > 9) {
            boardObj.printP2Wins();
        }
    }
    public static String calculatePlayersTurn() {
        players1Turn = !players1Turn;
        if (players1Turn) {
            return "Player 1";
        } else {
            return "Player 2";
        }
    }
}
