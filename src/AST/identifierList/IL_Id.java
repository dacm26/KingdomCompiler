/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.identifierList;
import AST.primaryExpression.*;

/**
 *
 * @author Daniel
 */
public class IL_Id extends identifierList{
    private primaryExpression id;

    public IL_Id(primaryExpression id) {
        this.id = id;
    }

    public primaryExpression getId() {
        return id;
    }

    public void setId(primaryExpression id) {
        this.id = id;
    }

    @Override
    public void printNode() {
        System.out.println("IL_Id");
        System.out.println(this.id);
    }
    
}
