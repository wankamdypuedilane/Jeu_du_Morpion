import com.dilane.game.Game;
import com.dilane.game.GameInvalidInputException;
import com.dilane.game.Player;

import java.util.HashMap;
import java.util.Scanner;

import static com.dilane.game.StringConstant.BLANK;

public  class Main {
    public static void main(String[] args) {
        var game = new Game();

       var player = Player.Premier;
       var players = initPlayers();

        while(true){
            try {
                System.out.println(game);
                System.out.println(players.get(player) + ", entrez un chiffre entre 1 et 9 : ");
                final var inputUser = getInputUser();
                game.processInput(player, inputUser);
                if (game.checkWim()){
                    System.out.println(players.get(player)+" a gagné la partie !");
                    System.out.println(game);
                }
                if (game.checkDraw()){
                    System.out.println("Personne n'a gagné la partie !");
                    System.out.println(game);
                }
                if (game.checkWim() || game.checkDraw()){
                    var replayAnswer = scanLetter("Voulez vous rejouer ?");
                    if(replayAnswer == 'o' || replayAnswer == 'O' || replayAnswer == 'y' || replayAnswer == 'Y'){
                        game = new Game();
                    }else{
                        break;
                    }
                }
                player = nextPlayer(player);
            }catch (GameInvalidInputException e){
                System.out.println(e.getMessage());
            }catch (NumberFormatException e){
                System.out.println("Vous devez saisir un chiffre entre 1 et 9 ");
            }
        }
    }

    private static char scanLetter(String question) {
        final var scanner = new Scanner(System.in);
        Character letter = null;
        do {
            System.out.println(question);
            var input = scanner.nextLine();
            if(input.length() == 1){
                letter = input.charAt(0);
            }
        }while(letter == null);
        return letter;

    }


    private static HashMap< Player, String> initPlayers() {
        var players = new HashMap<Player, String>();
        var scanner = new Scanner(System.in);
        do {
            System.out.println("Veuillez saisir le nom du premier joueur: ");
            players.put(Player.Premier, scanner.nextLine());
        }while(players.get(Player.Premier).equals(BLANK));
        do {
            System.out.println("Veuillez saisir le nom du deuxième joueur: ");
            players.put(Player.Deuxième, scanner.nextLine());
        }while(players.get(Player.Deuxième).equals(BLANK));

        return players;
    }

    private static int  getInputUser() throws GameInvalidInputException {
        final var scanner = new Scanner(System.in);
        var input = scanner.nextLine();
        if (input.equals("exit")  || input.equals("quit")){
            System.exit(0);
        }
        var inputEntier = Integer.parseInt(input);
        if (inputEntier < 1 || inputEntier > 9){
            throw new GameInvalidInputException("Le chiffre doit être entre 1 et 9");
        }
        return inputEntier;
    }

    private static Player nextPlayer(Player player) {
        if (player == Player.Premier){
            return Player.Deuxième;
        } else {
            return Player.Premier;
        }
    }
}