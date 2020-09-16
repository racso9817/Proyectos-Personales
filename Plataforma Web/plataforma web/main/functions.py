from .models import Token, UsuarioFinal, Cliente, SucursalCliente, CustomUser

def getTokensUsuario(username):
    tokens = Token.objects.filter(usuario__cuser__username=username)
    return tokens


def getTokensCliente(username):
    return None


def getTokenData(username, isCliente):
    if isCliente:
        return getTokensCliente(username)
    return getTokensUsuario(username)