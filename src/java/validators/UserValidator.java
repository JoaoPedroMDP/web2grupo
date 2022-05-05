/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Gustavo Schwanka GRR20193748
 */
public class UserValidator {
    private static final String EMAIL_PATTERN = 
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
    public static boolean validarEmail(String email){
        if(email.length() > 100){
            return false;
        }else{
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
        }
 }
    public static boolean nomeValido(String Nome){
        if(Nome.length() > 100){
            return false;
        }else {
            return true;
        }
    }
    public static boolean ruaValida(String rua){
        if( (rua.length() > 100) ||  (rua.length() <= 0)){
            return false;
        }else {
            return true;
        }
    }
    public static boolean nrValido(String nr){
        int n;
        try{
            n = Integer.parseInt(nr);
        }catch (Exception e){
            return false;
        }

        if( (n < 0) || (n > 2147483647)){
            return false;
       }
       return true;
    }
    public static boolean isCPF(String CPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") ||
            CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
            return(false);
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
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return(true);
            else return(false);
                } catch (InputMismatchException erro) {
                return(false);
            }
        }
    public static String imprimeCPF(String CPF) {
        return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
        CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
    }
    public static String tiraMascara(String cpf){
        cpf = cpf.replace(".","");
        cpf = cpf.replace("-","");
        return cpf;
    }
    public static boolean isDateValid(String strDate) {
            java.util.Date date=null;
            try{
                date = new java.text.SimpleDateFormat("dd/MM/yyyy").parse(strDate);

            }catch (java.text.ParseException e) {
               return false;
            }

            java.util.Date hoje = new java.util.Date();
    //        try{
    //            hoje ?= new java.text.SimpleDateFormat("dd/MM/yyyy").parse(hoje.toString());
    //        }catch(java.text.ParseException e){
    ////            return false;
    //        }
            if(hoje.after(date))
                return true;
            return false;
        }
    public static boolean iscepValido(String cep){
         int n;
         if(cep.length() > 8) return false;
        try{
            n = Integer.parseInt(cep);
        }catch (Exception e){
            return false;
        }
       return true;
    }
    public static String tiraMascaraCep(String cep){
        cep = cep.replace(".","");
        cep = cep.replace("-","");
        return cep;
    }
}