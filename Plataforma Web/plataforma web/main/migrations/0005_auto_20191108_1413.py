# Generated by Django 2.2.5 on 2019-11-08 19:13

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('main', '0004_auto_20191108_1351'),
    ]

    operations = [
        migrations.AlterModelOptions(
            name='customuser',
            options={'verbose_name': 'Custom Users'},
        ),
        migrations.AlterField(
            model_name='customuser',
            name='profile_pic',
            field=models.ImageField(default='profile_pics/defualt.jpg', upload_to='profile_pics'),
        ),
    ]
