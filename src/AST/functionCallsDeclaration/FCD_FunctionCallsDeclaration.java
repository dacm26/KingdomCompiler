/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.functionCallsDeclaration;

import AST.parameterList.*;
import app.intermediateCode.Generate;
import app.semanticAnalysis.Table.Node;
import app.semanticAnalysis.Table.Row;
import app.semanticAnalysis.Types.FunctionType;
import app.semanticAnalysis.Types.Type;
import java.util.ArrayList;

/**
 *
 * @author C5220701
 */
public class FCD_FunctionCallsDeclaration extends functionCallsDeclaration {

    private String id;
    private parameterList pL;
    private Generate generateCode;

    public FCD_FunctionCallsDeclaration(String id, parameterList pL) {
        this.id = id;
        this.pL = pL;
    }

    public FCD_FunctionCallsDeclaration(String id) {
        this.id = id;
        this.pL = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public parameterList getpL() {
        return pL;
    }

    public void setpL(parameterList pL) {
        this.pL = pL;
    }

    @Override
    public void generateIC(Generate gc, Node symbolNode){
        this.generateCode = gc;
        if (this.pL == null){
            this.generateCode.generateFunctionCall(this.id, 0);
        } else {
            //this.pL.generateIC(this.generateCode);
            ArrayList<String> novo = this.convertToString(this.pL.getTypes(symbolNode));
            this.generateCode.generateFunctionCall(this.id, novo.size());
        }
    }
    
    @Override
    public void printNode() {
        System.out.println("FCE_FunctionCallsExpression");
        System.out.println(this.id);
        if (this.pL != null) {
            this.pL.printNode();

        }
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        if (!symbolNode.search(this.id)) {
            System.err.println("Semantic Error: The function \'"+this.id+"\' doesn't exists.");
            symbolNode.setErrors();
            return;
        } else {
            if (this.pL == null) {
                //No tiene parametros
                Row row = symbolNode.searchRow(id);
                if (row.getType() instanceof FunctionType) {
                    FunctionType type = (FunctionType) row.getType();
                    if (!type.getParameters().isEmpty()) {
                        System.err.println("Semantic Error: Params mismatch\n" + "\tExpected: " + type.getParamsType() + " for the function: \'" + this.id + "\'.\n\tReceived: " + "lambda");
                        symbolNode.setErrors();
                        return;
                    }
                } else {
                    System.err.println("Semantic Error: Something is wrong with the call.");
                    symbolNode.setErrors();
                    return;
                }
            } else {
                //Tiene parametros
                Row row = symbolNode.searchRow(id);
                if (row.getType() instanceof FunctionType) {
                    FunctionType type = (FunctionType) row.getType();
                    if (type.getParameters().isEmpty()) {
                        System.err.println("Semantic Error: Type mismatch\n" + "\tExpected: " + type.getParamsType() + " for the function: \'" + this.id + "\'.\n\tReceived: " + this.paramType(this.convertToString(this.pL.getTypes(symbolNode))));
                        symbolNode.setErrors();
                        return;
                    } else {
                        //Comprobacion del envio de parametros
                    /*if (this.pL.validExpression(symbolNode)) {
                         System.err.println("Semantic Error: Something is wrong with the Expressions1.");
                         return;
                         } else {*/
                        ArrayList<String> novo = this.convertToString(this.pL.getTypes(symbolNode));
                        if (type.getParameters().size() != novo.size()) {
                            System.err.println("Semantic Error: Type mismatch\n" + "\tExpected: " + type.getParamsType() + " for the function: \'" + this.id + "\'.\n\tReceived: " + this.paramType(novo));
                            symbolNode.setErrors();
                            return;
                        } else {
                            if (!verifyParams(novo, type.getParameters())) {
                                System.err.println("Semantic Error: Type mismatch\n" + "\tExpected: " + type.getParamsType() + " for the function: \'" + this.id + "\'.\n\tReceived: " + this.paramType(novo));
                                symbolNode.setErrors();
                                return;
                            }
                        }
                        //}

                    }
                } else {
                    System.err.println("Semantic Error: Something is wrong with the call.");
                    symbolNode.setErrors();
                    return;
                }
            }
        }
    }

    private boolean verifyParams(ArrayList<String> t1, ArrayList<Type> t2) {
        for (int i = 0; i < t1.size(); i++) {
            if (!t1.get(i).equals(t2.get(i).toString())) {
                return false;
            }
        }
        return true;
    }

    private String paramType(ArrayList<String> t) {
        StringBuilder sB = new StringBuilder();
        if (t.isEmpty()) {
            sB.append("lambda");
        } else {
            for (int i = 0; i < t.size(); i++) {

                if (i < t.size() - 1) {
                    sB.append(t.get(i)).append(" X ");
                } else {
                    sB.append(t.get(i));
                }
            }
        }
        return sB.toString();
    }

    private ArrayList<String> convertToString(ArrayList<Integer> t) {

        ArrayList<String> retVal = new ArrayList<>();
        for (Integer t1 : t) {
            switch (t1) {
                case 1:
                    retVal.add("char");
                    break;
                case 2:
                    retVal.add("int");
                    break;
                case 3:
                    retVal.add("double");
                    break;
                case 4:
                    retVal.add("String");
                    break;
                case 5:
                    retVal.add("boolean");
                    break;
                default:
                    break;
            }
        }
        return retVal;
    }

}
