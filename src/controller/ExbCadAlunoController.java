package controller;

import Aplicacao.AltCadAluno;
import Aplicacao.BuscaExbAluno;
import Aplicacao.ExbCadAluno;
import Aplicacao.MainSchool;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Neto
 */
public class ExbCadAlunoController implements Initializable {
    
    @FXML private Label lbNome;
    @FXML private Label lbCPF;
    @FXML private Label lbRG;
    @FXML private Label lbDataN;
    @FXML private Label lbSexo;
    @FXML private Label lbEnd;
    @FXML private Label lbTel;
    @FXML private Label lbEmail;

    @FXML
    void acaoBtCancelar(ActionEvent event) {
        fechar();
    }

    @FXML
    void acaoBtAlterar(ActionEvent event) {
        
        AltCadAluno aca = new AltCadAluno();
        
        try {
            aca.start(new Stage());    		
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        fechar();

    }
    
    @FXML
    void acaoBtRemover(ActionEvent event) {
        
        MainSchool.getLdeAlunoPP().remover(MainSchool.getAlunoPP());
            
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("VALIDAÇÃO");
        alert.setContentText("Aluno Removido");
        alert.show();

        fechar();

    }
    
    public void carregar() {
        lbNome.setText(MainSchool.getAlunoPP().getNome());
        lbCPF.setText(MainSchool.getAlunoPP().getCpf());
        lbRG.setText(MainSchool.getAlunoPP().getRg());
        lbDataN.setText(MainSchool.getAlunoPP().getDataN());
        lbSexo.setText(MainSchool.getAlunoPP().getSexo());
        lbEnd.setText(MainSchool.getAlunoPP().getEndereço());
        lbTel.setText(MainSchool.getAlunoPP().getTelefone());
        lbEmail.setText(MainSchool.getAlunoPP().getEmail());
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.carregar();
    }

    public void fechar() {
        ExbCadAluno.getStage().close();
    }
    
}
