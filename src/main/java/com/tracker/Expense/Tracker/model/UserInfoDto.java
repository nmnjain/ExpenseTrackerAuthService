package com.tracker.Expense.Tracker.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.tracker.Expense.Tracker.entities.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoDto extends UserInfo

{

    private String userName;
    private String lastName;
    private Long phoneNumber;
    private String email;
}
