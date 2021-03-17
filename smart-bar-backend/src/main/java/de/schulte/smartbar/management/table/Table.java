package de.schulte.smartbar.management.table;

import de.schulte.smartbar.Entity;

public class Table extends Entity {

    private String name;
    
    private int seatCount;

    public static Table fromDto(TableDto tableDto) {
        Table table = new Table();
        table.setId(tableDto.getId());
        table.setName(tableDto.getName());
        table.setSeatCount(tableDto.getSeatCount());
        return table;
    }

    public TableDto toDto() {
        TableDto dto = new TableDto();
        dto.setId(getId());
        dto.setName(getName());
        dto.setSeatCount(getSeatCount());
        return dto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }
}
