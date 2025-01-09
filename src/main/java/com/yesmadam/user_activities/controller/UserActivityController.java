package com.yesmadam.user_activities.controller;

import com.yesmadam.user_activities.constants.UserAction;
import com.yesmadam.user_activities.dto.UserActivityResponseDTO;
import com.yesmadam.user_activities.service.UserActivityService;
import com.yesmadam.user_activities.util.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserActivityController {

    @Autowired
    private UserActivityService userActivityService;

    @GetMapping("/actions")
    public ResponseEntity<?> getUserActions(
            @RequestParam(value = "userId", required = false) Long userId,
            @RequestParam(value = "userAction", required = false) UserAction userAction,
            @RequestParam(value = "limit", defaultValue = "10") Integer limit,
            @RequestParam(value = "sortingOrder", defaultValue = "desc") String sortingOrder,
            @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo) throws BusinessException {
        UserActivityResponseDTO response = userActivityService.getUserActivities(userId, userAction, limit, pageNo, sortingOrder);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/count/actions")
    public ResponseEntity<?> getUserActionsCount(@RequestParam(required = false) Long userId, @RequestParam(required = false) UserAction userAction) {
        // Fetch user activity details with pagination
        Long response = userActivityService.getUserActionsCount(userId, userAction);
        return ResponseEntity.ok(response);
    }
}
