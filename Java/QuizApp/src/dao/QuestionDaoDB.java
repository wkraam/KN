package dao;

import db.DatabaseConnection;

import java.util.List;
import java.util.Objects;

public class QuestionDaoDB implements Dao<Question> {
    static DatabaseConnection con = new DatabaseConnection();

    //on init
    static {
        con.connectToDB();
    }

    @Override
    public Question getQ(int sequence){
        return con.getByID(sequence);
    }

    @Override
    public Answer getA(int sequence) {
        return con.getAnswer(sequence);
    }

    @Override
    public Topic getT(Question question) {
        return con.getTopic(question);
    }

    @Override
    public List<Answer> getAllAnswers(Question question) {
        return con.getAtoQ(question);
    }

    @Override
    public List<Question> getByTopic(int topic) {
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
    public void update(Question question, String[] params) {
        //updated values
        question.setDifficulty(Objects.requireNonNull(Integer.parseInt(params[0]), "Difficulty can't be null"));
        question.setQuestion(Objects.requireNonNull(params[1],"Question can't be null"));
        question.setAnswer(Objects.requireNonNull(Integer.parseInt(params[2]),"Answer can't be null"));
        question.setTopic(Objects.requireNonNull(Integer.parseInt(params[3]),"Topic can't be null"));
        //update object
        con.updateQuestion(question);
    }
}

//TODO:MOVE ANSWER TO IT'S OWN ANSWERDAODB CLASS
//TODO:MOVE TOPIC TO IT'S OWN TOPICDAO CLASS