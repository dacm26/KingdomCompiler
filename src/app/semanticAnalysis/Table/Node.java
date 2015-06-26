/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.semanticAnalysis.Table;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Daniel
 */
public class Node {
    
    private static boolean semanticErrors = false;
    private static Queue<String> programStrings = new LinkedList<>();

    private Node imAmYourFather;
    private Table symbolTable;
    private ArrayList<Node> weAreYourSons;

    public Node() {
        this.imAmYourFather = null;
        this.symbolTable = new Table();
        this.weAreYourSons = new ArrayList<>();

    }

    public void giffBaby(Node node) {
        this.weAreYourSons.add(node);
    }

    public boolean search(String id) {
        if (!this.symbolTable.search(id)) {
            if (this.imAmYourFather == null) {
                return false;
            } else {
                return this.imAmYourFather.search(id);
            }
        } else {
            return true;
        }
    }
    
    public boolean addMsg(String msg){
        return programStrings.add(msg);
    }
    public Queue<String> getProgramStrings(){
        return programStrings;
    }
    
    public void setErrors(){
        semanticErrors = true;
    }
    
    public boolean error(){
        return semanticErrors;
    }

    public boolean add(Row t) {
        if (this.search(t.getId())) {
            System.err.println("Semantic Error: the id: \"" + t.getId() + "\" already exists.");
            semanticErrors = true;
            return false;
        } else {
            this.symbolTable.add(t);
            return true;
        }
    }

    public Row searchRow(String id) {
        if (this.symbolTable.searchRow(id) != null) {
            return this.symbolTable.searchRow(id);
        } else {
            if (this.imAmYourFather == null) {
                return null;
            } else {
                return this.imAmYourFather.searchRow(id);
            }
        }
    }

    public Object getIdType(String id) {
        if (this.symbolTable.getIdType(id) == null) {
            if (this.imAmYourFather == null) {
                return null;
            } else {
                return this.imAmYourFather.getIdType(id);
            }
        } else {
            return this.symbolTable.getIdType(id);
        }
    }

    public boolean deleteLastNode() {
        if (!this.weAreYourSons.isEmpty()) {
            this.weAreYourSons.remove(this.weAreYourSons.size() - 1);
        }
        return true;
    }

    public int getNumericalIdType(String id) {
        Object type = this.getIdType(id);
        if (type == null) {
            return -1;
        }
        switch (type.toString()) {
            case "int":
                return 2;
            case "char":
                return 1;
            case "double":
                return 3;
            case "boolean":
                return 5;
            case "String":
                return 4;
            default:
                return -1;
        }
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

    public void printTables() {
        System.out.println(this.symbolTable.toString());
        if (!this.weAreYourSons.isEmpty()) {
            for (Node iAmASon : this.weAreYourSons) {
                iAmASon.printTables();
            }
        }

    }

}
