# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/pratama/Documents/SDK/android-sdk-macosx/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}


# Obfuscation parameters:
#-dontobfuscate
-useuniqueclassmembernames
-keepattributes SourceFile,LineNumberTable
-allowaccessmodification

#-keep class io.realm.annotations.RealmModule
#-keep @io.realm.annotations.RealmModule class *
#-keep class io.realm.internal.Keep
#-keep @io.realm.internal.Keep class * { *; }
#-dontwarn javax.**
#-dontwarn io.realm.**

# Keep GSON stuff
#-keep class sun.misc.Unsafe { *; }
#-keep class com.google.gson.** { *; }

# Keep Retrofit
#-keep class retrofit.** { *; }
#-keepclasseswithmembers class * {
#    @retrofit.** *;
#}
#-keepclassmembers class * {
#    @retrofit.** *;
#}

# Created by https://proguard.herokuapp.com/api/

-keep public class android.support.v7.widget.** { *; }
-keep public class android.support.v7.internal.widget.** { *; }
-keep public class android.support.v7.internal.view.menu.** { *; }

-keep public class * extends android.support.v4.view.ActionProvider {
    public <init>(android.content.Context);
}


-dontwarn android.support.design.**
-keep class android.support.design.** { *; }
-keep interface android.support.design.** { *; }
-keep public class android.support.design.R$* { *; }

# Retrofit 1.X

#-keep class com.squareup.okhttp.** { *; }
#-keep class retrofit.** { *; }
#-keep interface com.squareup.okhttp.** { *; }

#-dontwarn com.squareup.okhttp.**
#-dontwarn okio.**
#-dontwarn retrofit.**
#-dontwarn rx.**

#-keepclasseswithmembers class * {
#    @retrofit.http.* <methods>;
#}

# If in your rest service interface you use methods with Callback argument.
#-keepattributes Exceptions

# If your rest service methods throw custom exceptions, because you've defined an #ErrorHandler.
#-keepattributes Signature

# Also you must note that if you are using GSON for conversion from JSON to POJO representation, you must ignore those POJO classes from being obfuscated.
# Here include the POJO's that have you have created for mapping JSON response to POJO for example.


# RxJava 0.21

#-keep class rx.schedulers.Schedulers {
#    public static <methods>;
#}
#-keep class rx.schedulers.ImmediateScheduler {
#    public <methods>;
#}
#-keep class rx.schedulers.TestScheduler {
#    public <methods>;
#}
#-keep class rx.schedulers.Schedulers {
#    public static ** test();
#}


# Proguard Configuration for Realm (http://realm.io)
# For detailed discussion see: https://groups.google.com/forum/#!topic/realm-java/umqKCc50JGU
# Additionally you need to keep your Realm Model classes as well
# For example:
# -keep class com.yourcompany.realm.** { *; }

#-keep class io.realm.annotations.RealmModule
#-keep @io.realm.annotations.RealmModule class *
#-keep class io.realm.internal.Keep
#-keep @io.realm.internal.Keep class *
#-dontwarn javax.**
#-dontwarn io.realm.**


## joda-time-android 2.8.0
# This is only necessary if you are not including the optional joda-convert dependency

#-dontwarn org.joda.convert.FromString
#-dontwarn org.joda.convert.ToString
