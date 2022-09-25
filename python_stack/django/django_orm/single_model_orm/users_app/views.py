from multiprocessing import context
from django.shortcuts import render, HttpResponse, redirect
from .models import User
def root(request):
    context = {
        "Users": User.objects.all()
    }
    return render(request,"userForm.html",context)
def addUser(request):
    FirstName = request.POST['firstname']
    lastName = request.POST['lastname']
    Email = request.POST['Email']
    Age = request.POST['age']
    user = User(first_name = FirstName, Last_name=lastName, email = Email,age=Age )
    user.save()
    return redirect("/")
# Create your views here.

