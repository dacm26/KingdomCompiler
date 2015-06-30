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
                return stringify((String)content);
            }
            default:
                return "";
        }
    }
    
    @Override
    public void generateIC(){
    }

    public Object getContent() {
        return content;
    }
    
    public String stringify(String value) {
        return value;
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
        if (this.type == 4) {
            symbolNode.addMsg(this.content.toString());
        }
        if (this.type == 3) {
            symbolNode.addDouble(this.content.toString());
        }
        if (this.type == 1) {
            symbolNode.addChar(this.content.toString());
            
        }
        if (this.type == 2) {
            symbolNode.addInt(this.content.toString());
            
        }
        if (this.type == 5) {
            if (this.content.equals("true")) {
                symbolNode.addBool("1");
            }else{
                symbolNode.addBool("0");
            }
            
            
        }
    }
    
}
