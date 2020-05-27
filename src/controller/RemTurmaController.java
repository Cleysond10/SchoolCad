package controller;

import Aplicacao.MainSchool;
import Aplicacao.RemTurma;
import com.jfoenix.controls.JFXTextField;
import interfaceValidacao.MascaraFX;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import tiposdados.Turma;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class RemTurmaController implements Initializable {
    
    @FXML private JFXTextField tfBuscaTurma;
    
    private Turma turma;

    @FXML
    void acaoBtCancelar(ActionEvent event) {
        fechar();
    }

    @FXML
    void acaoBtRem(ActionEvent event) {
        turma = new Turma(tfBuscaTurma.getText(), "");
        
        if(MainSchool.getLdeTurma().consulta(turma) != null) {
            
            MainSchool.getLdeTurma().remover(turma);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("VALIDAÇÃO");
            alert.setContentText("Turma Removida");
            alert.show();
            
            fechar();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("VALIDAÇÃO");
            alert.setContentText("Código Inválido!!! \n Tente Novamente");
            alert.show();            
        } 
    }
    
    public void carregarMascara() {
        MascaraFX mascara = new MascaraFX();
        mascara.mascaraCodTurma(tfBuscaTurma);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarMascara();
    }    
    
    public void fechar() {
        RemTurma.getStage().close();
    }
    
}
