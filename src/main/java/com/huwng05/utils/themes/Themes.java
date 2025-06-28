/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huwng05.utils.themes;

import javafx.scene.Scene;

/**
 *
 * @author admin
 */
public enum Themes {
    DARK {
        @Override
        public void updateThemes(Scene scene) {
            ThemeManager.setThemeFactory(new DarkThemeFactory());
            ThemeManager.applyTheme(scene);
        }
    }, LIGHT {
        @Override
        public void updateThemes(Scene scene) {
            ThemeManager.setThemeFactory(new LightThemeFactory());
            ThemeManager.applyTheme(scene);
        }
    }, DEFAULT {
        @Override
        public void updateThemes(Scene scene) {
            ThemeManager.setThemeFactory(new DefaultThemeFactory());
            ThemeManager.applyTheme(scene);
        }
    };
    public abstract void updateThemes(Scene scene);
}
