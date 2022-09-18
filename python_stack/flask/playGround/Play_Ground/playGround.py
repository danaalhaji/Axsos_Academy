from flask import Flask, render_template
app = Flask(__name__, template_folder='templates')

@app.route("/")
def hello():
    return render_template("index.html",times=1, divColor= 'deeppink')

@app.route("/play/<number>")
def div(number):
    repeat = int(number)
    return render_template("index.html", times = repeat ,divColor= 'deeppink')

@app.route("/play/<number>/<color>")
def divColorAndNum(number,color):
    repeat = int(number)
    divColor = color
    return render_template("index.html", times = repeat, colorOfDiv =divColor )

if __name__ == "__main__":
    app.run()
