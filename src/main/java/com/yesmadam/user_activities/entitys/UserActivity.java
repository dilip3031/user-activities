package com.yesmadam.user_activities.entitys;

import com.yesmadam.user_activities.constants.UserAction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "user_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private String userDevice;
    private Timestamp logInTime;
    private Integer userActionCode;

    @Enumerated(EnumType.STRING)
    private UserAction userAction;

}