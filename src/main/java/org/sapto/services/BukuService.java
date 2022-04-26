package org.sapto.services;
import java.util.List;
import org.sapto.model.Buku;
import org.sapto.model.Publisher;
import org.sapto.model.Author;

import java.sql.SQLException;

public interface BukuService {
    Buku getDataBuku(int id) throws SQLException;

    List<Buku> getDataBukuAll() throws SQLException;

    List<Publisher> getPublisherAll() throws SQLException;

    Integer simpanPublisher(Publisher publisher);

    Publisher getPublisher(Integer id);

    Author getAuthor(Integer id);

    List<Author> getAuthorAll() throws SQLException;

    Author getAuthorAll(Integer id);

    Integer simpanAuthor(Author author);

}
