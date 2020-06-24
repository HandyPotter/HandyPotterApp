package com.unity3d.player.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.unity3d.player.UnityPlayerViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class Frag2Binding extends ViewDataBinding {
  @NonNull
  public final LinearLayout scrollView2;

  @NonNull
  public final TextView textView02;

  @Bindable
  protected UnityPlayerViewModel mViewModel;

  protected Frag2Binding(Object _bindingComponent, View _root, int _localFieldCount,
      LinearLayout scrollView2, TextView textView02) {
    super(_bindingComponent, _root, _localFieldCount);
    this.scrollView2 = scrollView2;
    this.textView02 = textView02;
  }

  public abstract void setViewModel(@Nullable UnityPlayerViewModel viewModel);

  @Nullable
  public UnityPlayerViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static Frag2Binding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.frag2, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static Frag2Binding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<Frag2Binding>inflateInternal(inflater, com.unity3d.player.R.layout.frag2, root, attachToRoot, component);
  }

  @NonNull
  public static Frag2Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.frag2, null, false, component)
   */
  @NonNull
  @Deprecated
  public static Frag2Binding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
    return ViewDataBinding.<Frag2Binding>inflateInternal(inflater, com.unity3d.player.R.layout.frag2, null, false, component);
  }

  public static Frag2Binding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static Frag2Binding bind(@NonNull View view, @Nullable Object component) {
    return (Frag2Binding)bind(component, view, com.unity3d.player.R.layout.frag2);
  }
}
