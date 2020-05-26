package controller;

import Aplicacao.AltTurma;
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
public class AltTurmaController implements Initializable {

    @FXML
    void acaoBtBuscar(ActionEvent event) {
        
    }
    
    @FXML
    void acaoBtCancelar(ActionEvent event) {
        fechar();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void fechar() {
        AltTurma.getStage().close();
    }
    
}
