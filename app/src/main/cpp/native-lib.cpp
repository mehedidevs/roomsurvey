#include <jni.h>
#include <string>

// api url
extern "C"
jstring
Java_com_mehedi_bedaroomtest_MainActivity_apiUrl(
        JNIEnv *env,
        __attribute__((unused)) jclass clazz
) {
//    std::string url = "https://legacy.beedamall.com/api/";
    std::string url = "https://api.beeda.com/";
//    std::string url = "http://192.168.88.199/";
//    std::string url = "http://192.168.88.221/beeda_backend/api/";
//    std::string url = "http://192.168.88.243/beeda_backend/api/";
//    std::string url = "http://192.168.88.234/beeda_backend/api/";
    return env->NewStringUTF(url.c_str());
}