package springdata.demo_book.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springdata.demo_book.dto.request.BookDto;
import springdata.demo_book.model.Book;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponse {

    List<BookDto> bookDtoResponseList = new ArrayList();
    List<Book> books;
}
