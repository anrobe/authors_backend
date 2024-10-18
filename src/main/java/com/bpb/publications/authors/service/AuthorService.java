package com.bpb.publications.authors.service;

import com.bpb.publications.authors.vo.AuthorVO;

import java.util.List;

/**
 * Interfaz de servicio para la gestión de autores.
 */
public interface AuthorService {

    /**
     * Recupera una lista de todos los autores.
     *
     * @return una lista de objetos AuthorVO
     */
    List<AuthorVO> getAuthors();

    /**
     * Recupera un autor por su ID.
     *
     * @param id el ID del autor
     * @return el objeto AuthorVO
     */
    AuthorVO getAuthor(Long id);

    /**
     * Agrega un nuevo autor.
     *
     * @param authorVO el objeto AuthorVO a agregar
     * @return el objeto AuthorVO agregado
     */
    AuthorVO addAuthor(AuthorVO authorVO);

    /**
     * Actualiza un autor existente.
     *
     * @param id el ID del autor a actualizar
     * @param authorVO el objeto AuthorVO con la información actualizada
     * @return el objeto AuthorVO actualizado
     */
    AuthorVO updateAuthor(Long id, AuthorVO authorVO);

    /**
     * Elimina un autor por su ID.
     *
     * @param id el ID del autor a eliminar
     */
    void deleteAuthor(Long id);
}
