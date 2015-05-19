/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.assignmentExpression;

import AST.expression.*;
import AST.variableTypeSpecifier.*;
import app.semanticAnalysis.Table.Table;

/**
 *
 * @author Daniel
 */
public class AEX_Assignation extends assignmentExpression {

    private variableTypeSpecifier vTS;
    private String id;
    private Expression exp;

    public AEX_Assignation(variableTypeSpecifier vTS, String id, Expression exp) {
        this.vTS = vTS;
        this.id = id;
        this.exp = exp;
    }

    public AEX_Assignation(String id, Expression exp) {
        this.vTS = null;
        this.id = id;
        this.exp = exp;
    }

    public variableTypeSpecifier getvTS() {
        return vTS;
    }

    public void setvTS(variableTypeSpecifier vTS) {
        this.vTS = vTS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Expression getExp() {
        return exp;
    }

    public void setExp(Expression exp) {
        this.exp = exp;
    }
    
    
    

    @Override
    public void printNode() {
    }

    @Override
    public void generateSymbolTable(Table symbolTable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
