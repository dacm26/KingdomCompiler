/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.functionDefinition;

import app.semanticAnalysis.Table.Table;

/**
 *
 * @author Daniel
 */
abstract public class functionDefinition {
    abstract public void printNode();
    abstract public void generateSymbolTable(Table symbolTable);
}
