package com.taeyoung.board.entity.primaryKey;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class LikyPk implements Serializable {
    
    // db이름과 같게 지어줘야함
    @Column(name = "user_email")
    private String  userEmail;

    @Column(name = "board_number")
    private int     boardNumber;
}
