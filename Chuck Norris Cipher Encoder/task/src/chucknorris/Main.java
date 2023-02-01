package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input string:");
        String str = in.nextLine();

        StringBuilder sbBinary = new StringBuilder();
        for (char ch : str.toCharArray()) {
            sbBinary.append(String.format("%7s", Integer.toBinaryString(ch)).replace(" ", "0"));
        }

        StringBuilder result = new StringBuilder();
        char value = 'x';
        for (char ch : sbBinary.toString().toCharArray()) {
            if (ch != value) {
                value = ch;
                result.append(" ");
                switch (ch) {
                    case '1' -> result.append("0");
                    case '0' -> result.append("00");
                }
                result.append(" ");
            }
            result.append("0");
        }

        System.out.println("The result:");
        System.out.println(result.toString().trim());
    }
}