import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        String input;
        String word;
        while (true) {
            System.out.print("Enter a string:");
            input = scanner.nextLine();
            for (char x: input.toCharArray()) {
                if (Character.isUpperCase(x)) {
                    input = input.replace(x, Character.toLowerCase(x));
                }
            }
            if (input.equals("exit")) {
                break;
            }
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == ',' || input.charAt(i) == '.' || input.charAt(i) == '!' || input.charAt(i) == '?') {
                    input = input.substring(0, i) + input.substring(i + 1);
                    i--;

                }
                if (input.charAt(i) == ' ') {
                    word = input.substring(0, i);
                    input = input.substring(i + 1);
                    i = -1;
                } else if (i == input.length() - 1) {
                    word = input;
                } else {
                    continue;
                }
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
            for (String key : map.keySet()) {
                System.out.println(key + ": " + map.get(key));
            }
            map.clear();
        }
        scanner.close();
    }
}