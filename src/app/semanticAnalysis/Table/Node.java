/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.semanticAnalysis.Table;

import app.semanticAnalysis.Types.FunctionType;
import app.semanticAnalysis.Types.PrimitiveDataType;
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

    private Node iAmYourFather;
    private Table symbolTable;
    private ArrayList<Node> weAreYourSons;

    public Node() {
        this.iAmYourFather = null;
        this.symbolTable = new Table();
        this.weAreYourSons = new ArrayList<>();

    }

    public void giffBaby(Node node) {
        this.weAreYourSons.add(node);
    }

    public void addVariablsFinalCode(StringBuilder sB) {
        this.addCode(sB);
        for (Node iAmASon : this.weAreYourSons) {
            iAmASon.addVariablsFinalCode(sB);
        }
    }

    private void addCode(StringBuilder sB) {
        ArrayList<Row> rows = symbolTable.getTable();
        String temp;
        for (Row row : rows) {
            if (!(row.getType() instanceof FunctionType || row.isParam())) {
                temp = "\t_" + row.getId() + ":\t" + this.getFinalType((PrimitiveDataType) row.getType())+"\n";
                sB.append(temp);
            }
        }
    }

    private String getFinalType(PrimitiveDataType t) {
        switch (t.getPrimitiveType().toString()) {
            case "int":
                return ".word\t0";
            case "char":
                return ".space\t1";
            case "double":
                return ".double\t0.0";
            case "boolean":
                return ".word\t0";
            case "String":
                return ".space\t255";
            default:
                return "Popeye, Encontre un error :(";
        }
    }

    public void addMsgsFinalCode(StringBuilder sB) {
        sB.append(".data\n");
        int msgCounter = 0;
        String temp;
        do {
            temp = "\t_msg" + msgCounter + ":\t.asciiz \"" + programStrings.poll() + "\\n\"\n";
            sB.append(temp);
            msgCounter++;
        } while (!programStrings.isEmpty());

    }

    public boolean search(String id) {
        if (!this.symbolTable.search(id)) {
            if (this.iAmYourFather == null) {
                return false;
            } else {
                return this.iAmYourFather.search(id);
            }
        } else {
            return true;
        }
    }

    public boolean addMsg(String msg) {
        return programStrings.add(msg);
    }

    public Queue<String> getProgramStrings() {
        return programStrings;
    }

    public void setErrors() {
        semanticErrors = true;
    }

    public boolean error() {
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
            if (this.iAmYourFather == null) {
                return null;
            } else {
                return this.iAmYourFather.searchRow(id);
            }
        }
    }

    public Object getIdType(String id) {
        if (this.symbolTable.getIdType(id) == null) {
            if (this.iAmYourFather == null) {
                return null;
            } else {
                return this.iAmYourFather.getIdType(id);
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
        return iAmYourFather;
    }

    public void setFather(Node iAmYourFather) {
        this.iAmYourFather = iAmYourFather;
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
