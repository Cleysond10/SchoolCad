package controller;

import Aplicacao.CadTurmaAlunos;
import Aplicacao.CadTurmaMenu;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

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
        CadTurmaMenu ctm = new CadTurmaMenu();

        try {
            ctm.start(new Stage());
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
        CadTurmaAlunos.getStage().close();
    }
    
}
