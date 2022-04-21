package org.sapto.services;

import org.sapto.model.Author;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.sapto.model.Buku;
import org.sapto.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BukuImpl implements BukuService {
    private Buku buku;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Buku getDataBuku(int id) throws SQLException {
        return null;
    }


    public List<Buku> getDataBukuAll(int id) throws SQLException {
        String sql = "SELECT book_id, title, isbn13, language_id, num_pages, publication_date, publisher_id\n" +
                "    FROM book where book_id = ?";

        /*String url = "jdbc:postgresql://localhost/bookworm";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "999");
        props.setProperty("ssl", "false");*/
        Connection conn = dataSource.getConnection(); /*DriverManager.getConnection(url, props);*/
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet result = ps.executeQuery();
        Buku buku = new Buku();
        while (result.next()) {
            buku.setJudulBuku(result.getString("title"));
        }
        System.out.println("buku" + buku.getJudulBuku());

        return buku;
    }

    @Override
    public List<Buku> getDataBukuAll() throws SQLException {
       /* String url = "jdbc:postgresql://localhost/gravity_books";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "999");
        props.setProperty("ssl", "false"); */
        Connection conn = dataSource.getConnection(); /*DriverManager.getConnection(url, props);*/
        String sql = "SELECT \n" +
                "\ta.book_id, \n" +
                "\ttitle, \n" +
                "\tisbn13, \n" +
                "\tlanguage_id, \n" +
                "\tnum_pages, \n" +
                "\tpublication_date, \n" +
                "\tpublisher_id, c.author_name as pengarang\n" +
                "from\n" +
                "\t\tbook a\n" +
                "\tleft join book_author b\n" +
                "\tleft join author c on\n" +
                "\tc.author_id = b.author_id\n" +
                "\ton\n" +
                "\tb.book_id = a.book_id";

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        List<Buku> listBuku = new ArrayList<>();
        while (result.next()) {
            Buku buku = new Buku();
            buku.setJudulBuku(result.getString("title"));
            buku.setPengarangBuku(result.getString("pengarang"));
            listBuku.add(buku);
        }
        System.out.println(" ==> " + listBuku.size());
        return listBuku;
    }

    @Override
    public List<Publisher> getPublisherAll() throws SQLException {
        String sql = "SELECT publisher_id, publisher_name FROM publisher";
        /*Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        List<Publisher> lisPulish = new ArrayList<>();
        while (result.next()){
            Publisher publisher = new Publisher();
            publisher.setPublisherId(result.getInt("publisher_id"));
            publisher.setPublishName(result.getString("publisher_name"));
            lisPulish.add(publisher);
        }
        return lisPulish; */
        return namedParameterJdbcTemplate.query(sql, (rs, rn) -> {
            Publisher publisher = new Publisher();
            publisher.setPublisherId(rs.getInt("publisher_id"));
            publisher.setPublishName(rs.getString("publisher_name"));
            return publisher;

        });

    }


    public org.sapto.model.Publisher getPublisherAll(Integer id) {
        return null;
    }

    public Publisher getPublisher(Integer id) {
        String sql = "SELECT publisher_id, publisher_name FROM publisher where publisher_id =:id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        return namedParameterJdbcTemplate.queryForObject(sql, map, (rs, rn) -> {
            Publisher publisher = new Publisher();
            publisher.setPublisherId(rs.getInt("publisher_id"));
            publisher.setPublishName(rs.getString("publisher_name"));
            return publisher;
        });
    }


    public List<Author> getAuthorAll() throws SQLException {
        String sql = "SELECT author_id, author_name FROM author";
        return namedParameterJdbcTemplate.query(sql, (rs, rn) -> {
            Author author = new Author();
            author.setAuthorId(rs.getInt("author_id"));
            author.setAuthorName(rs.getString("author_name"));
            return author;

        });

    }


        public Author getAuthor (Integer id){
            String sql = "SELECT author_id, author_name FROM where author_id =:id";
            MapSqlParameterSource map = new MapSqlParameterSource();
            map.addValue("id", id);
            return namedParameterJdbcTemplate.queryForObject(sql, map, (rs, rn) -> {
                Author author = new Author();
                author.setAuthorId(rs.getInt("author_id"));
                author.setAuthorName(rs.getString("author_name"));
                return author;
            });
        }


    public Integer simpanPublisher(Publisher publisher) {
        String sql = " INSERT INTO publisher (publisher_id, publisher_name)" +
                "VALUES(:publisher_id, :publisher_name)";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("publisher_id", publisher.getPublisherId());
        map.addValue("publisher_name", publisher.getPublishName());
        namedParameterJdbcTemplate.update(sql, map);

        return publisher.getPublisherId();
    }


    public Integer simpanAuthor(Author author){
        String sql = " INSERT INTO public.author(\n" +
                "\tauthor_id, author_name)\n" +
                "\tVALUES (?, ?)";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("author_id",Author.getAuthorId());
        map.addValue("author_name",Author.getAuthorName());
        namedParameterJdbcTemplate.update(sql,map);

        return author.getAuthorId();
    }
}