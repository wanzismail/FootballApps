package com.wanztudio.gdk.matchschedule.ui.main.dialog.view

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.wanztudio.gdk.matchschedule.R
import com.wanztudio.gdk.matchschedule.ui.base.view.BaseDialogView
import com.wanztudio.gdk.matchschedule.ui.main.dialog.interactor.MainDialogMVPInterator
import com.wanztudio.gdk.matchschedule.ui.main.dialog.presenter.MainDialogMVPPresenter
import javax.inject.Inject

/**
 * Created by Ridwan Ismail on 23 September 2018
 * You can contact me at : iwanz@pm.me
 */

class MainDialog : BaseDialogView(), MainDialogMVPView {

    companion object {
        fun newInstance(): MainDialog? {
            return MainDialog()
        }

    }

    @Inject
    internal lateinit var mPresenter: MainDialogMVPPresenter<MainDialogMVPView, MainDialogMVPInterator>

    private val TAG = "MainDialog"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.dialog_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter.onAttach(this)
    }

    override fun onDestroyView() {
        mPresenter.onDetach()
        super.onDestroyView()
    }

    override fun dismissDialog() = super.dismissDialog(TAG)

    override fun showSuccessMessage() = Toast.makeText(context, getString(R.string.feedback_submitted_successfully), Toast.LENGTH_LONG).show()

    internal fun show(fragmentManager: FragmentManager) = super.show(fragmentManager, TAG)

}