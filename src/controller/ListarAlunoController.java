package controller;

import Aplicacao.ExbCadAluno;
import Aplicacao.ListarAluno;
import Aplicacao.MainSchool;
import com.jfoenix.controls.JFXListView;
import estruturadados.LDE;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import controller.MainSchoolController;
import javafx.stage.Stage;
import tiposdados.Aluno;

/**
 * FXML Controller class
 *
 * @author Neto e Cleyson
 */
public class ListarAlunoController implements Initializable {
    
    @FXML private JFXListView<String> listaAluno;
    ObservableList<String> lista = FXCollections.observableArrayList();
    private LDE ldeAluno;
        

    @FXML
    void acaoBtCancelar(ActionEvent event) {
        fechar();
    }
    
    @FXML
    void AcaoDaLista(MouseEvent event) {
    	String cLista = listaAluno.getSelectionModel().getSelectedItem();
    	if(cLista == null || cLista.isEmpty()) {
            //fieldCarregar.setText("Lista Vazia");
    	}
    	else {
            Aluno a;
            a = Buscar(cLista);
            MainSchool.setAlunoPP(a);
            
            ExbCadAluno aca = new ExbCadAluno();

            try {
                aca.start(new Stage());    		
            }catch(Exception ex) {
                ex.printStackTrace();
            }
            fechar();
    	}
    }
    
    private void carregarDados() {
        ldeAluno = MainSchool.getLdeAlunoPP();        
        Aluno[] x = ldeAluno.listaAluno();
        if(x.length == 0) {
            System.out.println("Vazio");
        }
        else {
            String[] s = new String[x.length];
            for(int i = 0; i < x.length; i++) {
                s[i] = x[i].getNome();
            }
            //listaJogo.Inicializar();
            //x = listaJogo.listaSalvo();
            lista.removeAll(lista);
            lista.addAll(s);
            listaAluno.getItems().addAll(lista);
        }
        
    }
    
    public Aluno Buscar(String nome) {
        Aluno[] x = ldeAluno.listaAluno();
        Aluno a = null;        
        
        for(int i = 0; i < x.length; i++) {
            if(x[i].getNome().equals(nome)) {
                a = x[i];
            }            
        }
        
        return a;
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarDados();
    } 
    
    public void fechar() {
        ListarAluno.getStage().close();
    }

    public LDE getLdeAluno() {
        return this.ldeAluno;
    }

    public void setLdeAluno(LDE ldeAluno) {
        this.ldeAluno = ldeAluno;
    }
    
    
    
}
