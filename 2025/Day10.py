from pulp import PULP_CBC_CMD, LpProblem, lpSum, LpVariable, LpMinimize
import re

def parse_line(line):
    required = re.search(r'\[(.*?)\]', line).group(1)

    buttons = [
        tuple(map(int, m.split(',')))
        for m in re.findall(r'\((.*?)\)', line)
    ]

    set_part = re.search(r'\{(.*?)\}', line).group(1)
    values_set = list(map(int, set_part.split(',')))

    return required, buttons, values_set

results = []
answer = 0
with open("input.txt") as f:
    for line in f:
        line = line.strip()
        if not line:
            continue
        parsed = parse_line(line)
        pattern = parsed[0]
        buttons = parsed[1]
        joltage = parsed[2]

        coef = [[] for _ in range(len(joltage))]

        for i in range(0, len(joltage)):
            # create equation
            coef[i] = [0 for _ in range(len(buttons))]
            for k in range(0, len(buttons)):
                if i in buttons[k]:
                    coef[i][k] = coef[i][k] + 1

        prob = LpProblem("My_ILP_Problem", LpMinimize)

        xs = []

        # variables
        for i in range(0, len(buttons)):
           xs.append(LpVariable(f"x{i}", lowBound=0, cat='Integer'))

        for i in range(0, len(coef)):
            prob += lpSum([coef[i][k] * xs[k] for k in range(len(coef[i]))]) == joltage[i], f"Constraint_Sum_{i}"

        prob += lpSum(xs[k] for k in range(len(xs)))

        status = prob.solve(PULP_CBC_CMD(msg=False))

        ret = 0
        for i in range(0, len(buttons)):
            ret += xs[i].value()

        answer = answer + ret
print(answer)
