from flask import Flask
skill_app= Flask(__name__)

@skill_app.route("/")
def homepage():
    return "home bage from flask"

if __name__=="main":

    skill_app.run(debug=True, port=9000)