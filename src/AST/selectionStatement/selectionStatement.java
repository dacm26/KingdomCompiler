/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.selectionStatement;

import app.semanticAnalysis.Table.Table;

/**
 *
 * @author Daniel
 */
abstract public class selectionStatement {
    abstract public void printNode();
    abstract public void generateSymbolTable(Table symbolTable);
}
