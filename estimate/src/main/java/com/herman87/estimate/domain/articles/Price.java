package com.herman87.estimate.domain.articles;


import com.herman87.estimate.domain.common.Money;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class Price {

    @Column(name = "c_value")
    private double value;

    @Enumerated(EnumType.STRING)
    @Column(name = "c_money")
    private Money money;
}
