package controller;

import Aplicacao.MainSchool;
import Aplicacao.RemoverAluno;
import com.jfoenix.controls.JFXTextField;
import interfaceValidacao.MascaraFX;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import tiposdados.Aluno;

/**
 * FXML Controller class
 *
 * @author Neto e Cleyson
 */
public class RemoverAlunoController implements Initializable {
      
    private Aluno aluno;
    //private LDE<Aluno> ldeAlunoRem;
    @FXML private JFXTextField tfBuscaCPF;

    @FXML
    void acaoBtBuscar(ActionEvent event) {
        aluno = new Aluno(tfBuscaCPF.getText());       
        
        if(MainSchool.getLdeAlunoPP().consulta(aluno) != null) {
            
            MainSchool.getLdeAlunoPP().remover(aluno);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("VALIDAÇÃO");
            alert.setContentText("Aluno Removido");
            alert.show();
            
            fechar();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("VALIDAÇÃO");
            alert.setContentText("CPF Não Enontrado!!! \n Tente Novamente");
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
        mascara.mascaraCPF(tfBuscaCPF);
    }
    
    public void fechar() {
        RemoverAluno.getStage().close();
    }
    
}
