//Nicholas Justus
//4/18/21
package edu.tridenttech.cpt237.cafe.view;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Alert {
	private Stage myStage;
	Text message;
	
	public Alert() {
		StackPane pane = new StackPane();
		Scene scene = new Scene(pane);
		message = new Text("Error: Cannot accept an empty submission. Please add at least one item.");
		
		
		myStage = new Stage();
		myStage.setHeight(100);
		myStage.setWidth(440);
		myStage.setScene(scene);
		myStage.setTitle("Error");
		
		pane.getChildren().add(message);
	}
	
	public void show()
	{
		if (!myStage.isShowing()) {
			myStage.show();
		}else {
			myStage.toFront();
		}
	}
}
