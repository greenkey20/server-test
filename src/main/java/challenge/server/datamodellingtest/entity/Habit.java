package challenge.server.datamodellingtest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Habit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long habitId;

    @OneToMany(mappedBy = "habit", cascade = CascadeType.ALL)
    private List<UserHabit> userHabits;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    @JsonIgnore
    private Category category;

    @OneToMany(mappedBy = "habit", cascade = CascadeType.ALL)
    private List<Report> reports;

    // 양방향 매핑으로 해두었을 때 순환참조로 인해 stack overflow 발생해서 주석 처리해둠
//    @OneToMany(mappedBy = "habit", cascade = CascadeType.ALL)
//    private List<HabitReport> habitReports;

    public Long getCategoryId() {
        return this.category.getCategoryId();
    }
}
