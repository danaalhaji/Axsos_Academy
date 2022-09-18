from flask import Flask, render_template
app = Flask(__name__, template_folder='templates')

@app.route("/")
def hello():
    return render_template("index.html",times=1)

@app.route("/play/<number>")
def div(number):
    repeat = int(number)
    return render_template("index.html", times = repeat)

if __name__ == "__main__":
    app.run()
