//Nicholas Justus
//4/18/21
package edu.tridenttech.cpt237.cafe.view;

import edu.tridenttech.cpt237.cafe.model.Cafe;
import edu.tridenttech.cpt237.cafe.model.MenuItem;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class addPurchaseWindow {
	private Stage myStage;
	Text message;
	
	public addPurchaseWindow(MenuItem menuItem, Cafe cafe, int currentOrderId) {
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setVgap(8);
		pane.setHgap(10);
		
		Alert alert = new Alert();
		
		Scene scene = new Scene(pane);
		message = new Text("How many " +menuItem.getName()+ "s would you like?");
		GridPane.setConstraints(message, 0, 0);
		
		Button submit = new Button("Submit");
		pane.getChildren().add(submit);
		GridPane.setConstraints(submit, 0, 2);
		
		Button cancel = new Button("Cancel");
		pane.getChildren().add(cancel);
		GridPane.setConstraints(cancel, 1, 2);
		
		TextField input = new TextField("0");
		GridPane.setConstraints(input, 0, 1);
		input.setMaxWidth(50);

		submit.setOnAction(e -> {
			if (isInt(input)){
				cafe.addLineItem(currentOrderId, menuItem.getName(), Integer.parseInt(input.getText()));
				myStage.close();
			}else {
				alert.show();
			}
		});
		
		cancel.setOnAction(e -> {
			myStage.close();
		});
		
		
		myStage = new Stage();
		myStage.setHeight(150);
		myStage.setWidth(450);
		myStage.setScene(scene);
		myStage.setTitle("Selection");
		
		pane.getChildren().add(message);
		pane.getChildren().add(input);
	}
	
	private boolean isInt (TextField input) {
		try {
			int amount = Integer.parseInt(input.getText());
			if (amount <= 0) {
			    throw new IllegalArgumentException();
			}else {
				return true;
			}
		}catch(NumberFormatException e) {
			return false;
		}catch(IllegalArgumentException e) {
			return false;
		}
	}
	
	public void show(Cafe cafe)
	{
		if (!myStage.isShowing()) {
			myStage.show();
		}else {
			myStage.toFront();
		}
	}
}
