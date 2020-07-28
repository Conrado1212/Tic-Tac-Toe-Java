package stage3;

import java.util.ArrayList;
import java.util.Scanner;

public class Toe {
    private static int x;
    private static int o;

    public static void main(String[] args) {

    userInput();

    }
    public static ArrayList<Character> userInput() {
        ArrayList<Character> field = new ArrayList<Character>();
        ArrayList<Character> signs = new ArrayList<Character>();
        signs.add('X');
        signs.add('O');
        signs.add('_');

        Scanner sc = new Scanner(System.in);
        ArrayList<Character> userField = new ArrayList<Character>();

        System.out.println("Draw your field:");

        //while (field.size() < 9) {
            char input = sc.nextLine().toUpperCase().charAt(0);
            if (signs.contains(input)) {
                if (input == 'X') {
                    x += 1;
                } else if (input == 'O') {
                    o += 1;
                }
                field.add(input);
            } else {
                System.out.println("You can only input O, X, OR _");
            }
     //   }
        return field;
    }
    
}
