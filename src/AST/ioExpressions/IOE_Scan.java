/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.ioExpressions;

import app.semanticAnalysis.Table.Node;

/**
 *
 * @author C5220701
 */
public class IOE_Scan extends ioExpressions{
    private String id;
    private Generate generateCode;

    public IOE_Scan(String id) {
        this.id = id;
        this.generateCode = generateCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void generateIC(){
        this.generateCode.generateScan(id);
    }

    @Override
    public void printNode() {
        System.out.println("IOE_Scan");
        System.out.println(this.id);
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        if (!symbolNode.search(id)) {
            String errorMsg = "Semantic Error: The id: \'"+id+"\' doesn\'t exists";
            System.err.println(errorMsg);
        }
    }
    
}
