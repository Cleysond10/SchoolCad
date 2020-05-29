/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceValidacao;

import com.jfoenix.controls.JFXTextField;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Neto
 */
public class MascaraFX {
    
    public void mascaraCPF(JFXTextField textField){
       
        textField.setOnKeyTyped((KeyEvent event) -> {
            if("0123456789".contains(event.getCharacter())==false){
                event.consume();
            }
           
            if(event.getCharacter().trim().length()==0){ // apagando
               
                if(textField.getText().length()==4){
                    textField.setText(textField.getText().substring(0,3));
                    textField.positionCaret(textField.getText().length());
                }
                if(textField.getText().length()==8){
                    textField.setText(textField.getText().substring(0,7));
                    textField.positionCaret(textField.getText().length());
                }
                if(textField.getText().length()==12){
                    textField.setText(textField.getText().substring(0,11));
                    textField.positionCaret(textField.getText().length());
                }
               
            }else{ // escrevendo
               
                if(textField.getText().length()==14) event.consume();
               
                if(textField.getText().length()==3){
                    textField.setText(textField.getText()+".");
                    textField.positionCaret(textField.getText().length());
                }
                if(textField.getText().length()==7){
                    textField.setText(textField.getText()+".");
                    textField.positionCaret(textField.getText().length());
                }
                if(textField.getText().length()==11){
                    textField.setText(textField.getText()+"-");
                    textField.positionCaret(textField.getText().length());
                }
               
            }
        });
       
        textField.setOnKeyReleased((KeyEvent evt) -> {
           
            if(!textField.getText().matches("\\d.-*")){
                textField.setText(textField.getText().replaceAll("[^\\d.-]", ""));
                textField.positionCaret(textField.getText().length());
            }
        });
       
    }
    
    public void mascaraData(JFXTextField textField){
       
        textField.setOnKeyTyped((KeyEvent event) -> {
            if("0123456789".contains(event.getCharacter())==false){
                event.consume();
            }
           
            if(event.getCharacter().trim().length()==0){ // apagando
               
                if(textField.getText().length()==3){
                    textField.setText(textField.getText().substring(0,2));
                    textField.positionCaret(textField.getText().length());
                }
                if(textField.getText().length()==6){
                    textField.setText(textField.getText().substring(0,5));
                    textField.positionCaret(textField.getText().length());
                }
               
            }else{ // escrevendo
               
                if(textField.getText().length()==10) event.consume();
               
                if(textField.getText().length()==2){
                    textField.setText(textField.getText()+"/");
                    textField.positionCaret(textField.getText().length());
                }
                if(textField.getText().length()==5){
                    textField.setText(textField.getText()+"/");
                    textField.positionCaret(textField.getText().length());
                }
               
            }
        });
       
        textField.setOnKeyReleased((KeyEvent evt) -> {
           
            if(!textField.getText().matches("\\d/*")){
                textField.setText(textField.getText().replaceAll("[^\\d/]", ""));
                textField.positionCaret(textField.getText().length());
            }
        });
       
    }
    
    public void mascaraTel(JFXTextField textField){
       
        textField.setOnKeyTyped((KeyEvent event) -> {
            if("0123456789".contains(event.getCharacter())==false){
                event.consume();
            }
           
            if(event.getCharacter().trim().length()==0){ // apagando
               
                if(textField.getText().length()==10&&textField.getText().substring(9,10).equals("-")){
                    textField.setText(textField.getText().substring(0,9));
                    textField.positionCaret(textField.getText().length());
                }
                if(textField.getText().length()==9&&textField.getText().substring(8,9).equals("-")){
                    textField.setText(textField.getText().substring(0,8));
                    textField.positionCaret(textField.getText().length());
                }
                if(textField.getText().length()==4){
                    textField.setText(textField.getText().substring(0,3));
                    textField.positionCaret(textField.getText().length());
                }
                if(textField.getText().length()==1){
                    textField.setText("");
                }
               
            }else{ //escrevendo
               
                if(textField.getText().length()==14) event.consume();
               
                if(textField.getText().length()==0){
                    textField.setText("("+event.getCharacter());
                    textField.positionCaret(textField.getText().length());
                    event.consume();
                }
                if(textField.getText().length()==3){
                    textField.setText(textField.getText()+")"+event.getCharacter());
                    textField.positionCaret(textField.getText().length());
                    event.consume();
                }
                if(textField.getText().length()==8){
                    textField.setText(textField.getText()+"-"+event.getCharacter());
                    textField.positionCaret(textField.getText().length());
                    event.consume();
                }
                if(textField.getText().length()==9&&textField.getText().substring(8,9)!="-"){
                    textField.setText(textField.getText()+"-"+event.getCharacter());
                    textField.positionCaret(textField.getText().length());
                    event.consume();
                }
                if(textField.getText().length()==13&&textField.getText().substring(8,9).equals("-")){
                    textField.setText(textField.getText().substring(0,8)+textField.getText().substring(9,10)+"-"+textField.getText().substring(10,13)+event.getCharacter());
                    textField.positionCaret(textField.getText().length());
                    event.consume();
                }
               
            }
           
        });
       
        textField.setOnKeyReleased((KeyEvent evt) -> {
           
            if(!textField.getText().matches("\\d()-*")){
                textField.setText(textField.getText().replaceAll("[^\\d()-]", ""));
                textField.positionCaret(textField.getText().length());
            }
        });
               
    }
    
