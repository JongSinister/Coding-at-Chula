package component;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import pane.RootPane;

public class TodoItem extends HBox {
	public TodoItem(String value) {
		Text text = new Text(value);
		text.setFont(new Font(20));

		Button button = new Button("Delete");

		HBox hbox = new HBox(text, button);
		hbox.setSpacing(10);
		
		this.getChildren().addAll(text,button);
		
		button.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				RootPane.getDisplayPane().removeTodoItem(TodoItem.this);
			}
		});
	}
}
