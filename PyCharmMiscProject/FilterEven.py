def filterEven(list1):
    for i in list1:
        if i%2==0:
            list2.append(i)
    return list2



list1=[]
list2=[]
size=int(input("Enter The Size Of List"))

print("Enter ",size," Elements:")
for i in range(size):
    j=int(input())
    list1.append(j)

print(list1)
print("The filtered list is:")
filterEven(list1)
print(list2)