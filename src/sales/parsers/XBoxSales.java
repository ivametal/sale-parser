package sales.parsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import sales.Game;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ivametal on 02.02.2017.
 */
public class XBoxSales {
    public static ArrayList<Game> getGameSales() throws IOException {
        ArrayList<Game> gameList = new ArrayList<>();
        System.setProperty("javax.net.ssl.trustStore","C:\\Users\\Ivametal\\Desktop\\key\\new2.jks");
        Document doc = Jsoup.connect("https://www.trueachievements.com/xbox-sales.aspx").get();
        Elements elm = doc.select(".listholder");
        Elements elementsOne = elm.select(".even");
        Elements elementsTwo = elm.select(".odd");
        for (Element el : elementsOne) {
            Game game = new Game(el.select(".game").select("a").text(),el.select(".reduction").text(),
                    el.select(".bigicon").attr("src"));
            gameList.add(game);
        }
        for (Element el : elementsTwo) {
            Game game = new Game(el.select(".game").select("a").text(),el.select(".reduction").text(),
                    el.select(".bigicon").attr("src"));
            gameList.add(game);
        }
        return gameList;
    }
}
