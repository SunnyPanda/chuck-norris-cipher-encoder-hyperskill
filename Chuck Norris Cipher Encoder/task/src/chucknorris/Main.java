package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input string:");
        String str = in.nextLine();

        System.out.println("The result:");
        for (char ch : str.toCharArray()) {
            String binary = String.format("%7s", Integer.toBinaryString(ch)).replace(" ", "0");
            System.out.printf("%c = %s\n", ch, binary);
        }
    }
}