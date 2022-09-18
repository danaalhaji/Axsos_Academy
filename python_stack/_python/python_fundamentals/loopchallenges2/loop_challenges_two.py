from asyncio.windows_events import NULL

#find biggie

def biggie_size(listBig):
    bigger = []
    for x in range (0, len(listBig), 1 ):
        if listBig[x]>0:
            bigger.append("big")
        elif listBig[x]< 0:
            bigger.append(listBig[x])
    return bigger
print(biggie_size([-1, 3, 5, -5]))

#count positive 

def count_positives(count_list):
    count=0
    for x in range (0, len(count_list)-1, 1):
        if count_list[x] > 0:
            count+=1
    count_list[len(count_list)-1]=count
    return count_list
print(count_positives([-1,1,1,1]))

#find the sum 

def sum_total(listSum):
    sum=0
    for x in range (0, len(listSum), 1):
        sum+=listSum[x]
    return sum
print(sum_total([1,2,3,4]))

#find average

def average(listAvg):
    sum = 0
    for x in range (0, len(listAvg), 1):
        sum += listAvg[x]
    avg = sum /len(listAvg)
    return avg
print(average([1,2,3,4]))

#find length

# def length(listLength):
#     count =1
#     i=0
#     while(listLength[i]):
#         count+=1
#         print(count)
#         i+=1
#     return count
# print(length([37,2,1,-9]))

def length(list):
    length_of_list = len(list)
    return length_of_list

#find minimum

def minimum(listMin):
    min = 0
    for x in range (0, len(listMin), 1):
        for y in range (0, len(listMin), 1):
            if listMin[x] != listMin[y]:
                if listMin[y] < min:
                    min = listMin[y]
    return min
print(minimum([37,2,1,-9]))

#find maximum

def maximum(listmax):
    max = 0
    if listmax != []:    
        for x in range (0, len(listmax), 1):
            for y in range (0, len(listmax), 1):
                if listmax[x] != listmax[y]:
                    if listmax[y] > max :
                        max = listmax[y]
    else:
        return False
    return max
print(maximum([37,2,1,-9]))

# reverse list 

def reverse_list(list):
    revList = list[::-1]
    return revList

#Ultimate Analysis
def ultimateAnalysis(list):
    sum = sum_total(list)
    print("the sum of the list is" ,sum)
    avg = average(list)
    min = minimum(list)
    max = maximum(list)
    lengthList =  length(list)
    ultimateAnalysisDisc = [
        {'the sumation': sum},
        {'the average': avg},
        {'the maximum in the list is': max},
        {'the minimum is the list is ':min},
        {'the length of the list': lengthList}
    ]
    return ultimateAnalysisDisc
print(ultimateAnalysis([1,2,3]))
print(reverse_list([1,2,3]))
############ trying to build a length function from scratch###############
def length2(list):
    count = 0
    count2 =0 
    i=0
    while(i>-1):
        try:
            t=list[i]
            count+=1
            i+=1
        except IndexError:
            print('no element at index '+str(i))
            break
    for elem in list:
        count2+=1
    return count2, count

print(length2([1,2,3]))





