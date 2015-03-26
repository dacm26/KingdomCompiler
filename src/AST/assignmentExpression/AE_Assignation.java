/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.assignmentExpression;
import AST.conditionalExpression.*;
import AST.typeSpecifier.*;
/**
 *
 * @author Daniel
 */
public class AE_Assignation extends assignmentExpression{
    private typeSpecifier tS;
    private String id;
    private String operator;
    private conditionalExpression cE;

    public AE_Assignation(typeSpecifier tS, String id, conditionalExpression cE) {
        this.tS = tS;
        this.id = id;
        this.operator="=";
        this.cE = cE;
    }

    public AE_Assignation(String id, conditionalExpression cE) {
        this.tS=null;
        this.id = id;
        this.operator="=";
        this.cE = cE;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
    
    
    
    public typeSpecifier gettS() {
        return tS;
    }

    public void settS(typeSpecifier tS) {
        this.tS = tS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public conditionalExpression getcE() {
        return cE;
    }

    public void setcE(conditionalExpression cE) {
        this.cE = cE;
    }

    @Override
    public void printNode() {
        System.out.println("AE_Assignation");
        if (this.tS != null) {
            this.tS.printNode();
        }
        System.out.println(this.id);
        System.out.println(this.operator);
        this.cE.printNode();
    }
    
    
    
}
