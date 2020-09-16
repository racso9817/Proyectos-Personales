from django.contrib import admin
from django.contrib.auth import get_user_model
from django.contrib.auth.admin import UserAdmin

from .forms import CustomUserChangeForm, CustomUserCreationForm, CustomUserUpdateForm
from .models import *


class CustomUserAdmin(UserAdmin):
    add_form = CustomUserCreationForm
    form = CustomUserChangeForm
    model = CustomUser
    list_display = ['username', 'profile_pic', 'email', 'first_name', 'last_name', 'is_cliente']

admin.site.register(CustomUser)

# Register your models here.
admin.site.register(Campana)
admin.site.register(Cliente)
admin.site.register(Meta)
admin.site.register(RolesClientes)
admin.site.register(Sucursal)
admin.site.register(SucursalCliente)
admin.site.register(TelefonosClientes)
admin.site.register(TelefonosSucursales)
admin.site.register(TelefonosUsusarios)
admin.site.register(TipoTelefono)
admin.site.register(Token)
admin.site.register(UsuarioFinal)