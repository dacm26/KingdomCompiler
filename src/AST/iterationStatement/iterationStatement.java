package AST.iterationStatement;

import app.semanticAnalysis.Table.Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel
 */
abstract public class iterationStatement {
    abstract public void printNode();
    abstract public void generateSymbolTable(Table symbolTable);
}
