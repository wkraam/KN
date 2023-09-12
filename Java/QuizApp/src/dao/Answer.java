package dao;

public class Answer {
    private int ID;
    private String answer;
    private boolean isCorrect;

    public Answer(int ID, String answer, boolean isCorrect) {
        this.ID = ID;
        this.answer = answer;
        this.isCorrect = isCorrect;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "ID=" + ID +
                ", answer='" + answer + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
