package dao;

public class Question {

    private int ID;
    private int difficulty;
    private String question;
    private int answer;
    private int topic;

    public Question(int ID, int difficulty, String question, int answer, int topic) {
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

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getTopic() {
        return topic;
    }

    public void setTopic(int topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "\nQuestion{" +
                "ID=" + ID +
                ", difficulty=" + difficulty +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", topic='" + topic + '\'' +
                '}';
    }
}
