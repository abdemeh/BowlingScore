package com.bowling;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScoreSaver {

    private static final String FILE_NAME = "scores.json";

    public static void save(int score) {
        LocalDateTime now = LocalDateTime.now();
        String date = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String time = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        String jsonEntry = String.format("{\"date\": \"%s\", \"time\": \"%s\", \"score\": %d}", date, time, score);

        try (FileWriter fileWriter = new FileWriter(FILE_NAME, true);
                PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(jsonEntry);
            System.out.println("Score saved to " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Error saving score: " + e.getMessage());
        }
    }
}
