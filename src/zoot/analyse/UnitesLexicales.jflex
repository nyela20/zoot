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
csteB = vrai|faux
idf = [a-zA-Z_][a-zA-Z0-9_]*
finDeLigne = \r|\n
espace = {finDeLigne}  | [ \t\f]
commentaire = [/]{2}.*{finDeLigne}
paro = \( /* parenthèse ouvrante */
parf = \) /* parenthèse fermante */



%%
"//".*                                    { /* DO NOTHING */ }

"variables"            { return symbol(CodesLexicaux.VARIABLES); }

"fonctions"            { return symbol(CodesLexicaux.FONCTIONS); }

"debut"                { return symbol(CodesLexicaux.DEBUT); }

"fin"              	   { return symbol(CodesLexicaux.FIN); }

"retourne"             { return symbol(CodesLexicaux.RETOURNER); }

"ecrire"               { return symbol(CodesLexicaux.ECRIRE); }

"entier"               { return symbol(CodesLexicaux.ENTIER); }

"booleen"              { return symbol(CodesLexicaux.BOOLEEN); }

"="                    { return symbol(CodesLexicaux.EGAL); }

";"                    { return symbol(CodesLexicaux.POINTVIRGULE); }

{paro}                 { return symbol(CodesLexicaux.PARO); } 

{parf}                 { return symbol(CodesLexicaux.PARF); }

{csteE}      	         { return symbol(CodesLexicaux.CSTENTIERE, yytext()); }

{csteB}                { return symbol(CodesLexicaux.CSTBOOLEENNE, yytext()); }

{idf}      	           { return symbol(CodesLexicaux.IDF, yytext()); }

{commentaire}          { }

{espace}               { }

.                      { throw new AnalyseLexicaleException(yyline, yycolumn, yytext()) ; }
