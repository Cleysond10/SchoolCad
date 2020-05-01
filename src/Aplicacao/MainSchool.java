package Aplicacao;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Neto
 */
public class MainSchool extends Application {
    
    private static Stage stage;
    
    @Override
    public void start(Stage primaryStage) {
        try {
            stage = primaryStage;

            AnchorPane fxmlMenu = (AnchorPane)FXMLLoader.load(getClass().getResource("MainSchool.fxml"));
            Scene scene = new Scene(fxmlMenu,800,600);
            
            stage.setTitle("SCHOOLCAD");
            //asd
            stage.setScene(scene);
            stage.show();
            setStage(stage);
        } catch(Exception e) {
            e.printStackTrace();
        }    
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        MainSchool.stage = stage;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

