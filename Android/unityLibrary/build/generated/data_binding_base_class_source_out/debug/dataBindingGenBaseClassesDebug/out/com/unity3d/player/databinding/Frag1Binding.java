package com.unity3d.player.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.unity3d.player.UnityPlayerViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class Frag1Binding extends ViewDataBinding {
  @NonNull
  public final ImageView imageView;

  @NonNull
  public final TextView textView01;

  @Bindable
  protected UnityPlayerViewModel mViewModel;

  protected Frag1Binding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView imageView, TextView textView01) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imageView = imageView;
    this.textView01 = textView01;
  }

  public abstract void setViewModel(@Nullable UnityPlayerViewModel viewModel);

  @Nullable
  public UnityPlayerViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static Frag1Binding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.frag1, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static Frag1Binding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<Frag1Binding>inflateInternal(inflater, com.unity3d.player.R.layout.frag1, root, attachToRoot, component);
  }

  @NonNull
  public static Frag1Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.frag1, null, false, component)
   */
  @NonNull
  @Deprecated
  public static Frag1Binding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
    return ViewDataBinding.<Frag1Binding>inflateInternal(inflater, com.unity3d.player.R.layout.frag1, null, false, component);
  }

  public static Frag1Binding bind(@NonNull View view) {
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
  public static Frag1Binding bind(@NonNull View view, @Nullable Object component) {
    return (Frag1Binding)bind(component, view, com.unity3d.player.R.layout.frag1);
  }
}
