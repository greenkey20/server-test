package challenge.server.datamodellingtest.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

//    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
//    private List<Habit> habits;
}
