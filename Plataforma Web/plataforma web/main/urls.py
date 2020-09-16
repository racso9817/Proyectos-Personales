from django.conf.urls import url
from django.contrib.auth import views as auth_views
from .views import PuntosListView
from django.urls import path
from . import views as user_views

urlpatterns = [
    path('', user_views.mainpage, name='mainpage')
]