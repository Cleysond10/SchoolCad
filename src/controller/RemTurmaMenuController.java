package controller;

import Aplicacao.RemTurmaMenu;
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
public class RemTurmaMenuController implements Initializable {
    
    @FXML private JFXButton btTurma;
    @FXML private JFXButton btAlunos;
    @FXML private JFXButton btCancelar;

    @FXML
    void ActionRemTurma(ActionEvent event) {

    }

    @FXML
    void ActionRemTurmaAlunos(ActionEvent event) {

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
