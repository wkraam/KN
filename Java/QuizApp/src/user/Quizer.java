package user;

import dao.Dao;
import dao.Question;
import dao.QuestionDao;
import dao.QuestionDaoDB;


public class Quizer {
    private static Dao<Question> questionsDao;

    public static void run() {
        questionsDao = new QuestionDaoDB(); //PostgreSQL database
        //questionsDao = new QuestionDao(); //In memory database
        initdb(); //if the questions db does not have anything in it, it initializes it
        Question q1 = questionsDao.getQ(3);
        System.out.println(q1);
        System.out.println(questionsDao.getAllAnswers(q1));
    }

    //for db testing
    private static void initdb(){
        if(questionsDao.getAll().isEmpty()) {
            System.out.println("the db is empty, adding default cases");
            //Questions table
            questionsDao.save( 1, "Question1", 1, 1);
            questionsDao.save( 1, "Question2", 2, 2);
            questionsDao.save( 2, "Question3", 1, 1);
            questionsDao.save( 5, "Question4", 2, 1);
            //
        }else{
            System.out.println("the database has questions in it already, not adding default cases");
        }
    }
}
