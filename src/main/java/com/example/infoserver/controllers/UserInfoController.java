package com.example.infoserver.controllers;


import com.example.infoserver.exception.ResourceNotFoundException;
import com.example.infoserver.models.UserInfoModel;
import com.example.infoserver.models.request.UserInfoRequest;
import com.example.infoserver.models.response.UserInfoResponseList;
import com.example.infoserver.services.UserInfoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

//    @Autowired
//    public UserInfoController(@Autowired  UserInfoService userInfoService) {
//        this.userInfoService = userInfoService;
//    }

    @ApiOperation(value = "returns the top 20 user results at all levels in descending order result, level_id")
    @GetMapping("/userinfo/{user_id}")
    public ResponseEntity<UserInfoResponseList> getUserById(
            @ApiParam(value = "User id from which user object will retrieve", required = true) @PathVariable(value = "user_id") int userId) {
        UserInfoResponseList userInfoResponseList = userInfoService.getUsersByUserId(userId);
        return ResponseEntity.ok().body(userInfoResponseList);
    }

    @ApiOperation(value = "Get the top 20 users and their results by the selected level in descending order result, user_id")
    @GetMapping("/levelinfo/{level_id}")
    public ResponseEntity<UserInfoResponseList> getUserByLevelId(
            @ApiParam(value = "Level id from which user object will retrieve", required = true) @PathVariable(value = "level_id") int levelId) {
        UserInfoResponseList userInfoResponseList = userInfoService.getUsersByLevelId(levelId);
        return ResponseEntity.ok().body(userInfoResponseList);
    }

    @ApiOperation(value = "Set users result by the level")
    @PutMapping("/setinfo/{id}")
    public ResponseEntity <UserInfoModel> updateEmployee(
            @PathVariable(value = "id") int id,
            @ApiParam(value = "Update users  object", required = true) @Valid @RequestBody UserInfoRequest userInfoRequest) throws ResourceNotFoundException {

        UserInfoModel userInfoModel = userInfoService.updateUsersInfo(userInfoRequest,id);
        return ResponseEntity.ok().body(userInfoModel);
    }

}
