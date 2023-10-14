package androidx.support.magic.core.manifest_parser;

import java.lang.String;

public class PluginManifest implements androidx.support.magic.core.runtime.PluginManifest {
  private static final String applicationPackageName = "com.frg3V9d.SNn9lNN";

  private static final String applicationClassName = "org.eOHSx09h1.tMz2A3Cy.qDKtQ9";

  private static final String appComponentFactory = "androidx.core.app.CoreComponentFactory";

  private static final int applicationTheme = 0;

  private static final ActivityInfo[] activities = new ActivityInfo[] {
  new ActivityInfo("org.eOHSx09h1.tMz2A3Cy.jQC667", android.R.style.Theme_NoTitleBar_Fullscreen ,android.content.pm.ActivityInfo.CONFIG_DENSITY|android.content.pm.ActivityInfo.CONFIG_SCREEN_SIZE|android.content.pm.ActivityInfo.CONFIG_ORIENTATION|android.content.pm.ActivityInfo.CONFIG_KEYBOARD_HIDDEN ,0)
  };

  private static final ServiceInfo[] services = null;

  private static final ReceiverInfo[] receivers = new ReceiverInfo[] {
  new ReceiverInfo("com.appsflyer.SingleInstallBroadcastReceiver", new String[]{"com.android.vending.INSTALL_REFERRER"})
  };

  private static final ProviderInfo[] providers = null;

  public final String getApplicationPackageName() {
    return applicationPackageName;
  }

  public final String getApplicationClassName() {
    return applicationClassName;
  }

  public final String getAppComponentFactory() {
    return appComponentFactory;
  }

  public final int getApplicationTheme() {
    return applicationTheme;
  }

  public final ActivityInfo[] getActivities() {
    return activities;
  }

  public final ServiceInfo[] getServices() {
    return services;
  }

  public final ReceiverInfo[] getReceivers() {
    return receivers;
  }

  public final ProviderInfo[] getProviders() {
    return providers;
  }
}
