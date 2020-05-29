package controller;

import Aplicacao.MainSchool;
import Aplicacao.RemoverDisc;
import com.jfoenix.controls.JFXTextField;
import interfaceValidacao.MascaraFX;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import tiposdados.Disciplina;

/**
 * FXML Controller class
 *
 * @author Neto e Cleyson
 */
public class RemoverDiscController implements Initializable {
      
    private Disciplina disc;    
    @FXML private JFXTextField tfCodDisc;

    @FXML
    void acaoBtBuscar(ActionEvent event) {
        disc = new Disciplina(tfCodDisc.getText());       
        
        if(MainSchool.getLdeDisc().consulta(disc) != null) {
            disc = MainSchool.getLdeDisc().consulta(disc);
            if(disc.getQtdVTurma() == 0) {
                MainSchool.getLdeDisc().remover(disc);
            
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("VALIDAÇÃO");
                alert.setContentText("Aluno Removido");
                alert.show();

                fechar();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("VALIDAÇÃO");
                alert.setContentText("Disciplina Cadastrada em uma Turma");
                alert.show();
            }
            
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("VALIDAÇÃO");
            alert.setContentText("Código da Disciplina Inválido!!! \n Tente Novamente");
            alert.show();
        }

    }

    @FXML
    void acaoBtCancelar(ActionEvent event) {
        fechar();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarMascara();
    }
    
    public void carregarMascara() {
        MascaraFX mascara = new MascaraFX();
        mascara.mascaraCodDisc(tfCodDisc);
    }
    
    public void fechar() {
        RemoverDisc.getStage().close();
    }
    
}
