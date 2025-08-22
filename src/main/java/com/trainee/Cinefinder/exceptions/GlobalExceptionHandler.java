package com.trainee.Cinefinder.exceptions;

import com.trainee.Cinefinder.exceptions.artistas.ArtistaYaRegistradoException;
import com.trainee.Cinefinder.exceptions.categorias.CategoriaNoActualizadaException;
import com.trainee.Cinefinder.exceptions.categorias.CategoriaNoEliminadaException;
import com.trainee.Cinefinder.exceptions.categorias.CategoriaNombreYaExistenteException;
import com.trainee.Cinefinder.exceptions.peliculas.PeliculaNoActualizadaException;
import com.trainee.Cinefinder.exceptions.peliculas.PeliculaNoEliminadaException;
import com.trainee.Cinefinder.exceptions.peliculas.PeliculaTituloYaExistenteException;
import com.trainee.Cinefinder.model.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoriaNoEliminadaException.class)
    public ResponseEntity<ErrorResponse> handleCategoriaNoEliminada(CategoriaNoEliminadaException ex, WebRequest request){
        ErrorResponse error = ErrorResponse.builder()
                .code(String.valueOf(HttpStatus.BAD_REQUEST))
                .details(ex.getMessage())
                .location(request.getDescription(true))
                .moreInfo("No se pudo eliminar la categoria error en: " + request.getDescription(false).replace("uri=", ""))
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CategoriaNoActualizadaException.class)
    public ResponseEntity<ErrorResponse> handleCategoriaNoActualizada(CategoriaNoActualizadaException ex, WebRequest request){
        ErrorResponse error = ErrorResponse.builder()
                .code(String.valueOf(HttpStatus.BAD_REQUEST))
                .details(ex.getMessage())
                .location(request.getDescription(true))
                .moreInfo("No se pudo actualizar la categoria error en: " + request.getDescription(false).replace("uri=", ""))
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CategoriaNombreYaExistenteException.class)
    public ResponseEntity<ErrorResponse> handleCategoriaNombreYaExistente(CategoriaNombreYaExistenteException ex, WebRequest request){
        ErrorResponse error = ErrorResponse.builder()
                .code(String.valueOf(HttpStatus.BAD_REQUEST))
                .details(ex.getMessage())
                .location(request.getDescription(true))
                .moreInfo("No se pudo ingresar una nueva categoria error en: " + request.getDescription(false).replace("uri=", ""))
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PeliculaTituloYaExistenteException.class)
    public ResponseEntity<ErrorResponse> handlePeliculaTituloYaExistente(PeliculaTituloYaExistenteException ex, WebRequest request){
        ErrorResponse error = ErrorResponse.builder()
                .code(String.valueOf(HttpStatus.BAD_REQUEST))
                .details(ex.getMessage())
                .location(request.getDescription(true))
                .moreInfo("No se pudo ingresar una pelicula categoria error en: " + request.getDescription(false).replace("uri=", ""))
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PeliculaNoActualizadaException.class)
    public ResponseEntity<ErrorResponse> handlePeliculaNoActualizada(PeliculaNoActualizadaException ex, WebRequest request){
        ErrorResponse error = ErrorResponse.builder()
                .code(String.valueOf(HttpStatus.BAD_REQUEST))
                .details(ex.getMessage())
                .location(request.getDescription(true))
                .moreInfo("No se pudo actualizar la pelicula error en: " + request.getDescription(false).replace("uri=", ""))
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PeliculaNoEliminadaException.class)
    public ResponseEntity<ErrorResponse> handlePeliculaNoEliminada(PeliculaNoEliminadaException ex, WebRequest request){
        ErrorResponse error = ErrorResponse.builder()
                .code(String.valueOf(HttpStatus.BAD_REQUEST))
                .details(ex.getMessage())
                .location(request.getDescription(true))
                .moreInfo("No se pudo eliminar la categoria error en: " + request.getDescription(false).replace("uri=", ""))
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ArtistaYaRegistradoException.class)
    public ResponseEntity<ErrorResponse> handleArtistaYaRegistrado(ArtistaYaRegistradoException ex, WebRequest request){
        ErrorResponse error = ErrorResponse.builder()
                .code(String.valueOf(HttpStatus.BAD_REQUEST))
                .details(ex.getMessage())
                .location(request.getDescription(true))
                .moreInfo("No se pudo ingresar una pelicula categoria error en: " + request.getDescription(false).replace("uri=", ""))
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<ErrorResponse> handlerRecursoNoEncontrado(RecursoNoEncontradoException ex, WebRequest request) {
        ErrorResponse error = ErrorResponse.builder()
                .code(String.valueOf(HttpStatus.NOT_FOUND))
                .details(ex.getMessage())
                .location(request.getDescription(true))
                .moreInfo("No se encontró en la ruta: " + request.getDescription(false).replace("uri=", ""))
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex, WebRequest request) {
        ErrorResponse error = ErrorResponse.builder()
                .code("500")
                .details(ex.getMessage())
                .location(request.getDescription(false))
                .moreInfo("Ocurrió un error inesperado")
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}