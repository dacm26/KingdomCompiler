/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.labeledStatement;

import AST.compoundStatement.*;
import app.semanticAnalysis.Table.Node;

/**
 *
 * @author Daniel
 */
public class LS_Case extends labeledStatement {

    private Object content;
    private compoundStatement cS;
    private labeledStatement lS;
    private int contentType;

    public LS_Case(Object content, compoundStatement cS, labeledStatement lS, int cT) {
        this.content = content;
        this.cS = cS;
        this.lS = lS;
        this.contentType = cT;
    }

    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public compoundStatement getcS() {
        return cS;
    }

    public void setcS(compoundStatement cS) {
        this.cS = cS;
    }

    public labeledStatement getlS() {
        return lS;
    }

    public void setlS(labeledStatement lS) {
        this.lS = lS;
    }

    @Override
    public void printNode() {
    }

    @Override
    public boolean generateSymbolNode(Node symbolNode,String id) {
        int type1 = symbolNode.getNumericalIdType(id);
        if (this.contentType != type1) {
            reportSemanticError(this.contentType,type1);
            symbolNode.setErrors();
            return false;
        }
        
        Node novo = new Node();
        novo.setFather(symbolNode);
        symbolNode.giffBaby(novo);
        this.cS.generateSymbolNode(symbolNode.getSons().get(symbolNode.getSons().size()-1));
        return this.lS.generateSymbolNode(symbolNode,id);
    }

    private void reportSemanticError(int type1, int type2) {
        String typeReceived;
        switch (type1) {
            case 1:
                typeReceived = "char";
                break;
            case 2:
                typeReceived = "int";
                break;
            case 3:
                typeReceived = "double";
                break;
            case 4:
                typeReceived = "String";
                break;
            case 5:
                typeReceived = "boolean";
                break;
            default:
                typeReceived = "Wrong Operation";
                break;
        }
        String typeExpected;
        switch (type2) {
            case 1:
                typeExpected = "char";
                break;
            case 2:
                typeExpected = "int";
                break;
            case 3:
                typeExpected = "double";
                break;
            case 4:
                typeExpected = "String";
                break;
            case 5:
                typeExpected = "boolean";
                break;
            default:
                typeExpected = "Wrong Operation";
                break;
        }
        String errorMsg = "Semantic Error: Type mismatch\n" + "\tExpected: " + typeExpected + " for the switch.\n\tReceived: " + typeReceived;
        System.err.println(errorMsg);
    }

}
