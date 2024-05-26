# sweetBox

SpringBoot, REST

### Описание

Заглушка, обрабатывающая следующие запросы со стороны псевдо-тестируемой системы. 
 
1. Get localhost:8080/app/v1/getRequest?id={id}&name={name}
где id > 10 и длина name > 5. В случае если какое условие не выполняется вернуть InternalServerError и напечатать причину ошибки Вернуть тело ответа из текстового файла getAnswer.txt и подставив в него поле name и id.
В случае id > 10 and id < 50 время задержи = 1000мс, во всех остальных случаях 500мс

2. Post localhost:8080/app/v1/postRequest body : {“name”: “{name}”, “surname”: “{surname}”, ”age”:{age}} 
где {name}, {surname}, должны быть не пустыми, а {age} может быть пустым (дефолтное значение 123), в противном случае вернуть InternalServerError Вернуть ответ из приложенного файла – postAnswer.txt, подставив в него данные из тела запроса 

 


get
1) http://localhost:8080/app/v1/getRequest?id=11&name=Fridrich

ответ
{
    "Person1": {
        "id": 11,
        "name": "Fridrich"
    }
}

2) http://localhost:8080/app/v1/getRequest?id=11&name=Frid
500Internal Server Error


--------------------
post
http://localhost:8080/app/v1/postRequest


1)
{
        "name": "Frosya",
        "surname": "Solnechnaya",
        "age": 12
}

ответ
{
    "Person1": {
        "name": "Frosya",
        "surname": "Solnechnaya",
        "age": 12
    },
    "Person2": {
        "name": "Solnechnaya",
        "surname": "Frosya",
        "age": 24
    }
}

2)
{
        "name": "Frosya",
        "surname": "Solnechnaya",
        "age": null
}

ответ
{
    "Person1": {
        "name": "Frosya",
        "surname": "Solnechnaya",
        "age": 123
    },
    "Person2": {
        "name": "Solnechnaya",
        "surname": "Frosya",
        "age": 246
    }
}

3) 
{
        "name": ""
        "surname": "Solnechnaya",
        "age": 1
}

ответ
500Internal Server Error
