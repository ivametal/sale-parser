package sales.parsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import sales.Game;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ivametal on 01.02.2017.
 */
public class SteamSales {
    public static ArrayList<Game> getGameSales() throws IOException {
        ArrayList<Game> gameList = new ArrayList<>();

        Document doc = Jsoup.connect("http://steamsales.rhekua.com/").get();
        Elements elements = doc.select(".tab_row");
        for (Element el : elements) {
            Game game = new Game(el.select(".tab_desc").select("h4").text(),
                    el.select(".tab_discount").text(),
                    el.select(".tiny_cap_img").attr("src"));
            gameList.add(game);
        }


        return gameList;
    }
}
