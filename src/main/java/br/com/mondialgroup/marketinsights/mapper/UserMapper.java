package br.com.mondialgroup.marketinsights.mapper;

import br.com.mondialgroup.marketinsights.dto.request.UserRequest;
import br.com.mondialgroup.marketinsights.dto.response.UserResponse;
import br.com.mondialgroup.marketinsights.model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static User toUser(UserRequest request) {
        return User.builder()
                .username(request.username())
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .build();
    }

    public static UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
