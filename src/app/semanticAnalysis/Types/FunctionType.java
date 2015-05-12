/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.semanticAnalysis.Types;

import java.util.ArrayList;

/**
 *
 * @author C5220701
 */
public class FunctionType extends Type{
    private final ArrayList<Type> parameters;
    private final Type Return;

    public FunctionType(ArrayList<Type> parameters, Type Return) {
        this.parameters = parameters;
        this.Return = Return;
    }

    public ArrayList<Type> getParameters() {
        return parameters;
    }

    public Type getReturn() {
        return Return;
    }
    

    @Override
    public Type getType() {
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sB= new StringBuilder();
        for (int i = 0; i < this.parameters.size(); i++) {
            if(i < this.parameters.size()-1){
                sB.append(this.parameters.get(i).toString()).append(" X ");
            }else{
                 sB.append(this.parameters.get(i));
            }
        }
        sB.append(" --> ").append(this.Return.toString());
        return sB.toString();
    }
    
}
