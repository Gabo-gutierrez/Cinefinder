package com.trainee.Cinefinder.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SuccessResponse {
    private String type;
    private String code;
    private String details;
    private String location;
    private LocalDateTime timestamp;

    public String getCode() {
        return String.valueOf(HttpStatus.OK.value());
    }

    public LocalDateTime getTimestamp() {
        return LocalDateTime.now();
    }

    public String getType() {return "Success";}
}
