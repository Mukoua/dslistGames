package com.anderson.dslist.DTO;

import com.anderson.dslist.entities.Game;
import com.anderson.dslist.projections.GameMinProjections;

public class GameMinDTO {

    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;


    public GameMinDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getGameYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public GameMinDTO(Game entity) {
        id = entity.getId();
        title = entity.getTitle();
        year = entity.getGameYear();
        imgUrl = entity.getImgUrl();
        shortDescription = entity.getShortDescription();
    }
    public GameMinDTO(GameMinProjections projections) {
        id = projections.getId();
        title = projections.getTitle();
        year = projections.getGameYear();
        imgUrl = projections.getImgUrl();
        shortDescription = projections.getShortDescription();
    }
}
