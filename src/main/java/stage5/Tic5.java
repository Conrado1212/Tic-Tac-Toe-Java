package stage5;

import java.util.Arrays;
import java.util.Scanner;

public class Tic5 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] field = createField();
        printField(field);

        Gamer gamer = new Gamer('G');
        boolean exit = false;
        boolean move = false;
        String status = getStatus(field);

        do {
            gamer.whichGamer();
            do {
                char currentPlayer = gamer.getXorO();
                System.out.println(currentPlayer);
                System.out.print("Enter the coordinates: ");
                String go = scanner.nextLine();

                move = canMove(go, field, currentPlayer);

            } while (!move);
            printField(field);
            status = getStatus(field);

            if (!status.equals("Game not finished")) {
                exit = true;
            }
        } while (!exit);
        System.out.println(status);
    }

    private static char[][] createField() {
        char[] matrix = new char[9];
        Arrays.fill(matrix, ' ');
        return new char[][]{new char[]{matrix[0], matrix[1], matrix[2]}
                , new char[]{matrix[3], matrix[4], matrix[5]}
                , new char[]{matrix[6], matrix[7], matrix[8]}};
    }

    private static void printField(char[][] field) {
        System.out.println("---------");
        for (char[] position : field) {
            for (int i = 0; i < position.length; i++) {
                if (i == 0) {
                    System.out.print("| ");
                    System.out.print(position[i] + " ");
                } else if (i == position.length - 1) {
                    System.out.print(position[i]);
                    System.out.print(" |");
                } else {
                    System.out.print(position[i] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    private static boolean canMove(String go, char[][] field, char symbol) {
        if (!go.matches("\\d\\s\\d")) {
            System.out.println("You should enter numbers!");
            return false;
        }

        go = go.replaceAll("\\s", "");

        for (char x : go.toCharArray()) {
            int n = Character.getNumericValue(x);
            if (n > 3 || n < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
                return false;
            }
        }

        int moves = Integer.parseInt(go);

        switch (moves) {
            case 11:
                return fillField(field, 2, 0, symbol);
            case 12:
                return fillField(field, 1, 0 , symbol);
            case 13:
                return fillField(field, 0, 0, symbol);
            case 21:
                return fillField(field, 2, 1, symbol);
            case 22:
                return fillField(field, 1, 1, symbol);
            case 23:
                return fillField(field, 0, 1, symbol);
            case 31:
                return fillField(field, 2, 2, symbol);
            case 32:
                return fillField(field, 1, 2, symbol);
            case 33:
                return fillField(field, 0, 2, symbol);
            default:
                return false;
        }
    }

    private static boolean fillField(char[][] field, int i, int i1, char symbol) {
        if (field[i][i1] == 'X' || field[i][i1] == 'O') {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }

        field[i][i1] = symbol;
        return true;
    }

    private static String getStatus(char[][] field) {

        String xOro= "";


        int x = 0;
        int o = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == 'X') {
                    x++;
                }
                if (field[i][j] == 'O') {
                    o++;
                }
            }
        }

        boolean fullField = (x + o) == 9;


        boolean winX = false;
        boolean winO = false;


        for (int z = 0; z < 8; z++) {
            String input = null;
            switch (z) {
                case 0:
                    input = "" + field[0][0] + field[0][1] + field[0][2];

                    break;
                case 1:
                    input = "" + field[1][0] + field[1][1] + field[1][2];

                    break;
                case 2:
                    input = "" + field[2][0] + field[2][1] + field[2][2];

                    break;
                case 3:
                    input = "" + field[0][0] + field[1][0] + field[2][0];

                    break;
                case 4:
                    input = "" + field[0][1] + field[1][1] + field[2][1];

                    break;
                case 5:
                    input = "" + field[0][2] + field[1][2] + field[2][2];

                    break;
                case 6:
                    input = "" + field[0][0] + field[1][1] + field[2][2];

                    break;
                case 7:
                    input = "" + field[0][2] + field[1][1] + field[2][0];

                    break;
            }
            if (input.equals("XXX")) {
                winX = true;
            }
            if (input.equals("OOO")) {
                winO = true;
            }
        }


        if (!winX && !winO && !fullField) {
            return "Game not finished";
        }



        if (!winX && !winO && fullField) {
            return "Draw";
        }

        if (winX && !winO) {
            return "X wins";
        }

        if (!winX && winO) {
            return "O wins";
        }


        if ((winX && winO) || (x - o >= 2 || o - x >= 2)) {
            return "Impossible";
        }

        return xOro;
    }



}
class Gamer {

    char XorO;

    public Gamer(char XorO) {
        this.XorO = XorO;
    }

    public void setXorO(char XorO) {
        this.XorO = XorO;
    }

    public void whichGamer(){
        switch (this.XorO){
            case 'G':
            case 'O':
                this.setXorO('X');
                break;
            case 'X':
                this.setXorO('O');
                break;
        }
    }

    public char getXorO() {
        return XorO;
    }
}

