package stage4;

import java.util.Scanner;

public class TIc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String Input = scanner.nextLine().replace("\"", "");
        char[][] field = createField(Input.replace('_', ' '));
        printField(field);

        boolean move = false;
        do {
            System.out.print("Enter the coordinates: ");
            String go = scanner.nextLine();
            move = canMove(go, field, 'X');

        } while (!move);

        printField(field);


    }

    private static char[][] createField(String input) {
        char[] in = input.toCharArray();
        return new char[][]{new char[]{in[0], in[1], in[2]}
                , new char[]{in[3], in[4], in[5]}
                , new char[]{in[6], in[7], in[8]}};
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
                System.out.println("Coordinates should be from 1 to 3");
                return false;
            }
        }
        int moves = Integer.parseInt(go);

        switch (moves) {
            case 11:
                return fillField(field, 2, 0);
            case 12:
                return fillField(field, 1, 0);
            case 13:
                return fillField(field, 0, 0);
            case 21:
                return fillField(field, 2, 1);
            case 22:
                return fillField(field, 1, 1);
            case 23:
                return fillField(field, 0, 1);
            case 31:
                return fillField(field, 2, 2);
            case 32:
                return fillField(field, 1, 2);
            case 33:
                return fillField(field, 0, 2);
            default:
                return false;
        }
    }

    private static boolean fillField(char[][] field, int i1, int i2) {
        if (field[i1][i2] == 'X' || field[i1][i2] == 'O') {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }

        field[i1][i2] = 'X';
        return true;
    }
}


/*
    static Scanner scanner = new Scanner(System.in);
    static char[][] board = new char[3][3];
    static int Xcord, Ycord;

    public static void main(String[] args) {
        getInput();
        drawTable(board);
        getCoordinates();
        drawTable(board);
    }

    static void getInput(){ // gets matrix input from user as String
        System.out.println("Enter cells: ");
        String cells = scanner.next();
        fillTable(board, cells);
    }
    static void getCoordinates(){ // gets coordinates and checks whether it satisfies specific conditions
        System.out.println("Enter coordinates: ");
        while(true){

            while(!(scanner.hasNextInt()) ){
                System.out.println("You should enter numbers!");
            }

            Xcord = scanner.nextInt();
            Ycord = scanner.nextInt();

            if(Xcord > 3 || Xcord < 1 || Ycord > 3 || Ycord < 1){
                System.out.println("Coordinates should be from 1 to 3!");
            } else {
                ninetyRight(board);
                if(isEmpty(board, Xcord, Ycord)){
                    fillValue(board, 'X', Xcord, Ycord);
                    ninetyLeft(board);
                    break;
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
                ninetyLeft(board);
            }
        }
    }
    static void drawTable(char[][] arr){    // draws matrix as a table
        System.out.println("---------");
        for(int i = 0; i < 3; i++){
            System.out.print("| ");
            for(int j = 0; j < 3; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    static char[][] fillTable(char[][] arr, String input){ // fills the whole matrix by the String put by user
        int counter = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                arr[i][j] = input.charAt(counter);
                counter++;
            }
        }
        return arr;
    }

    static char[][] fillValue(char[][] arr, char value, int X, int Y){ // fills matrix with a specific value
        arr[X-1][Y-1] = value;
        return arr;
    }
     static char[][] ninetyRight(char[][] arr){ // rotates matrix to 90 degree right
        char[][] carr = new char[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                carr[i][j] = arr[i][j];
            }
        }

        int k = 2;
        for(int i = 0; i < 3; i++){
            arr[0][i] = carr[k][0];
            arr[1][i] = carr[k][1];
            arr[2][i] = carr[k][2];
            k--;
        }
        return arr;
    }

    static char[][] ninetyLeft(char[][] arr){ // rotates matrix to 90 degree left
        for(int i = 0; i < 3; i++){
            ninetyRight(arr);
        }
        return arr;
    }

    static boolean isEmpty(char[][] arr, int X, int Y){  // checks whether the chosen coordinates are empty
        return (arr[X-1][Y-1] == ' ' || arr[X-1][Y-1] == '_');
    }
}

   */