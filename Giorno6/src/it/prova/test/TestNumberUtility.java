package it.prova.test;

import it.prova.utility.NumberUtility;

import javax.swing.*;

public class TestNumberUtility {
    public static void main(String[] args){
        String daConvertire = JOptionPane.showInputDialog("Dammi un numero");
        while(daConvertire == null) break;


        if(daConvertire != null) {
            Integer risultato = NumberUtility.parseFromStringToInt(daConvertire);
            JOptionPane.showMessageDialog(null, risultato);
        }
    }
}
