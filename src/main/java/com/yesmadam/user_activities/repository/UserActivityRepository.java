package com.yesmadam.user_activities.repository;

import com.yesmadam.user_activities.constants.UserAction;
import com.yesmadam.user_activities.entitys.UserActivity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import static com.yesmadam.user_activities.constants.QueryConstants.USER_ACTIVITY_FILTER_QUERY;
import static com.yesmadam.user_activities.constants.QueryConstants.USER_ACTIVITY_FILTER_COUNT_QUERY;

import java.util.List;


@Repository
public interface UserActivityRepository extends JpaRepository<UserActivity, Integer> {

    @Query(value =USER_ACTIVITY_FILTER_QUERY, nativeQuery = false)
    List<UserActivity> findByUserAndUserAction(@Param("userId") Long userId, @Param("userAction") UserAction userAction, Pageable pageable);

    @Query(value =USER_ACTIVITY_FILTER_COUNT_QUERY, nativeQuery = false)
    Long countByUserAndUserAction(@Param("userId") Long userId, @Param("userAction") UserAction userAction);
}