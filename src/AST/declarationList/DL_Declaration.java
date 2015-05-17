/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.declarationList;
import AST.declaration.*;
/**
 *
 * @author Daniel
 */
public class DL_Declaration extends declarationList{
    private Declaration d;

    public DL_Declaration(Declaration d) {
        this.d = d;
    }

    public Declaration getD() {
        return d;
    }

    public void setD(Declaration d) {
        this.d = d;
    }

    @Override
    public void printNode() {
        System.out.println("DL_Declaration");
        this.d.printNode();
    }
    
}
