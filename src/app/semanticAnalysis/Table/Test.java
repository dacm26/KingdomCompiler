/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.semanticAnalysis.Table;

import app.semanticAnalysis.Types.*;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Test {
    public static void main(String[] args) {
        Table table = new Table();
        ArrayList<Type> a=new ArrayList<>();
        String f = "asdasd";
        table.add(new Row("a",new PrimitiveDataType(Integer.TYPE,Integer.SIZE/8)));
        table.add(new Row("b",new PrimitiveDataType(Character.TYPE,Character.SIZE/8)));
        table.add(new Row("c",new PrimitiveDataType(Double.TYPE,Double.SIZE/8)));
        table.add(new Row("d",new PrimitiveDataType(Boolean.TYPE,1)));
        table.add(new Row("e",new PrimitiveDataType(Void.TYPE,2)));
        table.add(new Row("f",new PrimitiveDataType(String.class.getSimpleName(),Character.SIZE*f.length()/8)));
        table.add(new Row("h",new FunctionType(a,new PrimitiveDataType(Integer.TYPE,Integer.SIZE/8))));
        System.out.println(table.toString());
        Object type = new Integer("");
        if (type instanceof Integer) {
            System.out.println(((Integer)type).toString());
        } else {
            System.out.println("No sale: "+type);
        }
        
    }
}
