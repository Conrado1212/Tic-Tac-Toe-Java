package stage4;

import java.util.Scanner;

public class Tic4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: " );

        String iinput = scanner.nextLine().replace("\"","");
        char[][] field = createField(iinput.replace('_',' '));
        printfield(field);

        boolean move = false;
        do{
            System.out.print("Enter the coordinates: ");
            String go = scanner.nextLine();
            move = canMove(go,field,'X');
        }while(!move);

        printfield(field);
    }


    private static char[][] createField(String input) {
        char[] matrix = input.toCharArray();
        return  new char[][]{new char[]{matrix[0],matrix[1],matrix[2]}
                ,new char[]{matrix[3],matrix[4],matrix[5]}
        ,new char[]{matrix[6],matrix[7],matrix[8]}};
    }

    private static void printfield(char[][] field) {
        System.out.println("---------");
        for(char[] position : field){
            for(int i = 0;i < position.length;i++){
                if(i == 0){
                    System.out.print("| ");
                    System.out.print(position[i]+ " ");
                }else if(i == position.length -1){
                    System.out.print(position[i]);
                    System.out.print(" |");
                }else{
                    System.out.print(position[i] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    private static boolean canMove(String  go, char[][] field, char symbol) {
        if(!go.matches("\\d\\s\\d")){
            System.out.println("You should only use numbers!");
            return  false;
        }

        go = go.replaceAll("\\s","");

        for(char x: go.toCharArray()){
            int n = Character.getNumericValue(x);
            if(n > 3 || n < 1){
                System.out.println("Coordinates should be from 1 to 3");
                return false;
            }
        }

        int moves = Integer.parseInt(go);
        switch (moves){
            case 11:
                return fillField(field,2,0);

            case 12:
                return fillField(field,1,0);

            case 13:
                return fillField(field,0,0);

            case 21:
                return  fillField(field,2,1);

                case 22:
                    return fillField(field,1,1);

            case 23:
                return fillField(field,0,1);

            case  31:
                return fillField(field,2,2);

            case 32:
                return fillField(field,1,2);

            case 33:
                return fillField(field,0,2);
            default:
                return false;

        }
    }

    private static boolean fillField(char[][] field, int i, int i1) {
        if(field[i][i1] == 'X' || field[i][i] == 'O'){
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
        field[i][i1] = 'X';
        return true;
    }
    }


