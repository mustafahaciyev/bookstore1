package com.example.bookstore.spec;

import com.example.bookstore.entity.Book;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecificationBuilder {

    public static Specification<Book> buildSpecification(BookSearchCriteria criteria) {
        Specification<Book> spec = Specification.where(null);

        if (criteria.getBookName() != null) {
            spec = spec.and(BookSpecification.hasBookName(criteria.getBookName()));
        }

        if (criteria.getTitle() != null) {
            spec = spec.and(BookSpecification.hasTitle(criteria.getTitle()));
        }

        if (criteria.getCategories() != null) {
            spec = spec.and(BookSpecification.hasCategories(criteria.getCategories()));
        }

        if (criteria.getBookYear() != null) {
            spec = spec.and(BookSpecification.hasBookYear(criteria.getBookYear()));
        }

        if (criteria.getAuthorId() != null) {
            // Burada Author entity'sini kullanarak bir Author nesnesi oluşturabilir ve spec'e ekleyebilirsiniz.
            // Örneğin, AuthorRepository kullanarak authorId'den yazarı alabilirsiniz.
            // Bu örnek sadece bir fikir vermek içindir.
            // spec = spec.and(BookSpecifications.hasAuthor(author));
        }

        return spec;
    }
}
