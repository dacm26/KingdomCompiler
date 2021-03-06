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
public class PE_Content extends primaryExpression{
       /*
         char = 1
         int = 2
         double = 3
         string = 4
         boolean = 5
         error = -1
        */
    private Object content;
    private int type;
    private Generate generateCode;
    
    public PE_Content(Object content, int type) {
        this.content = content;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String stringContent(){
        switch(type){
            case 1:{
                return Character.toString((char)content);
            }
            case 2:{
                return Integer.toString((int)content);
            }
            case 3:{
                return Double.toString((double)content);
            }
            case 4:{
                return (String)content;
            }
            case 5:{
                return stringify((boolean)content);
            }
            default:
                return "";
        }
    }
    
    @Override
    public void generateIC(Generate gc){
        this.generateCode = gc;
    }

    public Object getContent() {
        return content;
    }
    
    public String stringify(boolean value) {
        return value ? "true" : "false";
    }

    public void setContent(Object content) {
        this.content = content;
    }

    @Override
    public void printNode() {
        System.out.println("PE_Content");
        System.out.println(this.content.toString());
    }

    @Override
    public int getType(Node symbolTable) {
        return this.type;
    }

    
}
