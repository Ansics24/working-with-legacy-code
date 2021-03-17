package de.schulte.smartbar;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public abstract class Repository<T extends Entity> {

    private final AtomicLong nextId;

    protected PGSimpleDataSource dataSource;

    private String schemaAndTable;

    public Repository(String schemaAndTable) {
        this.schemaAndTable = schemaAndTable;
        nextId = new AtomicLong();

        dataSource = new PGSimpleDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUser("admin");
        dataSource.setPassword("admin");

        new JdbcTemplate(dataSource).query("select max(ID) as MAXID from " + schemaAndTable, rs -> {
            nextId.set(rs.getLong("MAXID"));
        });
    }

    public List<T> listAll() {
        return new JdbcTemplate(dataSource).query("select * from " + schemaAndTable, getRowMapper());
    }

    protected abstract RowMapper<T> getRowMapper();

    protected long getNextId() {
        nextId.set(nextId.get() + 1);
        return nextId.get();
    }

    protected abstract Class<T> getManagedClass();

}
