/*
Este código define una interfaz Java llamada "AuthorRepository" que actúa como un repositorio
para la entidad Author en una aplicación Spring Boot. Aquí se explica su estructura y funcionalidad:

1. Importaciones:
   - Se importa la clase Author del paquete com.bpb.publications.authors.entity.
   - Se importan clases de Spring Data JPA para la creación del repositorio.

2. Anotaciones:
   - @Repository("authorRepository"): Esta anotación marca la interfaz como un componente de
     repositorio en Spring. El nombre "authorRepository" se usa para identificar este bean
     específico si es necesario inyectarlo en otras partes de la aplicación.

3. Definición de la interfaz:
   - La interfaz AuthorRepository extiende JpaRepository<Author, Long>:
     * Author: Es el tipo de entidad con el que trabaja este repositorio.
     * Long: Es el tipo de dato de la clave primaria de la entidad Author.

4. Funcionalidad:
   - Al extender JpaRepository, esta interfaz hereda automáticamente una serie de métodos
     para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la entidad Author.
   - Algunos de los métodos heredados incluyen:
     * save(Author entity): Para guardar o actualizar un Author.
     * findById(Long id): Para buscar un Author por su id.
     * findAll(): Para obtener todos los Authors.
     * delete(Author entity): Para eliminar un Author.
     * count(): Para contar el número de Authors.
   - No se definen métodos adicionales en esta interfaz, lo que significa que se utilizarán
     solo los métodos estándar proporcionados por JpaRepository.

En resumen, esta interfaz proporciona una capa de abstracción para interactuar con la base de
datos en operaciones relacionadas con la entidad Author. Spring Data JPA se encargará de
implementar esta interfaz automáticamente, permitiendo realizar operaciones de base de datos
sin necesidad de escribir consultas SQL manualmente.
*/

package com.bpb.publications.authors.repository;

import com.bpb.publications.authors.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}