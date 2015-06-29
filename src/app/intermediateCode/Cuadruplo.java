/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.intermediateCode;

import java.util.ArrayList;

/**
 *
 * @author douglasortega
 */
public class Cuadruplo {
    
    private ArrayList<RowIC> rows;
    private ArrayList<RowIC> temprows;
    private int currentIndex;

    public Cuadruplo() {
        currentIndex = 0;
        rows = new ArrayList<>();
        temprows = new ArrayList<>();
    }

    public ArrayList<RowIC> getRows() {
        return rows;
    }

    public void setRows(ArrayList<RowIC> rows) {
        this.rows = rows;
    }
    
    public void addRow(String op, String arg1, String arg2, String res){
        rows.add(new RowIC(op, arg1, arg2, res));
        currentIndex++;
    }

    public void addRow(RowIC row){
        rows.add(row);
        currentIndex++;
    }

    public void addTempRow(String op, String arg1, String arg2, String res){
        temprows.add(new RowIC(op, arg1, arg2, res));
    }

    public void flushRows(ArrayList<RowIC> rowsArray){
        for(RowIC x: rowsArray){
            addRow(x);
        }
    }

    public void emptyTemp(){
        temprows.clear();
    }

    public ArrayList<RowIC> getTempRow(){
        return temprows;
    }

    public int getCurrentIndex(){
        return currentIndex;
    }

    public void print() {
        for (RowIC x: rows){
            System.out.println(x.toString());
        }
    }

}
