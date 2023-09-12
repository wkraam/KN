package user;

import dao.Dao;
import dao.Question;
import dao.QuestionDao;
import db.DatabaseConnection;

public class Quizer {
    private static Dao<Question> questionsDao;

    public static void run() {
        questionsDao = new QuestionDao();
        DatabaseConnection con = new DatabaseConnection();
        initdb();

        con.connectToDB();
        Question q1 = questionsDao.getQ(0);
        System.out.println(q1);
        System.out.println(questionsDao.getByTopic(1));
        System.out.println(con.getAllFromQuestion());
    }

    //for db testing
    private static void initdb(){
        questionsDao.save(new Question(0, 1, "Question1", 1, 1));
        questionsDao.save(new Question(1, 1, "Question2", 2, 2));
        questionsDao.save(new Question(2, 2, "Question3", 1, 1));
        questionsDao.save(new Question(3, 5, "Question4", 2, 1));
    }
}
