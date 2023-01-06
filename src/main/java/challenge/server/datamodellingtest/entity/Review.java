package challenge.server.datamodellingtest.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @Column
    private Integer score;

    @Column
    private String body;

    @OneToOne
    @JoinColumn(name = "USER_HABIT_ID")
    private UserHabit userHabit;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<Report> reports;

//    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
//    private List<ReviewReport> reviewReports;

    public Long getHabitId() {
        return this.userHabit.getHabitId();
    }

    public Long getUserId() {
        return this.userHabit.getUserId();
    }
}
