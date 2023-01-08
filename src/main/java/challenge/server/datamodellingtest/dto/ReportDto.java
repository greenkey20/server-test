package challenge.server.datamodellingtest.dto;

import challenge.server.datamodellingtest.entity.Report;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class ReportDto {
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Response {
        private Long reportId;
        private Long userId; // 신고자
        private Long habitId;
        private Long authId;
        private Long reviewId;
        private Report.ReportType reportType;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class CountResponse {
        private String reportType;
        private Long count;
    }
}
