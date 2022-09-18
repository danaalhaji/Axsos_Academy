from flask import Flask, render_template
tst = Flask(__name__)
@tst.run('/')
def Home():
    # return render_template("index.html")
    return "Hello!"

if __name__=="__main__":
    tst.run(debug=True)
