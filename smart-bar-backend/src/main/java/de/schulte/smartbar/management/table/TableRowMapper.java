package de.schulte.smartbar.management.table;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TableRowMapper implements RowMapper<Table> {

    @Override
    public Table mapRow(ResultSet rs, int rowNum) throws SQLException {
        Table table = new Table();
        table.setId(rs.getLong("id"));
        table.setName(rs.getString("name"));
        table.setSeatCount(rs.getInt("seat_count"));
        return table;
    }

}
