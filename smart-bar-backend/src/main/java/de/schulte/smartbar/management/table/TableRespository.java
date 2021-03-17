package de.schulte.smartbar.management.table;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import de.schulte.smartbar.Repository;

@Component
public class TableRespository extends Repository<Table> {

    public TableRespository() {
        super("smartbar.sm_table");
    }

    public Table save(Table table) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        if (table.getId() != null) {
            template.update("update smartbar.sm_table set name=?, seat_count=? where ID=?", table.getName(),
                    table.getSeatCount(), table.getId());
            return table;
        }
        final long id = getNextId();
        template.update("insert into smartbar.sm_table (id, name, seat_count) values (?,?,?)", id, table.getName(),
                table.getSeatCount());
        table.setId(id);
        return table;
    }

    @Override
    protected RowMapper<Table> getRowMapper() {
        return new TableRowMapper();
    }

    @Override
    protected Class<Table> getManagedClass() {
        return Table.class;
    }
}
