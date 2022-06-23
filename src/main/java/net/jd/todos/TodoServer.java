package net.jd.todos;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    int port;
    Todos todos;

    public TodoServer(int port, Todos todos) {
        this.todos = todos;
        this.port = port;
    }


    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8989);) {
            while (true) {
                System.out.println("Server wait connections");
                try (Socket socket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter out = new PrintWriter(socket.getOutputStream());) {

                    final String jsonCommandString = in.readLine();
                    System.out.println(jsonCommandString);

                    Gson gson = new Gson();
                    JsonObject jsonCommandObject = gson.fromJson(jsonCommandString, JsonObject.class);

                    if (jsonCommandObject.get("type").getAsString().equals("ADD")) {
                        todos.addTask(jsonCommandObject.get("task").getAsString());
                        System.out.println(todos.getAllTasks());
                        out.println(todos.getAllTasks());
                    }

                    if (jsonCommandObject.get("type").getAsString().equals("REMOVE")) {
                        todos.removeTask(jsonCommandObject.get("task").getAsString());
                        System.out.println(todos.getAllTasks());
                        out.println(todos.getAllTasks());
                    }


                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}