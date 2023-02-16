package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input string:");
        String str = in.nextLine();

        //String result = encode(str);
        String result = decode(str);

        printResult(result);
        //System.out.println(result.toString().trim());
    }

    private static String encode(String str) {
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
        return result.toString().trim();
    }

    private static String decode(String str) {
        String[] arr = str.split(" ");
        StringBuilder binStr = new StringBuilder();
        for (int i = 1; i < arr.length; i += 2) {
            switch (arr[i - 1]) {
                case "0" -> binStr.append("1".repeat(arr[i].length()));
                case "00" -> binStr.append("0".repeat(arr[i].length()));
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 7; i <= binStr.length(); i += 7) {
            result.append((char) Integer.parseInt(binStr.substring(i - 7, i), 2));
        }
        return result.toString();
    }
    private static void printResult(String result) {
        System.out.printf("The result:\n%s", result);
    }
}