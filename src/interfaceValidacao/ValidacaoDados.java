package interfaceValidacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author Neto e Cleyson
 */
public class ValidacaoDados {
    
    public int isValidEmail(String email) {
        
        //VALIDAR EMAIL
        int result = 0;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = 1;
        }
        
        return result;
    }
    
    public int isValidData(String dataN) {
        
        int result = 0;
        //VALIDAR DATA        
        Date data = null;
        
    	String dataTexto = new String(dataN);
    	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    	try {
    		format.setLenient(false);
    		data = format.parse(dataTexto);
    	} catch (ParseException e) {
    		result = 2;
    	}
        
        return result;
    }
    
    public int isValidNome(String nome) {
        
        int result = 0;
        //VALIDAR NOME
        if(nome==null) {
            result = 3;
        }
        else if(nome.trim().length()<3) {
            result = 3;
        }

        Pattern p1= Pattern.compile("[A-Za-zà-üÀ-Ü][ A-Za-zà-üÀ-Ü]*");
        Matcher m1= p1.matcher(nome);

        if(m1.matches()) {
            result = 0;
        }
        else {
            result = 3;
        }
        
        return result;
    }
    
    public int isValidCPF(String CPF) {
        int result = 0;
        
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11)) {
            result = 4;
            return result;
        }
            
          
        char dig10, dig11;
        int sm, i, r, num, peso;
          
        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
        // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {              
        // converte o i-esimo caractere do CPF em um numero:
        // por exemplo, transforma o caractere '0' no inteiro 0         
        // (48 eh a posicao de '0' na tabela ASCII)         
            num = (int)(CPF.charAt(i) - 48); 
            sm = sm + (num * peso);
            peso = peso - 1;
            }
          
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico
          
        // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }
          
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);
          
        // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                 result = 0;
            }                
            else {
                result = 4;
            }
        } catch (InputMismatchException erro) {
                result = 4;
        }
        
        return result;
    }
    
    public int isValidEnd(String endereco) {
        
        int result = 0;
        //VALIDAR ENDEREÇO
        if(endereco==null) {
            result = 5;
        }
        else if(endereco.trim().length()<3) {
            result = 5;
        }

        Pattern p1= Pattern.compile("[A-Za-zà-üÀ-Ü][ A-Za-zà-üÀ-Ü]*");
        Matcher m1= p1.matcher(endereco);

        if(m1.matches()) {
            result = 0;
        }
        else {
            result = 5;
        }
        
        return result;
    }
    
    public int isValidPeriodo(String endereco) {
        
        int result = 0;
        //VALIDAR ENDEREÇO
        if(endereco==null) {
            result = 6;
        }
        else if(endereco.trim().length()<3) {
            result = 6;
        }

        Pattern p1= Pattern.compile("[0-9][ A-Za-z]");
        Matcher m1= p1.matcher(endereco);

        if(m1.matches()) {
            result = 0;
        }
        else {
            result = 6;
        }
        
        return result;
    }
    
    public int isValidCargaH(String endereco) {
        
        int result = 0;
        //VALIDAR ENDEREÇO
        if(endereco==null) {
            result = 7;
        }
        else if(endereco.trim().length()<3) {
            result = 7;
        }
        
        if(endereco.equals("30") || endereco.equals("60")) {
            result = 0;
        }
        else {
            result = 7;
        }
        
        
        return result;
    }
    
    public int isValidHTurno(String nome, String HAula) {
        
        int result = 0;
        //VALIDAR NOME
        if(nome==null) {
            System.out.println("null");
            result = 9;
        }
        else if(nome.trim().length()<3) {
            System.out.println("trim");
            result = 9;
        }
        else if(nome.length()<2) {
            result = 9;
        }
        else if(nome.length() == 3 && !(HAula.equals("30"))) {
            System.out.println("Tamanho imcompativel com a carga horaria");
            result = 9;
        }
        else if(nome.length() == 3) {
            if(!(nome.charAt(0) == '0' || nome.charAt(0) == '1' || nome.charAt(0) == '2' || nome.charAt(0) == '3' || nome.charAt(0) == '4' || nome.charAt(0) == '5' || nome.charAt(0) == '6' || nome.charAt(0) == '7' || nome.charAt(0) == '8' || nome.charAt(0) == '9')) {
                System.out.println("primeiro indece da string T3");
                result = 9;
            }
            if(nome.charAt(1) == '0' || nome.charAt(1) == '1' || nome.charAt(1) == '2' || nome.charAt(1) == '3' || nome.charAt(1) == '4' || nome.charAt(1) == '5' || nome.charAt(1) == '6' || nome.charAt(1) == '7' || nome.charAt(1) == '8' || nome.charAt(1) == '9') {
                System.out.println("segundo indece da string T3");
                result = 9;
            }
            if(nome.charAt(2) == '0' || nome.charAt(2) == '1' || nome.charAt(2) == '2' || nome.charAt(2) == '3' || nome.charAt(2) == '4' || nome.charAt(2) == '5' || nome.charAt(2) == '6' || nome.charAt(2) == '7' || nome.charAt(2) == '8' || nome.charAt(2) == '9') {
                System.out.println("terceiro indece da string T3");
                result = 9;
            }
        }
        else if(nome.length()>3 && nome.length()<7){
            result = 9;
        }
        else if(nome.length() == 7 && !(HAula.equals("60"))) {
            System.out.println("Tamanho imcompativel com a carga horaria T7");
            result = 9;
        }
        else if(nome.length() == 7){
            if(nome.charAt(0) != '0' || nome.charAt(0) != '1' || nome.charAt(0) != '2' || nome.charAt(0) != '3' || nome.charAt(0) != '4' || nome.charAt(0) != '5' || nome.charAt(0) != '6' || nome.charAt(0) != '7' || nome.charAt(0) != '8' || nome.charAt(0) != '9') {
                System.out.println("primeiro indece da string T7");
                result = 9;
            }
            if(nome.charAt(1) == '0' || nome.charAt(1) == '1' || nome.charAt(1) == '2' || nome.charAt(1) == '3' || nome.charAt(1) == '4' || nome.charAt(1) == '5' || nome.charAt(1) == '6' || nome.charAt(1) == '7' || nome.charAt(1) == '8' || nome.charAt(1) == '9') {
                System.out.println("segundo indece da string T7");
                result = 9;
            }
            if(nome.charAt(2) == '0' || nome.charAt(2) == '1' || nome.charAt(2) == '2' || nome.charAt(2) == '3' || nome.charAt(2) == '4' || nome.charAt(2) == '5' || nome.charAt(2) == '6' || nome.charAt(2) == '7' || nome.charAt(2) == '8' || nome.charAt(2) == '9') {
                System.out.println("terceiro indece da string T7");
                result = 9;
            }
            
            if(nome.charAt(4) != '0' || nome.charAt(4) != '1' || nome.charAt(4) != '2' || nome.charAt(4) != '3' || nome.charAt(4) != '4' || nome.charAt(4) != '5' || nome.charAt(4) != '6' || nome.charAt(4) != '7' || nome.charAt(4) != '8' || nome.charAt(4) != '9') {
                System.out.println("QUINTO indece da string T7");
                result = 9;
            }
            if(nome.charAt(5) == '0' || nome.charAt(5) == '1' || nome.charAt(5) == '2' || nome.charAt(5) == '3' || nome.charAt(5) == '4' || nome.charAt(5) == '5' || nome.charAt(5) == '6' || nome.charAt(5) == '7' || nome.charAt(5) == '8' || nome.charAt(5) == '9') {
                System.out.println("SEXTO indece da string T7");
                result = 9;
            }
            if(nome.charAt(6) == '0' || nome.charAt(6) == '1' || nome.charAt(6) == '2' || nome.charAt(6) == '3' || nome.charAt(6) == '4' || nome.charAt(6) == '5' || nome.charAt(6) == '6' || nome.charAt(6) == '7' || nome.charAt(6) == '8' || nome.charAt(6) == '9') {
                System.out.println("SEXTO indece da string T7");
                result = 9;
            }
        }
        return result;
    }
    
    public int isValidCodTurma(String nome) {
        
        int result = 0;
        //VALIDAR NOME
        if(nome==null) {
            System.out.println("null");
            result = 8;
        }
        else if(nome.trim().length()<3) {
            System.out.println("trim");
            result = 8;
        }
        else if(nome.length()<5) {
            System.out.println("lenght");
            result = 8;
        }
        else {
            if(nome.charAt(0) == '0' || nome.charAt(0) == '1' || nome.charAt(0) == '2' || nome.charAt(0) == '3' || nome.charAt(0) == '4' || nome.charAt(0) == '5' || nome.charAt(0) == '6' || nome.charAt(0) == '7' || nome.charAt(0) == '8' || nome.charAt(0) == '9') {
                System.out.println("primeiro indece da string");
                result = 8;
            }
            if(nome.charAt(2) == 'M' || nome.charAt(2) == 'T' || nome.charAt(2) == 'N') {
                System.out.println("terceiro indece da string");
                result = 8;
            }
            if(nome.charAt(4) == 'M' || nome.charAt(4) == 'T' || nome.charAt(4) == 'N') {
                System.out.println("quinto indece da string");
                result = 8;
            }
            
        }
        
        
        
        return result;
    }
    
    public int isValidCodDisc(String nome) {
        
        int result = 0;
        //VALIDAR NOME
        if(nome==null) {
            System.out.println("null");
            result = 10;
        }
        else if(nome.trim().length()<3) {
            System.out.println("trim");
            result = 10;
        }
        else if(nome.length()<7) {
            result = 10;
        }
        else {
            if(nome.charAt(0) == '0' || nome.charAt(0) == '1' || nome.charAt(0) == '2' || nome.charAt(0) == '3' || nome.charAt(0) == '4' || nome.charAt(0) == '5' || nome.charAt(0) == '6' || nome.charAt(0) == '7' || nome.charAt(0) == '8' || nome.charAt(0) == '9') {
                System.out.println("primeiro indece da string T3");
                result = 10;
            }
            if(nome.charAt(1) == '0' || nome.charAt(1) == '1' || nome.charAt(1) == '2' || nome.charAt(1) == '3' || nome.charAt(1) == '4' || nome.charAt(1) == '5' || nome.charAt(1) == '6' || nome.charAt(1) == '7' || nome.charAt(1) == '8' || nome.charAt(1) == '9') {
                System.out.println("segundo indece da string T3");
                result = 10;
            }
            if(nome.charAt(2) == '0' || nome.charAt(2) == '1' || nome.charAt(2) == '2' || nome.charAt(2) == '3' || nome.charAt(2) == '4' || nome.charAt(2) == '5' || nome.charAt(2) == '6' || nome.charAt(2) == '7' || nome.charAt(2) == '8' || nome.charAt(2) == '9') {
                System.out.println("terceiro indece da string T3");
                result = 10;
            }
            if(!(nome.charAt(3) == '0' || nome.charAt(3) == '1' || nome.charAt(3) == '2' || nome.charAt(3) == '3' || nome.charAt(3) == '4' || nome.charAt(3) == '5' || nome.charAt(3) == '6' || nome.charAt(3) == '7' || nome.charAt(3) == '8' || nome.charAt(3) == '9')) {
                System.out.println("quarto indece da string T3");
                result = 10;
            }
            if(!(nome.charAt(4) == '0' || nome.charAt(4) == '1' || nome.charAt(4) == '2' || nome.charAt(4) == '3' || nome.charAt(4) == '4' || nome.charAt(4) == '5' || nome.charAt(4) == '6' || nome.charAt(4) == '7' || nome.charAt(4) == '8' || nome.charAt(4) == '9')) {
                System.out.println("quinta indece da string T3");
                result = 10;
            }
            if(!(nome.charAt(5) == '0' || nome.charAt(5) == '1' || nome.charAt(5) == '2' || nome.charAt(5) == '3' || nome.charAt(5) == '4' || nome.charAt(5) == '5' || nome.charAt(5) == '6' || nome.charAt(5) == '7' || nome.charAt(5) == '8' || nome.charAt(5) == '9')) {
                System.out.println("sexta indece da string T3");
                result = 10;
            }
            if(!(nome.charAt(6) == '0' || nome.charAt(6) == '1' || nome.charAt(6) == '2' || nome.charAt(6) == '3' || nome.charAt(6) == '4' || nome.charAt(6) == '5' || nome.charAt(6) == '6' || nome.charAt(6) == '7' || nome.charAt(6) == '8' || nome.charAt(6) == '9')) {
                System.out.println("setima indece da string T3");
                result = 10;
            }
        }
        return result;
    }
    
    
}
