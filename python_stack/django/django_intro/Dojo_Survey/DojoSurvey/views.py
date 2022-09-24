from multiprocessing import context
from django.shortcuts import render, redirect, HttpResponse

def root(request):
    return render(request, "index.html")

def surveyResult(request):
    name = request.POST['nameText']
    city = request.POST['City']
    lang = request.POST['FavoritLanguage']
    comments = request.POST['comment']
    context = {
        "name" : name,
        "city" : city,
        "lang" : lang,
        "comments" : comments
    }
    return render(request, "index2.html", context)
# Create your views here.
