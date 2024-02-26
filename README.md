# registerUsers
Servicio para el registro de usuarios.

endpoint:
agregar usuario_ POST
http://localhost:8080/api/user/add

Request body:
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

listar usuario por uuid_ GET
http://localhost:8080/api/user/id/1d494eee-ebc4-4603-bb0a-b203187cf0ba

listar todos los usuarios_ GET
http://localhost:8080/api/user/alluser

eliminar usuario por UUID_ DELETE
http://localhost:8080/api/user/delete/e653cf61-f996-4b8c-b6c8-924a7526eba8

modificar datos del usuario_ PUT
http://localhost:8080/api/user/update/4f78fe64-7ed2-4e0a-9fae-73eb27375920
Request body:
{
    "name": "Juan Rodriguez",
    "email": "sf@uakndrigue.org",
    "password": "hunter22",
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "countrycode": "57"
        }
    ]
}


documentacion con Swagger:
http://localhost:8080/doc/swagger-ui/index.html
