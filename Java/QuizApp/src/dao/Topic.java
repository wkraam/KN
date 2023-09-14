package dao;

public class Topic {
    private int id;
    private String topicBody;

    public Topic(int id, String topicBody) {
        this.id = id;
        this.topicBody = topicBody;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopicBody() {
        return topicBody;
    }

    public void setTopicBody(String topicBody) {
        this.topicBody = topicBody;
    }

    @Override
    public String toString() {
        return "\nTopic{" +
                "id=" + id +
                ", topicBody='" + topicBody + '\'' +
                '}';
    }
}
