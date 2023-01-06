package challenge.server.datamodellingtest.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authId;

    @ManyToOne
    @JoinColumn(name = "userHabitId")
    private UserHabit userHabit;

    @OneToMany(mappedBy = "auth", cascade = CascadeType.ALL)
    private List<Report> reports;

//    @OneToMany(mappedBy = "auth", cascade = CascadeType.ALL)
//    private List<AuthReport> authReports;
}
