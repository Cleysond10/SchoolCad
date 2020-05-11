/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Aplicacao.AltCadAluno;
import Aplicacao.MainSchool;
import com.jfoenix.controls.JFXTextField;
import interfaceValidacao.MascaraFX;
import interfaceValidacao.ValidacaoDados;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import tidosdados.Aluno;

/**
 * FXML Controller class
 *
 * @author Neto
 */
public class AltCadAlunoController implements Initializable {

    @FXML private JFXTextField tfNome;
    @FXML private JFXTextField tfCPF;
    @FXML private JFXTextField tfRG;
    @FXML private JFXTextField tfData;
    @FXML private JFXTextField tfSexo;
    @FXML private JFXTextField tfEnd;
    @FXML private JFXTextField tfTel;
    @FXML private JFXTextField tfEmail;
    
    private Aluno aluno;

    @FXML
    void acaoBtCancelar(ActionEvent event) {
        fechar();
    }

    @FXML
    void acaoBtSalvar(ActionEvent event) {
        ValidacaoDados valida = new ValidacaoDados();
        String x = tfCPF.getText();
        String cpf = "";
        
        
        for(int i = 0; i<x.length(); i++) {
            if(x.charAt(i) != '.' && x.charAt(i) != '-') {
                cpf = cpf + x.charAt(i);                
            }
        }      
        
        
        if(valida.isValidData(tfData.getText())==0 && valida.isValidEmail(tfEmail.getText())==0 && valida.isValidNome(tfNome.getText())==0 && valida.isValidCPF(cpf)==0) {
            aluno = new Aluno(tfCPF.getText());
            aluno.setEmail(tfEmail.getText());
            aluno.setDataN(tfData.getText());
            
            String nome;
            nome = tfNome.getText();
            nome = nome.toUpperCase();
            aluno.setNome(nome);
            
            aluno.setRg(tfRG.getText());
            aluno.setTelefone(tfTel.getText());        
            
            String endereco;
            endereco = tfEnd.getText();
            endereco = endereco.toUpperCase();
            aluno.setEndereço(tfEnd.getText());            
            
            aluno.setSexo(tfSexo.getText());
            
            
            MainSchool.getLdeAlunoPP().add(aluno);
            
            fechar();
        }
        else {
            System.out.println("Não Valido");
            
            if(valida.isValidEmail(tfEmail.getText())==1) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("VALIDAÇÃO");
                alert.setContentText("Verifique seu Email");
                alert.show();                
            }
            else if(valida.isValidData(tfData.getText())==2) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("VALIDAÇÃO");
                alert.setContentText("Verifique a Data de Nascimento");
                alert.show();                
            }
            else if(valida.isValidNome(tfNome.getText())==3) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("VALIDAÇÃO");
                alert.setContentText("Verifique o Nome");
                alert.show();                
            }
            else if(valida.isValidCPF(cpf)==4) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("VALIDAÇÃO");
                alert.setContentText("Verifique o CPF");
                alert.show();                
            }
            
        }
        MainSchool.getLdeAlunoPP().exibir();
        

    }
    
    public void carregarMascara() {
        MascaraFX mascara = new MascaraFX();
        mascara.mascaraCPF(tfCPF);
        mascara.mascaraData(tfData);
        mascara.mascaraTel(tfTel);
        mascara.mascaraRG(tfRG);
    }
    
    public void carregar() {
        tfNome.setText(MainSchool.getAlunoPP().getNome());
        tfCPF.setText(MainSchool.getAlunoPP().getCpf());
        tfRG.setText(MainSchool.getAlunoPP().getRg());
        tfData.setText(MainSchool.getAlunoPP().getDataN());
        tfSexo.setText(MainSchool.getAlunoPP().getSexo());
        tfEnd.setText(MainSchool.getAlunoPP().getEndereço());
        tfTel.setText(MainSchool.getAlunoPP().getTelefone());
        tfEmail.setText(MainSchool.getAlunoPP().getEmail()); 
        
        aluno = MainSchool.getAlunoPP();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.carregarMascara();
        this.carregar();
    } 
    
    public void fechar() {
        AltCadAluno.getStage().close();
    }
    
}
