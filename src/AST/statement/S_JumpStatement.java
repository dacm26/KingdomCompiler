/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.statement;
import AST.jumpStatement.*;
/**
 *
 * @author Daniel
 */
public class S_JumpStatement extends statement{
    private jumpStatement jS;

    public S_JumpStatement(jumpStatement jS) {
        this.jS = jS;
    }

    public jumpStatement getjS() {
        return jS;
    }

    public void setjS(jumpStatement jS) {
        this.jS = jS;
    }

    @Override
    public void printNode() {
        System.out.println("S_JumpStatement");
        this.jS.printNode();
    }
    
}
