package controller;

import Aplicacao.RemTurma;
import Aplicacao.RemTurmaAlunos;
import Aplicacao.RemTurmaMenu;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class RemTurmaMenuController implements Initializable {
    
    @FXML private JFXButton btTurma;
    @FXML private JFXButton btAlunos;
    @FXML private JFXButton btCancelar;

    @FXML
    void ActionRemTurma(ActionEvent event) {
        RemTurma rt = new RemTurma();
            
            try {
                    rt.start(new Stage());    		
            }catch(Exception ex) {
                    ex.printStackTrace();
            }
            fechar();
    }

    @FXML
    void ActionRemTurmaAlunos(ActionEvent event) {
        RemTurmaAlunos rta = new RemTurmaAlunos();
            
            try {
                    rta.start(new Stage());    		
            }catch(Exception ex) {
                    ex.printStackTrace();
            }
            fechar();
    }

    @FXML
    void ActionBtCancelar(ActionEvent event) {
        fechar();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void fechar() {
        RemTurmaMenu.getStage().close();
    }
    
}
