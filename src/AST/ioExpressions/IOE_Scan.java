/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.ioExpressions;

import app.semanticAnalysis.Table.Node;

/**
 *
 * @author C5220701
 */
public class IOE_Scan extends ioExpressions{
    private String id;

    public IOE_Scan(String id) {
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
        System.out.println("IOE_Scan");
        System.out.println(this.id);
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        if (!symbolNode.search(id)) {
            String errorMsg = "Semantic Error: The id: \'"+id+"\' doesn\'t exists"+"\n\tline: "+this.line;
            System.err.println(errorMsg);
            symbolNode.setErrors();
        }
    }
    
@Override
    public void setLine(int line) {
        this.line = line+1;
    }

    @Override
    public int getLine() {
        return this.line;
    }
    
}