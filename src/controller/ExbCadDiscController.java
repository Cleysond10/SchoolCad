package controller;

import Aplicacao.AltCadAluno;
import Aplicacao.AltCadDisc;
import Aplicacao.ExbCadDisc;
import Aplicacao.MainSchool;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import tiposdados.Disciplina;

/**
 * FXML Controller class
 *
 * @author Neto e Cleyson
 */
public class ExbCadDiscController implements Initializable {
    
    @FXML private Label lbCodDisc;
    @FXML private Label lbNome;
    @FXML private Label lbPeriodo;
    @FXML private Label lbCargaH;
    @FXML private Label lbCred;
    
    private Disciplina disc;
    
    @FXML
    void acaoBtCancelar(ActionEvent event) {
        fechar();
    }

     @FXML
    void acaoBtAlterar(ActionEvent event) {
        
        AltCadDisc aca = new AltCadDisc();
        
        try {
            aca.start(new Stage());    		
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        fechar();

    }

    @FXML
    void acaoBtRemover(ActionEvent event) {
        
        disc = new Disciplina(lbCodDisc.getText());       
        
        if(MainSchool.getLdeDisc().consulta(disc) != null) {            
            disc = MainSchool.getLdeDisc().consulta(disc);
            
            if(disc.getQtdVTurma() == 0) {
                MainSchool.getLdeDisc().remover(MainSchool.getDisc());

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("VALIDAÇÃO");
                alert.setContentText("Disciplina Removido");
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
    
    public void carregar() {
        lbNome.setText(MainSchool.getDisc().getNome());
        lbCodDisc.setText(MainSchool.getDisc().getCodDisc());
        lbCred.setText(MainSchool.getDisc().getCredito());
        lbCargaH.setText(MainSchool.getDisc().getCargaH());
        lbPeriodo.setText(MainSchool.getDisc().getPeriodo());
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.carregar();
    }

    public void fechar() {
        ExbCadDisc.getStage().close();
    }
    
}
