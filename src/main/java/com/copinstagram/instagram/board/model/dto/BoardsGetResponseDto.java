package com.copinstagram.instagram.board.model.dto;

import com.copinstagram.instagram.board.model.entity.Board;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class BoardsGetResponseDto {
    private Long id;
    private String author;
    private String content;
    private String modifiedDate;
    private String createdDate;

    public BoardsGetResponseDto(Board entity){
        this.id = entity.getId();
        this.author = entity.getAuthor();
        this.content = entity.getContent();
        this.modifiedDate = toStringDateTime(entity.getModifiedDate());
        this.createdDate = toStringDateTime(entity.getCreatedDate());
    }
    private String toStringDateTime(LocalDateTime localDateTime){
        if(localDateTime == null){
            return "";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return formatter.format(localDateTime);
    }
}
