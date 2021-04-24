package movie.scrapper.model;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

abstract public class MovieTheater {
    private static WebDriver driver;

    static {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        // not for opening any browser
        driver = new ChromeDriver((new ChromeOptions()).setHeadless(true));
    }

    abstract protected String getUrl(ScrapType type);

    // synchronizedされる必要あり(別のものスレッドで使われると変わる可能性あり)
    protected Document getHtmlDocument(ScrapType type) {
        System.out.println("called getHtmlDocument");
        driver.get(getUrl(type));
        String html = driver.getPageSource();
        return Jsoup.parse(html);
    }

    abstract public List<String> findMovies(ScrapType type);
} 
