package com.openrest.v1_1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ColorScheme implements Serializable, Cloneable {
	public static final String THEME_LIGHT = "light";
    public static final String THEME_DARK = "dark";
    
    /** All known themes. */
    public static final Set<String> ALL_THEMES = new HashSet<String>(Arrays.asList(new String[] {
    		THEME_LIGHT, THEME_DARK
    }));

    public ColorScheme(String theme, String background, String font, String border,
            String imageBackground, String imageBorder,
            String buttonFont, String buttonUp, String buttonDown, String buttonOver,
            String categoryFont, String categoryUp, String categoryDown, String categoryOver) {

        this.theme = theme;
        this.background = background;
        this.font = font;
        this.border = border;
        this.imageBackground = imageBackground;
        this.imageBorder = imageBorder;
        this.buttonFont = buttonFont;
        this.buttonUp = buttonUp;
        this.buttonDown = buttonDown;
        this.buttonOver = buttonOver;
        this.categoryFont = categoryFont;
        this.categoryUp = categoryUp;
        this.categoryDown = categoryDown;
        this.categoryOver = categoryOver;
    }

    /** Default constructor for JSON deserialization. */
    public ColorScheme() {}
    
    @Override
	public Object clone() {
    	return new ColorScheme(theme, background, font, border, imageBackground,
    			imageBorder, buttonFont, buttonUp, buttonDown, buttonOver,
    			categoryFont, categoryUp, categoryDown, categoryOver);
	}

    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    public String theme;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String background;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String font;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String border;

    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    public String imageBackground;

    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    public String imageBorder;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String buttonFont;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String buttonUp;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String buttonDown;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String buttonOver;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String categoryFont;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String categoryUp;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String categoryDown;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String categoryOver;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ColorScheme other = (ColorScheme) obj;
        if ((this.theme == null) ? (other.theme != null) : !this.theme.equals(other.theme)) {
            return false;
        }
        if ((this.background == null) ? (other.background != null) : !this.background.equals(other.background)) {
            return false;
        }
        if ((this.font == null) ? (other.font != null) : !this.font.equals(other.font)) {
            return false;
        }
        if ((this.border == null) ? (other.border != null) : !this.border.equals(other.border)) {
            return false;
        }
        if ((this.imageBackground == null) ? (other.imageBackground != null) : !this.imageBackground.equals(other.imageBackground)) {
            return false;
        }
        if ((this.imageBorder == null) ? (other.imageBorder != null) : !this.imageBorder.equals(other.imageBorder)) {
            return false;
        }
        if ((this.buttonFont == null) ? (other.buttonFont != null) : !this.buttonFont.equals(other.buttonFont)) {
            return false;
        }
        if ((this.buttonUp == null) ? (other.buttonUp != null) : !this.buttonUp.equals(other.buttonUp)) {
            return false;
        }
        if ((this.buttonDown == null) ? (other.buttonDown != null) : !this.buttonDown.equals(other.buttonDown)) {
            return false;
        }
        if ((this.buttonOver == null) ? (other.buttonOver != null) : !this.buttonOver.equals(other.buttonOver)) {
            return false;
        }
        if ((this.categoryFont == null) ? (other.categoryFont != null) : !this.categoryFont.equals(other.categoryFont)) {
            return false;
        }
        if ((this.categoryUp == null) ? (other.categoryUp != null) : !this.categoryUp.equals(other.categoryUp)) {
            return false;
        }
        if ((this.categoryDown == null) ? (other.categoryDown != null) : !this.categoryDown.equals(other.categoryDown)) {
            return false;
        }
        if ((this.categoryOver == null) ? (other.categoryOver != null) : !this.categoryOver.equals(other.categoryOver)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (this.theme != null ? this.theme.hashCode() : 0);
        hash = 59 * hash + (this.background != null ? this.background.hashCode() : 0);
        hash = 59 * hash + (this.font != null ? this.font.hashCode() : 0);
        hash = 59 * hash + (this.border != null ? this.border.hashCode() : 0);
        hash = 59 * hash + (this.imageBackground != null ? this.imageBackground.hashCode() : 0);
        hash = 59 * hash + (this.imageBorder != null ? this.imageBorder.hashCode() : 0);
        hash = 59 * hash + (this.buttonFont != null ? this.buttonFont.hashCode() : 0);
        hash = 59 * hash + (this.buttonUp != null ? this.buttonUp.hashCode() : 0);
        hash = 59 * hash + (this.buttonDown != null ? this.buttonDown.hashCode() : 0);
        hash = 59 * hash + (this.buttonOver != null ? this.buttonOver.hashCode() : 0);
        hash = 59 * hash + (this.categoryFont != null ? this.categoryFont.hashCode() : 0);
        hash = 59 * hash + (this.categoryUp != null ? this.categoryUp.hashCode() : 0);
        hash = 59 * hash + (this.categoryDown != null ? this.categoryDown.hashCode() : 0);
        hash = 59 * hash + (this.categoryOver != null ? this.categoryOver.hashCode() : 0);
        return hash;
    }

    private static final long serialVersionUID = 1L;
}
