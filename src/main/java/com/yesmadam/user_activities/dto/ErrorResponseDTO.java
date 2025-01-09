package com.yesmadam.user_activities.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class ErrorResponseDTO {
    private String errorCode;
    private String message;
}
