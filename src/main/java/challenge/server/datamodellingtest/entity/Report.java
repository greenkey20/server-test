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
}
