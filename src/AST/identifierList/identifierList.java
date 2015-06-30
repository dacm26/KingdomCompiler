/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.identifierList;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
abstract public class identifierList {
    abstract public void printNode();
    abstract public ArrayList<String> getIds();
   abstract public void setLine(int line);
    abstract public int getLine();
    protected int line;
}
