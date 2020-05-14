package controller;

import Aplicacao.CadProf;
import Aplicacao.MainSchool;
import interfaceValidacao.MascaraFX;
import interfaceValidacao.ValidacaoDados;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import tidosdados.Professor;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class CadProfController implements Initializable {
    
    @FXML private JFXTextField tfNome;
    @FXML private JFXTextField tfCpf;
    @FXML private JFXTextField tfRg;
    @FXML private JFXTextField tfTel;
    @FXML private JFXTextField tfEnd;
    @FXML private JFXTextField tfDnasc;
    @FXML private JFXTextField tfSexo;
    @FXML private JFXTextField tfEmail;
    @FXML private JFXTextField tfFormAcad;
    private Professor prof;
    
     @FXML
    void BtCadProf(ActionEvent event) {
        ValidacaoDados valida = new ValidacaoDados();
        String x = tfCpf.getText();
        String cpf = "";
                
        for(int i = 0; i<x.length(); i++) {
            if(x.charAt(i) != '.' && x.charAt(i) != '-') {
                cpf = cpf + x.charAt(i);                
            }
        }      
                
        if(valida.isValidData(tfDnasc.getText())==0 && valida.isValidEmail(tfEmail.getText())==0 && valida.isValidNome(tfNome.getText())==0 && valida.isValidCPF(cpf)==0) {
            prof = new Professor(tfCpf.getText());
            prof.setEmail(tfEmail.getText());
            prof.setDataN(tfDnasc.getText());
            
            String nome;
            nome = tfNome.getText();
            nome = nome.toUpperCase();
            prof.setNome(nome);
            
            prof.setRg(tfRg.getText());
            prof.setTelefone(tfTel.getText());        
            
            String endereco;
            endereco = tfEnd.getText();
            endereco = endereco.toUpperCase();
            prof.setEndereço(endereco);            
            
            prof.setSexo(tfSexo.getText());
            
            prof.setFormAcad(tfFormAcad.getText());            
            
            MainSchool.getLdeProf().add(prof);
            
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
            else if(valida.isValidData(tfDnasc.getText())==2) {
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
    }
    
    public void carregar() {
        MascaraFX mascara = new MascaraFX();
        mascara.mascaraCPF(tfCpf);
        mascara.mascaraData(tfDnasc);
        mascara.mascaraTel(tfTel);
        mascara.mascaraRG(tfRg);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.carregar();
    }
    
    public void fechar() {
        CadProf.getStage().close();
    }
    
}
