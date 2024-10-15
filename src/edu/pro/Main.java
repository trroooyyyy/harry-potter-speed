package edu.pro;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        LocalDateTime start = LocalDateTime.now();

        String content = new String(Files.readAllBytes(Paths.get("src/edu/pro/txt/harry.txt")));

        content = content.replaceAll("[^A-Za-z ]"," ").toLowerCase(Locale.ROOT);

        // Розбиття на слова
        String[] words = content.split(" +"); // 400 000

        // Використання HashMap для підрахунку частоти кожного унікального слова
        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        // Сортування за частотою
        List<Map.Entry<String, Integer>> sortedWords = wordFrequency.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .toList();

        // Виведення 30 найбільш частих слів
        for (int i = 0; i < Math.min(30, sortedWords.size()); i++) {
            System.out.println(sortedWords.get(i).getKey() + " " + sortedWords.get(i).getValue());
        }

        LocalDateTime finish = LocalDateTime.now();

        System.out.println("------");
        System.out.println(ChronoUnit.MILLIS.between(start, finish));

        /* ВАШ КОД - ~2700millis. Мій код - ~100millis
        Arrays.sort(words);

        String distinctString = " ";

        for (int i = 0; i < words.length ; i++) {
            if (!distinctString.contains(words[i])){
                distinctString+= words[i] + " ";
            }
        }

        String[] distincts = distinctString.split(" ");
        int[] freq = new int[distincts.length];

        for (int i = 0; i < distincts.length ; i++) {
            int count = 0;
            for (int j = 0; j < words.length ; j++) {
                if (distincts[i].equals(words[j])) {
                    count++;
                }
            }
            freq[i] = count;
        }

        for (int i = 0; i < distincts.length ; i++) {
            distincts[i] += " " + freq[i];
        }

        Arrays.sort(distincts, Comparator.comparing(str
                -> Integer.valueOf(str.replaceAll("[^0-9]", ""))));

        for (int i = 0; i < 30; i++) {
            System.out.println(distincts[distincts.length - 1 - i]);
        }
        */



    }


}
