package de.schulte.smartbar.management.table;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TableService {

    @Autowired
    private TableRespository tableRespository;

    public TableDto saveTable(TableDto tableDto) {
        final Table table = tableRespository.save(Table.fromDto(tableDto));
        return table.toDto();
    }

    public List<TableDto> listAll() {
        return tableRespository.listAll().stream().map(c ->c.toDto()).collect(Collectors.toList());
    }

}
