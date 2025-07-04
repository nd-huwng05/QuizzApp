/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huwng05.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author admin
 */
@Getter
@Setter
public class Level {
    private int id;
    private String name;
    private String note;
    public Level(int id, String name, String note) {
        this.id = id;
        this.name = name;
        this.note = note;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
