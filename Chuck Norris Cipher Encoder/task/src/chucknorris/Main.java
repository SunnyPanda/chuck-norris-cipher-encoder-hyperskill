package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input string:");
        String str = in.nextLine();

        for (char ch : str.toCharArray()) {
            System.out.print(ch + " ");
        }
    }
}