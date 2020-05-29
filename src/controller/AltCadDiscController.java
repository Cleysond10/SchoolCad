/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Aplicacao.AltCadAluno;
import Aplicacao.AltCadDisc;
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
import tiposdados.Aluno;
import tiposdados.Disciplina;

/**
 * FXML Controller class
 *
 * @author Neto e Cleyson
 */
public class AltCadDiscController implements Initializable {

    @FXML private JFXTextField tfCodDisc;
    @FXML private JFXTextField tfNome;
    @FXML private JFXTextField tfCargaH;
    @FXML private JFXTextField tfCred;
    @FXML private JFXTextField tfPeriodo;    
    private Disciplina disc;

    @FXML
    void acaoBtCancelar(ActionEvent event) {
        fechar();
    }

    @FXML
    void acaoBtSalvar(ActionEvent event) {
        ValidacaoDados valida = new ValidacaoDados();
        
        
        if(valida.isValidNome(tfNome.getText())==0 && valida.isValidCargaH(tfCargaH.getText())==0 && valida.isValidCodDisc(tfCodDisc.getText()) == 0) {
            String x;
            x = tfCodDisc.getText();
            x = x.toUpperCase();
            disc.setCodDisc(x);

            x = tfNome.getText();
            x = x.toUpperCase();
            disc.setNome(x);

            disc.setCargaH(tfCargaH.getText());

            disc.setCredito(tfCred.getText());

            x = tfPeriodo.getText();
            x = x.toUpperCase();
            disc.setPeriodo(x);



            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("VALIDAÇÃO");
            alert.setContentText("Cadastro Salvo com Sucesso.");
            alert.show();                

            fechar();
        }
        else {
            String vCagaH = "", vCodDisc = "", vNome = "";
            if(valida.isValidCargaH(tfCargaH.getText())==7) {
                vCagaH = "Verifique a Carga Horária";
            }

            if(valida.isValidNome(tfNome.getText())==3) {
                vNome = "Verifique o Nome";
            }
            if(valida.isValidCodDisc(tfCodDisc.getText())==10) {
                vCodDisc = "Verifique o Código da Disciplina";
            }


            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("VALIDAÇÃO");
            alert.setContentText(vCagaH + "\n" + vCodDisc + "\n" + vNome);
            alert.show();
            alert.show();
        }
    }
    
    public void carregarMascara() {
        MascaraFX mascara = new MascaraFX();
        mascara.mascaraCodDisc(tfCodDisc);
        mascara.mascaraCargaH(tfCargaH);
        mascara.mascaraCred(tfCred);
    }
    
    public void carregar() {
        tfNome.setText(MainSchool.getDisc().getNome());
        tfCodDisc.setText(MainSchool.getDisc().getCodDisc());
        tfCargaH.setText(MainSchool.getDisc().getCargaH());
        tfCred.setText(MainSchool.getDisc().getCredito());
        tfPeriodo.setText(MainSchool.getDisc().getPeriodo());
        
        disc = MainSchool.getDisc();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.carregarMascara();
        this.carregar();
    } 
    
    public void fechar() {
        AltCadDisc.getStage().close();
    }
    
}
