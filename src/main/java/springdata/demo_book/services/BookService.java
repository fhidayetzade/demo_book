package springdata.demo_book.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import springdata.demo_book.dto.request.BookDto;
import springdata.demo_book.dto.response.BookResponse;
import springdata.demo_book.model.Book;
import springdata.demo_book.repositories.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;


    public void add (BookDto bookDto){
        Book book = new Book();
        BeanUtils.copyProperties(bookDto,book);
        bookRepository.save(book);
    }

    public Long create (BookDto bookDto){
         Book book =Book.builder()
                .author(bookDto.getAuthor())
                .page(bookDto.getPage())
                .build();
         bookRepository.save(book);
         return book.getId();
    }

    public BookResponse bookResponse(){
        List<BookDto> bookDtos = bookRepository.findAll()
                .stream()
                .map(book -> convertBookDto(book))
                .collect(Collectors.toList());
        return BookResponse.builder()
                .bookDtoResponseList(bookDtos)
                .build();
    }

    public BookDto getBookId(Long id){
        return bookRepository
                .findById(id)
                .map(book -> convertBookDto(book))
                .orElseThrow();


    }

    public void edit(BookDto bookDto, Long id) {
        Book book = bookRepository.findById(id).orElseThrow(()->new RuntimeException("Exception Id"));
        book.setAuthor(bookDto.getAuthor());
        book.setPage(bookDto.getPage());
        bookRepository.save(book);

    }

    public void delete(Long id){
        Book book = bookRepository.findById(id)
                        .orElseThrow(()->new RuntimeException("Delete book id"));
        bookRepository.delete(book);
    }

    public BookDto convertBookDto(Book book) {
        BookDto bookDto = BookDto.builder()
                .id(book.getId())
                .author(book.getAuthor())
                .page(book.getPage())
                .build();
        return bookDto;
    }


}
