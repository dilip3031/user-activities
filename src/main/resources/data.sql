create table user_activities.users
(
    user_id     bigint       not null
        primary key,
    email       varchar(255) null,
    number      varchar(255) null,
    postal_code varchar(255) null,
    status      varchar(255) null,
    user_image  varchar(255) null,
    user_name   varchar(255) null
);

create table user_activities.user_details
(
    id               bigint                                                                                                           not null
        primary key,
    log_in_time      datetime(6)                                                                                                      null,
    user_action      enum ('ADDRESS_CHANGE', 'APP_CRASH', 'APP_UPDATE', 'CANCEL', 'LOGIN', 'ORDER_CREATION', 'ORDER_FAIL', 'PENDING') null,
    user_action_code int                                                                                                              null,
    user_device      varchar(255)                                                                                                     null,
    user_id          bigint                                                                                                           null,
    constraint FKicouhgavvmiiohc28mgk0kuj5
        foreign key (user_id) references user_activities.users (user_id)
);


INSERT INTO user_activities.users (user_id, email, number, postal_code, status, user_image, user_name)
VALUES (1, 'xyz@gmail.com', '0011001100', '110224', 'ACTIVE', null, 'XYZ'),
       (2, 'zxy@gmail.com', '1100110011', '110224', 'ACTIVE', null, 'ZXY');

INSERT INTO user_activities.user_details (id, log_in_time, user_action, user_action_code, user_device, user_id)
VALUES (1, '2025-01-09 10:08:53', 'LOGIN', 1, 'Android', 1),
       (2, '2025-01-09 11:10:01', 'APP_CRASH', 4, 'Android', 1),
       (3, '2025-01-09 12:10:51', 'LOGIN', 2, 'System', 2),
       (4, '2025-01-09 13:10:51', 'ADDRESS_CHANGE', 3, 'System', 2),
       (5, '2025-01-09 14:10:51', 'APP_CRASH', 4, 'Android', 2),
       (6, '2025-01-09 15:10:51', 'APP_UPDATE', 5, 'Android', 1),
       (7, '2025-01-09 16:10:51', 'CANCEL', 6, 'System', 1),
       (8, '2025-01-09 1:10:51', 'ORDER_CREATION', 7, 'System', 1),
       (9, '2025-01-09 12:10:51', 'ORDER_FAIL', 8, 'System', 2),
       (10, '2025-01-09 13:10:51', 'PENDING', 9, 'System', 2),
       (11, '2025-01-09 14:08:53', 'LOGIN', 1, 'Android', 2),
       (12, '2025-01-09 15:10:01', 'APP_CRASH', 4, 'Android', 2),
       (13, '2025-01-09 16:10:51', 'LOGIN', 2, 'System', 1),
       (14, '2025-01-09 01:10:51', 'ADDRESS_CHANGE', 3, 'System', 1),
       (15, '2025-01-09 02:10:51', 'APP_CRASH', 4, 'Android', 1),
       (16, '2025-01-09 03:10:51', 'APP_UPDATE', 5, 'Android', 2),
       (17, '2025-01-09 04:10:51', 'CANCEL', 6, 'System', 2),
       (18, '2025-01-09 16:10:51', 'ORDER_CREATION', 7, 'System', 2),
       (19, '2025-01-09 16:19:51', 'ORDER_FAIL', 8, 'System', 1),
       (20, '2025-01-09 16:12:51', 'PENDING', 9, 'System', 1)
;