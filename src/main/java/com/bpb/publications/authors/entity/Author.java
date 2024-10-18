/*
Este código define una clase Java llamada "Author" que representa una entidad en una base de datos.
Aquí se explica su estructura y funcionalidad:

1. Importaciones:
   - Se importan clases de JPA (Java Persistence API) para el mapeo objeto-relacional.
   - Se importan anotaciones de validación de Bean Validation.
   - Se importan anotaciones de Lombok para reducir el código repetitivo.

2. Anotaciones de clase:
   - @Entity: Indica que esta clase es una entidad JPA, mapeada a una tabla de base de datos.
   - @Table: Especifica el nombre de la tabla ("author") y el esquema ("pub") en la base de datos.
   - @Data: Anotación de Lombok que genera automáticamente getters, setters, toString, equals y hashCode.
   - @NoArgsConstructor: Lombok genera un constructor sin argumentos.
   - @AllArgsConstructor: Lombok genera un constructor con todos los argumentos.

3. Atributos de la clase:
   - id:
     * Es la clave primaria de la entidad (@Id).
     * No puede ser nulo (@NotNull).
     * Debe ser un número mayor o igual a 1 (@Min(1)).

   - firstName:
     * Representa el nombre del autor.
     * No puede estar en blanco (@NotBlank).
     * Tiene un tamaño máximo de 30 caracteres (@Size(max = 30)).
     * Se mapea a la columna "first_name" en la base de datos.

   - lastName:
     * Representa el apellido del autor.
     * Tiene las mismas restricciones y mapeo que firstName, pero se mapea a "last_name".

En resumen, esta clase define la estructura de datos para un autor en un sistema de publicación,
con validaciones para asegurar la integridad de los datos y anotaciones para facilitar
el mapeo objeto-relacional y reducir el código repetitivo.
*/

package com.bpb.publications.authors.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "author", schema = "pub")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 30)
    @Column(name = "first_name", length = 30)
    private String firstName;

    @NotBlank
    @Size(max = 30)
    @Column(name = "last_name", length = 30)
    private String lastName;
}
