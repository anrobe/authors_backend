/*
Este código define una clase Java llamada "AuthorVO" que representa un objeto de valor (Value Object)
para un autor en una aplicación.
Aquí se explica su estructura y funcionalidad:

1. Importaciones:
   - Se importan anotaciones de validación de Bean Validation para asegurar la integridad de los datos.
   - Se importan anotaciones de Lombok para reducir el código repetitivo.

2. Anotaciones de clase:
   - @Data: Anotación de Lombok que genera automáticamente métodos getter, setter, toString,
     equals y hashCode.
   - @NoArgsConstructor: Lombok genera un constructor sin argumentos.
   - @AllArgsConstructor: Lombok genera un constructor con todos los argumentos.

3. Atributos de la clase:
   - id:
     * Representa el identificador único del autor.
     * No puede ser nulo (@NotNull).
     * Debe ser un número mayor o igual a 1 (@Min(1)).

   - firstName:
     * Representa el nombre del autor.
     * No puede estar en blanco (@NotBlank).
     * Tiene un tamaño máximo de 30 caracteres (@Size(max = 30)).

   - lastName:
     * Representa el apellido del autor.
     * Tiene las mismas restricciones que firstName.

Diferencias clave con la clase Author vista anteriormente:
1. Esta clase no tiene anotaciones JPA (@Entity, @Table, @Column), lo que indica que no está
   directamente mapeada a una tabla de base de datos.
2. Se nombra con el sufijo "VO" (Value Object), lo que sugiere que se usa para transferir datos
   entre capas de la aplicación, posiblemente entre la capa de servicio y la capa de presentación.
3. Mantiene las validaciones de datos, lo que asegura la integridad de los datos incluso fuera
   del contexto de la base de datos.

En resumen, AuthorVO es una clase que representa los datos de un autor de forma independiente
de la persistencia, útil para operaciones que no requieren acceso directo a la base de datos,
como transferir datos a la interfaz de usuario o entre diferentes componentes de la aplicación.
*/

package com.bpb.publications.authors.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorVO {

    private Long id;

    @NotBlank
    @Size(max = 30)
    private String firstName;

    @NotBlank
    @Size(max = 30)
    private String lastName;
}