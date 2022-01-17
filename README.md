Programa 1: Realizar un programa identifique si un texto es palindromo o no. 
Un palindromo es una palabra o frase que al leerse de izquierda a derecha y viceversa expresan o tienen  el mismo sentido. 
Ejemplos: 
• luz azul 
• somos o no somos 
• oso 
• ana
--------------------------------------------
checar clase checkPalindromeMain
 - es una clase main que solicita una palabra desde terminal

--------------------------------------------

Programa 2: Crear un socket que mande un número al servidor y este le conteste si es  un número par o no 

--------------------------------------------
- Correr pŕoyecto Spring boot
- La clase del server es SocketController (ws://localhost:8080/socketserver)
- El cliente es la clase WebClient
--------------------------------------------

Programa 3: Realiar un programa que guarde en un archivo de texto lo que un usuario  ingrese en la terminal, el nombre del archivo debe tener el siguiente formato yyyyMMdd_HHmmss.txt 
Ejemplo del programa en la terminal: 
Introduce el texto a guardar: 
Hola mundo  
Se guardo el texto ingresado en un archivo de texto 
Programa 4: Realizar un programa que consulte la fecha y hora proporcionada por un  servicio web en un thread cada 5 segundos un total de 10 veces (ya sean exitosas las  consultas o no). 
Requerimientos: 
• La fecha y hora no debe ser del sistema 
• El formato de la fecha para mostrar es: yyyyMMdd 
• El formato de la hora para mostrar es: HH:mm:ss 
La fecha y hora debe corresponder a la de la Ciudad de México 
• Para obtener la fecha y hora se debe consumir un servicio web http://date.jsontest.com/ o  http://time.jsontest.com/ 
• En caso de ocurrir algún error al consumir el servicio web, mostrar el mensaje. “Ocurrior  un error en el consumo del servicio web” 
• 10 veces se va a consultar la fecha y hora, posteriormente se debe terminar el programa
Detalles del servicio web: 
• Se utiliza un servicio web de prueba proporcionado por jsontest, (la pagina del proyecto  es https://www.jsontest.com/) 
• El servicio web para obtener la fecha y hora es: http://date.jsontest.com/ o  http://time.jsontest.com/ 
• La respuesta del servicio web es un json con tres datos: date, milliseconds_since_epoch  y time 
o date: muestra la fecha en formato dd-MM-yyyy 
o milliseconds_since_epoch: fecha/hora en unix time 
o time: muestra la hora en formato hh:mm:ss a 
Ejemplo del servicio web: 
Request (GET): http://date.jsontest.com/ 
Response:  
{ 
 "date":"10-04-2021", 
 "milliseconds_since_epoch":1633365045595, 
 "time":"04:30:45 PM" 
} 
Notas importantes: 
• Tener en cuenta que el campo date y time no lo regresan en la zona horaria del equipo  donde se consume el servicio

--------------------------------------------
correr proyecto spring boot 
- El endpoint del servicio es localhost:8080/date tipo GET
--------------------------------------------
