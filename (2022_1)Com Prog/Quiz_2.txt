#1====================================================================================================
data = input().split()
s1 = 'AEILNORSTU'
s2 = 'DG'
s3 = 'BCMP'
s4 = 'FHVWY'
s5 = 'K'
s8 = 'JX'
s10 = 'QZ'
k = []
for word in data :
    score = 0
    for i in word :
        if i in s1 :
            score += 1
        elif i in s2 :
            score += 2
        elif i in s3 :
            score += 3
        elif i in s4 :
            score += 4
        elif i in s5 :
            score += 5
        elif i in s8 :
            score += 8
        elif i in s10 :
            score += 10
    k.append([-score,word])
for i in sorted(k) :
    print(i[1],str(-i[0]))

#2====================================================================================================
def match(word, pattern, include_chars, exclude_chars):
    #con1----------------------------------------------
    if len(word) != len(pattern) :
        return False
    #con2----------------------------------------------
    for i in range(len(word)) :
        if word[i] != pattern[i] and pattern[i] != '?' :
            return False
    #con3----------------------------------------------
    for i in range(len(pattern)) :
        if pattern[i] == '?' :
            if word[i] in exclude_chars :
                return False
    #con4----------------------------------------------
    for i in range(len(include_chars)) :
        if include_chars[i] not in word :
            return False
    lw = {}
    check = {}
    for i in word :
        if i not in lw :
            lw[i] = 1
        else :
            lw[i] += 1
    for i in pattern :
        if i != '?' :
            if i not in check :
                check[i] = 1
            else :
                check[i] += 1
    for i in include_chars  :
        if i not in check :
            check[i] = 1
        else :
            check[i] += 1            
    for i in check :
        if check[i] > lw[i] :
            return False
    return True
exec(input())

#3====================================================================================================
data1 = input()
data2 = input()

d1 = open(data1,'r')
d2 = open(data2,'r')

color = []
ans = ''
for line in d1 :
    line = line.strip()
    if line != '' :
        cl = [e.upper() for e in line.split()]
        color = color + cl
for L in d2 :
    l = L.upper()
    for c in color :
        start = 0
        while True :
            if l.find(c,start) == -1 :
                break
            else :
                start = l.find(c,start)
                l = l[:start] + ('<'+c.lower()+'>') + l[start:start+len(c)] + '</>' + l[start+len(c):]
                L = L[:start] + ('<'+c.lower()+'>') + L[start:start+len(c)] + '</>' + L[start+len(c):]
                start+=5+2*len(c)
    ans += L
print(ans)