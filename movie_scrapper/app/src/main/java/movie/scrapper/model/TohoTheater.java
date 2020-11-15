package movie.scrapper.model;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TohoTheater extends MovieTheater {
    @Override
    protected String getUrl(ScrapType type) {
        String url = null;
        
        switch(type) {
            case IN_THEATERS:
                url = "https://hlo.tohotheater.jp/net/movie/TNPI3090J01.do";
                break;
            case BE_RELEASED:
                url = "https://hlo.tohotheater.jp/net/movie/TNPI3080J01.do";
                break;    
            case RANKING:
                url = "https://www.tohotheater.jp/";
                break;
            default:
                break;
        }

        return url;
    }

    @Override
    public List<String> findMovies(ScrapType type) {
        Document doc = getHtmlDocument(type);

        List<String> movies = new ArrayList<String>();
        switch(type) {
            case IN_THEATERS:
                break;
            case BE_RELEASED:
                break;  
            case RANKING:
                Elements titles = doc.getElementsByClass("ranking-title");
                 for(Element title: titles) {
                     movies.add(title.child(0).text());
                 }
                break;
            default:
                break;
        }

        return movies;
    }
}
