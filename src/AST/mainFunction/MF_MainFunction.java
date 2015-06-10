/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.mainFunction;

import AST.functionTypeSpecifier.*;
import AST.compoundStatement.*;
import app.semanticAnalysis.Table.Row;
import app.semanticAnalysis.Table.Node;
import app.semanticAnalysis.Types.FunctionType;
import app.semanticAnalysis.Types.PrimitiveDataType;
import app.semanticAnalysis.Types.Type;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class MF_MainFunction extends mainFunction {

    private functionTypeSpecifier tS;
    private compoundStatement cS;

    public MF_MainFunction(functionTypeSpecifier tS, compoundStatement cS) {
        this.tS = tS;
        this.cS = cS;
    }

    public functionTypeSpecifier gettS() {
        return tS;
    }

    public void settS(functionTypeSpecifier tS) {
        this.tS = tS;
    }

    public compoundStatement getcS() {
        return cS;
    }

    public void setcS(compoundStatement cS) {
        this.cS = cS;
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        /*Function Type Specifier*/
        if (this.tS instanceof FTS_Type) {
            ArrayList<Type> params = new ArrayList<>();
            symbolNode.add(new Row("KingdomHearts", new FunctionType(params, new PrimitiveDataType(((FTS_Type) this.tS).getType(), 0)),false));
        }
        
        /*Compound Statement*/
        Node novo = new Node();
        novo.setFather(symbolNode);
        symbolNode.giffBaby(novo);
        this.cS.generateSymbolNode(symbolNode.getSons().get(symbolNode.getSons().size()-1));
    }

    
    @Override
    public void printNode() {
    }


}
