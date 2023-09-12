package user;

import dao.Dao;
import dao.Question;
import dao.QuestionDao;
import dao.QuestionDaoDB;


public class Quizer {
    private static Dao<Question> questionsDao;

    public static void run() {
        questionsDao = new QuestionDaoDB();
        //questionsDao = new QuestionDao();
        initdb();
        Question q1 = questionsDao.getQ(3);
        System.out.println(q1);
        System.out.println(q1.getAnswer());
        System.out.println(questionsDao.getAllAnswers(q1));
    }

    //for db testing
    private static void initdb(){
        if(questionsDao.getAll().isEmpty()) {
            System.out.println("the db is empty, adding default cases");
            questionsDao.save( 1, "Question1", 1, 1);
            questionsDao.save( 1, "Question2", 2, 2);
            questionsDao.save( 2, "Question3", 1, 1);
            questionsDao.save( 5, "Question4", 2, 1);
        }else{
            System.out.println("the database has questions in it already, not adding default cases");
        }
    }
}
