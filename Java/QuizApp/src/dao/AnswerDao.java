package dao;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import static dao.QuestionDao.con;

public class AnswerDao implements Dao<Answer>{
    @Override
    public Answer getObject(@NotNull Answer answer) {
        return con.getAnswer(answer.getID());
    }

    @Override
    public Answer getObjectWithId(int sequence) {
        return con.getAnswer(sequence);
    }

    @Override
    public List<Answer> getTopicById(int topic) {
        return null;
    }

    @Override
    public List<Answer> getAll() {///return con.getAtoQ(answer);
        return con.getAllFromAnswers();
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void delete(Answer answer) {
        con.deleteAnswer(answer);
    }

    @Override
    public void save(Answer answer) {
        con.saveAnswer(answer);
    }

    @Override
    public void save(int difficulty, String question, int answer, int topic) {

    }

    @Override
    public void update(Answer answer, String[] params) {

    }

}
