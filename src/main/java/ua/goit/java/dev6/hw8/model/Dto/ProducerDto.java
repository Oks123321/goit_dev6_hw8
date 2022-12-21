package ua.goit.java.dev6.hw8.model.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProducerDto {

    private UUID id;

    @NotBlank(message = "Name can't be blank")
    @Size(max = 250)
    private String name;

    @Override
    public String toString() {
        return id + "," + name;
    }
}
