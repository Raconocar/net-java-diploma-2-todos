package net.jd.todos;

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
        Collections.sort(taskList); // сортируем таски стандартным способом перед преобразованием в строку

        StringBuilder strbul = new StringBuilder();
        for (String str : taskList) {
            strbul.append(str);
            strbul.append(" ");
        }

        String str = strbul.toString();
        str = str.substring(0, str.length() - 1); //удаляем последний пробел чтобы глаза не мозолил
        return str;

    }

}