package challenge.server.datamodellingtest.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HabitReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long habitReportId;

//    @ManyToOne
//    @JoinColumn(name = "habitId")
//    private Habit habit;
}
