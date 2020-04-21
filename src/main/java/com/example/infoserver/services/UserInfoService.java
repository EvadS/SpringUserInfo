package com.example.infoserver.services;

import com.example.infoserver.exception.ResourceNotFoundException;
import com.example.infoserver.models.UserInfoModel;
import com.example.infoserver.models.request.UserInfoRequest;
import com.example.infoserver.models.response.UserInfoResponseList;


public interface UserInfoService {
    UserInfoResponseList getUsersByLevelId(int levelId);

    UserInfoModel updateUsersInfo(UserInfoRequest userInfoRequest, int id) throws ResourceNotFoundException;

    UserInfoResponseList getUsersByUserId(int userId);
}
