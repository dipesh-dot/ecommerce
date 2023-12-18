package com.productservice.generic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomResponseMessage {
    private HttpStatus status;
    private Object data;
    private String message;
}
