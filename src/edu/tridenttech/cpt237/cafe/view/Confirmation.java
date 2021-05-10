//Nicholas Justus
//4/18/21
package edu.tridenttech.cpt237.cafe.view;

import edu.tridenttech.cpt237.cafe.model.Cafe;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Confirmation {
	private Stage myStage;
	TextArea printout;
	
	public Confirmation(Cafe cafe, int currentOrderId) {
		FlowPane pane = new FlowPane();
		Scene scene = new Scene(pane);

		pane.setOrientation(Orientation.VERTICAL);
		printout = new TextArea(cafe.findPendingOrder(currentOrderId).getOrderedItems().toString());
		printout.setPrefWidth(400);
		printout.setWrapText(true);
		pane.getChildren().add(printout);
		myStage = new Stage();
		myStage.setHeight(400);
		myStage.setWidth(440);
		myStage.setScene(scene);
		myStage.setTitle("Confirm Order");
		printout.setEditable(false);
		Button okBtn = new Button("Confirm");
		pane.getChildren().add(okBtn);
		okBtn.setOnAction(e -> {
			cafe.placeOrder(currentOrderId);
			cafe.cancelOrder(currentOrderId);
			myStage.close();
			OrderWindow.close();
		});
		Button noBtn = new Button("Return to Order");
		pane.getChildren().add(noBtn);
		noBtn.setOnAction(e -> {
			myStage.close();
		});

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
