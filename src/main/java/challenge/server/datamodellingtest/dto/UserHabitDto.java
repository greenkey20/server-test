package challenge.server.datamodellingtest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class UserHabitDto {
    @Getter
    @AllArgsConstructor
    public static class Response {
        private Long userHabitId;
        private Long userId;
        private Long habitId;
    }
}
