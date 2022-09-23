from django.urls import path
from . import views
urlpatterns = [
    path('', views.root),
    path('collectfirstGold', views.firstGold),
    # path('collectSecGold', views.SecondGold),
    # path('collect3rdGold', views.ThirdGold),
    # path('collect4thGold', views.forthGold),
]