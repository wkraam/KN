package dao;

import java.util.List;

public interface Dao<Q> {
    Question getQ(int sequence);
    Answer getA(int sequence);

    List<Answer> getAllAnswers(Question question);

    List<Question> getByTopic(int topic);
    List<Q> getAll();

    void delete(int id);

    void save(Q q);

    void save(int difficulty, String question, int answer, int topic);

    void update(Q q, String[] params);
    void delete(Q q);
}
