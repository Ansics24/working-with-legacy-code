package de.schulte.smartbar.management.category;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import de.schulte.smartbar.Repository;

@Component
public class CategoryRespository extends Repository<Category> {

    public CategoryRespository() {
        super("smartbar.category");
    }

    public Category save(Category category) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        if (category.getId() != null) {
            template.update("update smartbar.category set name=? where ID=?", category.getName(), category.getId());
            return category;
        }
        final long id = getNextId();
        template.update("insert into smartbar.category (id, name) values (?,?)", id, category.getName());
        category.setId(id);
        return category;
    }

    public Category getById(Long id) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        final List<Category> list = template.query("select * from smartbar.category where id=" + id, getRowMapper());
        return list.get(0);
    }

    @Override
    protected RowMapper<Category> getRowMapper() {
        return new CategoryRowMapper();
    }

    @Override
    protected Class<Category> getManagedClass() {
        return Category.class;
    }
}
