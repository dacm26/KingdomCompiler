/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.externalDeclaration;
import AST.functionDefinition.*;
import app.semanticAnalysis.Table.Table;
/**
 *
 * @author Daniel
 */
public class ED_ExternalDeclaration extends externalDeclaration{
    private functionDefinition fD;
    private externalDeclaration eD;

    public ED_ExternalDeclaration(functionDefinition fD, externalDeclaration eD) {
        this.fD = fD;
        this.eD = eD;
    }

    public functionDefinition getfD() {
        return fD;
    }

    public void setfD(functionDefinition fD) {
        this.fD = fD;
    }

    public externalDeclaration geteD() {
        return eD;
    }

    public void seteD(externalDeclaration eD) {
        this.eD = eD;
    }

    @Override
    public void printNode() {
        System.out.println("ED_ExternalDeclaration");
        this.fD.printNode();
        this.eD.printNode();
    }

    @Override
    public void generateSymbolTable(Table symbolTable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
