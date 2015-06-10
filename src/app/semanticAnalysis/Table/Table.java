/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.semanticAnalysis.Table;

import app.semanticAnalysis.Types.FunctionType;
import app.semanticAnalysis.Types.PrimitiveDataType;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author C5220701
 */
public class Table {

    private ArrayList<Row> table;
    private HashMap<String, Integer> index;

    public Table() {
        this.table = new ArrayList<>();
        this.index = new HashMap<>();
    }

    public boolean add(Row t) {
        int dir=0;
        if (this.index.containsKey(t.getId())) {
            System.err.println("Semantic Error: the id: \""+t.getId()+ "\" already exists.");
            return false;
        }
        else if (this.table.isEmpty() && t.getType() instanceof PrimitiveDataType) {
            dir = 0;
        } else if (t.getType() instanceof FunctionType) {
            dir = -1;
        } else {
            if (this.table.get(this.table.size() - 1).getDir() < 0) {
                dir = 0;
            } else {
                if (t.isParam()) {
                    dir = 0;
                }else{
                    if (this.table.get(this.table.size() - 1).isParam()) {
                        dir = 0;
                    }else{
                        dir = this.table.get(this.table.size() - 1).getDir() + this.table.get(this.table.size() - 1).getType().getSize();
                    }
                    
                }
                

            }
        }
        t.setDir(dir);
        this.table.add(t);
        this.index.put(t.getId(), this.table.size() - 1);
        return true;

    }

    public boolean search(String id) {
        return this.index.containsKey(id);
    }
    
    public Row searchRow(String id){
        if (search(id)) {
            return this.table.get(this.index.get(id));
        }
        return null;
    }
    
    public Object getIdType(String id){
        if (this.search(id)) {
            return this.table.get(this.index.get(id)).getType();
        }else{
            return null;
        }
        
    }

    public ArrayList<Row> getTable() {
        return table;
    }

    public HashMap<String, Integer> getIndex() {
        return index;
    }

    @Override
    public String toString() {
        StringBuilder sB = new StringBuilder();
        sB.append("Table\n");
        sB.append("Id\t\tType\t\tisParam\t\tDir\n");
        for (Row name : this.table) {
            sB.append(name.toString());
        }
        sB.append("\n\nIndex\n");
        String key;
        int value;
        for (String name : this.index.keySet()) {

            key = name;
            value = this.index.get(key);
            sB.append(key);
            sB.append("\t\t");
            sB.append(value);
            sB.append("\n");

        }
        return sB.toString();
    }

}
