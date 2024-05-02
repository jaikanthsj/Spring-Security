package com.example.springsecurity.Repository;

import com.example.springsecurity.Model.BookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceClass implements BookService {

    private final Respository repository;

    @Autowired
    public ServiceClass(Respository repository){
        this.repository = repository;
    }

    @Override
    public BookModel addBooks(BookModel book){
        return repository.save(book);
    }

    @Override
    public List<BookModel> getAllBooks(){
        return repository.findAll();
    }

    @Override
    public Optional<BookModel> getBookById(int id){
        return repository.findById(id);
    }

    @Override
    public List<BookModel> getBookByTitle(String title){
        return repository.findByTitle(title);
    }

    @Override
    public List<BookModel> getBookByAuthor(String author){
        return repository.findByAuthor(author);
    }

    @Override
    public List<BookModel> getBookByGenre(String genre){
        return repository.findByGenre(genre);
    }

    @Override
    public List<BookModel> getBookByLanguage(String language){
        return repository.findByLanguage(language);
    }

    @Override
    public List<BookModel> getBookByTitles(List<String> titles){
        return repository.findByTitleIn(titles);
    }

    @Override
    public List<BookModel> getBookByAuthors(List<String> authors){
        return repository.findByAuthorIn(authors);
    }

    @Override
    public List<BookModel> getBookByGenres(List<String> genres){
        return repository.findByGenreIn(genres);
    }

    @Override
    public List<BookModel> getBookByLanguages(List<String> languages){
        return repository.findByLanguageIn(languages);
    }

    @Override
    public BookModel updateBook(BookModel book){
        return repository.save(book);
    }

    @Override
    public void deleteBook(int id){
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(int id){
        return repository.existsById(id);
    }

    @Override
    public String values() {
        return "";
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}