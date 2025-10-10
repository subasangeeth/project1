

def doubleList(list1,list2):
    for i in list1:
        list2.append(i*2)
    return list2

def sum(list2):
    sum = 0
    for i in list2:
        sum=i+sum
    return sum



list1=[1,2,3,4,5,6,7,8,9]
list2=[]

list2 =doubleList(list1,list2)
sum=sum(list2)
print(sum)
