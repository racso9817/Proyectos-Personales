from django.db import models
from django.contrib.auth.models import AbstractUser
from django.db.models.constraints import CheckConstraint, Q
from django.shortcuts import redirect, reverse
from django.utils.timezone import now
from django.core import validators
from PIL import Image

class Genero(models.Model):
    id_genero = models.AutoField(primary_key=True)
    descripcion = models.CharField(max_length=30, blank=True, null=True)

    class Meta:
        db_table = 'genero'


# AbstactUser ya tiene: username, first_name, last_name, email, is_active

class CustomUser(AbstractUser):
    genero = models.ForeignKey('Genero', models.PROTECT, db_column='genero')
    email = models.EmailField(blank=False, help_text='Correo Electrónico', error_messages = {'invalid': 'Correo invalido'}, validators=[validators.RegexValidator(r'^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$', ('Ingrese un correo valido.'), 'invalid'),])
    fecha_nacimiento = models.DateField(blank=True, null=True, help_text='Ingrese la fecha en formato mm/dd/yyyy.', error_messages = {'invalid': 'Fecha invalida'})
    direccion = models.CharField(max_length=100, blank=True, null=True)
    cedula_ruc = models.CharField(max_length=13, unique=True, help_text='Ingrese la cedula o ruc', validators=[validators.RegexValidator(r'\d\d\d\d\d\d\d\d\d\d|\d\d\d\d\d\d\d\d\d\d\d\d\d', ('Ingrese una cedula válida.'), 'invalid'),])
    razon_soc = models.CharField(max_length=50, null=False, blank=False, default='Cliente Final')
    profile_pic = models.ImageField(default='profile_pics/default.jpg', upload_to='profile_pics')
    is_cliente = models.BooleanField(null=False, blank = False, default = False, help_text = 'Seleccione si desea ser socio comercial y es dueño de un negocio, sino deje en blanco.', verbose_name='Socio o usuario:')

    def __str__(self):
        return f'{self.username}'

    
    def save(self, *args, **kwargs):
        super().save()

        img = Image.open(self.profile_pic.path)
        if img.size[1] > 300 or img.size[0] > 300:

            output_size = (300, 300)
            img = img.resize(output_size, Image.LANCZOS)
            img.save(self.profile_pic.path)


    class Meta:
        verbose_name= 'Custom User'

class RolesClientes(models.Model):
    id_rol = models.AutoField(primary_key=True)
    descripcion = models.CharField(max_length=15, blank=True, null=True)

    def __str__(self):
        return self.descripcion

    class Meta:
        db_table = 'roles_clientes'


class Cliente(models.Model):
    cuser = models.OneToOneField(CustomUser, on_delete=models.CASCADE)
    id_cliente = models.AutoField(primary_key=True)
    plan = models.IntegerField(blank=False, null=False, default=1)
    rol = models.ForeignKey('RolesClientes', models.PROTECT, db_column='rol')

    def __str__(self):
        return "Cliente: " + self.cuser.__str__()

    class Meta:
        db_table = 'cliente'


class UsuarioFinal(models.Model):
    cuser = models.OneToOneField(CustomUser, on_delete=models.CASCADE)
    id_usufinal = models.AutoField(primary_key=True)

    def __str__(self):
        return "Usuario Final: " + self.cuser.__str__()

    class Meta:
        db_table = 'usuario_final'


class TipoTelefono(models.Model):
    cod = models.AutoField(primary_key=True)
    descripcion = models.CharField(max_length=20)

    def __str__(self):
        return "{} {}".format(self.cod, self.descripcion)

    class Meta:
        db_table = 'tipo_telefono'


class TelefonosUsusarios(models.Model):
    id_telefono = models.AutoField(primary_key=True)
    numero = models.CharField(unique=True, max_length=14)
    usuario = models.ForeignKey('UsuarioFinal', models.PROTECT, db_column='usuario')
    tipo_telefono = models.ForeignKey('TipoTelefono', models.PROTECT, db_column='tipo_telefono')

    def __str__(self):
        return "{} {}".format(self.usuario, self.numero)
    
    class Meta:
        db_table = 'telefonos_ususarios'


class TelefonosClientes(models.Model):
    id_telefono = models.AutoField(primary_key=True)
    numero = models.CharField(unique=True, max_length=14)
    propietario = models.ForeignKey(Cliente, models.PROTECT, db_column='propietario')
    tipo_telefono = models.ForeignKey('TipoTelefono', models.PROTECT, db_column='tipo_telefono')


    def __str__(self):
        return "{} {}".format(self.propietario, self.numero)


    class Meta:
        db_table = 'telefonos_clientes'


