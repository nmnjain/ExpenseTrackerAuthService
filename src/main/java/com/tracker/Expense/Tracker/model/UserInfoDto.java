package com.tracker.Expense.Tracker.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.tracker.Expense.Tracker.entities.UserInfo;

import io.micrometer.common.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

public class UserInfoDto extends UserInfo

{
    @NonNull
    private String firstName;


    @NonNull
    private String lastName;
    @NonNull
    private Long phoneNumber;
    @NonNull
    private String email;
}
