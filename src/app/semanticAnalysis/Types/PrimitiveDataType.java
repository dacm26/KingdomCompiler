/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.semanticAnalysis.Types;


/**
 *
 * @author C5220701
 */
public class PrimitiveDataType extends Type{
    
    
    private final Object primitiveType;

    public PrimitiveDataType(Object primitiveType) {
        this.primitiveType = primitiveType;
    }

    public Object getPrimitiveType() {
        return primitiveType;
    }

    @Override
    public Type getType() {
        return this;
    }

    @Override
    public String toString() {
        return this.primitiveType.toString();
    }
    
}
