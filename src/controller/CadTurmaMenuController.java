package controller;

import Aplicacao.CadTurma;
import Aplicacao.CadTurmaAlunos;
import Aplicacao.CadTurmaMenu;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class CadTurmaMenuController implements Initializable {

    @FXML private JFXButton btNovaTurma;
    @FXML private JFXButton btInserirAluno;
    @FXML private JFXButton btCancelar;

     @FXML
    void ActionBtCancelar(ActionEvent event) {
        fechar();
    }

    @FXML
    void ActionInserirAluno(ActionEvent event) {
        CadTurmaAlunos cta = new CadTurmaAlunos();

            try {
                    cta.start(new Stage());
            }catch(Exception ex) {
                    ex.printStackTrace();
            }
            
        fechar();
    }

    @FXML
    void ActionNovaTurma(ActionEvent event) {
        CadTurma ct = new CadTurma();

            try {
                    ct.start(new Stage());
            }catch(Exception ex) {
                    ex.printStackTrace();
            }
            
        fechar();
            
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void fechar() {
        CadTurmaMenu.getStage().close();
    }
    
}
