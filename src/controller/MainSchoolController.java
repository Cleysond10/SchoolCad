/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Aplicacao.AltCadAluno;
import Aplicacao.BuscaAluno;
import Aplicacao.RemoverAluno;
import Aplicacao.CadProf;
import Aplicacao.AltProf;
import Aplicacao.AltTurma;
import Aplicacao.BuscProf;
import Aplicacao.BuscaDiscAlt;
import Aplicacao.BuscaExbAluno;
import Aplicacao.BuscaExbDisc;
import Aplicacao.ExbProf;
import Aplicacao.RemProf;
import Aplicacao.CadAluno;
import Aplicacao.CadDisc;
import Aplicacao.CadTurmaMenu;
import Aplicacao.ExbTurma;
import Aplicacao.ListarAluno;
import Aplicacao.ListarDisc;
import Aplicacao.ListarProf;
import Aplicacao.ListarTurmaMenu;
import Aplicacao.MainSchool;
import Aplicacao.RemTurmaMenu;
import Aplicacao.RemoverDisc;
import com.jfoenix.controls.JFXButton;
import estruturadados.LDE;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import tiposdados.Aluno;


/**
 *
 * @author Neto
 */
public class MainSchoolController implements Initializable {
    
    //private LDE<Aluno> ldeAlunoP;
    
    @FXML private JFXButton btAluno;
    @FXML private JFXButton btProf;
    @FXML private JFXButton btDisc;
    @FXML private JFXButton btTurm;
    @FXML private AnchorPane janela;
    @FXML private Pane JanelaPane;
    @FXML private Pane paneStatus;
    @FXML private Label labelStatus;
    // VARIAVEIS PANE ALUNO
    @FXML private Pane JanelaPaneA;
    @FXML private JFXButton btCadAluno;
    @FXML private JFXButton btAltAluno;
    @FXML private JFXButton btExbAluno;
    @FXML private JFXButton btRemAluno;
    @FXML private JFXButton btListAluno;
    @FXML private JFXButton btBuscAluno;
    // VARIAVEIS PANE PROFESSOR
    @FXML private JFXButton btCadProf;
    @FXML private JFXButton btAltProf;
    @FXML private JFXButton btExbProf;
    @FXML private JFXButton btRemProf;
    @FXML private JFXButton btListProf;
    @FXML private JFXButton btBuscProf;
    
    //VARIAVEIS PANE DISCIPLINA
    
    @FXML private Pane JanelaPaneD;
    @FXML private JFXButton btCadDisc;
    @FXML private JFXButton btAltDisc;
    @FXML private JFXButton btExbDisc;
    @FXML private JFXButton btRemDisc;
    @FXML private JFXButton btListDisc;
    
    //VARIAVEIS PANE TURMA
    
    @FXML private Pane JanelaPaneT;
    @FXML private JFXButton btCadTurma;
    @FXML private JFXButton btAltTurma;
    @FXML private JFXButton btExbTurma;
    @FXML private JFXButton btRemTurma;
    @FXML private JFXButton btListTurma;
    
    //ACÕES DO BOTÕES DA BARRA LATERAL
    @FXML
    void actionAluno(ActionEvent event) throws IOException {
        if(event.getSource().equals(btAluno)) {
            Pane pane = (Pane)FXMLLoader.load(getClass().getResource("/FXML/TelaAluno.fxml"));        
            JanelaPane.getChildren().add(pane);
            paneStatus.setBackground(new Background(new BackgroundFill(Paint.valueOf("#050453"), CornerRadii.EMPTY, Insets.EMPTY)));
            labelStatus.setText("ALUNO");
        }
        else if(event.getSource().equals(btProf)) {
            Pane pane = (Pane)FXMLLoader.load(getClass().getResource("/FXML/TelaProfessor.fxml"));        
            JanelaPane.getChildren().add(pane);
            paneStatus.setBackground(new Background(new BackgroundFill(Paint.valueOf("#050453"), CornerRadii.EMPTY, Insets.EMPTY)));
            labelStatus.setText("PROFESSOR");            
        }
        else if(event.getSource().equals(btDisc)) {
            Pane pane = (Pane)FXMLLoader.load(getClass().getResource("/FXML/TelaDisciplina.fxml"));        
            JanelaPane.getChildren().add(pane);
            paneStatus.setBackground(new Background(new BackgroundFill(Paint.valueOf("#050453"), CornerRadii.EMPTY, Insets.EMPTY)));
            labelStatus.setText("DISCIPLINA");            
        }
        else if(event.getSource().equals(btTurm)) {
            Pane pane = (Pane)FXMLLoader.load(getClass().getResource("/FXML/TelaTurma.fxml"));        
            JanelaPane.getChildren().add(pane);
            paneStatus.setBackground(new Background(new BackgroundFill(Paint.valueOf("#050453"), CornerRadii.EMPTY, Insets.EMPTY)));
            labelStatus.setText("TURMA");            
        }
        
    }
    
    @FXML
    void mouseExt(MouseEvent event) {

    }
    
    @FXML
    void mouseMov(MouseEvent event) {
        
    }
    
    //ACÕES DO BOTÕES DA PANE ALUNO
    @FXML
    void actionBtAltPaneAluno(ActionEvent event) {
        BuscaAluno alt = new BuscaAluno();
        
        try {
    		alt.start(new Stage());    		
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}

    }

    /*@FXML
    void actionBtBuscPane(ActionEvent event) {
        AltCadAluno ca = new AltCadAluno();
        
        try {
    		ca.start(new Stage());    		
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}

    }*/

