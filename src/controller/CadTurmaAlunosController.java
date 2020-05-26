package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class CadTurmaAlunosController implements Initializable {

    @FXML private ComboBox<String> cbCodTurma;
    @FXML private ComboBox<String> cbAlunos;
    @FXML private Button btInserir;
    @FXML private Button btVoltar;

    @FXML
    void ActionBtInserir(ActionEvent event) {

    }

    @FXML
    void ActionBtVoltar(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
