package dao;

public class Question {

    private int ID;
    private int difficulty;
    private String question;
    private String answer;
    private String topic;

    public Question(int ID, int difficulty, String question, String answer, String topic) {
        this.ID = ID;
        this.difficulty = difficulty;
        this.question = question;
        this.answer = answer;
        this.topic = topic;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Question{" +
                "ID=" + ID +
                ", difficulty=" + difficulty +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", topic='" + topic + '\'' +
                '}';
    }
}
