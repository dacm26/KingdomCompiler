/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.variableTypeSpecifier;

/**
 *
 * @author Daniel
 */
public class VTS_Type extends variableTypeSpecifier{
    private String type;

    public VTS_Type(String type) {
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
        System.out.println("VTS_Type");
        System.out.println(this.type);
    }
    
}
