package com.example.infoserver.models.response;

import com.example.infoserver.models.UserInfoModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserInfoResponseList {
    private List<UserInfoModel> userInfoModels;
    public UserInfoResponseList(List<UserInfoModel> userInfoModels) {
        this.userInfoModels = userInfoModels;
    }
}
