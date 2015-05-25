/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.semanticAnalysis.Table;

import AST.primaryExpression.PE_Content;
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
        System.out.println(table.getIdType("a").toString());
        
        
        /*
        PE_Content test=new PE_Content("123",2);
        PE_Content test1=new PE_Content("asd",4);
        PE_Content test2=new PE_Content("12.12",3);
        PE_Content test3=new PE_Content("a",1);
        PE_Content test4=new PE_Content(true,5);
        PE_Content test5=new PE_Content(false,5);
        
        System.out.println(test.getType());
        System.out.println(test1.getContent().toString());
        System.out.println(test2.getContent().toString());
        System.out.println(test3.getContent().toString());
        System.out.println(test4.getContent().toString());
        System.out.println(test5.getContent().toString());
        
        if ("int".equals(table.getIdType("a").toString())) {
            System.out.println("Es entero");
        }else{
            System.out.println("Neles");
        }
        */
        Object t = null;
        if (t == null) {
            System.out.println("oi");
        }
    }
}
