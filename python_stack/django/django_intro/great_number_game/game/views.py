from multiprocessing import context
from django.shortcuts import render,HttpResponse, HttpResponseRedirect, redirect
import random

def root(request):
    if 'randomNum' not in request.session:
        request.session['randomNum'] = random.randint(0,100)
        request.session['status']=''
    return render(request ,"gameNum.html")
def answerGuess(request):
    if request.session['randomNum']  == int(request.POST['numberGuess']):
        request.session['status']='true'
    else:
        request.session['status']='false'
    return redirect('/')

