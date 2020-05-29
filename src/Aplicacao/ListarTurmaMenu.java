package Aplicacao;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Lenovo
 */
public class ListarTurmaMenu extends Application {
    
    private static Stage stage;
    
    @Override
    public void start(Stage primaryStage) {
        try {
            stage = primaryStage;

            AnchorPane fxmlMenu = (AnchorPane)FXMLLoader.load(getClass().getResource("/FXML/ListarTurmaMenu.fxml"));
                        
            
            Scene scene = new Scene(fxmlMenu,600,500);           
            scene.getStylesheets().add(getClass().getResource("/CSS/CSSMainSchool.css").toExternalForm());          
            
            
            stage.setTitle("LISTAR - TURMA");            
            stage.setScene(scene);
            //stage.setMaximized(true);
            //ESSA FUNÇÃO A BAIXO FAZ A TELA FICAR CHEIA
            //stage.setFullScreen(true);
            //stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
            setStage(stage);
        }   catch (IOException ex) {
            Logger.getLogger(ListarAluno.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        ListarTurmaMenu.stage = stage;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}