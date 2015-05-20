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
    private Node imAmYourFather;
    private Table symbolTable;
    private ArrayList<Node> weAreYourSons;

    public Node() {
        this.imAmYourFather = null;
        this.symbolTable = new Table();
        this.weAreYourSons = new ArrayList<>();
        
    }

    public Node getFather() {
        return imAmYourFather;
    }

    public void setFather(Node imAmYourFather) {
        this.imAmYourFather = imAmYourFather;
    }

    public ArrayList<Node> getSons() {
        return weAreYourSons;
    }

    public void setSons(ArrayList<Node> weAreYourSons) {
        this.weAreYourSons = weAreYourSons;
    }
    
    
    
    public Table getSymbolTable() {
        return symbolTable;
    }

    public void setSymbolTable(Table symbolTable) {
        this.symbolTable = symbolTable;
    }


    
    
    
}
