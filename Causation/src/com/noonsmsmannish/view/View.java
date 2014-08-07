package com.noonsmsmannish.view;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class View extends Application{

	private static Stage primaryStage;
	private static Scene scene;
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	public static Scene getScene() {
		return scene;
	}

	private static BorderPane rootLayout;
	
	public static BorderPane getRootLayout() {
		return rootLayout;
	}
	public void setContent(Node node){
		rootLayout.setCenter(node);
	}

	@Override
	public void start(Stage primaryStage){
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Causation");
        try{
        	FXMLLoader loader = new FXMLLoader(View.class.getResource("RootLayout.fxml"));
        	rootLayout = (BorderPane) loader.load();
        	scene = new Scene(rootLayout);
        	primaryStage.setScene(scene);
        	primaryStage.show();
        	
        	Controller controller = loader.getController();
        	controller.setView(this);
        	
        } catch (Exception e){
        	e.printStackTrace();
        }
        
        setupMainMenu();

	}

	private void setupMainMenu() {
		FXMLLoader loader = new FXMLLoader(View.class.getResource("MainMenuPane.fxml"));
		try{
		AnchorPane mainMenu = (AnchorPane) loader.load();
		rootLayout.setCenter(mainMenu);
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public static View makeView(){
		View view = new View();
		launch();
		return view;
		
	}
	
}
