package com.example.Grupp1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import java.util.concurrent.ThreadLocalRandom;

@Repository
public class Repo {

    @Autowired
    private DataSource dataSource;

    private List<Joke> jokes;

//    public Repo() {
//        jokes = new ArrayList<>();
//
//        jokes.add(new Joke(1, "Alive", "Dark","I'm alive because of two reasons:\n 1. I was born. \n2. I haven't died yet.", "Simon"));
//        jokes.add(new Joke(2, "Stabbed", "Dark","I just read that someone in London gets stabbed every 52 seconds. Poor guy.", "Simon"));
//        jokes.add(new Joke(3, "I work with animals", "Dark","I work with animals,\" the guy says to his date.  \"That's so sweet,\" she replies. \"I love a man who cares about animals. Where do you work?\"\n\"I'm a butcher,\" he says", "Simon"));
//        jokes.add(new Joke(4, "Substitute", "Adult","What does tofu and a dildo have in common? They are both meat substitutes.", "Simon"));
//        jokes.add(new Joke(5, "The hint", "Adult","A woman walks out of the shower, winks at her boyfriend, and says, “Honey, I shaved myself down there. Do you know what that means?” The boyfriend says, “Yeah, it means the drain is clogged again.”", "Simon"));
//        jokes.add(new Joke(6, "Title", "Family"," HEJ HEJ ROLIGT", "Lwam"));
//        jokes.add(new Joke(7, "Title", "Family"," HEJ HEJ ROLIGT", "Lwam"));
//        jokes.add(new Joke(8, "Title", "Family"," HEJ HEJ ROLIGT", "Lwam"));
//        jokes.add(new Joke(9, "Title", "Family"," HEJ HEJ ROLIGT", "Lwam"));
//        jokes.add(new Joke(10, "Title", "Family"," HEJ HEJ ROLIGT", "Lwam"));
//
//        }

    public Joke getJoke(int id) {

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM Joke WHERE ID =?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rsBook(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Joke addJoke(Joke joke) {
        Joke lastJoke = jokes.get(jokes.size() - 1);
        joke.setId(lastJoke.getId() + 1);
        jokes.add(joke);
        return joke;
    }

    public int numberOfJokes() {

        int result = 0;

        try (Connection conn = dataSource.getConnection();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery("SELECT COUNT(*) AS CUNT FROM Joke")) {

            if (rs.next()) {
                result = rs.getInt("CUNT");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    public double averageRating(int id) {

        double result = 0.0;

        try (Connection conn = dataSource.getConnection();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery("SELECT ROUND(AVG(CAST(RatingValue AS DECIMAL)),1) AS New FROM Rating " +
                     "LEFT JOIN Joke ON joke.id = Rating.jokeId " +
                     "WHERE jokeID =" + id)) {
            if (rs.next()) {
                result = rs.getDouble("New");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void addRating(int id, int rating) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO Rating (JokeId, RatingValue) values (?,?)")){
             ps.setInt(1, id);
             ps.setInt(2, rating);
             ps.executeUpdate();
    } catch (SQLException e) {
            e.printStackTrace();
        }}


        private Joke rsBook(ResultSet rs) throws SQLException {
        return new Joke(rs.getInt("id"),
                rs.getString("title"),
                rs.getString("category"),
                rs.getString("body"),
                rs.getString("author"));

    }


}
