#Quiz_3_1
n = int(input())
all = {}
for i in range(n) :
    team,con = input().split()
    if con not in all :
        all[con] = {team}
    else :
        all[con].add(team)
while True :
    x = input().split()
    if x == ['q'] :
        break
    group = []
    for team in x :
        check = False
        for contry in all :
            if team in all[contry] :
                if contry in group :
                    break
                else :
                    group.append(contry)
                    check = True
        if check == False :
            break
    if check == False :
        print('Not OK')
    else :
        print('OK')
    group = []
#Quiz_3_2
n,m,k = [int(e) for e in input().split()]
all = {}
guest = {}
all_fac = set()
for i in range(n) :
    stu,fac = input().split()
    all[stu] = fac
    all_fac.add(fac)
for i in range(m) :
    x = input().split()
    guest[x[0]] = x[1:]
for i in range(k) :
    x = input().split()
    ans = all_fac
    for j in x :
        f = set()
        for k in guest[j] :
            f.add(all[k])
        ans = ans.intersection(f)
    if len(ans) != 0 :
        print(' '.join(sorted(ans)))
    else :
        print(None)
#Quiz_3_3
a = []
e = {}
while True :
    g1 = 0 ; g2 = 0
    x = input()
    if x == 'End' :
        break
    x = x.split()
    if x[0] == 'Ally' :
        a.append(set(x[1:]))
    elif x[0] == 'Enemy' :
        for i in a :
            if x[1] in i :
                g1 = i
            if x[2] in i :
                g2 = i
        if g1 == 0 :
            g1 = {x[1]}
            a.append(g1)
        if g2 == 0 :
            g2 = {x[2]}
            a.append(g2)
        for i in g1 :
            if i not in e :
                e[i] = g2
            else :
                for j in g2 :
                    r = e[i].union({j})
                    e[i] = r
        for i in g2 :
            if i not in e :
                e[i] = g1
            else :
                for j in g1 :
                    r = e[i].union({j})
                    e[i] = r
    if x[0] == 'Table' :
        x = x[1:]
        for i in range(len(x)) :
            check = True
            if x[i] in e :
                if x[i-1] in e[x[i]] :
                    check = False
                    break
        if check == True :
            print('Okay')
        else :
            print('No')