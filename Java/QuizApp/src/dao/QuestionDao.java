package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QuestionDao implements Dao<Question> {
    private List<Question> questions = new ArrayList<>();

    @Override
    public Question getQ(int seq){
        return questions.get(seq);
    }

    @Override
    public List<Question> getByTopic(int topic) {
        List<Question> returnList = new ArrayList<>();
        for (Question q:questions) {
            if (q.getTopic() == topic) returnList.add(q);
        }
        return returnList;
    }

    @Override
    public List<Question> getAll() {
        return questions;
    }

    @Override
    public void delete(Question question) {
        questions.remove(question);
    }

    @Override
    public void save(Question question) {
        questions.add(question);
    }

    @Override
    public void update(Question question, String[] params) {
        question.setID(Objects.requireNonNull(Integer.parseInt(params[0]),"ID can't be null"));
        question.setDifficulty(Objects.requireNonNull(Integer.parseInt(params[1]), "Difficulty can't be null"));
        question.setQuestion(Objects.requireNonNull(params[2],"Question can't be null"));
        question.setAnswer(Objects.requireNonNull(params[3],"Answer can't be null"));
        question.setTopic(Objects.requireNonNull(Integer.parseInt(params[4]),"Topic can't be null"));

        questions.add(question);
    }
}
