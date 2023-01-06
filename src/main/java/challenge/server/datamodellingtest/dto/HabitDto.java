package challenge.server.datamodellingtest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class HabitDto {
    @Getter
    @AllArgsConstructor
    public static class Response {
        private Long habitId;
    }
}