class Sucursal(models.Model):
    id_local = models.AutoField(primary_key=True)
    nombre = models.CharField(max_length=50)
    direccion = models.CharField(unique=True, max_length=150)
    correo = models.CharField(max_length=150, blank=True, null=True)
    imagenTkn = models.ImageField(default='token_pics/default.png', upload_to='token_pics')
    propietario = models.ForeignKey(Cliente, models.PROTECT, db_column='propietario')

    def get_absolute_url(self):
        return reverse('sucursal-details', kwargs={'pk': self.pk})
    
    def save(self, *args, **kwargs):
        super().save()

        img = Image.open(self.imagenTkn.path)
        if img.size[1] > 300 or img.size[0] > 300:

            output_size = (300, 300)
            img = img.resize(output_size, Image.LANCZOS)
            img.save(self.imagenTkn.path)


    def __str__(self):
        return str(self.id_local) + " " + self.nombre


    class Meta:
        db_table = 'sucursal'


class TelefonosSucursales(models.Model):
    id_telefono = models.AutoField(primary_key=True)
    numero = models.CharField(unique=True, max_length=14)
    propietario = models.ForeignKey(Sucursal, models.PROTECT, db_column='propietario')
    tipo_telefono = models.ForeignKey('TipoTelefono', models.PROTECT, db_column='tipo_telefono')


    def __str__(self):
        return "{} {}".format(self.propietario, self.numero)


    class Meta:
        db_table = 'telefonos_sucursales'


class Meta(models.Model):
    id_meta = models.AutoField(primary_key=True)
    nombre = models.CharField(max_length=50)
    descripcion = models.CharField(max_length=300, blank=True, null=True)
    tokens = models.IntegerField(null=False, blank=False, default=1)
    cliente = models.ForeignKey(Cliente, models.PROTECT, db_column='cliente')
    activa = models.IntegerField()

    class Meta:
        db_table = 'meta'
        db_constraints = {
            'not_zero_tokens':'check (tokens > 0)',
        }


class SucursalCliente(models.Model):
    id_cajero = models.AutoField(primary_key=True)
    sucursal = models.ForeignKey(Sucursal, models.PROTECT, db_column='sucursal')
    cliente = models.ForeignKey(Cliente, models.PROTECT, db_column='cliente')
    activo = models.BooleanField(blank=False, null=False, default=True)

    def __str__(self):
        return "{} en: {}".format(self.cliente.__str__(), self.sucursal.__str__())

    class Meta:
        db_table = 'sucursal_cliente'


class Token(models.Model):
    id_token = models.AutoField(primary_key=True)
    fecha = models.DateTimeField(editable=False, null=False, blank=True, default=now)
    usuario = models.ForeignKey('UsuarioFinal', models.PROTECT, db_column='usuario')
    cajero = models.ForeignKey(SucursalCliente, models.PROTECT, db_column='cajero')

    class Meta:
        db_table = 'token'


class Campana(models.Model):
    id_campana = models.AutoField(primary_key=True)
    nombre = models.CharField(max_length=30)
    fechainicio = models.DateTimeField(db_column='fechaInicio', null=False, blank=True, default=now)
    duracion = models.IntegerField(blank=False, null=False, default=1)
    target = models.CharField(max_length=300, blank=True, null=True)
    sucursal = models.ForeignKey('Sucursal', models.PROTECT, db_column='sucursal')

    class Meta:
        db_table = 'campana'
        db_constraints = {
            'not_yesterday':"check (fechainicio >= CONCAT(CURDATE(), ' 00:00:00'))",
            'not_zero_duration':'check (duracion > 0)',
        }


class Canje(models.Model):
    id_canje = models.AutoField(primary_key=True)
    usuario = models.ForeignKey('UsuarioFinal', models.PROTECT, db_column='usuario')
    cajero = models.ForeignKey('Cliente', models.PROTECT, db_column='cajero')
    meta = models.ForeignKey('Meta', models.PROTECT, db_column='meta')
    sucursal = models.ForeignKey('Sucursal', models.PROTECT, db_column='sucursal')
    fecha = models.DateTimeField(editable=False, null=False, blank=True, default=now)

    class Meta:
        db_table = 'canje'


class Canjetoken(models.Model):
    usuario = models.ForeignKey('UsuarioFinal', models.PROTECT, db_column='usuario', primary_key=True)
    token = models.ForeignKey('Token', models.PROTECT, db_column='token')
    fecha = models.DateTimeField(editable=False, null=False, blank=True, default=now)

    class Meta:
        db_table = 'canjetoken'
        unique_together = (('usuario', 'token'),)