package com.example.infoserver.services.impl;

import com.example.infoserver.exception.ResourceNotFoundException;
import com.example.infoserver.models.UserInfoModel;
import com.example.infoserver.models.request.UserInfoRequest;
import com.example.infoserver.models.response.UserInfoResponseList;
import com.example.infoserver.services.UserInfoService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    private static final int USER_TOP_COUNT = 20;

    ConcurrentHashMap<Integer, UserInfoModel> userInfoModelMap = new ConcurrentHashMap<Integer, UserInfoModel>();

    {
        Random rnd = new Random(100);
        int userCount = 1;
        for (int i = 0; i < USER_TOP_COUNT + 5; i++) {
            for (int j = 0; j < USER_TOP_COUNT + 5; j++) {
                userInfoModelMap.put(userCount, new UserInfoModel(i, j, rnd.nextInt(100)));
                userCount++;
            }
        }
        int a = 10;
    }

    @Override
    public UserInfoResponseList getUsersByLevelId(int levelId) {
        List<UserInfoModel> userInfoModels = userInfoModelMap.entrySet().stream()
                .filter(p -> p.getValue().getLevel_id() == levelId)
                .map(x -> x.getValue())

                .sorted(Comparator.comparingInt(UserInfoModel::getResult).reversed()
                        .thenComparing(UserInfoModel::getResult).reversed())
                .limit(USER_TOP_COUNT)
                .collect(Collectors.toList());

        return new UserInfoResponseList(userInfoModels);
    }

    @Override
    public UserInfoModel updateUsersInfo(UserInfoRequest userInfoRequest, int id) throws ResourceNotFoundException {

        UserInfoModel userInfoModels = userInfoModelMap.entrySet().stream()
                .filter(p -> p.getKey() == id)
                .map(x -> x.getValue())
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

        userInfoModels.setLevel_id(userInfoRequest.getLevel_id());
        userInfoModels.setUser_id(userInfoRequest.getUser_id());
        userInfoModels.setResult(userInfoRequest.getResult());

        return  userInfoModels;
    }

    @Override
    public UserInfoResponseList getUsersByUserId(int userId) {

        List<UserInfoModel> userInfoModels = userInfoModelMap.entrySet().stream()
                .filter(p -> p.getValue().getUser_id() == userId)
                .map(x -> x.getValue())
                .sorted(Comparator.comparingInt(UserInfoModel::getLevel_id).reversed()
                        .thenComparing(UserInfoModel::getResult).reversed())
                .limit(USER_TOP_COUNT)
                .collect(Collectors.toList());

        return new UserInfoResponseList(userInfoModels);
    }

//    ConcurrentHashMap <Integer, UserInfoModel> userInfoModelMap = new ConcurrentHashMap<Integer, UserInfoModel>(){{
//        put(1 , new UserInfoModel(1,1,31));
//        put(2 ,new UserInfoModel(1,2,32));
//        put(3 ,new UserInfoModel(1,3,33));
//        put(4 ,new UserInfoModel(1,4,34));
//        put(5 ,new UserInfoModel(1,5,35));
//
//        put(6, new UserInfoModel(2,1,31));
//        put(7,new UserInfoModel(2,2,32));
//        put(8,new UserInfoModel(2,3,33));
//        put(9,new UserInfoModel(2,4,4));
//
//        put(10,new UserInfoModel(3,1,40));
//        put(11,new UserInfoModel(3,2,12));
//        put(12,new UserInfoModel(3,3,43));
//        put(13,new UserInfoModel(3,4,10));
//
//        put(14,new UserInfoModel(4,1,440));
//        put(15,new UserInfoModel(4,2,412));
//        put(16,new UserInfoModel(4,3,443));
//        put(17,new UserInfoModel(4,4,410));
//        put(18,new UserInfoModel(4,5,180));
//
//        put(19,new UserInfoModel(5,1,32));
//        put(20,new UserInfoModel(5,2,56));
//        put(21,new UserInfoModel(5,3,74));
//        put(22,new UserInfoModel(5,4,36));
//        put(23,new UserInfoModel(5,5,94));
//
//        put(24,new UserInfoModel(6,1,83));
//        put(25,new UserInfoModel(6,2,14));
//        put(26,new UserInfoModel(6,3,34));
//        put(27,new UserInfoModel(6,4,20));
//        put(28,new UserInfoModel(6,5,25));
//
//    }};
}
