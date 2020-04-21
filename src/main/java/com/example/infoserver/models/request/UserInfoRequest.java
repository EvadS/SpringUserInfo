package com.example.infoserver.models.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInfoRequest {

    private int user_id;
    private int level_id;
    private int result;
}
