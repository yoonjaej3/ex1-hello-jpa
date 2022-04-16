package hellojpa.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
@AllArgsConstructor
@Getter
public class Address {

    private String city;
    private String street;

    @Column(name="ZIPCODE")
    private String zipcode;
}
