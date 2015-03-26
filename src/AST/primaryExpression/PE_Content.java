/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.primaryExpression;

/**
 *
 * @author Daniel
 */
public class PE_Content extends primaryExpression{
    private Object content;

    public PE_Content(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    @Override
    public void printNode() {
        System.out.println("PE_Content");
        System.out.println(this.content.toString());
    }
    
}