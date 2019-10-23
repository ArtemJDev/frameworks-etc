package ru.training.spring.jdbc.daoimprove.test_transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import ru.training.spring.jdbc.daoimprove.objects.Author;


@Component("sqliteDAO")
public class TransTest implements MP3Dao {

	private static final String mp3Table = "mp3";
	private static final String mp3View = "mp3_view";

	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public int insertMp3(MP3 mp3) {

		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());

		int author_id = insertAuthor(mp3.getAuthor());

		//неверное имя поля authorid
		String sqlInsertMP3 = "insert into mp3(author_id, name) VALUES (:authorId, :mp3Name)";

		MapSqlParameterSource params = new MapSqlParameterSource();

		params = new MapSqlParameterSource();
		params.addValue("mp3Name", mp3.getName());
		params.addValue("authorId", author_id);

		return  jdbcTemplate.update(sqlInsertMP3, params);

	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insertAuthor(Author author) {
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());

		String sqlInsertMP3 = "insert into author(name) VALUES (:authorName)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("authorName", author.getName());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(sqlInsertMP3, params, keyHolder);
		return keyHolder.getKey().intValue();



	}



}
