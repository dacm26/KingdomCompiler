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
public class IL_Id extends identifierList{
    private String id;

    public IL_Id(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void printNode() {
        System.out.println("IL_Id");
        System.out.println(this.id);
    }


    @Override
    public ArrayList<String> getIds() {
        ArrayList<String> retVal = new ArrayList<>();
        retVal.add(id);
        return retVal;
    }
    
}
