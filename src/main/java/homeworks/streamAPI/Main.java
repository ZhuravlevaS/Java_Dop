package homeworks.streamAPI;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Main {
// Дан список дат. Преобразуйте его в список дней недели.
    private static List<DayOfWeek> getDayOfWeeks(List<LocalDate> dates) {
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

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/js.txt"));
        List<String> lines = new ArrayList<>();

        String line;
        while ((line = reader.readLine()) != null){
            lines.add(line);
        }

        System.out.println(countUniqueWords(lines));


    }
}
