import re
from django.shortcuts import render, redirect, HttpResponse
from django.contrib import messages

from .models import *

def redirectShow(request):
    return redirect('/show')

def showsView(request):
    context={
        'Show' : TVShow.objects.all()
    }
    return render(request,"show.html",context)

def SubmitShow(request):

    return render(request,"addShow.html")

def showadd(request):
    errors = TVShow.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key,value in errors.items():
            messages.error(request,value)
        return redirect('/show/new')
    else:
        titlee = request.POST['addTitleText']
        netWork = request.POST['addNetworkText']
        relEasedDate = request.POST['releaseddate']
        description = request.POST['Description']
        newShow= TVShow.objects.create(title=titlee, network=netWork, release_date= relEasedDate, desc= description)
        return redirect("method/"+str(newShow.id))

def method(request,id):
    context={
        'show':TVShow.objects.get(id=int(id))
    }
    return render(request, "TVshowDetails.html",context)

def editShow(request,id):
    context={
        'show':TVShow.objects.get(id=int(id))
    }
    return render(request,"TVShowEdit.html",context)

def saveEdit(request,id):
    errors = TVShow.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key,value in errors.items():
            messages.error(request,value)
        return redirect('/show/'+str(id)+'/edit')
    else:
        titlee = request.POST['addTitleText']
        netWork = request.POST['addNetworkText']
        relEasedDate = request.POST['releaseddate']
        description = request.POST['Description']
        editShow = TVShow.objects.get(id=int(id))
        editShow.title=titlee
        editShow.network=netWork
        editShow.release_date= relEasedDate
        editShow.desc= description
        editShow.save()
        return redirect("/show/"+str(editShow.id)+"/edit")

def deleteShow(request, id):
    show=TVShow.objects.get(id=int(id))
    show.delete()
    return redirect('/show')
