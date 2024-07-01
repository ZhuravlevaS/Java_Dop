package homeworks.streamAPI.films;

import homeworks.streamAPI.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Создайте список фильмов в main.
//Создайте метод, группирующий фильмы по жанрам.
//Создайте метод, группирующий фильмы по рейтингу.
//Создайте метод, который получает топ 10 фильмов по рейтингу в заданной категории.
public class FilmService {
    public static void main(String[] args) {
        List<Film> films = generateFilms(20);

        System.out.println(groupFilmsPerGenre(films));
        System.out.println(groupFilmsPerRating(films));
        System.out.println(getTopTenFilms(films));
    }

    private static List<Film> generateFilms(int count) {
        List<Film> filmList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            filmList.add(new Film(
                    Utils.FAKER.harryPotter().book(),
                    Utils.FAKER.book().genre(),
                    Utils.FAKER.number().numberBetween(0, 6)));
        }

        return filmList;
    }

    //Создайте метод, группирующий фильмы по жанрам.
    private static Map<String, List<Film>> groupFilmsPerGenre(List<Film> films) {
        return films.stream()
                .collect(Collectors.groupingBy(
                        Film::getGenre
                ));
    }

    //Создайте метод, группирующий фильмы по рейтингу.
    private static Map<Integer, List<Film>> groupFilmsPerRating(List<Film> films) {
        return films.stream()
                .collect(Collectors.groupingBy(
                        Film::getRating
                ));
    }

    //Создайте метод, который получает топ 10 фильмов по рейтингу в заданной категории.
    private static List<Film> getTopTenFilms(List<Film> films){
        return films.stream()
                .sorted((o1, o2)-> o2.getRating() - o1.getRating())
                .limit(10)
                .collect(Collectors.toList());
    }
}
