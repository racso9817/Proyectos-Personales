# Generated by Django 3.0.3 on 2020-02-13 03:51

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('main', '0010_auto_20191210_1330'),
    ]

    operations = [
        migrations.AlterField(
            model_name='customuser',
            name='genero',
            field=models.ForeignKey(db_column='genero', on_delete=django.db.models.deletion.PROTECT, to='main.Genero'),
        ),
    ]