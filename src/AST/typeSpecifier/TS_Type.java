/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.typeSpecifier;

/**
 *
 * @author Daniel
 */
public class TS_Type extends typeSpecifier{
    private String type;

    public TS_Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void printNode() {
        System.out.println("TS_Type");
        System.out.println(this.type);
    }
    
}
