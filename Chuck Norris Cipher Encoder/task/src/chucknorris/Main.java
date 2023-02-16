package chucknorris;

import java.util.Scanner;

public class Main {
    private static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Please input operation (encode/decode/exit):");
        String input = in.nextLine();
        while (!input.equals("exit")) {
            switch (input) {
                case "encode" -> encode();
                case "decode" -> {
                    try {
                        decode();
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Encoded string is not valid.\n");
                    }
                }
                default -> System.out.printf("There is no '%s' operation\n\n", input);
            }

            System.out.println("Please input operation (encode/decode/exit):");
            input = in.nextLine();
        }
        System.out.println("Bye!");
    }

    private static void encode() {
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
        System.out.printf("Encoded string:\n%s\n\n", result.toString().trim());
    }

    private static void decode() {
        System.out.println("Input encoded string:");
        String str = in.nextLine();

        String[] arr = str.split(" ");
        if (arr.length % 2 != 0) throw new IllegalArgumentException();

        StringBuilder binStr = new StringBuilder();
        for (int i = 1; i < arr.length; i += 2) {
            switch (arr[i - 1]) {
                case "0" -> binStr.append("1".repeat(arr[i].length()));
                case "00" -> binStr.append("0".repeat(arr[i].length()));
                default -> throw new IllegalArgumentException();
            }
        }
        if (binStr.length() % 7 != 0) throw new IllegalArgumentException();
        
        StringBuilder result = new StringBuilder();
        for (int i = 7; i <= binStr.length(); i += 7) {
            result.append((char) Integer.parseInt(binStr.substring(i - 7, i), 2));
        }
        System.out.printf("Decoded string:\n%s\n\n", result);
    }
}