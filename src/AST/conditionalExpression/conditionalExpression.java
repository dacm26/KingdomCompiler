/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.conditionalExpression;
import app.intermediateCode.*;
import app.semanticAnalysis.Table.Node;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
abstract public class conditionalExpression {
  abstract public void printNode();
  abstract public ArrayList<Integer> getType(Node symbolTable);
  abstract public void generateIC();
  abstract public void setStringContent();
  abstract public String getStringContent();
  abstract public void setCodeBlock(ArrayList<RowIC> t);
  abstract public ArrayList<RowIC> getCodeBlock();
}
