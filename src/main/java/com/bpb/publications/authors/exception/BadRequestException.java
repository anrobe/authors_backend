/*
Este código define una clase Java llamada "BadRequestException" que representa una excepción
personalizada para manejar errores de solicitud incorrecta en una aplicación Spring Boot.
Aquí se explica su estructura y funcionalidad:

1. Importaciones:
   - Se importan clases de Spring Framework para manejar respuestas HTTP y anotaciones.

2. Anotaciones de clase:
   - @ResponseBody: Indica que el valor de retorno de los métodos debe ser vinculado al cuerpo
     de la respuesta web.
   - @ResponseStatus(HttpStatus.BAD_REQUEST): Especifica que cuando se lance esta excepción,
     la respuesta HTTP tendrá un código de estado 400 (Bad Request).

3. Definición de la clase:
   - La clase BadRequestException extiende RuntimeException, lo que significa que es una
     excepción no comprobada (unchecked exception).

4. Constructor:
   - Tiene un constructor que acepta un mensaje como parámetro.
   - Este constructor llama al constructor de la superclase (RuntimeException) con el mensaje
     proporcionado.

5. Método getMessage():
   - Sobrescribe el método getMessage() de la clase RuntimeException.
   - En este caso, simplemente devuelve el mensaje de la superclase sin modificaciones.
   - La sobrescritura aquí es redundante, ya que no añade ninguna funcionalidad adicional.

Funcionalidad y uso:
- Esta excepción se utiliza para indicar que una solicitud del cliente es incorrecta o inválida.
- Cuando se lanza esta excepción en un controlador de Spring, automáticamente se genera una
  respuesta HTTP con:
  * Código de estado 400 (Bad Request)
  * El mensaje de error en el cuerpo de la respuesta (debido a @ResponseBody)
- Esto permite un manejo más elegante y estandarizado de los errores de solicitud en la aplicación.

En resumen, BadRequestException es una clase de excepción personalizada diseñada para manejar
y comunicar errores de solicitud incorrecta en una API REST de Spring Boot, proporcionando
un mecanismo consistente para informar al cliente sobre problemas con su solicitud.
*/

package com.bpb.publications.authors.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseBody
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}