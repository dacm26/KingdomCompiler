/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.basicExpression;
/**
 *
 * @author Daniel
 */
public class BE_Scan extends basicExpression{
    private String id;

    public BE_Scan(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void printNode() {
        System.out.println("BE_Scan");
        System.out.println(this.id);
    }
    
    
}
