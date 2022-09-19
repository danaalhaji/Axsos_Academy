from flask import Flask , render_template, redirect, request
app = Flask (__name__, template_folder='template')

@app.route('/')
def homePage():
    return render_template("dojo_survey.html")

@app.route('/users', methods=['POST'])
def usersSubm():
    users_name=request.form['nameText']
    users_City=request.form['City']
    users_language= request.form['FavoritLanguage']
    users_comment= request.form['comment']
    return render_template("dojo_survey2.html", name = users_name, city = users_City, lang = users_language , comments=users_comment)

if __name__ == "__main__":
    app.run(debug=True)