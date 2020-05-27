package controller;

import Aplicacao.BuscaTurmaAluno;
import Aplicacao.BuscaTurmaDisc;
import Aplicacao.BuscaTurmaProf;
import Aplicacao.ListarTurma;
import Aplicacao.ListarTurmaAluno;
import Aplicacao.ListarTurmaMenu;
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
public class ListarTurmaMenuController implements Initializable {
    
    @FXML private JFXButton btListTurmas;
    @FXML private JFXButton btTurmasAluno;
    @FXML private JFXButton btTurmasProf;
    @FXML private JFXButton btTurmasDisc;
    @FXML private JFXButton btVCancelar;

    @FXML
    void ActionListTurmas(ActionEvent event) {
                           
        ListarTurma lt = new ListarTurma();

        try {
            lt.start(new Stage());    		
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        fechar();

    }

    @FXML
    void ActionTurmasAluno(ActionEvent event) {
        
        BuscaTurmaAluno bta = new BuscaTurmaAluno();

        try {
            bta.start(new Stage());    		
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        fechar();

    }

    @FXML
    void ActionTurmasDisc(ActionEvent event) {
        
        BuscaTurmaDisc btd = new BuscaTurmaDisc();

        try {
            btd.start(new Stage());    		
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        fechar();

    }

    @FXML
    void ActionTurmasProf(ActionEvent event) {
        
        BuscaTurmaProf btp = new BuscaTurmaProf();

        try {
            btp.start(new Stage());    		
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
        ListarTurmaMenu.getStage().close();
    }
    
}
