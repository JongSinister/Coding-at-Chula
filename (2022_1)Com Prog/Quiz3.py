l1 = [9,9,9,9,9,9,9];l2 = [9,9,9,9]
s1 = "";s2 = ""
for i in l1[::-1] :
    s1+=str(i)
for i in l2[::-1] :
    s2+=str(i)
x = int(s1)+int(s2)
v = []
for i in str(x)[::-1] :
    v.append(i)
print(v)
