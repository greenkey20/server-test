package challenge.server.datamodellingtest.dto;

import challenge.server.datamodellingtest.entity.UserHabit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class ReviewDto {
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Response {
        private Long reviewId;
        private Integer score;
        private String body;
        private Long habitId;
        private Long userId;
    }
}
