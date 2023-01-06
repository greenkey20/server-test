package challenge.server.datamodellingtest.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserHabit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userHabitId;

    @Column
    private String status;

    @Column
    private Integer wildCard;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "habitId")
    private Habit habit;

    @OneToMany(mappedBy = "userHabit", cascade = CascadeType.ALL)
    private List<Auth> auths;

    @OneToOne(mappedBy = "userHabit", cascade = CascadeType.ALL)
    private Review review;

    public Long getHabitId() {
        return this.habit.getHabitId();
    }

    public Long getUserId() {
        return this.user.getUserId();
    }
}
