from django import forms
from django.contrib.auth.forms import UserCreationForm, UserChangeForm
from .models import CustomUser, Cliente, UsuarioFinal, Sucursal
import django.core.validators as validators
from django.shortcuts import redirect, render

class CustomUserCreationForm(UserCreationForm):

    error_messages = {
        'telefono_invalido' : "El telefono ingresado no es valido",
        'password_mismatch' : "Las contraseñas no coinciden."
    }

    telefono = forms.CharField(label="Telefono", max_length=12, validators=[validators.RegexValidator(r'\d\d\d\d\d\d\d\d\d\d|\d\d\d\d\d\d\d\d\d\d\d\d|\d\d\d\d\d\d\d|\d\d\d\d\d\d\d\d\d\d\d', ('Ingrese un telefono válido.'), 'invalid'),])

    fecha_nacimiento = forms.DateField(
        widget=forms.DateInput(format='%d/%m/%Y'),
        input_formats=('%d/%m/%Y',)
    )
    
    def clean_telefono(self):
        telefono = self.cleaned_data.get("telefono")
        if telefono and not telefono.isdigit() and len(telefono) not in [7, 9, 12]:
            raise forms.ValidationError(
            self.error_messages['telefono_invalido'],
            code='telefono_invalido'
            )
        return self.cleaned_data

    class Meta:
        model = CustomUser
        fields = ('username', 'email', 'password1', 'password2', 'profile_pic', 'cedula_ruc', 'first_name', 'last_name', 'fecha_nacimiento', 'is_cliente')

class CustomUserUpdateForm(forms.ModelForm):

    error_messages = {
        'telefono_invalido' : "El telefono ingresado no es valido"
    }

    telefono = forms.CharField(label="Telefono", max_length=12, validators=[validators.RegexValidator(r'\d\d\d\d\d\d\d\d\d\d|\d\d\d\d\d\d\d\d\d\d\d\d|\d\d\d\d\d\d\d|\d\d\d\d\d\d\d\d\d\d\d', ('Ingrese un telefono válido.'), 'invalid'),])

    fecha_nacimiento = forms.DateField(
        widget=forms.DateInput(format='%d/%m/%Y'),
        input_formats=('%d/%m/%Y',)
    )

    def clean_telefono(self):
        telefono = self.cleaned_data.get("telefono")
        if telefono and not telefono.isdigit() and len(telefono) not in [7, 9, 12]:
            raise forms.ValidationError(
                self.error_messages['telefono_invalido'],
                code='telefono_invalido'
            )
        return telefono

    class Meta:
        model = CustomUser
        fields = ('email', 'telefono', 'fecha_nacimiento', 'profile_pic', 'genero', 'direccion')

class CustomUserChangeForm(UserChangeForm):

    profile_pic = forms.ImageField()

    class Meta:
        model = CustomUser
        fields = ('username', 'email', 'profile_pic', 'first_name', 'last_name', 'fecha_nacimiento', 'cedula_ruc', 'genero', 'direccion', 'profile_pic')

class ClienteUpdateForm(forms.ModelForm):
    class Meta:
        model = Cliente
        fields = ('rol',)


class SucursalCreationForm(forms.ModelForm):
    class Meta:
        model = Sucursal
        fields = "__all__"
        widgets = {
            'propietario' : forms.HiddenInput,
        }