    @FXML
    void actionBtCadPaneAluno(ActionEvent event) throws IOException {
        CadAluno ca = new CadAluno();
        
        try {
    		ca.start(new Stage());    		
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}

    }

    @FXML
    void actionBtExbPaneAluno(ActionEvent event) {
        BuscaExbAluno ca = new BuscaExbAluno();
        
        try {
    		ca.start(new Stage());    		
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}

    }

    @FXML
    void actionBtListPaneAluno(ActionEvent event) {
        ListarAluno la = new ListarAluno();
        
        try {
    		la.start(new Stage());    		
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}

    }

    @FXML
    void actionBtRemPaneAluno(ActionEvent event) {
        RemoverAluno ca = new RemoverAluno();
        
        try {
    		ca.start(new Stage());    		
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}

    }
    
    //ACÕES DO BOTÕES DA PANE PROFESSOR
    
    @FXML
    void actionBtCadProfPane(ActionEvent event) {
        CadProf cp = new CadProf();
        
        try {
            cp.start(new Stage());    		
    	}catch(Exception ex) {
            ex.printStackTrace();
    	}
    }
    
    @FXML
    void actionBtAltProfPane(ActionEvent event) {
        AltProf ap = new AltProf();
        
        try {
            ap.start(new Stage());    		
    	}catch(Exception ex) {
            ex.printStackTrace();
    	}
    }

    @FXML
    void actionBtExbProfPane(ActionEvent event) {
        ExbProf ep = new ExbProf();
        
        try {
            ep.start(new Stage());    		
    	}catch(Exception ex) {
            ex.printStackTrace();
    	}
    }

    @FXML
    void actionBtListProfPane(ActionEvent event) {
        ListarProf lp = new ListarProf();
        
        try {
    		lp.start(new Stage());    		
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }

    @FXML
    void actionBtRemProfPane(ActionEvent event) {
        RemProf rp = new RemProf();
        
        try {
            rp.start(new Stage());    		
    	}catch(Exception ex) {
            ex.printStackTrace();
    	}
    }
    
    //ACÕES DO BOTÕES DA PANE DISCIPLINA
    
    @FXML
    void actionBtAltPaneDiscipllina(ActionEvent event) {
        BuscaDiscAlt bda = new BuscaDiscAlt();
        
        try {
            bda.start(new Stage());    		
    	}catch(Exception ex) {
            ex.printStackTrace();
    	}        
    }

    @FXML
    void actionBtCadPaneDisciplina(ActionEvent event) {
        CadDisc cd = new CadDisc();
        
        try {
            cd.start(new Stage());    		
    	}catch(Exception ex) {
            ex.printStackTrace();
    	}
    }

    @FXML
    void actionBtExbPaneDisciplina(ActionEvent event) {
        BuscaExbDisc bed = new BuscaExbDisc();
        
        try {
            bed.start(new Stage());    		
    	}catch(Exception ex) {
            ex.printStackTrace();
    	}
    }

    @FXML
    void actionBtListPaneDisciplina(ActionEvent event) {
        ListarDisc ld = new ListarDisc();
        
        try {
            ld.start(new Stage());    		
    	}catch(Exception ex) {
            ex.printStackTrace();
    	}
    }

    @FXML
    void actionBtRemPaneDisciplina(ActionEvent event) {
        RemoverDisc rd = new RemoverDisc();
        
        try {
            rd.start(new Stage());    		
    	}catch(Exception ex) {
            ex.printStackTrace();
    	}
    }
    
    //ACÕES DO BOTÕES DA PANE TURMA
    
    @FXML
    void actionBtCadTurmaPane(ActionEvent event) {
        CadTurmaMenu ctm = new CadTurmaMenu();
        
        try {
            ctm.start(new Stage());    		
    	}catch(Exception ex) {
            ex.printStackTrace();
    	}
    }
    
    @FXML
    void actionBtAltTurmaPane(ActionEvent event) {
        AltTurma at = new AltTurma();
        
        try {
            at.start(new Stage());    		
    	}catch(Exception ex) {
            ex.printStackTrace();
    	}
    }

    @FXML
    void actionBtExbTurmaPane(ActionEvent event) {
        ExbTurma et = new ExbTurma();
        
        try {
            et.start(new Stage());    		
    	}catch(Exception ex) {
            ex.printStackTrace();
    	}
    }

    @FXML
    void actionBtListTurmaPane(ActionEvent event) {
        ListarTurmaMenu ltm = new ListarTurmaMenu();
        
        try {
    		ltm.start(new Stage());    		
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }

    @FXML
    void actionBtRemTurmaPane(ActionEvent event) {
        RemTurmaMenu rtm = new RemTurmaMenu();
        
        try {
            rtm.start(new Stage());    		
    	}catch(Exception ex) {
            ex.printStackTrace();
    	}
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        MainSchool.getLdeAlunoPP().Inicializar("aluno.sc");
        MainSchool.getLdeProf().Inicializar("professor.sc");
        MainSchool.getLdeDisc().Inicializar("disciplina.sc");
        
        /*ldeAlunoP = new LDE<Aluno>();
        ldeAlunoP.Inicializar("aluno.sc");
        MainSchool.setLdeAlunoPP(ldeAlunoP);
        */
    }

    /*public LDE getLdeAlunoP() {
        return this.ldeAlunoP;
    }

    public void setLdeAlunoP(LDE ldeAlunoP) {
        this.ldeAlunoP = ldeAlunoP;
    }
*/
    

    
    
}
