package challenge.server.datamodellingtest.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AuthReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authReportId;

//    @ManyToOne
//    @JoinColumn(name = "authId")
//    private Auth auth;

}
