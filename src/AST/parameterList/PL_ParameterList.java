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
public class PL_ParameterList extends parameterList{
    private parameterList pL;
    private VTS_Type type;
    private String id;

    public PL_ParameterList(parameterList pL, VTS_Type type, String id) {
        this.pL = pL;
        this.type = type;
        this.id = id;
    }

    public parameterList getpL() {
        return pL;
    }

    public void setpL(parameterList pL) {
        this.pL = pL;
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
        System.out.println("PL_ParameterList");
        this.pL.printNode();
        this.type.printNode();
        System.out.println(this.id);
    }
    
    
}
