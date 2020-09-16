from django.db.models.signals import post_save
from .models import *
from django.dispatch import receiver

@receiver(post_save, sender=CustomUser)
def create_usu_final(sender, instance, created, **kwargs):
    if created:
        UsuarioFinal.objects.create(cuser=instance)

@receiver(post_save, sender=CustomUser)
def save_usu_final(sender, instance, **kwargs):
    instance.UsuarioFinal.save()
