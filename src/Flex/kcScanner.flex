package Flex;


import java_cup.runtime.*;

%%

%unicode
%class kcScanner
%cup
%line
%column

%{
  private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
  }
  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }
%}

%eofval{ 
    return symbol(sym.EOF);
%eofval}

%eofval{
System.out.println("Fin del archivo");
return null;
%eofval}
DIGITO = [0-9]
LETRA = [a-zA-Z]
ID = {LETRA}({LETRA}|{DIGITO})*
INT = {DIGITO}+
%%

"(" {return symbol(sym.PARENA);}
")" {return symbol(sym.PARENC);}
"if" {return symbol(sym.IF);}
"=" {return symbol(sym.ASIGN);}
"+" {return symbol(sym.SUMA);}
"*" {return symbol(sym.MULTP);}
"/" {return symbol(sym.DIV);}
{INT} {return symbol(sym.INT, new Integer(Integer.parseInt(yytext())));}
{ID} {return symbol(sym.ID, yytext());}
[\t\r\f]  {}
[\n] {}
" " {}
. {}
