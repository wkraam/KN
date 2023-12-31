package dao;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

import static dao.QuestionDao.con;

public class AnswerDao implements Dao<Answer> {
    @Override
    public Answer getObject(@NotNull Answer answer) {
        return con.getAnswer(answer.getID());
    }

    @Override
    public Answer getObjectWithId(int sequence) {
        return con.getAnswer(sequence);
    }

    @Override
    public List<Answer> getQuestionsUsingTopicById(int topic) {
        return null;
    }

    @Override
    public List<Answer> getAll() {///return con.getAtoQ(answer);
        return con.getAllFromAnswers();
    }

    @Override
    public void delete(int id) {
        con.deleteAnswer(id);
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
    public void update(@NotNull Answer answer, String @NotNull [] params) {
        //updated values
        answer.setAnswer(Objects.requireNonNull((params[2]),"Answer can't be null"));
        answer.setCorrect(Objects.requireNonNull(Boolean.valueOf(params[3]),"isCorrect can't be null"));

        //update object
        con.updateAnswer(answer);
    }

}
