package Aplicacao;

import estruturadados.LDE;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tiposdados.Aluno;
import tiposdados.Disciplina;
import tiposdados.Professor;
import tiposdados.Turma;

/**
 *
 * @author Neto e Cleyson
 */
public class MainSchool extends Application {
    
    private static Stage stage;    
    private static LDE<Professor> ldeProf = new LDE<Professor>();
    private static Professor prof;
    private static LDE<Aluno> ldeAlunoPP = new LDE<Aluno>();
    private static Aluno alunoPP;
    private static LDE<Disciplina> ldeDisc = new LDE<Disciplina>();
    private static Disciplina Disc;
    private static LDE<Turma> ldeTurma = new LDE<Turma>();
    private static Turma Turma;
    
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
            
            
            stage.initStyle(StageStyle.UNDECORATED);
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

    
    // GET \ SET DISCIPLINA E LDE DISCIPLINA
    public static LDE<Disciplina> getLdeDisc() {
        return ldeDisc;
    }

    public static void setLdeDisc(LDE<Disciplina> ldeDisc) {
        MainSchool.ldeDisc = ldeDisc;
    }

    public static Disciplina getDisc() {
        return Disc;
    }

    public static void setDisc(Disciplina Disc) {
        MainSchool.Disc = Disc;
    }
    

    
//=======
    public static LDE<Professor> getLdeProf() {
        return ldeProf;
    }

    public static void setLdeProf(LDE<Professor> ldeProf) {
        MainSchool.ldeProf = ldeProf;
    }
    
    public static Professor getProf() {
        return prof;
    }

    public static void setProf(Professor prof) {
        MainSchool.prof = prof;
    }
    
    //Get & Set - LDE Turma
    
    public static LDE<Turma> getLdeTurma() {
        return ldeTurma;
    }

    public static void setLdeTurma(LDE<Turma> ldeTurma) {
        MainSchool.ldeTurma = ldeTurma;
    }

    public static Turma getTurma() {
        return Turma;
    }

    public static void setTurma(Turma Turma) {
        MainSchool.Turma = Turma;
    }

    
//>>>>>>> origin/master (ce9095f) - Criação da lde

  
}

