package com.xinosluitsnoi.mymoney.ui.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xinosluitsnoi.mymoney.R;
import com.xinosluitsnoi.mymoney.domain.repository.SettingsRepository;
import com.xinosluitsnoi.mymoney.domain.shared.SharedSettingsRepository;
import com.xinosluitsnoi.mymoney.mvp.contract.CurrencyDialogContract;
import com.xinosluitsnoi.mymoney.mvp.presenter.CurrencyPresenter;
import com.xinosluitsnoi.mymoney.ui.router.CurrencyDialogRouter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

public class CurrencyDialog extends BaseDialog<CurrencyDialogContract.Presenter>
        implements CurrencyDialogContract.View {

    public static final String dialog_tag = "dialog";

    public static CurrencyDialog newInstance() {
        return new CurrencyDialog();
    }

    private EditText input;

    @Override
    public void onResume() {
        super.onResume();

        final AlertDialog dialog = (AlertDialog) getDialog();

        if(dialog != null) {
            Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);

            positiveButton.setOnClickListener(v -> getPresenter().checkCurrencyTitle(input.getText().toString()));
        }
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);

        if(requireBaseActivity() instanceof MyDialogCloseListener) {
            ((MyDialogCloseListener)requireBaseActivity()).handleDialogClose();
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle(getDialogTitle());

        input = new EditText(requireContext());
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton(R.string.ok, (dialog, which) -> {
            //none
        });

        builder.setNegativeButton(R.string.cancel, (dialog, which) -> dialog.cancel());
        return builder.create();
    }

    @Override
    public void showInvalidTitle() {
        Toast.makeText(requireContext(), R.string.currency_input_error, Toast.LENGTH_SHORT).show();
    }

    @NonNull
    @Override
    protected CurrencyDialogContract.Presenter createPresenter() {
        CurrencyDialogContract.Router router = new CurrencyDialogRouter(requireBaseActivity());

        SharedPreferences sharedPreferences = requireBaseActivity().getSettingsPreferences();

        SettingsRepository settingsRepository =
                new SharedSettingsRepository(getResources(), sharedPreferences);
        return new CurrencyPresenter(router, settingsRepository);
    }

    @Override
    protected int getDialogTitle() {
        return R.string.currency_add_title;
    }
}