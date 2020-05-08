package controller;

import Aplicacao.BuscaExbAluno;
import Aplicacao.ExbCadAluno;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Neto
 */
public class ExbCadAlunoController implements Initializable {
    
    @FXML private JFXTextField tfNome;
    @FXML private JFXTextField tfCPF;
    @FXML private JFXTextField tfRG;
    @FXML private JFXTextField tfData;
    @FXML private JFXTextField tfSexo;
    @FXML private JFXTextField tfEnd;
    @FXML private JFXTextField tfTel;
    @FXML private JFXTextField tfEmail;

    @FXML
    void acaoBtCancelar(ActionEvent event) {
        fechar();
    }

    @FXML
    void acaoBtSalvar(ActionEvent event) {

    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    tfNome.setDisable(true);
    tfCPF.setDisable(true);
    tfRG.setDisable(true);
    tfData.setDisable(true);
    tfSexo.setDisable(true);
    tfEnd.setDisable(true);
    tfTel.setDisable(true);
    tfEmail.setDisable(true);
    }

    public void fechar() {
        ExbCadAluno.getStage().close();
    }
    
}
