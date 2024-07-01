package homeworks.streamAPI.films;

// Создайте класс Фильм с полями title, genre и rating.

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Film {
    private String title;
    private String genre;
    private int rating;
}
