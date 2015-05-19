/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.mainDeclarator;
import AST.parameterList.*;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class MD_Declaration extends mainDeclarator{
    private String main;
    private parameterList pL;

    public MD_Declaration() {
        this.main="KingdomHearts";
        this.pL=null;
    }

    public MD_Declaration(parameterList pL) {
        this.main="KingdomHearts";
        this.pL = pL;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public parameterList getpL() {
        return pL;
    }

    public void setpL(parameterList pL) {
        this.pL = pL;
    }

    @Override
    public void printNode() {
        System.out.println("MD_Declaration");
        System.out.println(this.main);
        if (this.pL != null) {
            this.pL.printNode();
        }
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
