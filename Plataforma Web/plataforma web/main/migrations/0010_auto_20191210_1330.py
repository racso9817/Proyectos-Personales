# Generated by Django 2.2.5 on 2019-12-10 18:30

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('main', '0009_auto_20191207_1555'),
    ]

    operations = [
        migrations.AlterField(
            model_name='sucursal',
            name='correo',
            field=models.CharField(blank=True, max_length=150, null=True),
        ),
    ]
