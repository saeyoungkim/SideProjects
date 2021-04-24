package movie.scrapper;

import movie.scrapper.model.MovieTheater;
import movie.scrapper.model.ScrapType;
import movie.scrapper.model.TohoTheater;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppHelper {
    // List size
    private final Integer LIST_SIZE = 3;

    private class Operation {
        public String text;
        public ScrapType type;

        public Operation(String _text, ScrapType _type) {
            this.text = _text;
            this.type = _type;
        }
    }

    private List<Operation> baseOperationList = new ArrayList<>();

    private int current;

    public Boolean isEntered;

    private Scanner sc;

    {
        baseOperationList.add(new Operation("1. 上映中の映画リスト", ScrapType.IN_THEATERS));
        baseOperationList.add(new Operation("2. 上映予定の映画リスト", ScrapType.BE_RELEASED));
        baseOperationList.add(new Operation("3. 上映中の映画ランキング", ScrapType.RANKING));

        current = 0;
        isEntered = false;

        sc = new Scanner(System.in);
    }

    public void showOperationList() {
        for(int idx = 0; idx < LIST_SIZE; ++idx) {
            System.out.println(baseOperationList.get(idx).text);
        }
    }

    private void clear() {
        try {
            Runtime.getRuntime().exec("clear");
        } catch (IOException exception) {
            exception.printStackTrace();
            return ;
        }
    }

    private void lineBreak() {
        System.out.println();
    }

    private void printAndGetSelection() {
        System.out.print("Please Enter the number: ");
        String number = sc.nextLine();

        try {
            current = Integer.parseInt(number);
        } catch (NumberFormatException e){
            e.printStackTrace();
        }
    }

    private void phase1() {
        clear();

        showOperationList();
        lineBreak();

        while(true){
            printAndGetSelection();
            if((0 < current) && (current <= LIST_SIZE)) break;
        }

        --current;
    }

    public void start() {
        phase1();

        MovieTheater theater = new TohoTheater();
        List<String> movies = theater.findMovies(baseOperationList.get(current).type);

        clear();
        movies.stream().forEach(movie -> System.out.println(movie));
    }
}
