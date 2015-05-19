/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.ioExpressions;

import app.semanticAnalysis.Table.Table;

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
    public void generateSymbolTable(Table symbolTable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
