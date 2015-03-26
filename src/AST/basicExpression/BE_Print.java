/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.basicExpression;
import AST.identifierList.*;
/**
 *
 * @author Daniel
 */
public class BE_Print extends basicExpression{
    private String content;
    private identifierList iL;

    public BE_Print(String content) {
        this.content = content;
        this.iL=null;
    }

    public BE_Print(String content, identifierList iL) {
        this.content = content;
        this.iL = iL;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public identifierList getiL() {
        return iL;
    }

    public void setiL(identifierList iL) {
        this.iL = iL;
    }

    @Override
    public void printNode() {
        System.out.println("BE_Print");
        System.out.print(this.content+"\t");
        if (this.iL != null) {
            this.iL.printNode();
        }
        
    }
    
    
}
