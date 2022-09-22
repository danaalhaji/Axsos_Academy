from multiprocessing import context
from django.shortcuts import render,HttpResponse, HttpResponseRedirect, redirect
import random

def root(request):
    if 'randomNum' not in request.session:
        request.session['randomNum'] = random.randint(0,100)
        print(request.session['randomNum'])
        request.session['status']=''
    return render(request ,"gameNum.html")
def answerGuess(request):
    request.session['status']='Result'
    if request.session['randomNum']  == int(request.POST['numberGuess']):
        request.session['status']='You Win!!!'
    elif request.session['randomNum']  > int(request.POST['numberGuess']):
        request.session['status']='Too Low'
    else:
        request.session['status']='Too High'
    return redirect('/')