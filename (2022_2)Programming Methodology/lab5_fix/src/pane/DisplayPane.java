package pane;

import component.TodoItem;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class DisplayPane extends VBox {
	private final ArrayList<ArrayList<TodoItem>> todoLists = new ArrayList<>();

	public DisplayPane() {
		// TODO: FILL CODE HERE
        this.setStyle("-fx-background-color:white; -fx-padding:20; -fx-spacing:10;");
	}

	public void addTodoList() {
		// TODO: FILL CODE HERE
		ArrayList<TodoItem> toDoItems = new ArrayList<>();
		todoLists.add(toDoItems);
	}

	public void setActiveTodoList(int index) {
		// TODO: FILL CODE HERE
		if (0 <= index && index < todoLists.size()) {
			RootPane.getDisplayPane().getChildren().clear();
			RootPane.getDisplayPane().getChildren().addAll(todoLists.get(index));
		}
	}

	public void addTodoItem(TodoItem todoItem) {
		int currentPage = RootPane.getNavigationPane().getCurrentPage();
		this.todoLists.get(currentPage).add(todoItem);
		this.getChildren().add(todoItem);
	}

	public void removeTodoItem(TodoItem todoItem) {
		int currentPage = RootPane.getNavigationPane().getCurrentPage();
		this.todoLists.get(currentPage).remove(todoItem);
		this.getChildren().remove(todoItem);

	}
}
