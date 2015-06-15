/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.statement;

import AST.declaration.*;
import app.intermediateCode.Generate;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class S_Declaration extends Statement{
    private Declaration declaration;

    public S_Declaration(Declaration declaration) {
        this.declaration = declaration;
    }

    public Declaration getDeclaration() {
        return declaration;
    }

    public void setDeclaration(Declaration declaration) {
        this.declaration = declaration;
    }
    
    @Override
    public void generateIC(Generate gc){
        
    }
    
    @Override
    public void printNode() {
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        this.declaration.generateSymbolNode(symbolNode);
    }
    
}
