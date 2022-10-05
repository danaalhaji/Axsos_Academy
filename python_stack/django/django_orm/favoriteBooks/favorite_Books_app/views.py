from django.shortcuts import render, redirect
from .models import *

def welcomePage(request):
    context= {
        'books' : Book.objects.all(),
        'user'  :  Users.objects.get(id=request.session['user_id']),
    }
    return render(request, "addBooks.html",context)

def addBooks(request):
    title =  request.POST['TitleInput']
    desc = request.POST['DescInput']
    upload = Users.objects.get(id=request.session['user_id'])
    b1 = Book.objects.create(title = title, describtion = desc, uploaded_by = upload)
    b1.Users_who_likes.add(upload)
    return redirect('/book')

def viewBook(request,id):
    context={
        'Book' : Book.objects.get(id=int(id)),
        'user' : Users.objects.get(id=request.session['user_id']),
        }
    return render(request,"bookView.html",context)

def addedFav(request,id):
    book = Book.objects.get(id=int(id))
    upload = Users.objects.get(id=request.session['user_id'])
    book.Users_who_likes.add(upload)
    return redirect('/book/description/'+str(id))

def unFav(request,id):
    book = Book.objects.get(id=int(id))
    user = Users.objects.get(id=request.session['user_id'])
    book.Users_who_likes.remove(user)
    return redirect('/book/description/'+str(id))
def editBook(request):
    context={
        'book' : Book.objects.get(id=int(request.POST['bookid'])),
        'user' : Users.objects.get(id=request.session['user_id']),
    }
    return render(request,"editBook.html",context)
# Create your views here.
