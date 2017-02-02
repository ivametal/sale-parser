package sales.sql;

import sales.Game;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Ivametal on 31.01.2017.
 */
public class SQBase {
    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;

    public static void Conn () throws ClassNotFoundException, SQLException {
        connection = null;
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:TEST1.s3db");
    }

    public static void CreateDB() throws SQLException {
        statement = connection.createStatement();
        deleteTable();
        statement.execute("CREATE TABLE IF NOT EXISTS 'games'('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'platform' INT," +
                "'game' TEXT, 'percent' TEXT, 'old_price' TEXT, 'new_price' TEXT, 'url' TEXT);");
    }

    public static void writeDB(ArrayList<Game> gameList, int platformId) throws SQLException {
        for (Game game : gameList)
        statement.execute("INSERT INTO 'games' ('platform','game','percent','old_price','new_price','url') VALUES ("+platformId+
        ", '"+game.getName()+"', '"+game.getSale()+"', ' "+game.getOldPrice()+"', '"+game.getNewPrice()+"', ' "+
        game.getImgUrl()+"');");
    }

    public static void readDB() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM  games");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("platform")+" "+resultSet.getString("game"));
        }
    }

    private static void deleteTable() throws SQLException {
        statement.execute("DROP TABLE 'games'");
    }

    public static void close() throws SQLException {
        resultSet.close();
        statement.close();
        connection.close();
    }
}
