package reverse.rca.com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReverseSentences {
    public static void main(String[] args) {
        String inputFileName = "java.txt";
        String outputFileName = "reversed.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] sentences = line.split("\\. "); // Split line into sentences
                StringBuilder reversedLine = new StringBuilder();

                for (String sentence : sentences) {
                    // Reverse the sentence
                    String reversedSentence = reverseSentence(sentence);
                    reversedLine.append(reversedSentence).append(". ");
                }

                writer.write(reversedLine.toString().trim()); // Write reversed line to output file
                writer.newLine();
            }

            System.out.println("Sentences reversed and saved to " + outputFileName);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    private static String reverseSentence(String sentence) {
        // Reverse the sentence
        StringBuilder reversedSentence = new StringBuilder(sentence);
        return reversedSentence.reverse().toString();
    }
}








