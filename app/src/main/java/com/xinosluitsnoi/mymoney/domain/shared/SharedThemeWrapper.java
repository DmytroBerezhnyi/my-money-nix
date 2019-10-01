package com.xinosluitsnoi.mymoney.domain.shared;

import android.content.SharedPreferences;
import android.content.res.Resources;

import com.xinosluitsnoi.mymoney.R;
import com.xinosluitsnoi.mymoney.domain.entity.Theme;

import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;

public class SharedThemeWrapper {

    private static final String THEME_SELECTED = "theme_selected";

    @NonNull
    private final SharedPreferences preferences;

    @NonNull
    private final Resources resources;

    public SharedThemeWrapper(@NonNull SharedPreferences preferences,
                              @NonNull Resources resources) {
        this.preferences = preferences;
        this.resources = resources;
    }

    @NonNull
    public List<Theme> getThemeList() {

        return Arrays.asList(new Theme(Theme.Type.Mode.SYSTEM),
                             new Theme(Theme.Type.Mode.DAY),
                             new Theme(Theme.Type.Mode.NIGHT));
    }

    @NonNull
    public Theme getSelectedTheme() {
        Theme theme = new Theme(preferences.getInt(THEME_SELECTED, Theme.Type.Mode.SYSTEM));
        theme.setTitle(getThemeTitle(theme));
        return theme;
    }

    public void setSelectedTheme(@NonNull Theme theme) {
        preferences.edit().putInt(THEME_SELECTED, theme.getTheme()).apply();
    }

    @NonNull
    public String getThemeTitle(@NonNull Theme theme) {
        switch (theme.getTheme()) {
            case Theme.Type.Mode.SYSTEM:
                return resources.getString(R.string.system);
            case Theme.Type.Mode.DAY:
                return resources.getString(R.string.day);
            case Theme.Type.Mode.NIGHT:
                return resources.getString(R.string.night);
            default:
                throw new IllegalStateException("Unknown theme");
        }
    }
}