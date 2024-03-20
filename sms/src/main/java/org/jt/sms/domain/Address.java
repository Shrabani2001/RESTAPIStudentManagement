package org.jt.sms.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(title = "Address Schema", description = "Address related schema")
public class Address {
    @Schema(example = "bhubaneswar")
    private String city;
    private String state;
    private String country;
}
