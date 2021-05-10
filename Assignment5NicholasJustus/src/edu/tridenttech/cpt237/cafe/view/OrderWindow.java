//Nicholas Justus
//4/18/21
package edu.tridenttech.cpt237.cafe.view;

import edu.tridenttech.cpt237.cafe.model.Cafe;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class OrderWindow {

	private static Stage myStage;
	GridPane pane = new GridPane();
	ListView<String> listView = new ListView<String>();
	
	public OrderWindow(Cafe cafe, int currentOrderId) {
		
		pane.setPadding(new Insets(10, 10, 10, 10));
		
		Scene scene = new Scene(pane);
		Button addBtn = new Button("Add Item");
		Button orderBtn = new Button("Place Order");
		Button quitBtn = new Button("Cancel");
		
		Alert alert = new Alert();
		
		pane.getChildren().add(addBtn);
		GridPane.setConstraints(addBtn, 1, 0);
		addBtn.setOnAction(e -> {
    		addPurchaseWindow shop = new addPurchaseWindow(cafe.getMenuItemByName(listView.getSelectionModel().getSelectedItem().substring(8)), cafe, currentOrderId);
        	shop.show(cafe);
		});
		
		
		myStage = new Stage();
		myStage.setScene(scene);
		myStage.setWidth(550);
		myStage.setTitle("Order");
		
		
		pane.getChildren().add(orderBtn);
		GridPane.setConstraints(orderBtn, 2, 0);
		orderBtn.setOnAction(e -> {
			if (cafe.findPendingOrder(currentOrderId).getTotalCost()<=0) {
				alert.show();
			}else {
				Confirmation confirm = new Confirmation(cafe, currentOrderId);
				confirm.show();
			}
		});
		pane.getChildren().add(quitBtn);
		GridPane.setConstraints(quitBtn, 3, 0);
		quitBtn.setOnAction(e -> {
			cafe.cancelOrder(currentOrderId);
			myStage.close();
		});
	}
	
	public void show(Cafe cafe) {
		if (!myStage.isShowing()) {
			for (int i=0; i < cafe.getAllMenuItems().size(); i++) {
				String post = ("$" + String.valueOf(cafe.getAllMenuItems().get(i).getBaseCost()));
				post = post.concat("0   "+cafe.getAllMenuItems().get(i).getName().toString());
				listView.getItems().add(post);
			}
			HBox hbox = new HBox(listView);
			GridPane.setConstraints(listView, 0, 0);
			pane.getChildren().add(hbox);
			
			myStage.show();
		}else {
			myStage.toFront();
		}
	}

	public static void close() {
		myStage.close();
		
	}
}
