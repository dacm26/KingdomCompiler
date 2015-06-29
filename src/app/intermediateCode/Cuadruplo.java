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
    
    private ArrayList<Row> rows;
    private ArrayList<Row> temprows;
    private int currentIndex;

    public Cuadruplo() {
        currentIndex = 0;
        rows = new ArrayList<>();
        temprows = new ArrayList<>();
    }

    public ArrayList<Row> getRows() {
        return rows;
    }

    public void setRows(ArrayList<Row> rows) {
        this.rows = rows;
    }
    
    public void addRow(String op, String arg1, String arg2, String res){
        rows.add(new Row(op, arg1, arg2, res));
        currentIndex++;
    }

    public void addRow(Row row){
        rows.add(row);
        currentIndex++;
    }

    public void addTempRow(String op, String arg1, String arg2, String res){
        temprows.add(new Row(op, arg1, arg2, res));
    }

    public void flushRows(ArrayList<Row> rowsArray){
        for(Row x: rowsArray){
            addRow(x);
        }
    }

    public void emptyTemp(){
        temprows.clear();
    }

    public ArrayList<Row> getTempRow(){
        return temprows;
    }

    public int getCurrentIndex(){
        return currentIndex;
    }

    public void print() {
        for (Row x: rows){
            System.out.println(x.toString());
        }
    }

    public void complete(int index){
        
    }
}
