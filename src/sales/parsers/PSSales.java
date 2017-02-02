package sales.parsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import sales.Game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

import static sales.Game.getUrl;

/**
 * Created by Ivametal on 31.01.2017.
 */
public class PSSales {
    public static ArrayList<Game> getGameSales(int consoleId) throws IOException {
        String address;
        switch (consoleId) {
            case 3 :
                address = "https://ps-sale.ru/ps3/";
                break;
            case 4 :
                address = "https://ps-sale.ru/";
                break;
            default:
                throw new InputMismatchException();
        }
        Document doc;
        ArrayList<Game> gameList = new ArrayList<>();
        org.jsoup.select.Elements el;
        System.setProperty("javax.net.ssl.trustStore", "C:\\Users\\Ivametal\\Desktop\\key\\new.jks");

        int i=0;
        doc = Jsoup.connect(address).get();
        el = doc.select(".container .divlink");
        for (Element element : el) {
            Game game = new Game(element.select(".name-holder").text(),
                    element.select(".percent-holder").text(),
                    element.select(".old-price-holder").text(),
                    element.select(".price-holder").text(),
                    element.select(".actual-days").text(),
                    getUrl(element.select("div").first().attr("style")));
            gameList.add(i++,game);
        }


        return gameList;
    }
}
