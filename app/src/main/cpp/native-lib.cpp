#include <jni.h>
#include <string>

// api url
extern "C"
jstring
Java_com_mehedi_bedaroomtest_MainActivity_apiUrl(
        JNIEnv *env,
        __attribute__((unused)) jclass clazz
) {

    std::string url = "";

    return env->NewStringUTF(url.c_str());
}