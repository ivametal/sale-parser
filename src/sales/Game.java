package sales;

/**
 * Created by Ivametal on 31.01.2017.
 */
public class Game {
    private String name, sale, oldPrice, newPrice, actual, imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public String getName() {
        return name;
    }


    public String getSale() {
        return sale;
    }


    public String getOldPrice() {
        return oldPrice;
    }


    public String getNewPrice() {
        return newPrice;
    }


    public static String getUrl(String str) {
        String url = "";
        for (int i=0;i<str.length();i++) {
            if (str.charAt(i)=='(') {
                int j=i;
                while (str.charAt(++j)!=')')
                    url+=str.charAt(j);
                break;
            }
        }
        return url;
    }

    public Game (String name, String sale, String oldPrice, String newPrice, String actual, String imgUrl) {
        this.name = withoutQuotes(name);
        this.sale = sale;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.actual = actual;
        this.imgUrl = imgUrl;
    }

    public Game(String name, String sale, String imgUrl) {
        this.name = name;
        this.sale = sale;
        this.imgUrl = imgUrl;
        oldPrice = null;
        newPrice = null;
        actual = null;

    }

    public String toString() {
        return " "+ name + " " + sale + " " + oldPrice + " " + newPrice +" " + actual+ " "+ imgUrl+"\n";
    }

    private String withoutQuotes(String str) {
        return str.replaceAll("\'","");
        }
    }


