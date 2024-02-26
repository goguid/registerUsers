# registerUsers
Servicio para el registro de usuarios.

endpoint:
agregar usuario_ POST
http://localhost:8080/api/user/add

Request:
{
    "name": "Juan Rodriguez",
    "email": "sf@uanrodrigue.org",
    "password": "hunter2",
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "countrycode": "57"
        }
    ]
}

listar usuario por email_ GET
http://localhost:8080/api/user/email/{email}

listar todos los usuarios_ GET
http://localhost:8080/api/user/alluser

eliminar usuario por UUID_ DELETE
http://localhost:8080/api/user/delete/e653cf61-f996-4b8c-b6c8-924a7526eba8




documentacion con Swagger:
http://localhost:8080/doc/swagger-ui/index.html
