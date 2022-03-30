package hellojpa.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="ORDERS")
@Getter
public class Order {

    @Id @GeneratedValue
    @Column(name="order_id")
    private Long id;

    @Column(name="member_id")
    private Long memberId;

   // private Member member;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
