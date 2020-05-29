package controller;

import Aplicacao.CadTurma;
import Aplicacao.CadTurmaMenu;
import Aplicacao.MainSchool;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import interfaceValidacao.MascaraFX;
import interfaceValidacao.ValidacaoDados;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
        
    private Turma turma;
    
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
    
    @FXML
    void ActionMouseHorario(MouseEvent event) {
        MascaraFX mascara = new MascaraFX();
        if (cbDisc.getSelectionModel().getSelectedItem().getCargaH() == "30"){
            mascara.mascaraHorario30(tfHorario);
        }
       
    }
    
    @FXML
    void BtCadTurma(ActionEvent event) {
        ValidacaoDados valida = new ValidacaoDados();
        
        
        if(valida.isValidCodTurma(tfCodTurma.getText()) == 0 && valida.isValidHTurno(tfHorario.getText(), cbDisc.getSelectionModel().getSelectedItem().getCargaH()) == 0) {
            turma = new Turma(tfCodTurma.getText(), cbDisc.getSelectionModel().getSelectedItem().getCodDisc());
        
            turma.setProfx(cbProfx.getSelectionModel().getSelectedItem());        
            turma.setHorario(tfHorario.getText());
            turma.setpLetivo(tfPLetivo.getText());

            Integer x = Integer.parseInt(tfQtdMaxAl.getText());
            turma.setQtdMaxAl(x);

            Turma[] vDiscTurmas = cbDisc.getSelectionModel().getSelectedItem().getTurmas();

            vDiscTurmas[cbDisc.getSelectionModel().getSelectedItem().getQtdVTurma()] = turma;
            Disciplina disc = MainSchool.getLdeDisc().consulta(cbDisc.getSelectionModel().getSelectedItem());
            System.out.println(disc);
            disc.setTurmas(vDiscTurmas);
            disc.setQtdVTurma(disc.getQtdVTurma() + 1);

            Turma[] vProfxTurmas = cbProfx.getSelectionModel().getSelectedItem().getTurmas();

            vProfxTurmas[cbProfx.getSelectionModel().getSelectedItem().getQtdVTurmas()] = turma;
            Professor prof = MainSchool.getLdeProf().consulta(cbProfx.getSelectionModel().getSelectedItem());
            prof.setTurmas(vProfxTurmas);
            prof.setQtdVTurmas(prof.getQtdVTurmas() + 1);


            MainSchool.getLdeTurma().add(turma);        


            if(MainSchool.getLdeTurma().consulta(turma) == null) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("VALIDAÇÃO");
                    alert.setContentText("Cadastro Salvo com Sucesso.");
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
    
    public void carregar() {
        MascaraFX mascara = new MascaraFX();
        mascara.mascaraCodTurma(tfCodTurma);
        //mascara.mascaraHorario30(tfHorario);
        mascara.mascaraHorario60(tfHorario);
        mascara.mascaraPLetivo(tfPLetivo);
        mascara.mascaraQtdMaxAl(tfQtdMaxAl);
               
    }
    
    public void carregarCB(){
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
    
    public void fechar() {
        CadTurma.getStage().close();
    }
    
}
