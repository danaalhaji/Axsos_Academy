from django.shortcuts import render, HttpResponse, redirect
from .models import *
def root(request):
    context={
        'Dojo': Dojos.objects.all()
    }
    return render(request,"index.html",context)

def DojoProcess(request):
    Name = request.POST['nameInput']
    City = request.POST['CityInput']
    State = request.POST['stateInput']
    dojo = Dojos(name = Name, city=City, state= State )
    dojo.save()
    return redirect("/")

def NinjaProcess(request):
    firstName = request.POST['firstNameInput']
    lastName = request.POST['lastNameInput']
    dojoNinja = Dojos.objects.get(id= request.POST['dojoNinjaa'])
    ninja = Ninjas(first_name =firstName, last_name=lastName,dojo = dojoNinja)
    ninja.save()
    return redirect("/")
# Create your views here.
