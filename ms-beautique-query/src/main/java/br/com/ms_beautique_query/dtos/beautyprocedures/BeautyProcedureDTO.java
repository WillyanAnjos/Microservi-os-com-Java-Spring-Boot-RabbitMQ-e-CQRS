package br.com.ms_beautique_query.dtos.beautyprocedures;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "beautyprocedures")
public class BeautyProcedureDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
