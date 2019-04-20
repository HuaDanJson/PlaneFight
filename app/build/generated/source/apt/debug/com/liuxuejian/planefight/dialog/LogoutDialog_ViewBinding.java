// Generated code from Butter Knife. Do not modify!
package com.liuxuejian.planefight.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.liuxuejian.planefight.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LogoutDialog_ViewBinding<T extends LogoutDialog> implements Unbinder {
  protected T target;

  private View view2131427484;

  private View view2131427483;

  private View view2131427481;

  @UiThread
  public LogoutDialog_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.tv_yes_logout_dialog, "field 'mYes' and method 'onOkClicked'");
    target.mYes = Utils.castView(view, R.id.tv_yes_logout_dialog, "field 'mYes'", TextView.class);
    view2131427484 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onOkClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_cancel_logout_dialog, "field 'mCancel' and method 'onCancelClicked'");
    target.mCancel = Utils.castView(view, R.id.tv_cancel_logout_dialog, "field 'mCancel'", TextView.class);
    view2131427483 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onCancelClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rl_log_out_dialog, "field 'mLogoutDialog' and method 'onHidleClicked'");
    target.mLogoutDialog = Utils.castView(view, R.id.rl_log_out_dialog, "field 'mLogoutDialog'", RelativeLayout.class);
    view2131427481 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onHidleClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mYes = null;
    target.mCancel = null;
    target.mLogoutDialog = null;

    view2131427484.setOnClickListener(null);
    view2131427484 = null;
    view2131427483.setOnClickListener(null);
    view2131427483 = null;
    view2131427481.setOnClickListener(null);
    view2131427481 = null;

    this.target = null;
  }
}
