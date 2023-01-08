package challenge.server.datamodellingtest.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @Enumerated(EnumType.STRING)
    private ReportType reportType;

    @ManyToOne
    @JoinColumn(name = "habitId")
    private Habit habit;

    @ManyToOne
    @JoinColumn(name = "authId")
    private Auth auth;

    @ManyToOne
    @JoinColumn(name = "reviewId")
    private Review review;

    public Long getHabitId() {
        return this.habit.getHabitId();
    }

    public Long getAuthId() {
        return this.auth.getAuthId();
    }

    public Long getReviewId() {
        return this.review.getReviewId();
    }

    public enum ReportType {
        HATEFUL(1, "욕설"),
        SEXUAL(2, "선정적"),
        SPAM(3, "광고"),
        VIOLENT(4, "폭력적");

        @Getter
        private Integer typeNumber;

        @Getter
        private String description;

        ReportType(Integer typeNumber, String description) {
            this.typeNumber = typeNumber;
            this.description = description;
        }
    }
}
