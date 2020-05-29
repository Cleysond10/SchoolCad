package controller;

import Aplicacao.AltCadTurma;
import Aplicacao.MainSchool;
import com.jfoenix.controls.JFXTextField;
import interfaceValidacao.ValidacaoDados;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
    private Disciplina discc;
    private Professor proff;
    ObservableList<Disciplina> obsDisc = FXCollections.observableArrayList();
    ObservableList<Professor> obsProfx = FXCollections.observableArrayList();

    @FXML
    void BtAltCadTurma(ActionEvent event) {
        Turma[] vDiscTurmas = discc.getTurmas();
        Turma[] vProfxTurmas = proff.getTurmas();
        ValidacaoDados valida = new ValidacaoDados();
        
        
        for(int i = 0; i < vDiscTurmas.length; i++) {
            if(vDiscTurmas[i] != null && vDiscTurmas[i].getCodTurma().equals(turma.getCodTurma())) {
                proff.setQtdVTurmas(proff.getQtdVTurmas()- 1);
                vDiscTurmas[i] = null;
                for(i = i; i < vDiscTurmas.length - 1; i++) {
                    vDiscTurmas[i] = vDiscTurmas[i + 1];
                }
                break;
            }
        }
        //vDiscTurmas[cbDisc.getSelectionModel().getSelectedItem().getQtdVTurma()] = turma;
        
        
        
        
        for(int i = 0; i < vProfxTurmas.length; i++) {
            if(vProfxTurmas[i] != null && vProfxTurmas[i].getCodTurma().equals(turma.getCodTurma())) {
                proff.setQtdVTurmas(proff.getQtdVTurmas()- 1);
                vProfxTurmas[i] = null;
                for(i = i; i < vProfxTurmas.length - 1; i++) {
                    vProfxTurmas[i] = vProfxTurmas[i + 1];
                }
                break;
            }
        }
        
        
        //vProfxTurmas[cbProfx.getSelectionModel().getSelectedItem().getQtdVTurmas()] = turma;
        
        if(valida.isValidCodTurma(tfCodTurma.getText()) == 0 && valida.isValidHTurno(tfHorario.getText(), cbDisc.getSelectionModel().getSelectedItem().getCargaH()) == 0) {
            
            turma.setCodTurma(tfCodTurma.getText());
        
            turma.setCodDisc(cbDisc.getSelectionModel().getSelectedItem().getCodDisc());

            turma.setProfx(cbProfx.getSelectionModel().getSelectedItem());
            turma.setHorario(tfHorario.getText());
            turma.setpLetivo(tfPLetivo.getText());

            vDiscTurmas = cbDisc.getSelectionModel().getSelectedItem().getTurmas();

            vDiscTurmas[cbDisc.getSelectionModel().getSelectedItem().getQtdVTurma()] = turma;
            cbDisc.getSelectionModel().getSelectedItem().setTurmas(vDiscTurmas);
            cbDisc.getSelectionModel().getSelectedItem().setQtdVTurma(cbDisc.getSelectionModel().getSelectedItem().getQtdVTurma() + 1);

            vProfxTurmas = cbProfx.getSelectionModel().getSelectedItem().getTurmas();

            vProfxTurmas[cbProfx.getSelectionModel().getSelectedItem().getQtdVTurmas()] = turma;
            cbProfx.getSelectionModel().getSelectedItem().setTurmas(vProfxTurmas);        
            cbProfx.getSelectionModel().getSelectedItem().setQtdVTurmas(cbProfx.getSelectionModel().getSelectedItem().getQtdVTurmas() + 1);
            
            if(MainSchool.getLdeTurma().consulta(turma) == null) {
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("VALIDAÇÃO");
                alert.setContentText("Alteração Salvo com Sucesso.");
                alert.show();
                
            }

            fechar();
        
        }
        else {
            String vCodTurma = "", vHorario = "", vNome = "", vCPF = "";
            if(valida.isValidCodTurma(tfCodTurma.getText())==8) {
                vCodTurma = "Verifique o Código da Turma";
            }
            if(valida.isValidHTurno(tfHorario.getText(), cbDisc.getSelectionModel().getSelectedItem().getCargaH())==9) {
                vHorario = "Verifique o Horário";
            }
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("VALIDAÇÃO");
            alert.setContentText(vCodTurma + "\n" + vHorario);
            alert.show();                
        }
        
        
        
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
        
        Disciplina disc = new Disciplina(MainSchool.getTurma().getCodDisc());
        disc = MainSchool.getLdeDisc().consulta(disc);
        
        cbDisc.getSelectionModel().select(disc);
        cbProfx.getSelectionModel().select(MainSchool.getTurma().getProfx());
        
        this.proff = MainSchool.getTurma().getProfx();
        this.discc = disc;
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
