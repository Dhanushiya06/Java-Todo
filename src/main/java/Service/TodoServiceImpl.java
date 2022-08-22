package Service;

import model.Todo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TodoServiceImpl implements TodoService {

    private ArrayList<Todo> todos;
    private Scanner scanner;

    public TodoServiceImpl(ArrayList<Todo> todos, Scanner scanner) {
        this.todos = todos;
        this.scanner = scanner;
    }

    @Override
    public void addTodo() {
        System.out.println("AddTodo");
        System.out.println("********");
        System.out.println("Enter your item: ");
        String itemName = scanner.next();
        // todo
        Todo todo = new Todo();
        todo.setId(todos.size() + 1);
        todo.setItemName(itemName);
        todo.setCompleted(false);
        todos.add(todo);
        System.out.println("********");
    }
    @Override
    public void viewTodo() {
        System.out.println("ViewTodo");
        System.out.println("********");
        for (Todo todo : todos) {
            System.out.println(todo.getId() + "." + todo.getItemName()
                    + " Completed Status - " + (todo.isCompleted() ? "Yes" : "No"));
        }
        System.out.println("********");
    }
    @Override
    public void updateTodo() {
        System.out.println("UpdateTodo");
        System.out.println("********");
        for (Todo todo : todos) {
            System.out.println(todo.getId() + "." + todo.getItemName()
                    + " Completed Status - " + (todo.isCompleted() ? "Yes" : "No"));
        }
        System.out.println("Enter your update choice: ");
        int choice = scanner.nextInt();
        Todo todo = todos.get(choice - 1);
        todo.setCompleted(!todo.isCompleted());
        System.out.println("********");
    }
    public void printMainMenu() {

        while (true) {
            System.out.println("1.AddTodo");
            System.out.println("2.ViewTodo");
            System.out.println("3.UpdateTodo");
            System.out.println("4.Exit");
            System.out.println("Enter your choice: ");
            int choice = 0;
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> addTodo();
                    case 2 -> viewTodo();
                    case 3 -> updateTodo();
                    case 4 -> System.exit(0);
                    default -> System.out.println("Invalid Choice");
                }
            } catch (InputMismatchException exception) {
                System.out.println("Invalid Choice!!!");
            }
        }
    }
}
