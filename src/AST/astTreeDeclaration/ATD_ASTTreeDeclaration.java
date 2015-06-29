/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.astTreeDeclaration;
import AST.mainFunctionDeclaration.*;
import app.finalMixCode.FinalMixCodeGenerator;
import app.semanticAnalysis.Table.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import app.intermediateCode.*;
import java.io.PrintWriter;
import java.util.Queue;
/**
 *
 * @author C5220701
 */
public class ATD_ASTTreeDeclaration extends astTreeDeclaration{
    private mainFunctionDeclaration mFD;
    private Node symbolNode;
    private Generate generateCode;

    public ATD_ASTTreeDeclaration(mainFunctionDeclaration mFD) {
        this.mFD = mFD;
        this.symbolNode= new Node();
        this.generateCode = new Generate();        
        this.generateSymbolNode();
        this.generateIC();
    }

    public Node getSymbolNode() {
        return symbolNode;
    }

    public void setSymbolNode(Node symbolNode) {
        this.symbolNode = symbolNode;
    }
    

    public mainFunctionDeclaration getmFD() {
        return mFD;
    }

    public void setmFD(mainFunctionDeclaration mFD) {
        this.mFD = mFD;
    }
    
    @Override
    public void generateIC(){
        this.mFD.generateIC(generateCode);
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.generateCode.printIC();
    }
    
    @Override
    public void generateSymbolNode(){
        this.mFD.generateSymbolNode(symbolNode);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            Logger.getLogger(ATD_ASTTreeDeclaration.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //symbolNode.printTables();
        
        if (symbolNode.error()) {//Se encontraron errores semanticos
            System.out.println("Can't proceed. Check the errors.");
        }else{
            FinalMixCodeGenerator FMCG = new FinalMixCodeGenerator();
            StringBuilder sB = new StringBuilder();
            symbolNode.addMsgsFinalCode(sB);
            symbolNode.addVariablsFinalCode(sB);
            symbolNode.addDoublesFinalCode(sB);
            symbolNode.addCharsFinalCode(sB);
            symbolNode.addBoolsFinalCode(sB);
            symbolNode.addIntsFinalCode(sB);
            sB.append("\t_zeroDouble:\t.double\t0.0\t\n");
            sB.append("\t_charBuffer:\t.space\t2\t\n");
            /*sB.append(".text\n");
            sB.append("\tmain:\n");
            sB.append(FMCG.print("_msg0"));
            sB.append(FMCG.print("_msg1"));
            sB.append(FMCG.scan("_a","int"));
            sB.append(FMCG.print("_msg3"));
            sB.append(FMCG.scan("_c","char"));
            sB.append(FMCG.print("_msg4"));
            sB.append(FMCG.scan("_d","double"));
            sB.append(FMCG.print("_msg5"));
            sB.append(FMCG.scan("_e","String"));
            sB.append(FMCG.print("_msg6","_a","int"));
            sB.append(FMCG.print("_msg7","_b","boolean"));
            sB.append(FMCG.print("_msg8","_c","char"));
            sB.append(FMCG.print("_msg9","_d","double"));
            sB.append(FMCG.print("_msg10","_e","String"));
            sB.append(FMCG.exit());
            */try{
                PrintWriter pW = new PrintWriter("./finalMix.s","UTF-8");
                pW.println(sB.toString());
                pW.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
            System.out.println(sB.toString());
        }
        //this.generateCode.printIC();
    }
   

    @Override
    public void printNode() {
        this.symbolNode.toString();
    }
    
@Override
    public void setLine(int line) {
        this.line = line+1;
    }

    @Override
    public int getLine() {
        return this.line;
    }
    
}