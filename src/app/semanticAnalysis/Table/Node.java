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
    private Node leftestSon;
    private ArrayList<Node> rightSons;

    public Node() {
        this.symbolTable = new Table();
        this.leftestSon = null;
        this.rightSons = new ArrayList<>();
        
    }
    
    public Table getSymbolTable() {
        return symbolTable;
    }

    public void setSymbolTable(Table symbolTable) {
        this.symbolTable = symbolTable;
    }

    public Node getLeftestSon() {
        return leftestSon;
    }

    public void setLeftestSon(Node leftestSon) {
        this.leftestSon = leftestSon;
    }

    public ArrayList<Node> getRightSons() {
        return rightSons;
    }

    public void setRightSons(ArrayList<Node> rightSons) {
        this.rightSons = rightSons;
    }

    
    
    
}
