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
                sB.append("\t\tlw $t0, ").append(arg1).append("\n");
                sB.append("\t\tsw $t0, ").append(result).append("\n");
                break;
            case "char":
                sB.append("\t\tlb $t0, ").append(arg1).append("\n");
                sB.append("\t\tsb $t0, ").append(result).append("\n");
                break;
            case "double":
                sB.append("\t\tl.d $f0, ").append(arg1).append("\n");
                sB.append("\t\ts.d $f0, ").append(result).append("\n");
                break;
            case "boolean":
                sB.append("\t\tlb $t0, ").append(arg1).append("\n");
                sB.append("\t\tsb $t0, ").append(result).append("\n");
                break;
            case "String":
                sB.append("\t\tla $a0, ").append(arg1).append("\n");
                sB.append("\t\tla $a1, ").append(result).append("\n");
                sB.append("\t\tjal _string_copy\n");
                break;
            default:
                sB.append("Error assign");
                break;
        }
        return sB.toString();

    }

    public String booleanOperation(String operation, String arg1, String arg2, String result, String type) {
        StringBuilder sB = new StringBuilder();
        sB.append("\t\tlb $t0, ").append(arg1).append("\n");
        sB.append("\t\tlb $t1, ").append(arg1).append("\n");
        switch (operation) {
            case "&&":
                sB.append("\t\tand $t2, $t0, $t1\n");
                sB.append("\t\tsb $t2, ").append(result).append("\n");
                break;
            case "||":
                sB.append("\t\tor $t2, $t0, $t1\n");
                sB.append("\t\tsb $t2, ").append(result).append("\n");
                break;
            case "==":
                sB.append("\t\tmove $a0, $t0\n");
                sB.append("\t\tmove $a1, $t1\n");
                sB.append("\t\tjal _equals\n");
                sB.append("\t\tsb $v0, ").append(result).append("\n");
                break;
            case "!=":
                sB.append("\t\tmove $a0, $t0\n");
                sB.append("\t\tmove $a1, $t1\n");
                sB.append("\t\tjal _notEquals\n");
                sB.append("\t\tsb $v0, ").append(result).append("\n");
                break;
            case ">":
                sB.append("\t\tmove $a0, $t0\n");
                sB.append("\t\tmove $a1, $t1\n");
                sB.append("\t\tjal _greater\n");
                sB.append("\t\tsb $v0, ").append(result).append("\n");
                break;
            case ">=":
                sB.append("\t\tmove $a0, $t0\n");
                sB.append("\t\tmove $a1, $t1\n");
                sB.append("\t\tjal _greaterEquals\n");
                sB.append("\t\tsb $v0, ").append(result).append("\n");
                break;
            case "<":
                sB.append("\t\tmove $a0, $t0\n");
                sB.append("\t\tmove $a1, $t1\n");
                sB.append("\t\tjal _less\n");
                sB.append("\t\tsb $v0, ").append(result).append("\n");
                break;
            case "<=":
                sB.append("\t\tmove $a0, $t0\n");
                sB.append("\t\tmove $a1, $t1\n");
                sB.append("\t\tjal _lessEquals\n");
                sB.append("\t\tsb $v0, ").append(result).append("\n");
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
            sB.append("\t\tlw $t0, ").append(arg1).append("\n");
            sB.append("\t\tlw $t1, ").append(arg2).append("\n");
            switch (operation) {
                case "+":
                    sB.append("\t\tadd $t2, $t0, $t1\n");
                    break;
                case "-":
                    sB.append("\t\tsub $t2, $t0, $t1\n");
                    break;
                case "*":
                    sB.append("\t\tmul $t2, $t0, $t1\n");
                    break;
                case "/":
                    sB.append("\t\tdiv $t0, $t1\n");
                    sB.append("\t\tmflo $t2\n");
                    
                    break;
                default:
                    sB.append("Error aritemetico");
                    break;
            }
            sB.append("\t\tsw $t2, ").append(result).append("\n");
        } else {
            sB.append("\t\tl.d $f0, ").append(arg1).append("\n");
            sB.append("\t\tl.d $f2, ").append(arg2).append("\n");
            switch (operation) {
                case "+":
                    sB.append("\t\tadd.d $f4, $f0, $f2\n");
                    break;
                case "-":
                    sB.append("\t\tsub.d $f4, $f0, $f2\n");
                    break;
                case "*":
                    sB.append("\t\tmul.d $f4, $f0, $f2\n");
                    break;
                case "/":
                    sB.append("\t\tdiv.d $f4, $f0, $f2\n");
                    break;
                default:
                    sB.append("Error aritemetico");
                    break;
            }
            sB.append("\t\ts.d $f4, ").append(result).append("\n");
        }
        
        return sB.toString();
    }

    public String exit() {
        StringBuilder sB = new StringBuilder();
        sB.append("\t\tli $v0, 10\n\t\tsyscall\n\n");
        sB.append("\t_greater:\n" +
"		\t\tbgt $a0, $a1, _true\n" +
"		\t\tli $v0, 0\n" +
"		\t\tjr $ra\n" +
"	\t_greaterEquals:\n" +
"		\t\tbge $a0, $a1, _true\n" +
"		\t\tli $v0, 0\n" +
"		\t\tjr $ra\n" +
"	\t_less:\n" +
"		\t\tblt $a0, $a1, _true\n" +
"		\t\tli $v0, 0\n" +
"		\t\tjr $ra\n" +
"	\t_lessEquals:\n" +
"		\t\tble $a0, $a1, _true\n" +
"		\t\tli $v0, 0\n" +
"		\t\tjr $ra		\n" +
"	\t_notEquals:\n" +
"		\t\tbne $a0, $a1, _true\n" +
"		\t\tli $v0, 0\n" +
"		\t\tjr $ra \n" +
"	\t_equals:\n" +
"		\t\tbeq $a0, $a1, _true\n" +
"		\t\tli $v0, 0\n" +
"		\t\tjr $ra \n" +
"	\t_true:\n" +
"		\t\tli $v0, 1\n" +
"		\t\tjr $ra\n\n");
        
        sB.append("\t_string_copy:\n"
                + "\t\tlb $s0, ($a0)\n"
                + "\t\tbeqz $s0, _string_copy_end\n"
                + "\t\tb _string_copy_char\n"
                + "\n"
                + "\t\t_string_copy_char:\n"
                + "\t\tsb $s0, ($a1)\n"
                + "\t\taddi $a0, $a0, 1\n"
                + "\t\taddi $a1, $a1, 1\n"
                + "\t\tb _string_copy\n"
                + "\n"
                + "\t_string_copy_end:\n"
                + "\t\tsb $zero, ($a1)\n"
                + "\t\tjr $ra");

        return sB.toString();
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

    public String print(String id, String type) {
        StringBuilder sB = new StringBuilder();
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
