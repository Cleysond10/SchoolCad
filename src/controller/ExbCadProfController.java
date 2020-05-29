package controller;

import Aplicacao.AltCadAluno;
import Aplicacao.AltCadProf;
import Aplicacao.ExbCadProf;
import Aplicacao.MainSchool;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import tiposdados.Professor;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ExbCadProfController implements Initializable {
    
    @FXML private Label lbNome;
    @FXML private Label lbCpf;
    @FXML private Label lbRg;
    @FXML private Label lbDnasc;
    @FXML private Label lbSexo;
    @FXML private Label lbEnd;
    @FXML private Label lbTel;
    @FXML private Label lbEmail;
    @FXML private Label lbFormAcad;
    
    private Professor prof;

    @FXML
    void acaoBtVoltar(ActionEvent event) {
        fechar();
    }
    
     @FXML
    void acaoBtAlterar(ActionEvent event) {
        AltCadProf aca = new AltCadProf();
        
        try {
            aca.start(new Stage());    		
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        fechar();
    }

    @FXML
    void acaoBtRemover(ActionEvent event) {
        
        prof = new Professor(lbCpf.getText());
        
        if(MainSchool.getLdeProf().consulta(prof) != null) {

            prof = MainSchool.getLdeProf().consulta(prof);
            if(prof.getQtdVTurmas() == 0) {
                MainSchool.getLdeProf().remover(prof);
            
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("CONFIRMAÇÃO");
                alert.setContentText("Removido com Sucesso.");
                alert.show();

                fechar();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("VALIDAÇÃO");
                alert.setContentText("Professor Cadastrado em uma Turma");
                alert.show();
            }
            
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("VALIDAÇÃO");
            alert.setContentText("CPF Inválido!!! \n Tente Novamente");
            alert.show();
        }

    }
    
    public void carregar() {
        lbNome.setText(MainSchool.getProf().getNome());
        lbCpf.setText(MainSchool.getProf().getCpf());
        lbRg.setText(MainSchool.getProf().getRg());
        lbDnasc.setText(MainSchool.getProf().getDataN());
        lbSexo.setText(MainSchool.getProf().getSexo());
        lbEnd.setText(MainSchool.getProf().getEndereço());
        lbTel.setText(MainSchool.getProf().getTelefone());
        lbEmail.setText(MainSchool.getProf().getEmail());
        lbFormAcad.setText(MainSchool.getProf().getFormAcad());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.carregar();
    }

    public void fechar() {
        ExbCadProf.getStage().close();
    }    
    
}
