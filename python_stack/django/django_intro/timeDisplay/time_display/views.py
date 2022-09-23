from django.shortcuts import render,HttpResponse, HttpResponseRedirect, redirect
from time import gmtime, strftime, time

def index(request):
    context = {
        "time": strftime(" %d-%b-%Y %H:%M %p", gmtime())
    }
    print(context)
    return render(request,"index.html",context)

# Create your views here.
