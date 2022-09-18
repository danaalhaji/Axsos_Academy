def leap_year(year):
    if (year %10 != 0 and year %4 == 0  ):
        print("The year",year,"is a leap year")
        return True
    elif(year %400 == 0):
        print("The year",year,"is a leap year")
        return True
    else:
        print("The year",year,"is not a leap year")
        return False
leap_year(1800)
leap_year(1600)
leap_year(7600)

def count_substring(string , sub_string):
    x = string.rsplit(sub_string)
    return len(x)-1

print(count_substring("ABSHIZLMSHIZ, HIZ", "HIZ"))
# count_substring("ABSdaklfnaij", "dana")