package com.yesmadam.user_activities.constants;

public class QueryConstants {
    public static final String USER_ACTIVITY_FILTER_QUERY = """ 
             SELECT u From UserActivity  u
             where (:userId IS NULL  OR u.userId=:userId ) 
             and (:userAction IS NULL  OR u.userAction=:userAction )
            """;
    public static final String USER_ACTIVITY_FILTER_COUNT_QUERY = """ 
            SELECT COUNT(u) From UserActivity  u
            where (:userId IS NULL  OR u.userId=:userId ) 
            and  (:userAction IS NULL  OR u.userAction=:userAction )
            """;
}
