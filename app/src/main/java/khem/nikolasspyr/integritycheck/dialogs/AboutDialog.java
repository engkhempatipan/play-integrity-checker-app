package khem.nikolasspyr.integritycheck.dialogs;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import khem.nikolasspyr.integritycheck.BuildConfig;
import khem.nikolasspyr.integritycheck.R;
import khem.nikolasspyr.integritycheck.Utils;


public class AboutDialog {

    private final AlertDialog dialog;

    public AboutDialog(Context context) {

        dialog = new MaterialAlertDialogBuilder(context, R.style.Theme_PlayIntegrityAPIChecker_Dialogs)
                .setPositiveButton(R.string.ok, (dialog, which) -> {

                })
                .create();

        View dialogView = View.inflate(context, R.layout.dialog_about, null);

        dialog.setView(dialogView);

        TextView aboutText = dialogView.findViewById(R.id.about_text);

        aboutText.setText(context.getResources().getString(R.string.about_text).replace("{name}", BuildConfig.VERSION_NAME).replace("{code}", String.valueOf(BuildConfig.VERSION_CODE)));

        MaterialButton githubBtn = dialogView.findViewById(R.id.about_github);
        MaterialButton licensesBtn = dialogView.findViewById(R.id.about_licenses);


        githubBtn.setOnClickListener(v -> {
            Utils.openLink(context.getString(R.string.about_github_link), context);
            dialog.dismiss();
        });


        licensesBtn.setOnClickListener(v -> {
            new LicensesDialog(context).show();
            dialog.dismiss();
        });

    }

    public void show() {
        dialog.show();
    }
}
