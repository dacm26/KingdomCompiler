/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.finalMixCode;

/**
 *
 * @author C5220701
 */
public class FinalMixCodeGenerator {

    public FinalMixCodeGenerator() {
    }

    public String assign(String arg1, String result, String type) {
        StringBuilder sB = new StringBuilder();
        switch (type) {
            case "int":
                break;
            case "char":
                break;
            case "double":
                break;
            case "boolean":
                break;
            case "String":
                break;
            default:
                sB.append("Error assign");
                break;
        }
        return sB.toString();

    }

    public String booleanOperation(String operation, String arg1, String arg2, String result, String type) {
        StringBuilder sB = new StringBuilder();
        switch (operation) {
            case "&&":
                break;
            case "||":
                break;
            case "!":
                break;
            default:
                sB.append("Error op booleana");
                break;
        }
        return sB.toString();
    }

    public String arithmeticOperation(String operation, String arg1, String arg2, String result, String type) {
        StringBuilder sB = new StringBuilder();
        if (type.equals("int")) {
            switch (operation) {
                case "+":
                    break;
                case "-":
                    break;
                case "*":
                    break;
                case "/":
                    break;
                default:
                    sB.append("Error aritemetico");
                    break;
            }

        } else {
            switch (operation) {
                case "+":
                    break;
                case "-":
                    break;
                case "*":
                    break;
                case "/":
                    break;
                default:
                    sB.append("Error aritemetico");
                    break;
            }
        }
        return sB.toString();
    }

    public String exit() {
        return "\t\tli $v0, 10\n\t\tsyscall";
    }

    public String scan(String id, String type) {
        StringBuilder sB = new StringBuilder();
        switch (type) {
            case "int":
                sB.append("\t\tli $v0, 5\n");
                sB.append("\t\tsyscall\n");
                sB.append("\t\tsw $v0, ").append(id).append("\n");
                break;
            case "char":
                sB.append("\t\tli $v0, 8\n");
                sB.append("\t\tla $a0, ").append("_charBuffer").append("\n");
                sB.append("\t\tla $a1, 2\n");
                sB.append("\t\tsyscall\n");
                sB.append("\t\tlb $s0,($a0)\n");
                sB.append("\t\tsb $s0, ").append(id).append("\n");
                break;
            case "double":
                sB.append("\t\tli $v0, 7\n");
                sB.append("\t\tsyscall\n");
                sB.append("\t\ts.d $f0, ").append(id).append("\n");
                break;
            case "boolean":
                break;
            case "String":
                sB.append("\t\tli $v0, 8\n");
                sB.append("\t\tla $a0, ").append(id).append("\n");
                sB.append("\t\tla $a1, 255\n");
                sB.append("\t\tsyscall\n");
                break;
            default:
                sB.append("Error scan");
                break;
        }
        return sB.toString();
    }

    public String print(String msg) {
        return this.printType(msg, "String");
    }

    public String print(String msg, String id, String type) {
        StringBuilder sB = new StringBuilder();
        sB.append(this.printType(msg, "String"));
        sB.append(this.printType(id, type));
        return sB.toString();
    }

    private String printType(String id, String type) {
        StringBuilder sB = new StringBuilder();
        switch (type) {
            case "int":
                sB.append("\t\tli $v0, 1\n");
                sB.append("\t\tlw $a0, ").append(id).append("\n");
                sB.append("\t\tsyscall\n");
                break;
            case "char":
                sB.append("\t\tli $v0, 4\n");
                sB.append("\t\tla $a0, ").append(id).append("\n");
                sB.append("\t\tsyscall\n");
                break;
            case "double":
                sB.append("\t\tli $v0, 3\n");
                sB.append("\t\tl.d $f12, ").append(id).append("\n");
                sB.append("\t\tsyscall\n");
                break;
            case "boolean":
                sB.append("\t\tli $v0, 1\n");
                sB.append("\t\tlb $a0, ").append(id).append("\n");
                sB.append("\t\tsyscall\n");
                break;
            case "String":
                sB.append("\t\tli $v0, 4\n");
                sB.append("\t\tla $a0, ").append(id).append("\n");
                sB.append("\t\tsyscall\n");
                break;
            default:
                sB.append("Error print");
                break;
        }
        return sB.toString();
    }

}
