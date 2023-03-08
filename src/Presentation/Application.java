package Presentation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = FXMLLoader.load(getClass().getResource("Views/productView.fxml"));
        Scene scene = new Scene(root,500, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Gestion de produits");
        primaryStage.show();
    }
}
