/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.intermediateCode;

import java.util.ArrayList;
import java.util.HashMap;
import AST.compoundStatement.*;
import AST.selectionStatement.selectionStatement;
import java.util.Stack;

/**
 *
 * @author C5220703
 */
public class Generate {

    int tempIndex;
    int tagIndex;
    HashMap<String, StringBuilder> functionCode;
    Cuadruplo cuadruplo;
    String tempInUse;
    
    public Generate() {
        tempIndex = 0;
        tagIndex = 0;
        functionCode = new HashMap<>();
        cuadruplo = new Cuadruplo();
        tempInUse = "";
    }

    public int getTempIndex() {
        return tempIndex;
    }

    public void addTempIndex() {
        this.tempIndex++;
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
    
    public void printIC(){
        cuadruplo.print();
    }
    
    public void generateTag(String tag){
        cuadruplo.addRow("ETIQ", tag, "", "");
    }

    public String generateTag(){
        String tag = "etiq"+tagIndex;
        tagIndex++;
        return tag;
    }
    
    public void generateFunctionCall(String id, int parameterQuantity){
        cuadruplo.addRow("call", id, Integer.toString(parameterQuantity), "");
    }
    
    public void generateParameter(String x){
        cuadruplo.addRow("param", x, "", "");
    }
    
    public void generateGOTO(String tag){
    }

    public String generateOperation(String left, String operator, String right){
        cuadruplo.addTempRow(operator,left,right,"t"+tempIndex);
        this.tempInUse= "t"+tempIndex;
        tempIndex++;
        return tempInUse;
    }

    public void generateAssign(String left, String right){
        cuadruplo.addRow("=",right, "", left);
    }

    public void generateIfStatement(String operation, String tag, compoundStatement stm, compoundStatement stmElse, selectionStatement sS){
        cuadruplo.addRow("IF",operation,"true",tag);
        cuadruplo.addRow("goto", "etiq"+tagIndex, "", "" );
        String falseTag = "etiq"+tagIndex;
        tagIndex++;
        generateTag(tag);
        stm.generateIC();
        generateTag(falseTag);
        if(stmElse != null){
            stmElse.generateIC();
        } 
        if(sS != null){
            sS.generateIC();
        }
    }

    public void generateSwitchStatement(String operation){

    }

    public void generatePrint(String id, String content){
        if (id != ""){
            cuadruplo.addRow("print",id,"","");
        } else {
            cuadruplo.addRow("print",content,"","");
        }
    }

    public void generateScan(String id){
        cuadruplo.addRow("scan",id,"","");
    }

    public ArrayList<RowIC> getCodeBlock(){
        return cuadruplo.getTempRow();
    }

    public void flushCodeBlock(ArrayList<RowIC> t){
        cuadruplo.flushRows(t);
    }

    public void emptyTemp(){
        cuadruplo.emptyTemp();
    }
}