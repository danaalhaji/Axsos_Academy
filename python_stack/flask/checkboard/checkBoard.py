from flask import Flask, render_template
app = Flask(__name__)
@app.route("/")
def eightByEight():
    return render_template("checkboard.html",firstRetp = 4 ,secondRep =4, first_color = 'red', second_color='black')
@app.route("/4")
def fourByFour():
    return render_template("checkboard.html",firstRetp = 2 ,secondRep =2, first_color = 'red', second_color='black')
@app.route("/<x>")
def customCheckboardRow(x):
    first=int(x)
    return render_template("checkboard.html",firstRetp = first ,secondRep =1 , first_color = 'red', second_color='black')
@app.route("/<x>/<y>")
def customCheckboardWithColor(x,y):
    first=int(int(x)/4)
    second=int(int(y)/4)
    return render_template("checkboard.html",firstRetp = first,secondRep =second, first_color = 'red', second_color='black')
@app.route("/<x>/<y>/<color1>/<color2>")
def customCheckboard(x,y,color1,color2):
    first=int(int(x)/4)
    second=int(int(y)/4)
    return render_template("checkboard.html",firstRetp = first, secondRep = second, first_color = color1, second_color = color2)  
if __name__=="__main__":
    app.run(debug=True)
