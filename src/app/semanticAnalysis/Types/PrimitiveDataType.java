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
    private final int size;

    public PrimitiveDataType(Object primitiveType,int size) {
        this.primitiveType = primitiveType;
        this.size = size;
    }
    @Override
    public int getSize() {
        return size;
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
