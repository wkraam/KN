package db;

import dao.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    Connection c = null;
    Statement stmt;
    ResultSet rs;

    public Connection connectToDB(){
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "Leopard1996");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        return c;
    }

    public void closeDBConnection() throws SQLException {
        try {
            c.close();
            System.out.println("Database connection closed successfully");
        } catch (SQLException eSQL){
            eSQL.printStackTrace();
        }
    }

    public void saveQuestion(){

    }

    public void updateQuestion(){

    }

    public List<Question> getAllFromQuestion(){

        List<Question> returnList = new ArrayList<>();

        try {
            stmt = c.createStatement();
            rs = stmt.executeQuery("select * from public.questions");
            //System.out.println("ID, difficulty, question, answer, topic");

            //geting every row at a time and making them into Question obj., adding to the returnList.
            while (rs.next()){
                int id = rs.getInt("id");
                int difficulty = rs.getInt("difficulty");
                String question = rs.getString("question");
                int answer = rs.getInt("answer");
                int topic = rs.getInt("topic");
                //System.out.println(id+", "+difficulty+", "+question+", "+answer+", "+topic);
                returnList.add(new Question(id, difficulty, question, answer, topic));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnList;
    }

}
