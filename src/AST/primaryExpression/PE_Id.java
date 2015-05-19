/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.primaryExpression;

import app.semanticAnalysis.Table.Node;

/**
 *
 * @author Daniel
 */
public class PE_Id extends primaryExpression{
    private String id;

    public PE_Id(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void printNode() {
        System.out.println("PE_Id");
        System.out.println(id);
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        
    }
    
}
