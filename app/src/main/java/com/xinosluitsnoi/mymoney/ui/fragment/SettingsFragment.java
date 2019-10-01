package com.xinosluitsnoi.mymoney.ui.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xinosluitsnoi.mymoney.R;
import com.xinosluitsnoi.mymoney.domain.entity.Currency;
import com.xinosluitsnoi.mymoney.domain.entity.Theme;
import com.xinosluitsnoi.mymoney.domain.repository.SettingsRepository;
import com.xinosluitsnoi.mymoney.domain.shared.SharedSettingsRepository;
import com.xinosluitsnoi.mymoney.mvp.contract.SettingsContract;
import com.xinosluitsnoi.mymoney.mvp.presenter.SettingsPresenter;
import com.xinosluitsnoi.mymoney.ui.router.SettingsRouter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SettingsFragment
        extends BaseFragment<SettingsContract.Presenter>
        implements SettingsContract.View {

    private TextView tvCurrencyDefault;

    private TextView tvTHemeDefault;

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvCurrencyDefault = view.findViewById(R.id.tv_default_currrency);
        tvTHemeDefault = view.findViewById(R.id.tv_default_theme);

        view.findViewById(R.id.layout_currency)
            .setOnClickListener(v -> getPresenter().showCurrencyScreen());

        view.findViewById(R.id.layout_theme)
            .setOnClickListener(v -> getPresenter().showThemeScreen());
    }

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().loadCurrentSettings();
    }

    @Override
    public void showSelectedCurrency(@NonNull Currency currency) {
        tvCurrencyDefault.setText(currency.getTitle());
    }

    @Override
    public void showSelectedTheme(@NonNull Theme theme) {
        tvTHemeDefault.setText(theme.getTitle());
    }

    @Override
    public int getToolbarTitleResource() {
        return R.string.title_settings;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_settings;
    }

    @NonNull
    @Override
    protected SettingsContract.Presenter createPresenter() {
        SettingsContract.Router router = new SettingsRouter(requireBaseActivity());

        SharedPreferences sharedPreferences = requireBaseActivity().getSettingsPreferences();

        SettingsRepository settingsRepository =
                new SharedSettingsRepository(getResources(), sharedPreferences);

        return new SettingsPresenter(router, settingsRepository);
    }
}