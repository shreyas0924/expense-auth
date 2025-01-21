package com.expense.auth.model;

import com.expense.auth.entities.UserInfo;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;


@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserInfoDto extends UserInfo {
     
     private String firstName;
     private String lastName;
     private Long phoneNumber;
     private String email;
}

