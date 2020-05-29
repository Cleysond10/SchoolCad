package Aplicacao;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Lenovo
 */
public class ExbProf extends Application {
    private static Stage stage;
    
    @Override
    public void start(Stage primaryStage) {
        try {
            stage = primaryStage;

            AnchorPane fxmlMenu = (AnchorPane)FXMLLoader.load(getClass().getResource("/FXML/ExbProf.fxml"));
            
            Scene scene = new Scene(fxmlMenu,600,500);           
            scene.getStylesheets().add(getClass().getResource("/CSS/CSSMainSchool.css").toExternalForm());          
            
            stage.setTitle("EXIBIR - PROFESSOR");            
            stage.setScene(scene);
            //stage.setMaximized(true);
            //ESSA FUNÇÃO A BAIXO FAZ A TELA FICAR CHEIA
            //stage.setFullScreen(true);
            //stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
            setStage(stage);
        }   catch (IOException ex) {
            Logger.getLogger(ExbProf.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        ExbProf.stage = stage;
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }        
}