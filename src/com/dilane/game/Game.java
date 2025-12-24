package com.dilane.game;

import java.util.Arrays;

import static com.dilane.game.StringConstant.Line_Separator;
import static com.dilane.game.StringConstant.Space;

public class Game {
    private char[][] grid = new char[][]{
            {'.', '.', '.'},
            {'.', '.', '.'},
            {'.', '.', '.'}
    };



    public void processInput(Player player, int inputUser) throws GameInvalidInputException {
        var row = (inputUser-1)/3;
        var column = (inputUser-1)%3;
        if (grid[row][column] == '.'){
            if (player.equals(Player.Premier)){
                grid[row][column]='X';
            }else {
                grid[row][column] = 'O';
            }
        }else {
            throw new GameInvalidInputException("La case est déjà occupée, veuillez saisir un autre chiffre !");
        }
    }

    public boolean checkWim() {
        for (int i = 0; i<3; i++){
            var checkLine = grid[i][0] == grid[i][1] && grid[i][1]==grid[i][2] && grid[i][2] !='.';
            var checkColumn = grid[0][i] == grid[1][i] && grid[1][i]==grid[2][i] && grid[2][i] !='.';
            if (checkLine || checkColumn){
                return true;
            }
        }

        var checkDiagonal1 = grid[0][0]==grid[1][1] && grid[1][1] == grid[2][2] && grid[2][2] != '.';
        var checkDiagonal2 = grid[0][2]==grid[1][1] && grid[1][1] == grid[2][0] && grid[2][0] != '.';
        if (checkDiagonal1 || checkDiagonal2){
            return true;
        }
        return false;

    }

    @Override
    public String toString() {
        final var builder = new  StringBuilder();
        builder.append("Grille du Morpion : ").append(Line_Separator);
        for (char[] lines : grid){
            for (char cell : lines){
                builder.append(Space).append(cell).append(Space);
            }
            builder.append(Line_Separator);
        }
        return builder.toString();
    }

    public boolean checkDraw() {
        for (char[] row : grid){
            for (char cell :row){
                if (cell == '.'){
                    return false;
                }
            }
        }
        return true;
    }
}
