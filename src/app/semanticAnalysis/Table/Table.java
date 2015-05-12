/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.semanticAnalysis.Table;

import app.semanticAnalysis.Types.*;
import java.util.HashMap;

/**
 *
 * @author C5220701
 */
public class Table {

    private HashMap<String, Type> table;

    public Table() {
        this.table = new HashMap<>();
    }

    public boolean add(String id, Type t) {
        if (this.table.containsKey(id)) {
            return false;
        }
        
        this.table.put(id, t);
        return true;

    }

    public HashMap<String, Type> getTable() {
        return table;
    }

}
