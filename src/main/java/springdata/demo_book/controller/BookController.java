package springdata.demo_book.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springdata.demo_book.dto.request.BookDto;
import springdata.demo_book.dto.response.BookResponse;
import springdata.demo_book.services.BookService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/add")
    public void addBook(@RequestBody BookDto bookDto){
         bookService.add(bookDto);
    }

    @GetMapping("/getAll")
    public BookResponse getBookAll(){
        return bookService.bookResponse();
    }

    @GetMapping("/getById/{id}")
    public BookDto getById(@PathVariable("id") Long id){
        return bookService.getBookId(id);
    }

    @PostMapping("/update/{id}")
    public void update(BookDto bookDto, @PathVariable("id") Long id){
        bookService.edit(bookDto,id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        bookService.delete(id);
    }
}
