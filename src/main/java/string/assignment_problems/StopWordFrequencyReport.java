package string.assignment_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StopWordFrequencyReport {

    public static void printFilteredWordFrequency(String feedback) {

        // Convert to lowercase
        String cleanedText = feedback.toLowerCase();

        // Remove punctuation
        cleanedText = cleanedText.replace(".", "");
        cleanedText = cleanedText.replace(",", "");

        // Split into words
        String[] words = cleanedText.split("\\s+");

        // Stop words
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        HashMap<String, Integer> frequency = new HashMap<>();

        // Count words
        for (String word : words) {

            boolean isStopWord = false;

            // Check if word is a stop word
            for (String stopWord : stopWords) {

                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;
                }
            }

            // Skip stop words
            if (isStopWord) {
                continue;
            }

            // Count the word
            if (frequency.containsKey(word)) {
                frequency.put(word, frequency.get(word) + 1);
            } else {
                frequency.put(word, 1);
            }
        }

        // Convert HashMap entries into a list
        ArrayList<Map.Entry<String, Integer>> wordList =
                new ArrayList<>(frequency.entrySet());

        // Sort by count in descending order
        wordList.sort((entry1, entry2) ->
                entry2.getValue() - entry1.getValue());

        // Print result
        for (Map.Entry<String, Integer> entry : wordList) {

            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter feedback: ");
        String feedback = scanner.nextLine();

        printFilteredWordFrequency(feedback);

        scanner.close();
    }
}
