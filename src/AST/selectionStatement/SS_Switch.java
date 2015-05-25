/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.selectionStatement;

import AST.labeledStatement.*;
import app.semanticAnalysis.Table.Node;

/**
 *
 * @author Daniel
 */
public class SS_Switch extends selectionStatement {

    private String id;
    private labeledStatement lS;

    public SS_Switch(String id, labeledStatement lS) {
        this.id = id;
        this.lS = lS;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
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
    public void generateSymbolNode(Node symbolNode) {
        String errorMsg;
        if (!symbolNode.search(id)) {
            errorMsg = "Semantic Error: The id: \'" + id + "\' doesn\'t exists";
            System.err.println(errorMsg);
            return;
        }
        Node novo = new Node();
        novo.setFather(symbolNode);
        symbolNode.giffBaby(novo);
        if (!this.lS.generateSymbolNode(symbolNode.getSons().get(symbolNode.getSons().size()-1),id)) {
            symbolNode.deleteLastNode();
        }
    }

}
