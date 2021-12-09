grammar AntlrArithmetic;

compileUnit
    :   expr EOF
    ;

expr
    :   '(' expr ')'                                       # parensExpr
    |   op=(ADDITION|SUBTRACTION) expr                     # unaryExpr
    |   left=expr op=(MULTIPLICATION|DIVISION) right=expr  # infixExpr
    |   left=expr op=(ADDITION|SUBTRACTION) right=expr     # infixExpr
    |   IDENTIFIER                                         # identifierExpression
    |   value=NUMBER                                       # numberExpr
    ;

IDENTIFIER
    :    ([a-zA-Z]) ([a-zA-Z] | [0-9])*
    ;

NUMBER
  :  [0-9]+
     {
       try {
           short numberValue = Short.parseShort(getText());
       } catch (NumberFormatException ex) {
           throw new NumberFormatException("Supports only positive number with size not more than 16 bit");
       }
     }
  ;
ADDITION : '+';
SUBTRACTION : '-';
MULTIPLICATION : '*';
DIVISION : '/';

WS : [ \t\n\r\f]+ -> skip;