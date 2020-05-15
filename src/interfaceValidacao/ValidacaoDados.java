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
    
    
}
