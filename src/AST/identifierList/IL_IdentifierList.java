/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.identifierList;

import app.semanticAnalysis.Table.Node;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class IL_IdentifierList extends identifierList{
    private identifierList iL;
    private String id;

    public IL_IdentifierList(identifierList iL, String id) {
        this.iL = iL;
        this.id = id;
    }

    public identifierList getiL() {
        return iL;
    }

    public void setiL(identifierList iL) {
        this.iL = iL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void printNode() {
        System.out.println("IL_identifierList");
        this.iL.printNode();
        System.out.println(this.id);
    }


    @Override
    public ArrayList<String> getIds() {
        ArrayList<String> temp = this.iL.getIds();
        temp.add(id);
        return temp;
    }
    
    
@Override
    public void setLine(int line) {
        this.line = line+1;
    }

    @Override
    public int getLine() {
        return this.line;
    }
    
}