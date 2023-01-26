package zoot.analyse ;

import java_cup.runtime.*;
import zoot.exceptions.AnalyseLexicaleException;
      
%%
   
%class AnalyseurLexical
%public

%line
%column
    
%type Symbol
%eofval{
        return symbol(CodesLexicaux.EOF) ;
%eofval}

%cup

%{

  private StringBuilder chaine ;

  private Symbol symbol(int type) {
	return new Symbol(type, yyline, yycolumn) ;
  }

  private Symbol symbol(int type, Object value) {
	return new Symbol(type, yyline, yycolumn, value) ;
  }
%}

csteE = [0-9]+
csteB = "vrai",* | "faux",*
finDeLigne = \r|\n
espace = {finDeLigne}  | [ \t\f]
idf = [a-zA-Z_,][a-zA-Z0-9_,]*

%%
"//".*                                    { /* DO NOTHING */ }

"debut"                { return symbol(CodesLexicaux.DEBUT); }
"fin"              	   { return symbol(CodesLexicaux.FIN); }

"ecrire"               { return symbol(CodesLexicaux.ECRIRE); }

";"                    { return symbol(CodesLexicaux.POINTVIRGULE); }

{csteE}      	       { return symbol(CodesLexicaux.CSTENTIERE, yytext()); }
{csteB}                { return symbol(CodesLexicaux.CSTBOOLEENNE, yytext()); }

{espace}               { }

.                      { throw new AnalyseLexicaleException(yyline, yycolumn, yytext()) ; }

"booleen"              { return symbol(CodesLexicaux.BOOLEEN);}
"entier"               { return symbol(CodesLexicaux.ENTIER);}

{idf}                  { return symbol(CodesLexicaux.IDF, yytext());}

"variables"            { return symbol(CodesLexicaux.VARIABLES);}

"="                    { return symbol(CodesLexicaux.EGAL); }

