from django.shortcuts import render,HttpResponse, HttpResponseRedirect, redirect
from time import gmtime, strftime, time
import random 
def root(request):
    request.session.set_expiry(3600)
    if 'totalGold' and 'activity' not in request.session:
        request.session['totalGold']="0"
        request.session['activity'] =[]
    return render(request,"index.html")
    '''Collecting gold method'''
def firstGold(request):
    time =strftime(" %d-%b-%Y %H:%M %p", gmtime())
    if request.method == 'POST':
        if 'Find1Gold' in request.POST:
            request.session['firstButton']= random.randint(10,20)
            request.session['totalGold'] = int(request.session['totalGold'])+int(request.session['firstButton'])
            newActv=f"You've entered a form and earned, {request.session['firstButton']} gold, {time}"
            request.session['activity'].append(newActv)
            return redirect("/")
            # check the second button raise 10-20
        elif 'Find2Gold' in request.POST:
            request.session['second']= random.randint(10,20)
            request.session['totalGold'] = int(request.session['totalGold'])+int(request.session['second'])
            newActv=f"You've entered a cave and earned, {request.session['second']}gold, {time}"
            request.session['activity'].append(newActv)
            return redirect("/")
            # check the third button raise 10-20
        elif 'Find3Gold' in request.POST:
            request.session['third']= random.randint(10,20)
            request.session['totalGold'] = int(request.session['totalGold'])+int(request.session['third'])
            newActv=f"You've entered a house and earned, {request.session['third']} gold, {time}"
            request.session['activity'].append(newActv)
            return redirect("/")
            # check the 4th button raise or decrease -50-50
        elif 'Find4Gold' in request.POST:
            request.session['forth']= random.randint(-50,50)
            request.session['totalGold'] = int(request.session['totalGold'])+int(request.session['forth'])
            if request.session['forth'] >0:
                newActv=f"You completed a quest and earned , {request.session['forth']} gold, {time}"
                request.session['activity'].append(newActv)
            else:
                newActv=f"You failed a quest and lost, {request.session['forth']} gold,Ouch {time}"
                request.session['activity'].append(newActv)
            return redirect("/")


# Create your views here.
