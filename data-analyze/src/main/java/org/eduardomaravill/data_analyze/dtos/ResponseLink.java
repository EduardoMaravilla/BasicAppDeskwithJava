package org.eduardomaravill.data_analyze.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseLink {
    private Long id;
    private String url;
}
