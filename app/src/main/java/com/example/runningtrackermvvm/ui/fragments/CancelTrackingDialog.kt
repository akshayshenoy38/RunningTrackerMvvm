package com.example.runningtrackermvvm.ui.fragments

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.runningtrackermvvm.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class CancelTrackingDialog: DialogFragment() {
    private var yesListener: (() -> Unit)? = null

    fun setYesListener(listener: (() -> Unit)) {
        yesListener = listener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return MaterialAlertDialogBuilder(requireContext(), R.style.AlertDialogTheme)
            .setTitle("Cancel the Run?")
            .setMessage("Are you sure that you want to cancel the current run and delete its data?")
            .setIcon(R.drawable.ic_delete)
            .setPositiveButton("Yes") { _, _ ->
                yesListener?.let { yes ->
                    yes()
                }

            }
            .setNegativeButton("No") { dialogInterface, _ ->
                dialogInterface.cancel()
            }
            .create()
    }
}