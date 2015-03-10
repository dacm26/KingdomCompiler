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
    System.out.println("Fin del archivo");
    return symbol(sym.EOF);
%eofval}


DIGIT = [0-9]
LETTER = [a-zA-Z]
SDELIMITER = [\"]
CDELIMITER = [\']

ID = (_|{LETTER})(_|{LETTER}|{DIGIT})*
INT = {DIGIT}+
DOUBLE = ({DIGIT}+\.{DIGIT}+)
COMMENT = #(.|[\r\n])*?#
STRINGCONTENT = (\\.|[^\"])*
CHARCONTENT = (\\.|[^\'])*

LINEBREAK = [ \n\t\r\s]
%state KCHAIN
%state KCHAR

%%
<YYINITIAL>{
	"int"                   {return symbol(sym.INTEGER);}
	"bool"                  {return symbol(sym.BOOLEAN);}
	"munny"                 {return symbol(sym.DOUBLE);}
	"char"                  {return symbol(sym.CHAR);}
	"KChain"                {return symbol(sym.STRING);}
	"void"                {return symbol(sym.VOID);}

	"true"                  {return symbol(sym.TRUE);}
	"false"                 {return symbol(sym.FALSE);}

	"for"                   {return symbol(sym.FOR);}
	"while"                 {return symbol(sym.WHILE);}

	"if"                    {return symbol(sym.IF);}
	"elsif"                 {return symbol(sym.ELSIF);}
	"else"                  {return symbol(sym.ELSE);}
	"switch"                {return symbol(sym.SWITCH);}
	"case"                  {return symbol(sym.CASE);}
	"default"               {return symbol(sym.DEFAULT);}
	"ragnarok"              {return symbol(sym.BREAK);}
	"secondChance"          {return symbol(sym.CONTINUE);}

	"KingdomHearts"         {return symbol(sym.MAIN);}
	"Ability"               {return symbol(sym.FUNCTION);}
	"giff"                  {return symbol(sym.RETURN);}

	"print"                 {return symbol(sym.PRINT);}
	"scan"                  {return symbol(sym.SCAN);}

	","                     {return symbol(sym.COMMA);}
        ":"                      {return symbol(sym.COLON);}
	";"                     {return symbol(sym.END);}

	"+"                     {return symbol(sym.ADD);}
	"-"                     {return symbol(sym.MIN);}
	"*"                     {return symbol(sym.MUL);}
	"/"                     {return symbol(sym.DIV);}

	"("                     {return symbol(sym.OPAR);}
	")"                     {return symbol(sym.CPAR);}
	"\{"                    {return symbol(sym.OCBRA);}
	"\}"                    {return symbol(sym.CCBRA);}

	">="                    {return symbol(sym.GREATEREQ);}
	"<="                    {return symbol(sym.LESSEQ);}
	">"                     {return symbol(sym.GREATER);}
	"<"                     {return symbol(sym.LESS);}
	"!="                    {return symbol(sym.NEQU);}
	"=="                    {return symbol(sym.EQU);}

	"!"                     {return symbol(sym.NOT);}
	"||"                    {return symbol(sym.OR);} 
	"&&"                    {return symbol(sym.AND);}

	"="                     {return symbol(sym.ASSIGN);}


        {LINEBREAK}             {}
	{INT} 			{return symbol(sym.INT, new Integer(Integer.parseInt(yytext())));}
	{DOUBLE}                {return symbol(sym.DOUBLEVALUE, new Double(Double.parseDouble(yytext())));}
	{ID} 			{return symbol(sym.ID, yytext());}
	{SDELIMITER}            {yybegin(KCHAIN);}
	{CDELIMITER}            {yybegin(KCHAR);}

	
	{COMMENT}               {}
	.                       { System.err.println("Illegal character <" + yytext() + "> at line: " + (yyline + 1) + " column: " + (yycolumn + 1)); }

}

<KCHAIN> {
    {SDELIMITER}            { yybegin(YYINITIAL);                         }
    {STRINGCONTENT}         { return symbol(sym.STRINGCONTENT, yytext()); }
    .                       { System.err.println("Illegal character <" + yytext() + "> at line: " + (yyline + 1) + " column: " + (yycolumn + 1)); }

}

<KCHAR> {
    {CDELIMITER}            { yybegin(YYINITIAL);                         }
    {CHARCONTENT}           {   if(yytext().length()>1){
                                    System.err.println("A char can't handle that kind of darkness <" + yytext() + "> at line: " + (yyline + 1) + " column: " + (yycolumn + 1));
                                }else{
                                   return symbol(sym.CHARCONTENT, new Character(yytext().charAt(0))); }
                                }
                                
    .                       { System.err.println("Illegal character <" + yytext() + "> at line: " + (yyline + 1) + " column: " + (yycolumn + 1)); }
}