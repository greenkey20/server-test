package challenge.server.datamodellingtest.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewReportId;

//    @ManyToOne
//    @JoinColumn(name = "reviewId")
//    private Review review;
}
