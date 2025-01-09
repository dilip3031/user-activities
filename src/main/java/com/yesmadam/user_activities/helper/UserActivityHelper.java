package com.yesmadam.user_activities.helper;

import com.yesmadam.user_activities.constants.ErrorMessageCodeConstante;
import com.yesmadam.user_activities.dto.DetailDTO;
import com.yesmadam.user_activities.dto.UserActivityResponseDTO;
import com.yesmadam.user_activities.entitys.User;
import com.yesmadam.user_activities.entitys.UserActivity;
import com.yesmadam.user_activities.util.BusinessException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserActivityHelper {
    public DetailDTO getDetailDTO(UserActivity userActivity) {
        return DetailDTO.builder().userAction(userActivity.getUserAction()).userDevice(userActivity.getUserDevice()).logInTime(userActivity.getLogInTime()).build();
    }

    public UserActivityResponseDTO getUserActivityResponseDTO(Optional<User> byUserId, List<DetailDTO> detailDTOS) {
        if (byUserId.isPresent()) {
            User user = byUserId.get();
            return UserActivityResponseDTO.builder().details(detailDTOS).email(user.getEmail()).name(user.getUserName()).number(user.getNumber()).build();
        } else {
            return UserActivityResponseDTO.builder().details(detailDTOS).email("N/A").name("N/A").number("N/A").build();
        }
    }

    public void validateUserInfo(Optional<User> byUserId, Long userId) throws BusinessException {
        if (userId != null) {
            if (!byUserId.isPresent()) {
                throw new BusinessException(ErrorMessageCodeConstante.NOT_FOUND);
            }
        }
    }
}