    public void mascaraRG(JFXTextField textField){
       
        textField.setOnKeyTyped((KeyEvent event) -> {
            if("0123456789".contains(event.getCharacter())==false){
                event.consume();
            }
           
            if(event.getCharacter().trim().length()==0){ // apagando
               
                if(textField.getText().length()==2){
                    textField.setText(textField.getText().substring(0,1));
                    textField.positionCaret(textField.getText().length());
                }
                if(textField.getText().length()==6){
                    textField.setText(textField.getText().substring(0,5));
                    textField.positionCaret(textField.getText().length());
                }
                /*if(textField.getText().length()==10){
                    textField.setText(textField.getText().substring(0,9));
                    textField.positionCaret(textField.getText().length());
                }*/
               
            }else{ // escrevendo
               
                if(textField.getText().length()==9) event.consume();
               
                if(textField.getText().length()==1){
                    textField.setText(textField.getText()+".");
                    textField.positionCaret(textField.getText().length());
                }
                if(textField.getText().length()==5){
                    textField.setText(textField.getText()+".");
                    textField.positionCaret(textField.getText().length());
                }
                /*if(textField.getText().length()==11){
                    textField.setText(textField.getText()+"-");
                    textField.positionCaret(textField.getText().length());
                }*/
               
            }
        });
       
        textField.setOnKeyReleased((KeyEvent evt) -> {
           
            if(!textField.getText().matches("\\d.-*")){
                textField.setText(textField.getText().replaceAll("[^\\d.-]", ""));
                textField.positionCaret(textField.getText().length());
            }
        });
       
    }
    
    public void mascaraCodDisc(JFXTextField textField){
       
        textField.setOnKeyTyped((KeyEvent event) -> {
            if("ABCDEFGHIJYLMNOPQRSTUVWXZ0123456789".contains(event.getCharacter())==false){
                event.consume();
            }
           
            if(event.getCharacter().trim().length()==0){ // apagando
               
                if(textField.getText().length()==3 && textField.getText().substring(1,2).equals("I")){
                    textField.setText(textField.getText().substring(0,2));
                    textField.positionCaret(textField.getText().length());
                }
                
               
            }else{ // escrevendo
               
                if(textField.getText().length()==7) event.consume();
               
                /*if(textField.getText().length()==2){
                    textField.setText(textField.getText()+"/");
                    textField.positionCaret(textField.getText().length());
                }
                if(textField.getText().length()==5){
                    textField.setText(textField.getText()+"/");
                    textField.positionCaret(textField.getText().length());
                }*/
               
            }
        });
       
        textField.setOnKeyReleased((KeyEvent evt) -> {
           
            if(!textField.getText().matches("[A-Z0-9]*")){
                textField.setText(textField.getText().replaceAll("[A-Z0-9]", ""));       
                textField.positionCaret(textField.getText().length());
            }
        });
       
    }
    
    public void mascaraNomeDisc(JFXTextField textField){
       
        textField.setOnKeyTyped((KeyEvent event) -> {
            if("ABCDEFGHIJYLMNOPQRSTUVWXZ".contains(event.getCharacter())==false){
                event.consume();
            }
           
            if(event.getCharacter().trim().length()==0){ // apagando
               
                if(textField.getText().length()==3 && textField.getText().substring(1,2).equals("I")){
                    textField.setText(textField.getText().substring(0,2));
                    textField.positionCaret(textField.getText().length());
                }
                
               
            }else{ // escrevendo
               
                if(textField.getText().length()==50) event.consume();
               
                /*if(textField.getText().length()==2){
                    textField.setText(textField.getText()+"/");
                    textField.positionCaret(textField.getText().length());
                }
                if(textField.getText().length()==5){
                    textField.setText(textField.getText()+"/");
                    textField.positionCaret(textField.getText().length());
                }*/
               
            }
        });
       
        textField.setOnKeyReleased((KeyEvent evt) -> {
           
            if(!textField.getText().matches("[A-Za-z][ A-Za-z]*")){
                textField.setText(textField.getText().replaceAll("[A-Za-z][ A-Za-z]*", ""));       
                textField.positionCaret(textField.getText().length());
            }
        });
       
    }
    
