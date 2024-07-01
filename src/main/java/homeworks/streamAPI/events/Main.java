package homeworks.streamAPI.events;

import homeworks.streamAPI.Utils;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

//4 Дан список событий с полями name и date. Найдите ближайшее к текущей дате событие.
public class Main {

    public static void main(String[] args) {
        List<Event> eventList = generateEvents(10);

        System.out.println(getNearestEvent(eventList, LocalDate.of(2024, 06, 30)));
    }

    private static List<Event> generateEvents(int count) {
        List<Event> eventList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            eventList.add(
                    new Event(Utils.FAKER.aquaTeenHungerForce().character(),
                            LocalDate.of(2020 + i, 1 + i, 10 + i))
            );
        }

        return eventList;
    }

    private static Event getNearestEvent(List<Event> eventList, LocalDate date) {
        Map<Long, Event> map = eventList.stream()
                .collect(Collectors.toMap(
                        (el) -> {
                            Duration days = Duration.ofDays(DAYS.between(el.getDate(), date));
                            return Math.abs(days.getSeconds());
                        },
                        (el) -> el
                ));

        long min = map.keySet().stream().mapToLong(el -> el).min().orElse(0);


        return map.get(min);
    }
}
