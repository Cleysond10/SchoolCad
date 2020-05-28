package controller;

import Aplicacao.AltCadTurma;
import Aplicacao.MainSchool;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import tiposdados.Disciplina;
import tiposdados.Professor;
import tiposdados.Turma;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AltCadTurmaController implements Initializable {
    
    @FXML private JFXTextField tfCodTurma;
    @FXML private JFXTextField tfHorario;
    @FXML private JFXTextField tfPLetivo;
    @FXML private JFXTextField tfQtdMaxAl;
    @FXML private ComboBox<Disciplina> cbDisc;
    @FXML private ComboBox<Professor> cbProfx;
    
    private Turma turma;
    ObservableList<Disciplina> obsDisc = FXCollections.observableArrayList();
    ObservableList<Professor> obsProfx = FXCollections.observableArrayList();

    @FXML
    void BtAltCadTurma(ActionEvent event) {
        
    }
    
    @FXML
    void ActionBtCancelar(ActionEvent event) {
        fechar();
    }
    
    public void carregar() {
        tfCodTurma.setText(MainSchool.getTurma().getCodTurma());
        tfHorario.setText(MainSchool.getTurma().getHorario());
        tfPLetivo.setText(MainSchool.getTurma().getpLetivo());
        
        //Integer x = Integer.parseInt(tfQtdMaxAl.getText());
        tfQtdMaxAl.setText(MainSchool.getTurma().getQtdMaxAl() + "");
        
        turma = MainSchool.getTurma();
    }
    
    public void carregarCB (){
        Professor[] vProf = MainSchool.getLdeProf().listaProf();
        if (vProf.length == 0){
            System.out.println("LISTA VAZIA");
        } else{
            obsProfx.addAll(vProf);
            cbProfx.setItems(obsProfx);
        }
        
        Disciplina[] vDisc = MainSchool.getLdeDisc().listaDisc();
        if (vDisc.length == 0){
            System.out.println("LISTA VAZIA");
        } else{
            obsDisc.addAll(vDisc);
            cbDisc.setItems(obsDisc);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregar();
        carregarCB();
    }    
    
    public void fechar(){
        AltCadTurma.getStage().close();
    }
    
}
