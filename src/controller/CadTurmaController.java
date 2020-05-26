package controller;

import Aplicacao.CadTurma;
import Aplicacao.CadTurmaMenu;
import Aplicacao.MainSchool;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import estruturadados.LDE;
import interfaceValidacao.MascaraFX;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tiposdados.Disciplina;
import tiposdados.Professor;
import tiposdados.Turma;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class CadTurmaController implements Initializable {
    
    @FXML private JFXTextField tfCodTurma;
    @FXML private JFXTextField tfHorario;
    @FXML private JFXTextField tfPLetivo;
    @FXML private JFXTextField tfQtdMaxAl;
    @FXML private JFXComboBox<Disciplina> cbDisc;
    @FXML private JFXComboBox<Professor> cbProfx;
    @FXML private JFXButton btVoltar;
    ObservableList<Disciplina> obsDisc = FXCollections.observableArrayList();
    ObservableList<Professor> obsProfx = FXCollections.observableArrayList();
    
    private LDE<Disciplina> LdeDisc;
    private LDE<Professor> LdeProf;
    private Turma Turma;
    
    @FXML
    void ActionBtVoltar(ActionEvent event) {
        CadTurmaMenu ctm = new CadTurmaMenu();

        try {
            ctm.start(new Stage());
        }catch(Exception ex) {
            ex.printStackTrace();
        }
                
        fechar();
        
    }
    
    /*@FXML
    void ActionMouseHorario(MouseEvent event) {
        MascaraFX mascara = new MascaraFX();
        
        mascara.mascaraHorario30(tfHorario);
        mascara.mascaraHorario60(tfHorario);
    }*/
    
    @FXML
    void BtCadTurma(ActionEvent event) {
        
    }
    
    public void carregar() {
        MascaraFX mascara = new MascaraFX();
        mascara.mascaraCodTurma(tfCodTurma);
        mascara.mascaraHorario30(tfHorario);
        //mascara.mascaraHorario60(tfHorario);
               
    }
    
    public void carregarCB(){
        Professor[] vProf = MainSchool.getLdeProf().listaProf();
        if (vProf.length == 0){
            System.out.println("LISTA VAZIA");
        } else{
            obsProfx.addAll(vProf);
            cbProfx.setItems(obsProfx);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregar();
        carregarCB();
    }    
    
    public void fechar() {
        CadTurma.getStage().close();
    }
    
}
