/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.intermediateCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author C5220703
 */
public class Generate {

    ArrayList<String> tempList;
    HashMap<String, StringBuilder> functionCode;
    StringBuilder intermediateCode;
    
    public Generate() {
        tempList = new ArrayList<>();
        functionCode = new HashMap<>();
        intermediateCode = new StringBuilder();
    }

    public ArrayList<String> getTempList() {
        return tempList;
    }

    public void setTempList(ArrayList<String> tempList) {
        this.tempList = tempList;
    }
    
    public void addFunction(String id){
        this.functionCode.put(id, new StringBuilder());
    }
    
    public StringBuilder getFunctionCode(String id){
        return this.functionCode.get(id);
    }
    
    public void setFunctionCode(String id, StringBuilder fC){
        this.functionCode.put(id, fC);
    }

    public StringBuilder getintermediateCode() {
        return intermediateCode;
    }

    public void setintermediateCode(StringBuilder intermediateCode) {
        this.intermediateCode = intermediateCode;
    }
    
    public void printIC(){
        System.out.println(intermediateCode.toString());
    }
    
    public void generateTag(String tag){
        intermediateCode.append(tag+":\n");
    }
    
    public void generateFunctionCall(String id, int parameterQuantity){
        intermediateCode.append("call "+id+", "+parameterQuantity+"\n");
        intermediateCode.append(functionCode.get((String)id));
    }
    
    public void generateTypeParameterList(ArrayList<String> parameters){
        for (String x: parameters){
            intermediateCode.append("param "+x+"\n");
        }
    }
    
    public void generateGOTO(String tag, Boolean peekFromStack){
    }
    
//    public void temporalNuevo(){
//        
//    }
}
