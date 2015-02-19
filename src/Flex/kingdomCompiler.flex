package Flex;


%%

%class Lexer
%unicode
%line
%column
%standalone

name = ((([a-zA-z]+)\s{0,1}){1,4})
salary = ([0-9]+.[0-9]{2})
date = ([0-9]{2}[/][0-9]{2}[/][0-9]{4})
lineBreak = \n | \t | \s | \r

%%

<YYINITIAL> {
    
    {name}	{System.out.println("Nombre: "+yytext());}
    {salary}	{System.out.println("Salario: "+yytext());}
    {date}	{System.out.println("Fecha: "+yytext());}
    {lineBreak} {  }
    .           {  }

}
