package com.noonsmsmannish.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Controller {

	private View view;
	private Stage stage;
	private Scene scene;
	
	public Controller(){
		this.stage = View.getPrimaryStage();
		this.scene = View.getScene();
	}
	
	  public void setView(View view) {
	        this.view = view;
	  }

	  @FXML
	  private Button newGameButton;
	
	@FXML
	private void showGraphPane(){
		try {
			FXMLLoader loader = new FXMLLoader(View.class.getResource("ChartPane.fxml"));
			AnchorPane chartPane = (AnchorPane) loader.load();
			View.getRootLayout().setCenter(chartPane);
			showGraph();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@FXML
	private PieChart chart;
	
	private void showGraph(){
        
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Grapefruit", 13),
                new PieChart.Data("Oranges", 25),
                new PieChart.Data("Plums", 10),
                new PieChart.Data("Pears", 22),
                new PieChart.Data("Apples", 30));
        chart = new PieChart(pieChartData);
        chart.setTitle("Imported Fruits");
        
        ((BorderPane) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();

        
	}
	
}