    public void mascaraCargaH(JFXTextField textField){
       
        textField.setOnKeyTyped((KeyEvent event) -> {
            if("036".contains(event.getCharacter())==false){
                event.consume();
            }
           
            if(event.getCharacter().trim().length()==0){ // apagando
               
                if(textField.getText().length()==3 && textField.getText().substring(1,2).equals("I")){
                    textField.setText(textField.getText().substring(0,2));
                    textField.positionCaret(textField.getText().length());
                }
                
               
            }else{ // escrevendo
               
                if(textField.getText().length()==2) event.consume();
               
                /*if(textField.getText().length()==2){
                    textField.setText(textField.getText()+"/");
                    textField.positionCaret(textField.getText().length());
                }
                if(textField.getText().length()==5){
                    textField.setText(textField.getText()+"/");
                    textField.positionCaret(textField.getText().length());
                }*/
               
            }
        });
       
        textField.setOnKeyReleased((KeyEvent evt) -> {
           
            if(!textField.getText().matches("[30]*[60]*")){
                textField.setText(textField.getText().replaceAll("[30]*[60]*", ""));       
                textField.positionCaret(textField.getText().length());
            }
        });
       
    }
    
    public void mascaraCred(JFXTextField textField){
       
        textField.setOnKeyTyped((KeyEvent event) -> {
            if("24".contains(event.getCharacter())==false){
                event.consume();
            }
           
            if(event.getCharacter().trim().length()==0){ // apagando
               
                if(textField.getText().length()==3 && textField.getText().substring(1,2).equals("I")){
                    textField.setText(textField.getText().substring(0,2));
                    textField.positionCaret(textField.getText().length());
                }
                
               
            }else{ // escrevendo
               
                if(textField.getText().length()==1) event.consume();
               
                /*if(textField.getText().length()==2){
                    textField.setText(textField.getText()+"/");
                    textField.positionCaret(textField.getText().length());
                }
                if(textField.getText().length()==5){
                    textField.setText(textField.getText()+"/");
                    textField.positionCaret(textField.getText().length());
                }*/
               
            }
        });
       
        textField.setOnKeyReleased((KeyEvent evt) -> {
           
            if(!textField.getText().matches("[2]*[4]*")){
                textField.setText(textField.getText().replaceAll("[2]*[4]*", ""));       
                textField.positionCaret(textField.getText().length());
            }
        });
       
    }
    
    public void mascaraCodTurma(JFXTextField textField){
       
        textField.setOnKeyTyped((KeyEvent event) -> {
            if("MTN0123456789".contains(event.getCharacter()) == false){
                event.consume();
            }
           
            if(event.getCharacter().trim().length()==0){ // apagando
               
                if(textField.getText().length()==1 && textField.getText().substring(0,1).equals("[0-9]")){
                    textField.setText(textField.getText().substring(0,1));
                    textField.positionCaret(textField.getText().length());
                }
                if(textField.getText().length()==3 && textField.getText().substring(2,4).equals("[M-T]")){
                    textField.setText(textField.getText().substring(0,1));
                    textField.positionCaret(textField.getText().length());
                }
                
               
            }else{ // escrevendo
               
                if(textField.getText().length() == 5) event.consume();
                if(textField.getText().length() == 1){
                    textField.setText(textField.getText()+"S");
                    textField.positionCaret(textField.getText().length());
                }
                if(textField.getText().length() == 3){
                    textField.setText(textField.getText()+"-");
                    textField.positionCaret(textField.getText().length());
                }
                /*if(textField.getText().length()==5){
                    textField.setText(textField.getText()+"/");
                    textField.positionCaret(textField.getText().length());
                }*/
               
            }
        });
       
        textField.setOnKeyReleased((KeyEvent evt) -> {
           
            if(!textField.getText().matches("[M-T][S][0-9]-[0-9]")){
                textField.setText(textField.getText().replaceAll("[M-T][S][0-9]-[0-9]", ""));       
                textField.positionCaret(textField.getText().length());
            }
        });
       
    }    
    
