package Aplicacao;

import estruturadados.LDE;
import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tidosdados.Aluno;
import tidosdados.Professor;

/**
 *
 * @author Neto
 */
public class MainSchool extends Application {
    
    private static Stage stage;    
    private static LDE<Professor> ldeProfPP;
    private static LDE<Aluno> ldeAlunoPP = new LDE<Aluno>();
    private static Aluno alunoPP = new Aluno("");
    //private double xOffset = 0;
    //private double yOffset = 0;
    
    @Override
    public void start(Stage primaryStage) {
        try {
            stage = primaryStage;

            AnchorPane fxmlMenu = (AnchorPane)FXMLLoader.load(getClass().getResource("/FXML/MainSchool.fxml"));
            /*
            //grab your root here
            fxmlMenu.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            
            });
            
            fxmlMenu.setOnMouseDragged(event -> {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            });
            */
            
            
            Scene scene = new Scene(fxmlMenu,1280,710);           
            scene.getStylesheets().add(getClass().getResource("/CSS/CSSMainSchool.css").toExternalForm());
            
            
            
            stage.setTitle("SCHOOLCAD");            
            stage.setScene(scene);
            stage.setMaximized(true);
            //ESSA FUNÇÃO A BAIXO FAZ A TELA FICAR CHEIA
            //stage.setFullScreen(true); 
            //stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
            setStage(stage);
            
            //ANIMATION
            //new FadeIn(fxmlMenu).play();
            
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
    
    //METODO PARA VER QUAL A CONFIGURAÇÃO DA RESOLUÇÃO DO PC
    /*
    public static int getWH(int v) {
        Toolkit tk;
        tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        if(v == 1) {                
            return d.width;
        }
        else {
            return d.height;
        }        
    }*/

    public static LDE<Aluno> getLdeAlunoPP() {
        return ldeAlunoPP;
    }

    public static void setLdeAlunoPP(LDE<Aluno> ldeAlunoPP) {
        MainSchool.ldeAlunoPP = ldeAlunoPP;
    }

//<<<<<<< HEAD (0323b65) - Feito as validações dos
    public static Aluno getAlunoPP() {
        return alunoPP;
    }

    public static void setAlunoPP(Aluno alunoPP) {
        MainSchool.alunoPP = alunoPP;
    }
    
    

    
//=======
    public static LDE<Professor> getLdeProfPP() {
        return ldeProfPP;
    }

    public static void setLdeProfPP(LDE<Professor> ldeProfPP) {
        MainSchool.ldeProfPP = ldeProfPP;
    }
//>>>>>>> origin/master (ce9095f) - Criação da lde
    
}

