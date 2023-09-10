import dao.Question;
import dao.QuestionDao;
import user.Quizer;

public class Main {
    public static void main(String[] args) {
        //initDB();
        Quizer.main();

    }

    private static void initDB(){
        QuestionDao questiondb = new QuestionDao();
        questiondb.save(new Question(1, 1, "Question1", "Answer1", "Topic"));
    }
}