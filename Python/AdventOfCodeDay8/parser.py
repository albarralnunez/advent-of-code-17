import ply.lex as lex
import ply.yacc as yacc
import operator as op


reserved = {
   'if': 'IF',
   'inc': 'INC',
   'dec': 'DEC',
}


tokens = [
        'REGISTER',
        'NE', 'EQ', 'LE', 'GE', 'LT', 'GT',
        'NUMBER',
    ] + list(reserved.values())


# Tokens

def t_REGISTER(t):
    r'[a-zA-Z_][a-zA-Z0-9_]*'
    t.type = reserved.get(t.value, t.type)
    return t


def t_NUMBER(t):
    r'-?\d+'
    t.value = int(t.value)
    return t


def t_EQ(t):
    r'=='
    t.value = op.eq
    return t


def t_NE(t):
    r'!='
    t.value = op.ne
    return t


def t_LE(t):
    r'<='
    t.value = op.le
    return t


def t_GE(t):
    r'>='
    t.value = op.ge
    return t


def t_LT(t):
    r'<'
    t.value = op.lt
    return t


def t_GT(t):
    r'>'
    t.value = op.gt
    return t


# Ignored characters
t_ignore_WS = r'\s+'


def t_newline(t):
    r'\n+'
    t.lexer.lineno += t.value.count("\n")


def t_error(t):
    print("Illegal character '%s'" % t.value[0])
    t.lexer.skip(1)


# Build the lexer
lexer = lex.lex()


# dictionary of registers
registers = {}
max_value = 0


def p_instruction_list(p):
    '''
    instruction_list : instruction
                     | instruction_list instruction
    '''
    pass


def p_instruction(p):
    '''
    instruction : REGISTER operations NUMBER condition
    '''
    global max_value
    if not p[4]:
        return
    if not p[1] in registers:
        registers[p[1]] = 0
    if p[2] == 'inc':
        registers[p[1]] += p[3]
    if p[2] == 'dec':
        registers[p[1]] -= p[3]
    if max_value < registers[p[1]]:
        max_value = registers[p[1]]


def p_operations(p):
    '''
    operations : INC
               | DEC
    '''
    p[0] = p[1]


def p_condition(p):
    '''
    condition : IF REGISTER comparators NUMBER
    '''
    register_value = registers.get(p[2], 0)
    p[0] = p[3](register_value, p[4])


def p_comparators(p):
    '''
    comparators : LE
                | GE
                | LT
                | GT
                | EQ
                | NE
    '''
    p[0] = p[1]


def p_error(p):
    print("LINE %s: Syntax error at '%s'" % (p.lineno, p.value))


parser = yacc.yacc()


program_path = '../../inputs/day8.txt'
# program_path = 'test.rgi'
with open(program_path) as f:
    program = f.read()
    parser.parse(program)
    print("## PROBLEM 1 ##")
    print(max(registers.items(), key=lambda x: x[1]))
    print("## PROBLEM 2 ##")
    print(max_value)
