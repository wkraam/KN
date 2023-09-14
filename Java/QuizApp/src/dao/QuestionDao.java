package dao;

import db.DatabaseConnection;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class QuestionDao implements Dao<Question> {
    static DatabaseConnection con = new DatabaseConnection();

    //on init
    static {
        con.connectToDB();
    }

    @Override
    public Question getObjectWithId(int sequence){
        return con.getByID(sequence);
    }


    @Override
    public Question getObject(Question question) {
        return con.getByID(question.getID());
    }

    @Override
    public List<Question> getQuestionsUsingTopicById(int topic) {
        return con.getByTopic(topic);
    }

    @Override
    public List<Question> getAll() {
        return con.getAllFromQuestion();
    }

    @Override
    public void delete(Question question) {
        con.deleteQuestion(question);
    }

    @Override
    public void delete(int id){
        con.deleteQuestion(id);
    }

    @Override
    public void save(Question question) {
        con.saveQuestion(question);
    }

    @Override
    public void save(int difficulty, String question, int answer, int topic) {
        con.saveQuestion(difficulty, question, answer, topic);
    }

    @Override
    public void update(@NotNull Question question, String @NotNull [] params) {

        //updated values
        question.setDifficulty(Objects.requireNonNull(Integer.parseInt(params[0]), "Difficulty can't be null"));
        question.setQuestion(Objects.requireNonNull(params[1],"Question can't be null"));
        question.setAnswer(Objects.requireNonNull(Integer.parseInt(params[2]),"Answer can't be null"));
        question.setTopic(Objects.requireNonNull(Integer.parseInt(params[3]),"Topic can't be null"));

        //update object
        con.updateQuestion(question);
    }
}