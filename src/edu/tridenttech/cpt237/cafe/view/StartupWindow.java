//Nicholas Justus
//4/18/21
package edu.tridenttech.cpt237.cafe.view;

import java.io.FileNotFoundException;

import edu.tridenttech.cpt237.cafe.model.Cafe;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class StartupWindow {

	private Stage myStage;
	
	public StartupWindow(Stage stage) throws FileNotFoundException {
		
		FlowPane pane = new FlowPane();
		
		
		
		Cafe cafe = new Cafe("cafeMenu.txt");
		
		Scene scene = new Scene(pane);
		
		Button newBtn = new Button("New Order");
		Button displayBtn = new Button("Display Orders");
		Button quitBtn = new Button("Quit");
		
		myStage = new Stage();
		myStage.setScene(scene);
		myStage.setWidth(450);
		myStage.setTitle("Joe's Java and Koffee Kafe");
		pane.getChildren().add(newBtn);
		newBtn.setOnAction(e -> {
			int currentOrderId = cafe.startOrder();
			OrderWindow main = new OrderWindow(cafe, currentOrderId);
            main.show(cafe);
            
		});
		pane.getChildren().add(displayBtn);
		displayBtn.setOnAction(e -> {
			cafe.displayOrders();
		});
		pane.getChildren().add(quitBtn);
		quitBtn.setOnAction(e -> {
            Platform.exit();
		});
	}
	
	public void show() {
		myStage.show();
	}
}
