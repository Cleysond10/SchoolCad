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
    
    @FXML
    void ActionMouseHorario(MouseEvent event) {
        MascaraFX mascara = new MascaraFX();
        if (cbDisc.getSelectionModel().getSelectedItem().getCargaH() == "30"){
            mascara.mascaraHorario30(tfHorario);
        }
       
    }
    
    @FXML
    void BtCadTurma(ActionEvent event) {
        Turma = new Turma(tfCodTurma.getText(), cbDisc.getSelectionModel().getSelectedItem().getCodDisc());
        
        Turma.setProfx(cbProfx.getSelectionModel().getSelectedItem());
        Turma.setHorario(tfHorario.getText());
        Turma.setpLetivo(tfPLetivo.getText());
        
        Integer x = Integer.parseInt(tfQtdMaxAl.getText());
        Turma.setQtdMaxAl(x);
        
        Turma[] vDiscTurmas = cbDisc.getSelectionModel().getSelectedItem().getTurmas();
        int cont = 0;
        for (int i = 0; i < vDiscTurmas.length; i++){
            if (vDiscTurmas[i] != null){
                cont++;
            }
        }
        vDiscTurmas[cont] = Turma;
        cbDisc.getSelectionModel().getSelectedItem().setTurmas(vDiscTurmas);
        
        Turma[] vProfxTurmas = cbProfx.getSelectionModel().getSelectedItem().getTurmas();
        int cont1 = 0;
        for (int i = 0; i < vProfxTurmas.length; i++){
            if (vProfxTurmas[i] != null){
                cont1++;
            }
        }
        vProfxTurmas[cont1] = Turma;
        cbProfx.getSelectionModel().getSelectedItem().setTurmas(vProfxTurmas);        
        
        MainSchool.getLdeTurma().add(Turma);
        
        MainSchool.getLdeTurma().exibir();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("VALIDAÇÃO");
        alert.setContentText("Cadastro Salvo com Sucesso.");
        alert.show();                

        fechar();
        
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
