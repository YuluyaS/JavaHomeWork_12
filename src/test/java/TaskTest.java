import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testng.asserts.Assertion;

import static org.testng.asserts.Assertion.*;

public class TaskTest {

    @Test
    public void testSimpleTaskMatches() {
        SimpleTask task = new SimpleTask(123,"Позвонить домой");

        //boolean expected = true;
        boolean actual = task.matches( "Позвонить");

        //Assertions.assertEquals(expected, actual);
        Assertions.assertTrue(actual);
    }

    @Test
    public void testSimpleTaskNotMatches() {
        SimpleTask task = new SimpleTask(123,"Позвонить домой");

        boolean actual = task.matches( "Написать");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testEpicTaskMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks );

        boolean actual = epic.matches( "Яйца");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testEpicTaskNotMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks );

        boolean actual = epic.matches( "Колбаса");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testMeetingTaskTopicMatches() {

        String topic = "Молоко";
        String project = "Молочный";
        String start = "В понедельник";

        Meeting meeting = new Meeting (50, topic, project, start);

        boolean actual = meeting.matches( "Молоко");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingTaskProjectMatches() {

        String topic = "Молоко";
        String project = "Молочный";
        String start = "В понедельник";

        Meeting meeting = new Meeting (50, topic, project, start);

        boolean actual = meeting.matches( "Молочный");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingTaskNotMatches() {

        String topic = "Молоко";
        String project = "Молочный";
        String start = "В понедельник";

        Meeting meeting = new Meeting (50, topic, project, start);

        boolean actual = meeting.matches( "В понедельник");

        Assertions.assertFalse(actual);
    }

}