package dao;

import java.util.List;

public interface Dao<Q> {
    // ----------------- get -------------------------
    Q getObject(Q objectType); //get Q
    Q getObjectWithId(int id);
    List<Q> getQuestionsUsingTopicById(int topic); //get a list of questions sorted by topic
    List<Q> getAll(); //get a list of all objects in its table
    // ----------------- del -------------------------
    void delete(int id);
    void delete(Q q);
    // ----------------- save -------------------------
    void save(Q q);
    void save(int difficulty, String question, int answer, int topic); //question specific save method
    // ----------------- update -------------------------
    void update(Q q, String[] params);


}