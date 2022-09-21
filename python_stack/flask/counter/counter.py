from flask import Flask , render_template, redirect,session, request
app = Flask (__name__, template_folder='template')
app.secret_key = 'counterCount'

@app.route('/')
def mainPage():
    if 'times' not in session:
        session['times'] = 0
    else:
        session['times'] +=1 
    return render_template("counter.html")

@app.route('/counter' ,methods=['POST'])
def countPage():
    if  request.form['reset'] == 'resetR':
        session['times'] = 0
    if request.form['add2V'] == 'Add2':
        session['times'] +=1
    return redirect('/')

if __name__ == "__main__":
    app.run(debug=True)