/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.functionDefinition;
import AST.typeSpecifier.*;
import AST.compoundStatement.*;
import AST.parameterList.*;
/**
 *
 * @author Daniel
 */
public class FD_FunctionDefinition extends functionDefinition{
    private typeSpecifier type;
    private String id;
    private parameterList pL;
    private compoundStatement cS;

    public FD_FunctionDefinition(typeSpecifier type, String id, compoundStatement cS) {
        this.type = type;
        this.id = id;
        this.pL = null;
        this.cS = cS;
    }

    public FD_FunctionDefinition(typeSpecifier type, String id, parameterList pL, compoundStatement cS) {
        this.type = type;
        this.id = id;
        this.pL = pL;
        this.cS = cS;
    }

    public typeSpecifier getType() {
        return type;
    }

    public void setType(typeSpecifier type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public parameterList getpL() {
        return pL;
    }

    public void setpL(parameterList pL) {
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
    
    
}
