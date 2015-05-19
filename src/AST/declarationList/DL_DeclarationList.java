/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.declarationList;
import AST.declaration.*;
import app.semanticAnalysis.Table.Table;
/**
 *
 * @author Daniel
 */
public class DL_DeclarationList extends declarationList{
    private declarationList dL;
    private Declaration d;

    public DL_DeclarationList(declarationList dL, Declaration d) {
        this.dL = dL;
        this.d = d;
    }

    public declarationList getdL() {
        return dL;
    }

    public void setdL(declarationList dL) {
        this.dL = dL;
    }

    public Declaration getD() {
        return d;
    }

    public void setD(Declaration d) {
        this.d = d;
    }

    @Override
    public void printNode() {
        System.out.println("DL_DeclarationList");
        this.dL.printNode();
        this.d.printNode();
    }

    @Override
    public void generateSymbolTable(Table symbolTable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
