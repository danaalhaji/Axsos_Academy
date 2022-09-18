from tkinter.tix import INTEGER
from flask import Flask
routing_understanding = Flask(__name__)

@routing_understanding.route("/")
def hello():
    return "Hello World!"

@routing_understanding.route("/dojo")
def dojo():
    return "Dojo!"

@routing_understanding.route("/say/<name>")
def hi(name):
    return "Hi!"+name

@routing_understanding.route("/repeat/<intN>/<name>")
def repeat(intN,name):
    repeatInt= int(intN)*f"{name}"
    return repeatInt

@routing_understanding.route("/<IntSecNum>")
def secondInt(IntSecNum):
    try:
        int(IntSecNum[1])
        return "Second element is integer"
    except ValueError:
        return "False"

@routing_understanding.route("/<name>")
def TryAgain(name):
    if (name != "dojo" and name != "say" and name != "repeat" and name!= "num" ):
        return "Try Again"

if __name__ == "__main__":
    routing_understanding.run()