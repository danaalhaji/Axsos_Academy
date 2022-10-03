from django.urls import path
from . import views
urlpatterns = [
    path('', views.redirectShow),
    path('show', views.showsView),
    path('show/new', views.SubmitShow),
    path('show/add', views.showadd),
    path('show/method/<int:id>', views.method),
    path('show/<int:id>/edit', views.editShow),
    path('show/<int:id>/edit/save', views.saveEdit),
    path('show/<int:id>/delete',views.deleteShow),
]