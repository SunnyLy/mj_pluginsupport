# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile


#kotlin一般性配置 START
-dontwarn kotlin.**
-keepclassmembers class **$WhenMappings {
    <fields>;
}
-keepclassmembers class kotlin.Metadata {
    public <methods>;
}
#kotlin一般性配置 END

#kotlin优化性能 START
-assumenosideeffects class kotlin.jvm.internal.Intrinsics {
    static void checkParameterIsNotNull(java.lang.Object, java.lang.String);
}
#kotlin优化性能 END

-keep class org.slf4j.**{*;}
-dontwarn org.slf4j.impl.**

-keep class androidx.support.magic.dynamic.host.**{*;}
-keep class androidx.support.magic.dynamic.impl.**{*;}
-keep class androidx.support.magic.dynamic.loader.**{*;}
-keep class androidx.support.magic.core.common.**{*;}
-keep class androidx.support.magic.core.loader.**{*;}
-keep class androidx.support.magic.core.runtime.**{*;}

-dontwarn  androidx.support.magic.dynamic.host.**
-dontwarn  androidx.support.magic.dynamic.impl.**
-dontwarn  androidx.support.magic.dynamic.loader.**
-dontwarn  androidx.support.magic.core.common.**
-dontwarn  androidx.support.magic.core.loader.**
