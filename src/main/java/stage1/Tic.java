package stage1;

import java.util.Scanner;

public class Tic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [][]tic = new String[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                tic[i][j]= scanner.nextLine();
                System.out.println(tic[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("X O X");
        System.out.println("O X O");
        System.out.println("X X O");
    }
}
/* public static void main(String[] args) {
        // write your code here
        int n = 3;
        final Random random = new Random();
        String [] x_o  = {"O" , "X"};
        String[][] ticTacToe = new String[n][n];
        for (int i = 0; i < ticTacToe.length; i++){
            for (int j = 0; j < ticTacToe[i].length; j++){
                String c = x_o[(int) (Math.random() * 2)];
                ticTacToe[i][j] = c;
                System.out.print(ticTacToe[i][j] + " ");
            }
            System.out.println();
        }

 */