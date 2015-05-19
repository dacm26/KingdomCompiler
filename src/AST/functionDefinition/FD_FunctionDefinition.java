/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.functionDefinition;
import AST.functionTypeSpecifier.*;
import AST.compoundStatement.*;
import AST.typeParameterList.*;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class FD_FunctionDefinition extends functionDefinition{
    private functionTypeSpecifier type;
    private String id;
    private typeParameterList pL;
    private compoundStatement cS;

    public FD_FunctionDefinition(functionTypeSpecifier type, String id, compoundStatement cS) {
        this.type = type;
        this.id = id;
        this.pL = null;
        this.cS = cS;
    }

    public FD_FunctionDefinition(functionTypeSpecifier type, String id, typeParameterList pL, compoundStatement cS) {
        this.type = type;
        this.id = id;
        this.pL = pL;
        this.cS = cS;
    }

    public functionTypeSpecifier getType() {
        return type;
    }

    public void setType(functionTypeSpecifier type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public typeParameterList getpL() {
        return pL;
    }

    public void setpL(typeParameterList pL) {
        this.pL = pL;
    }

    public compoundStatement getcS() {
        return cS;
    }

    public void setcS(compoundStatement cS) {
        this.cS = cS;
    }

    @Override
    public void printNode() {
        System.out.println("FD_FunctionDefinition");
        this.type.printNode();
        System.out.println(this.id);
        if (this.pL != null) {
            this.pL.printNode();
        }
        this.cS.printNode();
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        
    }
    
    
}
