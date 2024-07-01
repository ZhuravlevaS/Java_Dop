package homeworks.streamAPI.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

//4 Дан список событий с полями name и date. Найдите ближайшее к текущей дате событие.

@ToString
@Getter
@AllArgsConstructor
public class Event {
    private String name;
    private LocalDate date;
}
