package stage2;

import java.util.Scanner;

public class Tac {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("Enter cells: " + input);
        System.out.println("---------");
        for(int i =0;i<3;i++){
            System.out.print("| ");
            for(int j=0;j<3;j++){
                System.out.printf("%s ", input.charAt(3 * i + j));
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}
/* public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        char[] arr = scanner.nextLine().toCharArray();
        for (int i = 0; i < 9; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < 9; i+=3) {
            System.out.println(String.format("| %c %c %c |", arr[i], arr[i+1], arr[i+2]));
        }
        for (int i = 0; i < 9; i++) {
            System.out.print("-");
        }
        
 */