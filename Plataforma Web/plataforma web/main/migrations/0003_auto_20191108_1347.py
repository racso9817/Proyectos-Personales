# Generated by Django 2.2.5 on 2019-11-08 18:47

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('main', '0002_auto_20191108_1335'),
    ]

    operations = [
        migrations.AlterField(
            model_name='customuser',
            name='profile_pic',
            field=models.ImageField(default='defualt.jpg', upload_to='profile_pics/'),
        ),
    ]
