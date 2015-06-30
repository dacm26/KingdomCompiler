/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.primaryExpression;

import app.intermediateCode.Generate;
import app.semanticAnalysis.Table.Node;

/**
 *
 * @author Daniel
 */
public class PE_Id extends primaryExpression{
    private String id;
    private Generate generateCode;

    public PE_Id(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void generateIC(){
    }
    
    @Override
    public void printNode() {
        System.out.println("PE_Id");
        System.out.println(id);
    }
    
        /*
         char = 1
         int = 2
         double = 3
         string = 4
         boolean = 5
         error = -1
        */
    
    @Override
    public int getType(Node symbolTable) {
        Object t = symbolTable.getIdType(this.getId());
        if (t == null) {
            return -1;
        }
        String type = symbolTable.getIdType(this.getId()).toString();
        switch(type){
            case "int":
                return 2;
            case "char":
                return 1;
            case "double":
                return 3;
            case "boolean":
                return 5;
            case "String":
                return 4;
            default:
                return -1;
        }
        
    }
    
@Override
    public void setLine(int line) {
        this.line = line+1;
    }

    @Override
    public int getLine() {
        return this.line;
    }

    @Override
    public void generateConstants(Node symbolNode) {
    }
    
}
