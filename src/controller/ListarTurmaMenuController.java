package controller;

import Aplicacao.ListarTurmaMenu;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

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

    }

    @FXML
    void ActionTurmasAluno(ActionEvent event) {

    }

    @FXML
    void ActionTurmasDisc(ActionEvent event) {

    }

    @FXML
    void ActionTurmasProf(ActionEvent event) {

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
