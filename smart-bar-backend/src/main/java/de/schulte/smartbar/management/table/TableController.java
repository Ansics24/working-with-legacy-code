package de.schulte.smartbar.management.table;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/tables")
public class TableController {

    @Autowired
    private TableService tableService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<TableDto> createTable(@RequestBody TableDto tableDto) {
        final TableDto resultingDto = tableService.saveTable(tableDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(resultingDto);
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<TableDto> updateTable(TableDto tableDto) {
        final TableDto resultingDto = tableService.saveTable(tableDto);
        return ResponseEntity.ok(resultingDto);
    }

    @GetMapping
    public ResponseEntity<List<TableDto>> list() {
        return ResponseEntity.ok(tableService.listAll());
    }

}
