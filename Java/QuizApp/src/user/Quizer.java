package user;

import dao.Dao;
import dao.Question;
import dao.QuestionDao;

import java.util.Optional;

public class Quizer {
    private static Dao<Question> questionsDao;

    public static void main() {
        questionsDao = new QuestionDao();
        initdb();
        Question q1 = questionsDao.getQ(0);
        System.out.println(q1);
        System.out.println(questionsDao.getAll());

    }

    private static void initdb(){
        questionsDao.save(new Question(1, 1, "Question1", "Answer1", "Topic1"));
        questionsDao.save(new Question(2, 1, "Question2", "Answer2", "Topic2"));
    }
}
