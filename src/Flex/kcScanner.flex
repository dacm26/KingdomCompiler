package Flex;


import java_cup.runtime.Symbol;

%%
%cup
%ignorecase
%type java_cup.runtime.Symbol
%class kcScanner
%{
  public Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
  }
  public Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }
%}
%eofval{
System.out.println("Fin del archivo");
return null;
%eofval}
DIGITO = [0-9]
LETRA = [a-zA-Z]
ID = {LETRA}({LETRA}|{DIGITO})*
INT = {DIGITO}+
%%

"(" {return new Symbol(sym.PARENA);}
")" {return new Symbol(sym.PARENC);}
"if" {return new Symbol(sym.IF);}
"=" {return new Symbol(sym.ASIGN);}
"+" {return new Symbol(sym.SUMA);}
"*" {return new Symbol(sym.MULTP);}
"/" {return new Symbol(sym.DIV);}
{INT} {return new Symbol(sym.INT, new Integer(Integer.parseInt(yytext())));}
{ID} {return new Symbol(sym.ID, yytext());}
[\t\r\f]  {}
[\n] {}
" " {}
. {}