package dao;

import java.util.List;

public interface Dao<Q> {
    Question getQ(int sequence); //get question
    Answer getA(int sequence); //get answer

    Topic getT(Question question); //get topic

    List<Answer> getAllAnswers(Question question); //get a list of all answers

    List<Question> getByTopic(int topic); //get a list of questions sorted by topic
    List<Q> getAll();

    void delete(int id);

    void save(Q q);

    void save(int difficulty, String question, int answer, int topic);

    void update(Q q, String[] params);
    void delete(Q q);
}

//TODO: clean this messy code!!
