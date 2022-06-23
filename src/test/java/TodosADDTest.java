import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import net.jd.todos.Todos;

class TodosADDTest {

    private final Todos todos = new Todos();

    @Test
    void addTask() {
        todos.addTask("testAdd");
        assertEquals("testAdd", todos.getAllTasks());
    }
}