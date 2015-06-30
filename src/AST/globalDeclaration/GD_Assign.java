/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.globalDeclaration;

import AST.expression.Expression;
import AST.variableTypeSpecifier.VTS_Type;
import AST.variableTypeSpecifier.variableTypeSpecifier;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class GD_Assign extends globalDeclaration{
    private variableTypeSpecifier type;
    private String id;
    private Expression exp;

    public GD_Assign(String id, Expression exp) {
        this.type=null;
        this.id = id;
        this.exp = exp;
    }

    public GD_Assign(variableTypeSpecifier type, String id, Expression exp) {
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