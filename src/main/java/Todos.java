import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Todos {

    List<String> taskList = new ArrayList<String>();

    public void addTask(String task) {
        this.taskList.add(task);
    }

    public void removeTask(String task) {
        this.taskList.remove(task);
    }

    public String getAllTasks() {
        Stream stream = this.taskList.stream();
        return stream.sorted().toString();
    }

}