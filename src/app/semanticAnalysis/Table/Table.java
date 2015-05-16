/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.semanticAnalysis.Table;

import app.semanticAnalysis.Types.FunctionType;
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
        int dir;

        if (this.index.containsKey(t.getId())) {
            return false;
        }
        if (this.table.isEmpty()) {
            dir = 0;
        }else if (t.getType() instanceof FunctionType) {
            dir=t.getType().getSize();
        }
        else{
            dir = this.table.get(this.table.size() - 1).getDir()+this.table.get(this.table.size() - 1).getType().getSize();
        }
        t.setDir(dir);
        this.table.add(t);
        this.index.put(t.getId(), this.table.size() - 1);
        return true;

    }

    public boolean search(String id) {
        return this.index.containsKey(id);
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
        sB.append("Id\t\tType\t\tDir\n");
        for (Row name : this.table) {
            sB.append(name.toString());
        }
        sB.append("\n\nIndex\n");
        String key;
        int value;
        for (String name : this.index.keySet()) {

            key = name;
            value =this.index.get(key);
            sB.append(key);
            sB.append("\t\t");
            sB.append(value);
            sB.append("\n");

        }
        return sB.toString();
    }

}