    public void mascaraHorario30(JFXTextField textField){
       
        textField.setOnKeyTyped((KeyEvent event) -> {
            if("ABCDEFGHIJKLMNOPQ234567".contains(event.getCharacter()) == false){
                event.consume();
            }
           
            if(event.getCharacter().trim().length()==0){ // apagando
               
                /*if(textField.getText().length()==3 && textField.getText().substring(1,2).equals("I")){
                    textField.setText(textField.getText().substring(0,2));
                    textField.positionCaret(textField.getText().length());
                }*/
                
               
            }else{ // escrevendo
                if(textField.getText().length() == 3) event.consume();
                                
                /*if(textField.getText().length()==5){
                    textField.setText(textField.getText()+"/");
                    textField.positionCaret(textField.getText().length());
                }*/
               
            }
        });
       
        textField.setOnKeyReleased((KeyEvent evt) -> {
           
            if(!textField.getText().matches("[2-7][A-Q][A-Q]")){
                textField.setText(textField.getText().replaceAll("[2-7][A-Q][A-Q]", ""));       
                textField.positionCaret(textField.getText().length());
            }
        });
       
    }
    
    public void mascaraHorario60(JFXTextField textField){
       
        textField.setOnKeyTyped((KeyEvent event) -> {
            if("ABCDEFGHIJKLMNOPQ234567".contains(event.getCharacter()) == false){
                event.consume();
            }
           
            if(event.getCharacter().trim().length()==0){ // apagando
               
                /*if(textField.getText().length()==3 && textField.getText().substring(1,2).equals("I")){
                    textField.setText(textField.getText().substring(0,2));
                    textField.positionCaret(textField.getText().length());
                }*/
                
               
            }else{ // escrevendo
                if(textField.getText().length() == 7) event.consume();
                
                if(textField.getText().length() == 3){
                    textField.setText(textField.getText()+"-");
                    textField.positionCaret(textField.getText().length());
                }
                /*if(textField.getText().length()==5){
                    textField.setText(textField.getText()+"/");
                    textField.positionCaret(textField.getText().length());
                }*/
               
            }
        });
       
        textField.setOnKeyReleased((KeyEvent evt) -> {
           
            if(!textField.getText().matches("[2-7][A-Q]-[2-7][A-Q]")){
                textField.setText(textField.getText().replaceAll("[2-7][A-Q]-[2-7][A-Q]", ""));       
                textField.positionCaret(textField.getText().length());
            }
        });
       
    }
    
    public void mascaraPLetivo(JFXTextField textField){
       
        textField.setOnKeyTyped((KeyEvent event) -> {
            if("0123456789".contains(event.getCharacter()) == false){
                event.consume();
            }
           
            if(event.getCharacter().trim().length()==0){ // apagando
               
                /*if(textField.getText().length()==3 && textField.getText().substring(1,2).equals("I")){
                    textField.setText(textField.getText().substring(0,2));
                    textField.positionCaret(textField.getText().length());
                }*/
                
               
            }else{ // escrevendo
                if(textField.getText().length() == 6) event.consume();
                
                if(textField.getText().length() == 4){
                    textField.setText(textField.getText()+".");
                    textField.positionCaret(textField.getText().length());
                }
                /*if(textField.getText().length()==5){
                    textField.setText(textField.getText()+"/");
                    textField.positionCaret(textField.getText().length());
                }*/
               
            }
        });
       
        textField.setOnKeyReleased((KeyEvent evt) -> {
           
            if(!textField.getText().matches("[0-9][0-9][0-9][0-9].[1-2]")){
                textField.setText(textField.getText().replaceAll("[0-9][0-9][0-9][0-9].[1-2]", ""));       
                textField.positionCaret(textField.getText().length());
            }
        });
       
    }
    
    public void mascaraQtdMaxAl(JFXTextField textField){
       
        textField.setOnKeyTyped((KeyEvent event) -> {
            if("0123456789".contains(event.getCharacter()) == false){
                event.consume();
            }
           
            if(event.getCharacter().trim().length()==0){ // apagando
               
            }else{ // escrevendo
                if(textField.getText().length() == 3) event.consume();
            }
        });
       
        textField.setOnKeyReleased((KeyEvent evt) -> {
           
            if(!textField.getText().matches("[0-9][0-9][0-9]")){
                textField.setText(textField.getText().replaceAll("[0-9][0-9][0-9]", ""));       
                textField.positionCaret(textField.getText().length());
            }
        });
       
    }
    
}
