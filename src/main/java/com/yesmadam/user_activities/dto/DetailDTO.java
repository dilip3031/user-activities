package com.yesmadam.user_activities.dto;

import com.yesmadam.user_activities.constants.UserAction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailDTO {
    private String userDevice;
    private Timestamp logInTime;
    private UserAction userAction;

}
