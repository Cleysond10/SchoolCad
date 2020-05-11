package controller;

import Aplicacao.MainSchool;
import Aplicacao.RemoverAluno;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import tidosdados.Aluno;

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
        MainSchool.getLdeAlunoPP().remover(aluno);
        
        fechar();

    }

    @FXML
    void acaoBtCancelar(ActionEvent event) {
        fechar();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void fechar() {
        RemoverAluno.getStage().close();
    }
    
}
