/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Aplicacao.CadAluno;
import Aplicacao.MainSchool;
import com.jfoenix.controls.JFXTextField;
import estruturadados.LDE;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import tidosdados.Aluno;

/**
 * FXML Controller class
 *
 * @author Neto
 */
public class CadAlunoController implements Initializable {
    
    @FXML private JFXTextField tfNome;
    @FXML private JFXTextField tfCPF;
    @FXML private JFXTextField tfRG;
    @FXML private JFXTextField tfData;
    @FXML private JFXTextField tfSexo;
    @FXML private JFXTextField tfEnd;
    @FXML private JFXTextField tfTel;
    @FXML private JFXTextField tfEmail;
    //private LDE<Aluno> ldeAlunoCad;
    private Aluno aluno;

    @FXML
    void acaoBtCancelar(ActionEvent event) {
        fechar();
    }

    @FXML
    void acaoBtSalvar(ActionEvent event) {
        aluno = new Aluno(tfCPF.getText());
        aluno.setDataN(tfData.getText());
        aluno.setEmail(tfEmail.getText());
        aluno.setEndereço(tfEnd.getText());
        aluno.setNome(tfNome.getText());
        aluno.setRg(tfRG.getText());
        aluno.setSexo(tfSexo.getText());
        aluno.setTelefone(tfTel.getText());
        MainSchool.getLdeAlunoPP().add(aluno);
        
        
        //ldeAlunoCad = MainSchool.getLdeAlunoPP();
        //ldeAlunoCad.add(aluno);
        //MainSchool.setLdeAlunoPP(ldeAlunoCad);
        fechar();
        

    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //ldeAlunoCad = MainSchool.getLdeAlunoPP();
    } 
    
    public void fechar() {
        CadAluno.getStage().close();
    }   
    
}
