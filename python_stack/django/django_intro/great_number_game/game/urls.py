from django.urls import path
from . import views
urlpatterns = [
    path('', views.root),
    path('answer', views.answerGuess),
]