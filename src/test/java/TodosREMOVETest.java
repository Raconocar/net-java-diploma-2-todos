import net.jd.todos.Todos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TodosREMOVETest {
    private final Todos todos = new Todos();

    @Test
    void removeTask() {
        todos.addTask("testAdd");
        todos.addTask("testAdd");
        todos.addTask("testAdd");
        todos.addTask("testAdd");
        todos.removeTask("testAdd");
        assertEquals("testAdd testAdd testAdd", todos.getAllTasks());
    }
}