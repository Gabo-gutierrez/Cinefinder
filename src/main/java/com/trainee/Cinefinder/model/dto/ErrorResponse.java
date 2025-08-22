package com.trainee.Cinefinder.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
    private String type;
    private String code;
    private String details;
    private String location;
    private String moreInfo;
    private LocalDateTime timestamp;

    public String getType() {return "error";}
}
