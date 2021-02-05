import java.util.Scanner;

public class CoinTossGame {

    private Scanner scanner;

    public static void main(String args[]) {
        CoinTossGame game = new CoinTossGame();
        game.scanner = new Scanner(System.in);

        Player player1 = new Player(game.askPlayerName());
        player1.setGuess(game.askGuess());

        Player player2 = new Player(game.askPlayerName());
        player2.setGuess(game.setPlayerTwoGuess(player1.getGuess()));

        Coin coin = new Coin();
        coin.flip();
        System.out.println("Coin side: " + coin.getSide());
        game.setWinner(coin, player1, player2);
        game.scanner.close();
    }

    private String askPlayerName() {
        System.out.println("Enter the first player's name: ");
        return scanner.nextLine();
    }

    private String askGuess() {
        String prompt = String.format("%s or %s?", Coin.HEADS, Coin.TAILS);
        System.out.println(prompt);
        String guess = scanner.nextLine();

        while (!guess.equalsIgnoreCase(Coin.HEADS) && !guess.equalsIgnoreCase(Coin.TAILS)) {
            System.out.println("Invalid data. Please try again!" + prompt);
            guess = scanner.nextLine();
        }
        return guess;
    }

    private String setPlayerTwoGuess(String guess) {
        if (guess.equalsIgnoreCase(Coin.HEADS))
            return Coin.TAILS;
        return Coin.HEADS;
    }

    private void setWinner(Coin coin, Player player1, Player player2) {
        if (coin.getSide().equalsIgnoreCase(player1.getGuess()))
            System.out.println(player1.getName() + " has won!");
        else
            System.out.println(player2.getName() + " has won!");
    }
}
