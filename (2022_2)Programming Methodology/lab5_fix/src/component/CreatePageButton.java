package component;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import pane.RootPane;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;

public class CreatePageButton extends StackPane {

	public CreatePageButton() {
		Circle circle = new Circle(20, Color.LIGHTGRAY);
		Text text = new Text("+");
		text.setFont(new Font(20));
		Cursor cursor = Cursor.HAND;
		this.setCursor(cursor);
		
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				RootPane.getNavigationPane().addPage();
			}

		});
		
		this.getChildren().addAll(circle,text);

	}
}
