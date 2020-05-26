package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
public class CadTurmaController implements Initializable {
    
    @FXML private JFXTextField tfCodTurma;
    @FXML private JFXTextField tfHorario;
    @FXML private JFXTextField tfPLetivo;
    @FXML private JFXTextField tfQtdMaxAl;
    @FXML private JFXComboBox<String> cbDisc;
    @FXML private JFXComboBox<String> cbProfx;
    @FXML private JFXButton btVoltar;

    @FXML
    void ActionBtVoltar(ActionEvent event) {
        
    }

    @FXML
    void BtCadTurma(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
