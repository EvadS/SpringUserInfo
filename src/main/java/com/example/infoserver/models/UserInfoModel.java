package com.example.infoserver.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class UserInfoModel {
    private int user_id;
    private  int level_id;
    private int result;


}
