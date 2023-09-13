package dao;

import java.util.List;

import static dao.QuestionDao.con;

public class TopicDao implements Dao<Topic>{
    @Override
    public Topic getObject(Topic topic) {
    return con.getTopic(topic.getId());
}

    @Override
    public Topic getObjectWithId(int id) {
        return null;
    }

    @Override
    public List<Topic> getTopicById(int topic) {
        return null;
    }

    @Override
    public List<Topic> getAll() {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void save(Topic topic) {

    }

    @Override
    public void save(int difficulty, String question, int answer, int topic) {

    }

    @Override
    public void update(Topic topic, String[] params) {

    }

    @Override
    public void delete(Topic topic) {

    }
}
