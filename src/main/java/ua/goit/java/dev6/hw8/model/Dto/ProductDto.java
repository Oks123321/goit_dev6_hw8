package ua.goit.java.dev6.hw8.model.Dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
public class ProductDto {
    private UUID id;

    @NotBlank(message = "Name can't be blank")
    @Size(max = 250)
    private String name;

    @NotNull(message = "Price required")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal price;

    private ProducerDto producer;

    @NotNull(message = "Producer must be select")
    private UUID producerId;


}
