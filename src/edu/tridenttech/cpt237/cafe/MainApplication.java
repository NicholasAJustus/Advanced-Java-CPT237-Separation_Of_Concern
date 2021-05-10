package edu.tridenttech.cpt237.cafe;

import edu.tridenttech.cpt237.cafe.view.StartupWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApplication extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		new StartupWindow(primaryStage).show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
