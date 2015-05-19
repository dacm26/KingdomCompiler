/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.semanticAnalysis.Table;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Node {
    private Table symbolTable;
    private Table leftestSon;
    private ArrayList<Table> rightSons;

    public Node() {
        this.symbolTable = new Table();
        this.leftestSon = new Table();
        this.rightSons = new ArrayList<>();
        
    }

    public Table getSymbolTable() {
        return symbolTable;
    }

    public void setSymbolTable(Table symbolTable) {
        this.symbolTable = symbolTable;
    }

    public Table getLeftestSon() {
        return leftestSon;
    }

    public void setLeftestSon(Table leftestSon) {
        this.leftestSon = leftestSon;
    }

    public ArrayList<Table> getRightSons() {
        return rightSons;
    }

    public void setRightSons(ArrayList<Table> rightSons) {
        this.rightSons = rightSons;
    }
    
    
    
    
}
