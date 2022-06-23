import net.jd.todos.Todos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodosGetAllTaskTest {

    private final Todos todos = new Todos();

    @Test
    void getAllTasks() {
        todos.addTask("testAdd");
        todos.addTask("testAdd");
        todos.addTask("testAdd");
        todos.addTask("testAdd");
        assertEquals("testAdd testAdd testAdd testAdd", todos.getAllTasks());

    }
}