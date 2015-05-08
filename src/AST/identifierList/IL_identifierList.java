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
public class IL_identifierList extends identifierList{
    private identifierList iL;
    private primaryExpression id;

    public IL_identifierList(identifierList iL, primaryExpression id) {
        this.iL = iL;
        this.id = id;
    }

    public identifierList getiL() {
        return iL;
    }

    public void setiL(identifierList iL) {
        this.iL = iL;
    }

    public primaryExpression getId() {
        return id;
    }

    public void setId(primaryExpression id) {
        this.id = id;
    }

    @Override
    public void printNode() {
        System.out.println("IL_identifierList");
        this.iL.printNode();
        System.out.println(this.id);
    }
    
    
}
