from django.shortcuts import render,HttpResponse, HttpResponseRedirect, redirect
from datetime import date, datetime
import random 
def root(request):
    request.session.set_expiry(3600)
    if 'totalGold' not in request.session:
        request.session['totalGold']="0"
    return render(request,"index.html")
def firstGold(request):
    if request.method == 'POST':
        if 'Find1Gold' in request.POST:
            request.session['firstButton']= random.randint(10,20)
            request.session['totalGold'] = int(request.session['totalGold'])+int(request.session['firstButton'])
            request.session['time']=f"You've earned, {request.session['firstButton']}"
            return redirect("/")
            # check the second button raise 10-20
        elif 'Find2Gold' in request.POST:
            request.session['second']= random.randint(10,20)
            request.session['totalGold'] = int(request.session['totalGold'])+int(request.session['second'])
            request.session['time']=f"You've earned, {request.session['second']}"
            return redirect("/")
            # check the third button raise 10-20
        elif 'Find3Gold' in request.POST:
            request.session['third']= random.randint(10,20)
            request.session['totalGold'] = int(request.session['totalGold'])+int(request.session['third'])
            request.session['time']=f"You've earned, {request.session['third']}"
            return redirect("/")
            # check the 4th button raise or decrease -50-50
        elif 'Find4Gold' in request.POST:
            request.session['forth']= random.randint(-50,50)
            request.session['totalGold'] = int(request.session['totalGold'])+int(request.session['forth'])
            if request.session['forth'] >0:
                request.session['time']=f"You've earned, {request.session['forth']}"
            else:
                request.session['time']=f"You've LOST, {request.session['forth']}"
            return redirect("/")


# Create your views here.
