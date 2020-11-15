package movie.scrapper;

import java.util.List;
import movie.scrapper.model.*;

public class App {
    public static void main(String[] args) {
        MovieTheater theater = new TohoTheater();

        List<String> movies = theater.findMovies(ScrapType.RANKING);

        System.out.println("# Movie Ranking");
        for(String movie: movies) {
            System.out.println(movie);
        }
    }
}
