package br.ultimate_restfull.services;

import br.ultimate_restfull.data.dto.BookDTO;
import br.ultimate_restfull.exception.RequiredObjectIsNullException;
import br.ultimate_restfull.exception.ResourceNotFoundException;
import br.ultimate_restfull.model.Book;
import br.ultimate_restfull.repository.BookRepository;
import static br.ultimate_restfull.mapper.ObjectMapper.parseListObjects;
import static br.ultimate_restfull.mapper.ObjectMapper.parseObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private Logger logger = LoggerFactory.getLogger(BookService.class.getName());

    @Autowired
    BookRepository repository;

    public List<BookDTO> findAllBooks() {
        logger.info("Finding all books!");
        var entityList = parseListObjects(repository.findAll(), BookDTO.class);
        return entityList;
    }

    public BookDTO findById(Long id) {
        logger.info("Finding a book!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found, for this ID"));
        var dto = parseObject(entity, BookDTO.class);

        return dto;
    }

    public BookDTO findByTitle(String title) {
        logger.info("Finding a title!");

        var entityList = repository.findAll();
        var bookFiltred = entityList
                .stream()
                .filter(book -> title.contains(book.getTitle()))
                .findFirst();

        var dto = bookFiltred.map(book -> parseObject(book, BookDTO.class))
                .orElse(null);

        return dto;
    }

    public BookDTO create(BookDTO book) {
        if(book == null) throw new RequiredObjectIsNullException();

        logger.info("Creating a book");

        var entity = parseObject(book, Book.class);
        var dto = parseObject(repository.save(entity), BookDTO.class);

        return dto;
    }

    public BookDTO update(BookDTO book) {
        if(book == null) throw new RequiredObjectIsNullException();

        logger.info("Creating a book");
        var entity = repository.findById(book.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found, for this ID"));

        entity.setTitle(book.getTitle());
        entity.setPrice(book.getPrice());
        entity.setAuthorName(book.getAuthorName());
        entity.setLaunchDate(book.getLaunchDate());

        var dto = parseObject(repository.save(entity), BookDTO.class);

        return dto;
    }

    public void delete(Long id) {
        logger.info("Delete a book");

        Book entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found, for this ID"));
    }

//    private void addHateoasLinks(BookDTO dto) {
//        dto.add(linkTo(methodOn(BookController.class).(dto.getId())).withSelfRel().withType("GET"));
//
//        dto.add(linkTo(methodOn(BookController.class).update(dto)).withRel("findAll").withType("GET"));
//        dto.add(linkTo(methodOn(BookController.class).update(dto)).withRel("create").withType("POST"));
//        dto.add(linkTo(methodOn(BookController.class).update(dto)).withRel("update").withType("PUT"));
//
//        dto.add(linkTo(methodOn(BookController.class).update(dto)).withRel("delete").withType("DELETE"));
//    }
}
