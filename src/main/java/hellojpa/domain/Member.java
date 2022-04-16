package hellojpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name="USERNAME")
    private String username;

//    @Column(name="TEAM_ID")
//    private Long teamId;

//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="TEAM_ID")
//    private Team team;

    //주소
    @Embedded
    private Address homeAddress;
}
