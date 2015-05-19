/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.declaration;

import AST.expression.Expression;
import AST.variableTypeSpecifier.*;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class D_Assign extends Declaration{
    private variableTypeSpecifier type;
    private String id;
    private Expression exp;

    public D_Assign(String id, Expression exp) {
        this.type=null;
        this.id = id;
        this.exp = exp;
    }

    public D_Assign(variableTypeSpecifier type, String id, Expression exp) {
        this.type = type;
        this.id = id;
        this.exp = exp;
    }

    public variableTypeSpecifier getType() {
        return type;
    }

    public void setType(variableTypeSpecifier type) {
        this.type = type;
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
    public void generateSymbolNode(Node symbolNode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
