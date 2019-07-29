package search.tranning.tranning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import search.tranning.tranning.model.People;
import search.tranning.tranning.repositories.mapper.PeopleRowMapper;

@RestController
public class SearchController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/search")
    public ResponseEntity<Object> searchName(@RequestParam String name) {
//        https://www.concretepage.com/spring-boot/spring-boot-jdbc-example
        String sql = new StringBuilder().append("SELECT * FROM `people` WHERE people.name LIKE \"%")
                .append(name)
                .append("%\" limit 100")
                .toString();
        RowMapper<People> rowMapper = new PeopleRowMapper();
        return ResponseEntity.ok(jdbcTemplate.query(sql, rowMapper));
    }
}
