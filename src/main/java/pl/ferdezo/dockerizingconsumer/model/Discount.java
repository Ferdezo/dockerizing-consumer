package pl.ferdezo.dockerizingconsumer.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Discount implements Identifiable {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private BigDecimal oldPrice;
}
