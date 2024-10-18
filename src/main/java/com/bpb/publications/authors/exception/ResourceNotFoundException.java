/*
Este código define una clase Java llamada "ResourceNotFoundException" que representa una
excepción personalizada para manejar errores de recurso no encontrado en una aplicación
Spring Boot. Aquí se explica su estructura y funcionalidad:

1. Importaciones:
   - Se importan clases de Spring Framework para manejar respuestas HTTP y anotaciones.

2. Anotaciones de clase:
   - @ResponseBody: Indica que el valor de retorno de los métodos debe ser vinculado al
     cuerpo de la respuesta web.
   - @ResponseStatus(HttpStatus.NOT_FOUND): Especifica que cuando se lance esta excepción,
     la respuesta HTTP tendrá un código de estado 404 (Not Found).

3. Definición de la clase:
   - La clase ResourceNotFoundException extiende RuntimeException, lo que significa que es
     una excepción no comprobada (unchecked exception).

4. Constructor:
   - Tiene un constructor que acepta un mensaje como parámetro.
   - Este constructor llama al constructor de la superclase (RuntimeException) con el mensaje
     proporcionado.

5. Método getMessage():
   - Sobrescribe el método getMessage() de la clase RuntimeException.
   - En este caso, simplemente devuelve el mensaje de la superclase sin modificaciones.
   - La sobrescritura aquí es redundante, ya que no añade ninguna funcionalidad adicional.

Funcionalidad y uso:
- Esta excepción se utiliza para indicar que un recurso solicitado no se ha encontrado en
  el servidor.
- Cuando se lanza esta excepción en un controlador de Spring, automáticamente se genera una
  respuesta HTTP con:
  * Código de estado 404 (Not Found)
  * El mensaje de error en el cuerpo de la respuesta (debido a @ResponseBody)
- Esto permite un manejo más elegante y estandarizado de los errores de recurso no encontrado
  en la aplicación.

En resumen, ResourceNotFoundException es una clase de excepción personalizada diseñada para
manejar y comunicar errores de recurso no encontrado en una API REST de Spring Boot,
proporcionando un mecanismo consistente para informar al cliente cuando el recurso solicitado
no existe o no está disponible.
*/

package com.bpb.publications.authors.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseBody
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
