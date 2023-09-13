import dao.Question;
import db.DatabaseConnection;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {
    DatabaseConnection dbConnection = new DatabaseConnection();
    {
        dbConnection.connectToDB();
    }

    @Test
    void questionsShouldNotBeEmpty() {
        assertFalse(dbConnection.dbIsEmpty("questions"));
    }

    @Test
    void answersShouldNotBeEmpty() {
        assertFalse(dbConnection.dbIsEmpty("answers"));
    }

    @Test
    void topicsShouldNotBeEmpty() {
        assertFalse(dbConnection.dbIsEmpty("topics"));
    }

    @Test
    void anwerstoquestionsShouldNotBeEmpty() {
        assertFalse(dbConnection.dbIsEmpty("answerstoquestions"));
    }

    @Test
    void saveAndDeleteQuestionsShouldSaveToDatabaseAndDelete(){
        int initialLength = dbConnection.getAllFromQuestion().size();
        dbConnection.saveQuestion(1,"test",1,-1);
        int saveLength = dbConnection.getAllFromQuestion().size();
        List<Question> delID = dbConnection.getByTopic(-1);
        for(Question id: delID){
            dbConnection.deleteQuestion(id);
        }
        int deleteLength = dbConnection.getAllFromQuestion().size();
        assertNotEquals(initialLength,saveLength);
        assertEquals(initialLength, deleteLength);
    }

}