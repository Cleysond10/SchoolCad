package controller;

import Aplicacao.MainSchool;
import Aplicacao.RemTurmaAlunos;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import interfaceValidacao.MascaraFX;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import tiposdados.Aluno;
import tiposdados.Turma;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class RemTurmaAlunosController implements Initializable {
    
    @FXML private JFXTextField tfBuscaAluno;
    @FXML private JFXComboBox<Turma> cbCodTurma;
    ObservableList<Turma> obsTurmaAluno = FXCollections.observableArrayList();

    @FXML
    void acaoBtCancelar(ActionEvent event) {
        fechar();
    }

    @FXML
    void acaoBtRem(ActionEvent event) {
        Aluno aluno = new Aluno(tfBuscaAluno.getText());
        Turma turma = cbCodTurma.getSelectionModel().getSelectedItem();
        Aluno[] vAluno = turma.getAlunos();
                
        
        if(cbCodTurma.getSelectionModel().getSelectedItem().getQtdAl() != 0) {
            int k =0;
            for(int i =0; i < vAluno.length; i++) {
            
                if(vAluno[i].compareTo(aluno) == 0) {
                    k=i;
                    vAluno[i] = null;
                    vAluno[i].setQtdVTurmas(vAluno[i].getQtdVTurmas() - 1);
                    for(i = i; i < vAluno.length -1; i++) {
                        vAluno[i] = vAluno[i+1];
                    }
                    
            
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("VALIDAÇÃO");
                    alert.setContentText("Aluno Removido");
                    alert.show();

                    fechar();                
                }
            }
            if(vAluno[k].compareTo(aluno) != 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("VALIDAÇÃO");
                alert.setContentText("Aluno Não Existe!!! \n Tente Novamente");
                alert.show();            
            }
            
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("VALIDAÇÃO");
            alert.setContentText("Não Existe Alunos Cadastrado!!! \n Tente Outra Turma");
            alert.show();            
        }
        
    }
    
    public void carregarList(){
        Turma[] vTurma = MainSchool.getLdeTurma().listaTurma();
        
        obsTurmaAluno.addAll(vTurma);
        cbCodTurma.setItems(obsTurmaAluno);
               
    }
    
    public void carregarMascara() {
        MascaraFX mascara = new MascaraFX();
        mascara.mascaraCPF(tfBuscaAluno);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarMascara();
        carregarList();
    }

    public void fechar(){
        RemTurmaAlunos.getStage().close();
    }
    
}
