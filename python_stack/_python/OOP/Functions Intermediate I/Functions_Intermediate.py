
import random
def randInt(min,max):
        if (max < min and max < 0):
                print("invalid numbers")
        else:
                num = random.random()*(min+(max-min))
        return num

print(randInt(0,1)) 		    # should print a random integer between 0 to 1
print(randInt(min=0,max=50)) 	    # should print a random integer between 0 to 50 random.random() * 50
print(randInt(min=50,max=100)) 	    # should print a random integer between 50 to 100
print(randInt(min=50, max=500))     # should print a random integer between 50 and 500