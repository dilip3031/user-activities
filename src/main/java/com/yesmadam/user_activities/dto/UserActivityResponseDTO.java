package com.yesmadam.user_activities.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserActivityResponseDTO {
    public String name;
    public String email;
    public String number;
    public List<DetailDTO> details;
}