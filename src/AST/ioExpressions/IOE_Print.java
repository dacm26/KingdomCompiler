/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.ioExpressions;
import AST.parameterList.*;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author C5220701
 */
public class IOE_Print extends ioExpressions{
    private String content;
    private String id;
    private parameterList iL;

    public IOE_Print(String content, boolean isId) {
        
        if (isId) {
            this.id=content;
        }else{
            this.content = content;
        }
        this.iL=null;
        this.id=null;
    }

    public IOE_Print(String content, parameterList iL) {
        this.content = content;
        this.iL = iL;
        this.id=null;
    }

    public String getContent() {
        return content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    

    public void setContent(String content) {
        this.content = content;
    }

    public parameterList getiL() {
        return iL;
    }

    public void setiL(parameterList iL) {
        this.iL = iL;
    }

    @Override
    public void printNode() {
        System.out.println("IOE_Print");
        System.out.println(this.content);
        if (this.iL !=null) {
            this.iL.printNode();
            
        }
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
