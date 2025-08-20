package com.anderson.dslist.projections;

import jakarta.persistence.criteria.CriteriaBuilder;

public interface GameMinProjections {

    Long getId();
    String getTitle();
    Integer getYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();
}
