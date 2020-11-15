package movie.scrapper.model;

import java.util.List;
import java.net.MalformedURLException;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.HttpStatusException;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

abstract public class MovieTheater {
    abstract protected String getUrl(ScrapType type);
    private static WebDriver driver = null;

    private static void init() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        // not for opening any browser
        driver = new ChromeDriver((new ChromeOptions()).setHeadless(true));
    }
    private static boolean isInited = false;

    // synchronizedされる必要あり(別のものスレッドで使われると変わる可能性あり)
    protected Document getHtmlDocument(ScrapType type) {
        if(!isInited) {
            init();
            isInited = true;
        }
        driver.get(getUrl(type));
        String html = driver.getPageSource();
        return Jsoup.parse(html);
    }

    abstract public List<String> findMovies(ScrapType type);
} 
