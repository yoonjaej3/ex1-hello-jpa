package hellojpa;

import lombok.*;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name="MEMBER")
@Getter  @Setter
@AllArgsConstructor
@NoArgsConstructor
//@SequenceGenerator(name="member_seq_generator",sequenceName = "member_seq")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable=false)
    private String username;
//    private Integer age;
//
//    @Enumerated(EnumType.STRING)
//    private RoleType roleType;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;
//
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//
//    @Lob
//    private String description;

}
