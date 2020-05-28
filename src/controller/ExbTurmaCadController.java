package controller;

import Aplicacao.AltCadTurma;
import Aplicacao.ExbTurmaCad;
import Aplicacao.MainSchool;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import tiposdados.Aluno;


/**
 * FXML Controller class
 *
 * @author Neto
 */
public class ExbTurmaCadController implements Initializable {
    
    @FXML private Label lbCodTurma;
    @FXML private Label lbHorario;
    @FXML private Label lbPLetivo;
    @FXML private Label lbQtdMAlunos;
    @FXML private Label lbDisc;
    @FXML private Label lbProf;
    @FXML private JFXListView<Aluno> lvAlunos;
    ObservableList<Aluno> obsAluno = FXCollections.observableArrayList();    

    @FXML
    void acaoBtCancelar(ActionEvent event) {
        fechar();
    }

    @FXML
    void acaoBtAlterar(ActionEvent event) {
        
        AltCadTurma aca = new AltCadTurma();
        
        try {
            aca.start(new Stage());    		
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        fechar();

    }
    
    @FXML
    void acaoBtRemover(ActionEvent event) {
        
        MainSchool.getLdeTurma().remover(MainSchool.getTurma());
            
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("VALIDAÇÃO");
        alert.setContentText("Turma Removido");
        alert.show();

        fechar();

    }
    
    public void carregarDados() {
        lbCodTurma.setText(MainSchool.getTurma().getCodTurma());
        lbHorario.setText(MainSchool.getTurma().getHorario());
        lbPLetivo.setText(MainSchool.getTurma().getpLetivo());
        lbQtdMAlunos.setText(MainSchool.getTurma().getQtdMaxAl() + "");
        lbDisc.setText(MainSchool.getTurma().getCodDisc());
        lbProf.setText(MainSchool.getTurma().getProfx().getNome());
    }
    
    public void carregarLista() {
        Aluno[] vAluno = MainSchool.getTurma().getAlunos();
        Aluno a = new Aluno("");
        a.setNome("");
        if (MainSchool.getTurma().getAlunos().length == 0){
            System.out.println("LISTA VAZIA");
        } else{
            Aluno[] vAlunoTest = new Aluno[vAluno.length];
            for(int i = 0; i < vAluno.length; i++) {
                if(vAluno[i] == null) {
                    vAlunoTest[i] = a;
                }
                else {
                    vAlunoTest[i] = vAluno[i];
                }
            }
            obsAluno.addAll(vAlunoTest);
            lvAlunos.setItems(obsAluno);
        }        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.carregarDados();
        this.carregarLista();
    }

    public void fechar() {
        ExbTurmaCad.getStage().close();
    }
    
}
