/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.parameterList;
import AST.variableTypeSpecifier.*;
/**
 *
 * @author Daniel
 */
public class PL_Id extends parameterList{
    private VTS_Type type;
    private String id;

    public PL_Id(VTS_Type type, String id) {
        this.type = type;
        this.id = id;
    }

    public VTS_Type getType() {
        return type;
    }

    public void setType(VTS_Type type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void printNode() {
        System.out.println("PL_Id");
        this.type.printNode();
        System.out.println(this.id);
    }
    
}
