/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.globalDeclaration;

import app.semanticAnalysis.Table.Table;

/**
 *
 * @author Daniel
 */
public abstract class globalDeclaration {
    abstract public void printNode();
    abstract public void generateSymbolTable(Table symbolTable);
}
