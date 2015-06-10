/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.semanticAnalysis.Table;

import app.semanticAnalysis.Types.*;

/**
 *
 * @author Daniel
 */
public class Row {
    private String id;
    private Type type;
    private boolean isParam;
    private int dir;

    public Row(String id,Type type,boolean isParam) {
        this.id= id;
        this.type = type;
        this.isParam = isParam;
        this.dir = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isParam() {
        return isParam;
    }

    public void setIsParam(boolean isParam) {
        this.isParam = isParam;
    }
    
    
    
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    @Override
    public String toString() {
        return this.id+"\t\t"+this.type.toString()+"\t\t"+this.isParam+"\t\t"+this.dir+"\n";
    }
    
    
}
