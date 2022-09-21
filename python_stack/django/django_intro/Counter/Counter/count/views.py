from django.shortcuts import render,HttpResponse, redirect

def root(request):
    if  'counter'  not in request.session :
        request.session['counter']=0
    else:
        request.session['counter']+=1
    return render(request,"index.html")
def destroy(request):
    request.session['counter']=-1
    return redirect('/')
# Create your views here.