#include "TaskBar.h"

#include <Windows.h>
// #include <iostream>

JNIEXPORT void JNICALL Java_com_example_demo_TaskBar_SetTaskbarProgress (JNIEnv *env, jobject obj, jfloat progress) {
    
}

JNIEXPORT void JNICALL Java_com_example_demo_TaskBar_SetTaskbarProgressState (JNIEnv *, jobject, jobject) {

}

JNIEXPORT jlong JNICALL Java_com_example_demo_TaskBar_getHWND (JNIEnv *env, jobject obj, jstring name) {
    // std::cout << "Creating string" << std::endl;
    const jchar *cName = env->GetStringChars(name, NULL);
    // std::cout << "Find window" << std::endl;
    const HWND hwnd = FindWindow(NULL, reinterpret_cast<LPCWSTR>(cName));
    // std::cout << "Release string" << std::endl;
    env->ReleaseStringChars(name, cName);
    // std::cout << "Return" << std::endl;
    return jlong(hwnd);
}