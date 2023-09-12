package db;

import dao.Question;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    Connection c = null;
    Statement stmt;
    PreparedStatement pstmt;
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

    public void closeDBConnection(){
        try {
            c.close();
            System.out.println("Database connection closed successfully");
        } catch (SQLException eSQL){
            eSQL.printStackTrace();
        }
    }


    //with Question object.
    public void saveQuestion(@NotNull Question question){
        try{
            pstmt = c.prepareStatement("insert into questions(id, difficulty, question, answer, topic)  " +
                    "VALUES (?,?,?,?,?)");
            pstmt.setInt(1, question.getID());
            pstmt.setInt(2, question.getDifficulty());
            pstmt.setString(3, question.getQuestion());
            pstmt.setInt(4, question.getAnswer());
            pstmt.setInt(5, question.getTopic());
            pstmt.execute();
            System.out.println("Question obj. saved");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //w/o Question object, with custom ID.
    public void saveQuestion(int id, int difficulty, String question, int answer, int topic){
        try{
            pstmt = c.prepareStatement("insert into questions(id, difficulty, question, answer, topic)  " +
                    "VALUES (?,?,?,?,?)");
            pstmt.setInt(1, id);
            pstmt.setInt(2, difficulty);
            pstmt.setString(3, question);
            pstmt.setInt(4, answer);
            pstmt.setInt(5, topic);
            pstmt.execute();
            System.out.println("plaintext question saved w/ id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //w/o Question object, autoincrement ID (ID's can get messy, so not recommended).
    public void saveQuestion(int difficulty, String question, int answer, int topic){
        try{
            pstmt = c.prepareStatement("insert into questions(difficulty, question, answer, topic)  " +
                "VALUES (?,?,?,?)");
            pstmt.setInt(1, difficulty);
            pstmt.setString(2, question);
            pstmt.setInt(3, answer);
            pstmt.setInt(4, topic);
            pstmt.execute();
            System.out.println("plaintext question saved w/o id");} catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void updateQuestion(@NotNull Question question){
        try{
            pstmt = c.prepareStatement("update questions " +
                    "set(?,?,?,?,?) where id = ?");
            pstmt.setInt(1, question.getID());
            pstmt.setInt(2, question.getDifficulty());
            pstmt.setString(3, question.getQuestion());
            pstmt.setInt(4, question.getAnswer());
            pstmt.setInt(5, question.getTopic());
            pstmt.setInt(6, question.getID());
            pstmt.execute();
            System.out.println("Question obj. updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void deleteQuestion(int id){
        try{
            pstmt = c.prepareStatement("delete * from questions where id = ?");
            pstmt.setInt(1, id);
            pstmt.execute();
            System.out.println("Deleted question with id: "+id);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteQuestion(@NotNull Question question){
        try{
            pstmt = c.prepareStatement("delete * from questions where id = ?");
            pstmt.setInt(1, question.getID());
            pstmt.execute();
            System.out.println("Deleted question: "+question);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    //a check if database is empty or not
    public boolean dbIsEmpty(String databaseName){
        try{
            String str = "select count(*) from "+databaseName;
            pstmt = c.prepareStatement(str);
            pstmt.execute();
            rs = pstmt.getResultSet();
            rs.next();
            if(rs.getInt("count") == 0){
                return true;
            }else return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Question> getAllFromQuestion(){

        List<Question> returnList = new ArrayList<>();

        try {
            stmt = c.createStatement();
            rs = stmt.executeQuery("select * from public.questions");
            //System.out.println("ID, difficulty, question, answer, topic");

            //getting every row at a time and making them into Question obj., adding to the returnList.
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


    public Question getByID(int ID){
        try {
            stmt = c.createStatement();
            rs = stmt.executeQuery("select * from public.questions where id = "+ID);


            while (rs.next()){
                int id = rs.getInt("id");
                int difficulty = rs.getInt("difficulty");
                String question = rs.getString("question");
                int answer = rs.getInt("answer");
                int topic = rs.getInt("topic");
                return new Question(id, difficulty, question, answer, topic);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Question> getByTopic(int topicInt){
        List<Question> returnList = new ArrayList<>();

        try {
            stmt = c.createStatement();
            rs = stmt.executeQuery("select * from public.questions where topic = "+topicInt);

            //getting every row at a time with specific topic and making them into Question obj., adding to the returnList.
            while (rs.next()){
                int id = rs.getInt("id");
                int difficulty = rs.getInt("difficulty");
                String question = rs.getString("question");
                int answer = rs.getInt("answer");
                int topic = rs.getInt("topic");
                returnList.add(new Question(id, difficulty, question, answer, topic));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnList;
    }



}
