package controller;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ExbCadTurmaController implements Initializable {
    
    @FXML private JFXTextField tfCodTurma;
    @FXML private JFXTextField tfHorario;
    @FXML private JFXTextField tfPLetivo;
    @FXML private JFXTextField tfQtdMaxAl;
    @FXML private JFXTextField tfDisc;
    @FXML private JFXTextField tfProf;
    @FXML private JFXListView<String> lvAlunos;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
