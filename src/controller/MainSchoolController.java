/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Aplicacao.AltCadAluno;
import Aplicacao.BuscaAluno;
import Aplicacao.RemoverAluno;
import Aplicacao.CadAluno;
import com.jfoenix.controls.JFXButton;
import static java.awt.Color.red;
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
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.WHITE;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;


/**
 *
 * @author Neto
 */
public class MainSchoolController implements Initializable {
    
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

    @FXML
    void actionBtBuscPane(ActionEvent event) {
        AltCadAluno ca = new AltCadAluno();
        
        try {
    		ca.start(new Stage());    		
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}

    }

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
    void actionBtExbPane(ActionEvent event) {
        CadAluno ca = new CadAluno();
        
        try {
    		ca.start(new Stage());    		
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}

    }

    @FXML
    void actionBtListPane(ActionEvent event) {
        CadAluno ca = new CadAluno();
        
        try {
    		ca.start(new Stage());    		
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
