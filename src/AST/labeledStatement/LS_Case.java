/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.labeledStatement;

import AST.compoundStatement.*;

/**
 *
 * @author Daniel
 */
public class LS_Case extends labeledStatement{
    private Object content;
    private compoundStatement cS;
    private labeledStatement lS;

    public LS_Case(Object content, compoundStatement cS, labeledStatement lS) {
        this.content = content;
        this.cS = cS;
        this.lS = lS;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public compoundStatement getcS() {
        return cS;
    }

    public void setcS(compoundStatement cS) {
        this.cS = cS;
    }

    public labeledStatement getlS() {
        return lS;
    }

    public void setlS(labeledStatement lS) {
        this.lS = lS;
    }
    
    

    @Override
    public void printNode() {
    }
    
}
