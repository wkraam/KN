package user;

import dao.Dao;
import dao.Question;
import dao.QuestionDao;
import db.DatabaseConnection;

import java.sql.Connection;

public class Quizer {
    private static Dao<Question> questionsDao;

    public static void run() {
        questionsDao = new QuestionDao();
        DatabaseConnection con = new DatabaseConnection();
        initdb();

        con.connectToDB();
        Question q1 = questionsDao.getQ(0);
        System.out.println(q1);
        //System.out.println(questionsDao.getAll());
        System.out.println(questionsDao.getByTopic(1));
    }

    private static void initdb(){
        questionsDao.save(new Question(0, 1, "Question1", "Answer1", 1));
        questionsDao.save(new Question(1, 1, "Question2", "Answer2", 2));
        questionsDao.save(new Question(2, 2, "Question3", "Answer1", 1));
        questionsDao.save(new Question(3, 5, "Question4", "Answer2", 1));
    }
}
