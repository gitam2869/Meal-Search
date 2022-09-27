//
// Created by gautam on 27/09/22.
//

#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_app_mealsearch_utils_Keys_devBaseURL(JNIEnv *env, jobject thiz) {
    std::string base_url = "www.themealdb.com";
    return env->NewStringUTF(base_url.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_app_mealsearch_utils_Keys_prodBaseURL(JNIEnv *env, jobject thiz) {
    std::string prod_url = "P Secured key";
    return env->NewStringUTF(prod_url.c_str());
}