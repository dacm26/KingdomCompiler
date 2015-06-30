/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.declaration;
import AST.variableTypeSpecifier.*;
import AST.identifierList.*;
import app.intermediateCode.Generate;
import app.semanticAnalysis.Table.Node;
import app.semanticAnalysis.Table.Row;
import app.semanticAnalysis.Types.PrimitiveDataType;
import java.util.ArrayList;
/**
 *
 * @author Daniel
 */
public class D_identifierList extends Declaration{
    private variableTypeSpecifier tS;
    private Generate generateCode;
    private identifierList iL;

    public D_identifierList(variableTypeSpecifier tS, identifierList iL) {
        this.tS = tS;
        this.iL = iL;
    }

    public variableTypeSpecifier gettS() {
        return tS;
    }

    public void settS(variableTypeSpecifier tS) {
        this.tS = tS;
    }

    public identifierList getiL() {
        return iL;
    }

    public void setiL(identifierList iL) {
        this.iL = iL;
    }

    @Override
    public void generateIC(){
    }

    @Override
    public void printNode() {
        System.out.println("D_identifierList");
        this.tS.printNode();
        this.iL.printNode();
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        ArrayList<String> ids= this.iL.getIds();
        for (String id : ids) {
            symbolNode.add(new Row(id, new PrimitiveDataType(((VTS_Type)this.tS).getType(),((VTS_Type)this.tS).getSize()),false));
        }
        
    }
    
@Override
    public void setLine(int line) {
        this.line = line+1;
    }

    @Override
    public int getLine() {
        return this.line;
    }
    

@Override
    public void generateConstants(Node symbolNode) {
    }
}
