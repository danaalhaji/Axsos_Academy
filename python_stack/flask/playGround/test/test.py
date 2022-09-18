from flask import Flask, render_template
test = Flask(__name__, template_folder='Templates')
@test.route('/')
def test1():
    return render_template("test.html", phrase="hello",times = 5)
@test.route('/dana')
def name():
    return render_template("test.html", phrase= "dana", times=100)

if __name__==("__main__"):
    test.run(debug=True)