package com.financeiro.util;

  
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;  
  
public final class Moeda {  
      
    /** 
     * Simbolos especificos do Dolar Americano 
     */  
    private static final DecimalFormatSymbols DOLAR = new DecimalFormatSymbols(Locale.US);  
    /** 
     * Mascara de dinheiro para Dolar Americano 
     */  
    public static final DecimalFormat DINHEIRO_DOLAR = new DecimalFormat(Constantes.FORMAT_MOEDA_DECIMAL,DOLAR);  
    /** 
     * Simbolos especificos do Euro 
     */  
    private static final DecimalFormatSymbols EURO = new DecimalFormatSymbols(Locale.GERMANY);  
    /** 
     * Mascara de dinheiro para Euro 
     */  
    public static final DecimalFormat DINHEIRO_EURO = new DecimalFormat(Constantes.FORMAT_MOEDA_DECIMAL,EURO);  
    /** 
     * Locale Brasileiro 
     */  
    private static final Locale BRAZIL = new Locale(Constantes.PARAM_LOCALE_PT, Constantes.PARAM_LOCALE_BR);  
    /** 
     * Sï¿½mbolos especificos do Real Brasileiro 
     */  
    private static final DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);  
    /** 
     * Mascara de dinheiro para Real Brasileiro 
     */  
    public static final DecimalFormat DINHEIRO_REAL = new DecimalFormat(Constantes.FORMAT_MOEDA_DECIMAL,REAL);  
      
    /** 
     * Mascara texto com formatacao monetaria 
     * @param valor Valor a ser mascarado 
     * @param moeda Padrao monetario a ser usado 
     * @return Valor mascarado de acordo com o padrao especificado 
     */  
    public static String mascaraDinheiro(BigDecimal valor, DecimalFormat moeda){  
        return moeda.format(valor);  
    }  
}  
