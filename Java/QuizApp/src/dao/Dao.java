package dao;

import java.util.List;

public interface Dao<Q> {
    Question getQ(int sequence);
    List<Question> getByTopic(int topic);
    List<Q> getAll();
    void save(Q q);
    void update(Q q, String[] params);
    void delete(Q q);
}
