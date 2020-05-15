package controller;

import Aplicacao.CadAluno;
import Aplicacao.CadDisc;
import Aplicacao.MainSchool;
import com.jfoenix.controls.JFXTextField;
import interfaceValidacao.MascaraFX;
import interfaceValidacao.ValidacaoDados;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import tiposdados.Aluno;
import tiposdados.Disciplina;

/**
 * FXML Controller class
 *
 * @author Neto e Cleyson
 */
public class CadDiscController implements Initializable {
    
    
    @FXML private JFXTextField tfCodDisc;
    @FXML private JFXTextField tfNome;
    @FXML private JFXTextField tfCargaH;
    @FXML private JFXTextField tfCred;
    @FXML private JFXTextField tfPeriodo;    
    private Disciplina Disc;

    @FXML
    void acaoBtCancelar(ActionEvent event) {
        fechar();
    }

    @FXML
    void acaoBtSalvar(ActionEvent event) {
        
        ValidacaoDados valida = new ValidacaoDados();
        
        
        
        
        if(valida.isValidNome(tfNome.getText())==0 && valida.isValidCargaH(tfCargaH.getText())==0) {
            String x;
        x = tfCodDisc.getText();
        x = x.toUpperCase();
        Disc = new Disciplina(x);
        
        x = tfNome.getText();
        x = x.toUpperCase();
        Disc.setNome(x);
                
        Disc.setCargaH(tfCargaH.getText());
        
        Disc.setCredito(tfCred.getText());

        x = tfPeriodo.getText();
        x = x.toUpperCase();
        Disc.setPeriodo(x);
        
        MainSchool.getLdeDisc().add(Disc);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("VALIDAÇÃO");
            alert.setContentText("Cadastro Salvo com Sucesso.");
            alert.show();                
            
            fechar();
        }
        else {
            System.out.println("Não Valido");
            
            if(valida.isValidNome(tfNome.getText())==3) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("VALIDAÇÃO");
                alert.setContentText("Verifique o Nome");
                alert.show();                
            }            
            else if(valida.isValidCargaH(tfCargaH.getText())==7) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("VALIDAÇÃO");
                alert.setContentText("Verifique a Carga Horária");
                alert.show();                
            }
            
        }
        
        //ldeAlunoCad = MainSchool.getLdeAlunoPP();
        //ldeAlunoCad.add(aluno);
        //MainSchool.setLdeAlunoPP(ldeAlunoCad);
        
    }
    
    public void carregar() {
        MascaraFX mascara = new MascaraFX();
        mascara.mascaraCodDisc(tfCodDisc);
        mascara.mascaraCargaH(tfCargaH);
        mascara.mascaraCred(tfCred);
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        //ldeAlunoCad = MainSchool.getLdeAlunoPP();
        this.carregar();
    } 
    
    public void fechar() {
        CadDisc.getStage().close();
    }
    
    
}
