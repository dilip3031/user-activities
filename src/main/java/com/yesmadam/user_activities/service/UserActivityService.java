package com.yesmadam.user_activities.service;

import com.yesmadam.user_activities.constants.UserAction;
import com.yesmadam.user_activities.dto.DetailDTO;
import com.yesmadam.user_activities.dto.UserActivityResponseDTO;
import com.yesmadam.user_activities.entitys.User;
import com.yesmadam.user_activities.entitys.UserActivity;
import com.yesmadam.user_activities.helper.UserActivityHelper;
import com.yesmadam.user_activities.repository.UserActivityRepository;
import com.yesmadam.user_activities.repository.UserRepository;
import com.yesmadam.user_activities.util.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserActivityService {

    @Autowired
    private UserActivityRepository userActivityRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserActivityHelper userActivityHelper;

    public UserActivityResponseDTO getUserActivities(Long userId, UserAction userAction, Integer limit, Integer pageNo, String sortingOrder) throws BusinessException {
        log.info("Requesting for UserActivity by userId: {} userAction: {}", userId, userAction);
        Optional<User> byUserId = userRepository.findByUserId(userId);
        userActivityHelper.validateUserInfo(byUserId, userId);
        pageNo = (pageNo < 1) ? 1 : pageNo;
        Pageable pageable = PageRequest.of(pageNo - 1, limit, sortingOrder.equals("desc") ? Sort.by("logInTime").descending() : Sort.by("logInTime").ascending());
        List<UserActivity> byUserAndUserAction = userActivityRepository.findByUserAndUserAction(userId, userAction, pageable);
        List<DetailDTO> detailDTOS = byUserAndUserAction.stream().map(userActivityHelper::getDetailDTO).toList();
        return userActivityHelper.getUserActivityResponseDTO(byUserId, detailDTOS);

    }

    public Long getUserActionsCount(Long userId, UserAction userAction) {
        log.info("Requesting for UserActivity  Count by userId: {} userAction: {}", userId, userAction);
        return userActivityRepository.countByUserAndUserAction(userId, userAction);
    }
}

