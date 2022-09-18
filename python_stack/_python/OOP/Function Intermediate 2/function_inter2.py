x = [ [5,2,3], [10,8,9]] 
students = [
    {'first_name':  'Michael', 'last_name' : 'Jordan'},
    {'first_name' : 'John', 'last_name' : 'Rosales'}
]
sports_directory = {
    'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
    'soccer' : ['Messi', 'Ronaldo', 'Rooney']
}
z = [ {'x': 10, 'y': 20} ]

########### change the last name for the first object
students[0]['last_name'] = 'Bryant'

########## change messi into Andress

sports_directory['soccer'][0] = 'Andress'
print(sports_directory['soccer'][0])

########## change y to 20
z[0]['y'] =30
print(z)

##########
#2
students2 = [
        {'first_name':  'Michael', 'last_name' : 'Jordan'},
        {'first_name' : 'John', 'last_name' : 'Rosales'},
        {'first_name' : 'Mark', 'last_name' : 'Guillen'},
        {'first_name' : 'KB', 'last_name' : 'Tonel'}
    ]
def iterateDictionary(students):
    for i in range (0, len(students), 1):
        print( *students[i], *students[i]['first_name'], *students[i]['last_name'], sep= "")
iterateDictionary(students2)

###### 3 ######

def iterateDictionary2(i,students):
    for x in range (0, len(students), 1):
        print("this is the first name")
        print(*students[x][i], sep= "")
iterateDictionary2('first_name',students2)
iterateDictionary2('last_name', students2)

###### 4 ##########
dojo = {
    'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
    'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
}
"""define the function""" 
def printInfo(dict):
    print(len(dojo['locations']), "LOCATIONS")
    for location in dojo['locations']:
        print(location)
    print(len(dojo['instructors']), "INSTRUCTORS")
    for instructor in dojo['instructors']:
        print(instructor)

printInfo(dojo)