/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.ioExpressions;
import AST.identifierList.*;
/**
 *
 * @author C5220701
 */
public class IOE_Print extends ioExpressions{
    private String content;
    private identifierList iL;

    public IOE_Print(String content) {
        this.content = content;
        this.iL=null;
    }

    public IOE_Print(String content, identifierList iL) {
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
        System.out.println("IOE_Print");
        System.out.println(this.content);
        if (this.iL !=null) {
            this.iL.printNode();
            
        }
    }
    
    
    
    
}
