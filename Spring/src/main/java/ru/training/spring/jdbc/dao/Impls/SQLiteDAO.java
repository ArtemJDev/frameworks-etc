package ru.training.spring.jdbc.dao.Impls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import ru.javabegin.training.spring.dao.interfaces.MP3Dao;
import ru.javabegin.training.spring.dao.objects.MP3;

@Component("sqliteDAO")
public class SQLiteDAO implements MP3Dao {

  private SimpleJdbcInsert insertMP3;

//  private JdbcTemplate jdbcTemplate;
  private NamedParameterJdbcTemplate jdbcTemplate;

  private DataSource dataSource;

  @Autowired
  public void setDataSource(DataSource  dataSource) {
    this.dataSource = dataSource;
    this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    this.insertMP3 = new SimpleJdbcInsert(dataSource).withTableName("mp3").usingColumns("name", "author");
  }

  public int insert(MP3 mp3) {
//    String sql = "insert into mp3(name,author) values(?,?)";
//      String sql = "insert into mp3(name,author) VALUES (:name, :author)";
//    KeyHolder keyHolder = new GeneratedKeyHolder();
    MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("name", mp3.getName());
    parameterSource.addValue("author", mp3.getAuthor());
//    jdbcTemplate.update(sql,parameterSource, keyHolder);
    return insertMP3.execute(parameterSource);
    //если надо возвратить id всталенный
//    jdbcTemplate.update(sql, new Object[]{mp3.getName(), mp3.getAuthor()});
  }

  //массовая вставка
  public int batchInsert(List<MP3> listMP3) {
    String sql = "Insert into mp3(name, author) values(:name, :author)";

    //или так чтобы не спутать места
    SqlParameterSource[] params = new SqlParameterSource[listMP3.size()];
    for (int i = 0; i < listMP3.size(); i++) {
      MapSqlParameterSource p = new MapSqlParameterSource();
      p.addValue("name", listMP3.get(i).getName());
      p.addValue("author",listMP3.get(i).getAuthor());
      params[i] = p;
    }

    //объъявлеям параметерSQL масмв
//    SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(listMP3.toArray());
    int[] updateCounts = jdbcTemplate.batchUpdate(sql, params);
    return updateCounts.length;
  }


  public void insert(List<MP3> mp3) {
    for(MP3 mp31 : mp3) {
      insert(mp31);
    }
  }


  public void insertWithJDBC(MP3 mp3) {
    Connection conn = null;
    try {
      Class.forName("org.sqlite.JDBC");
      String url = "jdbc:sqlite:db/SpringDB.db";
      conn = DriverManager.getConnection(url, "", "");
    } catch (ClassNotFoundException e1) {
      e1.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    String sql = "insert into mp3 (name, author) VALUES (?, ?)";
    try {
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, mp3.getName());
      ps.setString(2, mp3.getAuthor());
      ps.executeUpdate();
      ps.close();

    } catch (SQLException e) {
      e.printStackTrace();

    } finally {
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
        }
      }
    }
  }

  public Map<String, Integer> getStat() {
    String sql = "select author,count(*) as count from mp3 group by author";

    return jdbcTemplate.query(sql, new ResultSetExtractor<Map<String, Integer>>() {

      public Map<String, Integer> extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        Map<String, Integer> map = new TreeMap<String, Integer>();

        while(resultSet.next()) {
          String author = resultSet.getString("author");
          int count = resultSet.getInt("count");
          map.put(author, count);
        }
        return map;
      }    });
  }

  public void delete(int id) {
//  String sql = "delete from mp3 where id=?";
  String sql = "delete from mp3 where id=:id";
  MapSqlParameterSource parameterSource = new MapSqlParameterSource();
  parameterSource.addValue("id", id);

//  int result = jdbcTemplate.update(sql,id);
  int result = jdbcTemplate.update(sql,parameterSource);
  }

  public void delete(MP3 mp3) {
    delete(mp3.getId());
  }

  public MP3 getMP3ByID(int id) {
    String sql = "select * FROM mp3 where id=:id";
    MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("id", id);
    return jdbcTemplate.queryForObject(sql, parameterSource, new MP3RowMapper());
  }

  public List<MP3> getMP3ListByName(String name) {
    String sql = "select * FROM mp3 where UPPER(name) like :name";
    MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("name", "%" + name.toUpperCase() + "%");
    return jdbcTemplate.query(sql, parameterSource, new MP3RowMapper());
  }

  public List<MP3> getMP3ListByAuthor(String author) {
    String sql = "select * FROM mp3 where upper(author) like :author";
    MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("author", "%" + author.toUpperCase() + "%");
    return jdbcTemplate.query(sql, parameterSource, new MP3RowMapper());
  }

  public int getMP3Count() {
    String sql = " SELECT * FROM mp3";
    return jdbcTemplate.getJdbcOperations().queryForObject(sql, Integer.class);
  }



  private static final class MP3RowMapper implements RowMapper<MP3> {
    public MP3 mapRow(ResultSet resultSet, int i) throws SQLException {
      MP3 mp3 = new MP3();
      mp3.setId(resultSet.getInt("id"));
      mp3.setName(resultSet.getString("name"));
      mp3.setAuthor(resultSet.getString("author"));
      return mp3;
    }
  }



}
