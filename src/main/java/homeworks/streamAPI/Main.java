package homeworks.streamAPI;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Main {
// Дан список дат. Преобразуйте его в список дней недели.
    private static List<DayOfWeek> getDayOfWeeks(List<LocalDate> dates) {
        char c = '1';

        return dates.stream()
                .map(LocalDate::getDayOfWeek)
                .collect(Collectors.toList());
    }

    //1 Дан текст. Подсчитайте количество уникальных слов в этом тексте.
    private static int countUniqueWords(List<String> lines) {
        return lines.stream()
                .map(s -> s.split("\\W+"))
                .flatMap(Arrays::stream)
                .filter(s-> !s.isEmpty())
                .collect(Collectors.toMap(
                        Function.identity(),
                        el -> 1L,
                        (oldValue, el2) -> oldValue + 1
                )).entrySet().stream()
                .filter(m-> m.getValue() == 1)
                .map(Map.Entry::getKey)
                .toList()
                .size();
    }

    public static void main(String[] args)  {
        Path filePath = Paths.get("src/main/resources/js.txt");
        List<String> lines = null;
        try {
            lines = Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(countUniqueWords(lines));


    }
}
