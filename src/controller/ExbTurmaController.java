package controller;

import Aplicacao.ExbTurma;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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
public class ExbTurmaController implements Initializable {
    
    @FXML private JFXTextField tfBuscCpf;
    @FXML private JFXButton btBuscar;
    @FXML private JFXButton btCancelar;

    @FXML
    void ActionBtBuscar(ActionEvent event) {
        
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
        ExbTurma.getStage().close();
    }
    
}
