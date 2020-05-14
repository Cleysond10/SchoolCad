package controller;

import Aplicacao.ExbCadProf;
import Aplicacao.MainSchool;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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

    @FXML
    void acaoBtVoltar(ActionEvent event) {
        fechar();
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
