
import student


m1=int(input("enter mark1 : "))
m2=int(input("enter mark2 : "))
m3=int(input("enter mark3 : "))
m4=int(input("enter mark4 : "))
m5=int(input("enter mark5 : "))

tot=student.total(m1,m2,m3,m4,m5)
avg=student.avg(tot)

if avg>90:
    print("O")
elif avg>70:
    print("A")
elif avg>50:
    print("B")
elif avg>40:
    print("C")
elif avg>30:
    print("FAIL")