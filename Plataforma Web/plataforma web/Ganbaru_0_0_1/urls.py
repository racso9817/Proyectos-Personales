from django.conf import settings
from django.conf.urls import include, url
from django.conf.urls.static import static
from django.contrib import admin
from django.contrib.auth import views as auth_views
from django.urls import path

from main.views import *

urlpatterns = [
    path('admin/', admin.site.urls),
    path('', include('main.urls'), name='mainpage_clean'),
    path('main/', include('main.urls'), name='mainpage'),
    path('acerca/', acerca, name='acerca'),
    path('entrar/', auth_views.LoginView.as_view(template_name='main/entrar.html'), name='entrar'),
    path('cerrarsesion/', auth_views.LogoutView.as_view(template_name='main/salir.html'), name='salir'),
    path('servicios/', servicios, name='servicios'),
    path('registro/', registro, name='registro'),
    path('profile/', profile, name='profile'),
    # path('puntos/', puntos, name='puntos'),
    path('puntos/<int:pk>/', PuntosDetailView.as_view(), name='puntos-details'),
    path('puntos/', PuntosListView.as_view(), name='puntos'),
    # Sucursales
    path('dashboard/sucursales/<int:pk>/', SucursalesDetailView.as_view(), name='sucursal-details'),
    path('dashboard/sucursales/', SucursalesListView.as_view(), name='sucursales'),
    path('dashboard/sucursales/crear/', SucursalCreationView.as_view(), name='sucursal-create'),
    path('dashboard/sucursales/addMeta/', aggMeta, name='aggMeta'),
    path('dashboard/sucursales/addSucursal', aggSucursal, name='aggSucursal'),
    path('dashboard/cajeros/<int:pk>/', CajerosDetailView.as_view(), name='cajero-details'),
    path('dashboard/cajeros/', CajerosListView.as_view(), name='cajeros'),
    path('dashboard/addCajero/', aggCajero, name='aggCajero'),
    path('dashboard/', dashboard, name='dashboard'),
    path('dashboard/estadistica_cliente/', estadistica, name='estadistica'),
    path('dashboard/campana/', campana, name='campana'),
]

if settings.DEBUG:
    urlpatterns += static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)
