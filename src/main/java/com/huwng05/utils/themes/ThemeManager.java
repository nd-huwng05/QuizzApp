/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huwng05.utils.themes;

import com.huwng05.quizzapp.App;
import javafx.scene.Scene;

/**
 *
 * @author admin
 */
public class ThemeManager {
    private static ThemesFactory themeFactory = new DefaultThemeFactory();

    /**
     * @param aThemeFactory the themeFactory to set
     */
    public static void setThemeFactory(ThemesFactory aThemeFactory) {
        themeFactory = aThemeFactory;
    }
    
    public static void applyTheme(Scene scene) {
        scene.getRoot().getStylesheets().clear();
        scene.getRoot().getStylesheets().add(themeFactory.getStyleSheet());
        
    }
}
