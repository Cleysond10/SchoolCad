package controller;

import Aplicacao.MainSchool;
import Aplicacao.RemProf;
import com.jfoenix.controls.JFXTextField;
import interfaceValidacao.MascaraFX;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import tiposdados.Professor;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class RemProfController implements Initializable {

    private Professor prof;
    @FXML private JFXTextField tfBuscaCPF;

    @FXML
    void acaoBtCancelar(ActionEvent event) {
        fechar();
    }

    @FXML
    void acaoBtRem(ActionEvent event) {
        
        prof = new Professor(tfBuscaCPF.getText());
        
        if(MainSchool.getLdeProf().consulta(prof) != null) {

            prof = MainSchool.getLdeProf().consulta(prof);
            MainSchool.getLdeProf().remover(prof);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("CONFIRMAÇÃO");
            alert.setContentText("Removido com Sucesso.");
            alert.show();

            fechar();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("VALIDAÇÃO");
            alert.setContentText("CPF Inválido!!! \n Tente Novamente");
            alert.show();
        }
    }
    
    public void carregarMascara() {
        MascaraFX mascara = new MascaraFX();
        mascara.mascaraCPF(tfBuscaCPF);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarMascara();
    }    
    
    public void fechar() {
        RemProf.getStage().close();
    }
    
}
