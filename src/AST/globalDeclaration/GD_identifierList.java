/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.globalDeclaration;
import AST.variableTypeSpecifier.*;
import AST.identifierList.*;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class GD_identifierList extends globalDeclaration{
    private variableTypeSpecifier tS;
    private identifierList iL;

    public GD_identifierList(variableTypeSpecifier tS, identifierList iL) {
        this.tS = tS;
        this.iL = iL;
    }

    public variableTypeSpecifier gettS() {
        return tS;
    }

    public void settS(variableTypeSpecifier tS) {
        this.tS = tS;
    }

    public identifierList getiL() {
        return iL;
    }

    public void setiL(identifierList iL) {
        this.iL = iL;
    }

    @Override
    public void printNode() {
        System.out.println("D_identifierList");
        this.tS.printNode();
        this.iL.printNode();
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        
    }
    
}
