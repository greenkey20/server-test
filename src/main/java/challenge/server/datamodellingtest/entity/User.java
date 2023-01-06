package challenge.server.datamodellingtest.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "USERS")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    private String email;

    @Column
    private Boolean isBlackList;

    @Column
    private String password;

    @Column
    private Integer reportedCount;

    @Column
    private String status;

    @Column
    private String username;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserHabit> userHabits;

}
