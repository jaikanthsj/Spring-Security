package com.example.springsecurity.Controller;


import com.example.springsecurity.Model.BookModel;
import com.example.springsecurity.Repository.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController{

    private BookService service;

    @Autowired
    public BookController(BookService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<BookModel>> getAllBooks(){
        List<BookModel> books = service.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("{id}")
    public ResponseEntity<BookModel> getBookById(@PathVariable int id){
        Optional<BookModel> books = service.getBookById(id);
        return books.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/byTitles")
    public ResponseEntity<List<BookModel>> getBookByTitles(@RequestBody List<String> titles) {
        List<BookModel> books = service.getBookByTitles(titles);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/byAuthors")
    public ResponseEntity<List<BookModel>> getBookByAuthors(@RequestBody List<String> authors) {
        List<BookModel> books = service.getBookByAuthors(authors);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/byGenres")
    public ResponseEntity<List<BookModel>> getBookByGenres(@RequestBody List<String> genres) {
        List<BookModel> books = service.getBookByGenres(genres);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/byLanguages")
    public ResponseEntity<List<BookModel>> getBookByLanguages(@RequestBody List<String> languages) {
        List<BookModel> books = service.getBookByLanguages(languages);
        return ResponseEntity.ok(books);
    }

    @PostMapping
    public ResponseEntity<BookModel> createBook(@RequestBody BookModel books){
        BookModel createdBook = service.addBooks(books);
        return ResponseEntity.ok(createdBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookModel> updateBook(@PathVariable int id, @RequestBody BookModel books){
        books.setId(id);
        BookModel updatesBook = service.updateBook(books);
        return ResponseEntity.ok(updatesBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id){
        service.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
