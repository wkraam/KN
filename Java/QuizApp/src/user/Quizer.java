package user;

import dao.*;


public class Quizer {
    private static Dao<Question> questionsDao;
    private static Dao<Answer> answersDao;
    private static Dao<Topic> topicsDao;

    public static void run() {
        questionsDao = new QuestionDao();
        answersDao = new AnswerDao();
        topicsDao = new TopicDao();


        initdb(); //if the questions db does not have anything in it, it initializes it


        Question q1 = questionsDao.getObjectWithId(3);
        System.out.println(q1);
        System.out.println(questionsDao.getAll());
        questionsDao.save(new Question(600,2, "Suss", 2, 1));

        System.out.println(questionsDao.getQuestionsUsingTopicById(1));
        questionsDao.update(questionsDao.getObjectWithId(600), new String[]{"601", "testing update object", "3", "6"});

        System.out.println(questionsDao.getQuestionsUsingTopicById(6));
        questionsDao.delete(600);

        System.out.println(answersDao.getAll());
        Answer a1 = answersDao.getObjectWithId(1);
        a1.setCorrect(!a1.isCorrect());
        System.out.println(a1.isCorrect());
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
