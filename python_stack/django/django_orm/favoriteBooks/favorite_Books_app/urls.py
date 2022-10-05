
from django.urls import path
from . import views

urlpatterns = [
    path('', views.welcomePage),
    path('proccessAddBook',views.addBooks),
    path('description/<int:id>', views.viewBook),
    path('addToFav/<int:id>', views.addedFav),
    path('unfovarite/<int:id>', views.unFav),
    path('editPage', views.editBook),
]