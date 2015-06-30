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

    public ATD_ASTTreeDeclaration(mainFunctionDeclaration mFD, Generate generateCode) {
        this.mFD = mFD;
        this.symbolNode= new Node();
        //this.generateCode = new Generate();       
        this.generateSymbolNode();
        this.generateCode = generateCode;
        this.mFD.generateIC();
        this.generateCode.printIC();
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
            sB.append(".text\n");
            sB.append("\tmain:\n");
            sB.append(FMCG.assign("_int0", "_x", "int"));
            sB.append(FMCG.print("_msg0","_x", "int"));
            sB.append(FMCG.assign("_char0", "_a", "char"));
            sB.append(FMCG.print("_msg1","_a", "char"));
            sB.append(FMCG.assign("_bool0", "_b", "boolean"));
            sB.append(FMCG.print("_msg2","_b", "boolean"));
            sB.append(FMCG.assign("_double0", "_c", "double"));
            sB.append(FMCG.print("_msg3","_c", "double"));
            sB.append(FMCG.assign("_msg4", "_d", "String"));
            sB.append(FMCG.print("_msg5","_d", "String"));
            sB.append(FMCG.exit());
            try{
                PrintWriter pW = new PrintWriter("./finalMix.s","UTF-8");
                pW.println(sB.toString());
                pW.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
            //System.out.println(sB.toString());
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
