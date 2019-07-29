package search.tranning.tranning.repositories.mapper;

import org.springframework.jdbc.core.RowMapper;
import search.tranning.tranning.model.People;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PeopleRowMapper implements RowMapper<People> {

    @Override
    public People mapRow(ResultSet row, int i) throws SQLException {
        return People.builder()
                .name(row.getString("name"))
                .address(row.getString("address"))
                .phone(row.getString("phone"))
                .note(row.getString("note"))
                .email(row.getString("email"))
                .build();
    }
}
