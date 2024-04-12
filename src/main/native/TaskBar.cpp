#include "TaskBar.h"

#include <iostream>
#include <Shobjidl_core.h>
#include <Windows.h>

JNIEXPORT void JNICALL Java_com_david_progresstaskbar_TaskBar_setTaskbarProgress (JNIEnv *env, jobject obj, jfloat progress) {
    jclass cls = env->GetObjectClass(obj);
    jfieldID fieldID = env->GetFieldID(cls, "HWND", "J");
    HWND hwnd = reinterpret_cast<HWND>(env->GetLongField(obj, fieldID));
    ITaskbarList3* pTaskbarList = nullptr;
    HRESULT hr = CoCreateInstance(CLSID_TaskbarList, nullptr, CLSCTX_INPROC_SERVER, IID_ITaskbarList3, (void**)&pTaskbarList);

    if (SUCCEEDED(hr)) {
        hr = pTaskbarList->SetProgressValue(hwnd, progress, 100);
        pTaskbarList->Release();
    }
}

JNIEXPORT void JNICALL Java_com_david_progresstaskbar_TaskBar_setTaskbarProgressState(JNIEnv *env, jobject obj, jobject state) {
    jclass cls = env->GetObjectClass(obj);
    jfieldID fieldID = env->GetFieldID(cls, "HWND", "J");
    HWND hwnd = reinterpret_cast<HWND>(env->GetLongField(obj, fieldID));

    jclass clSTATUS = env->FindClass("com/david/progresstaskbar/TaskBar$State");
    jfieldID id = env->GetStaticFieldID(clSTATUS, "NoProgress", "Lcom/david/progresstaskbar/TaskBar$State;");
    jobject NoProgress = env->GetStaticObjectField(clSTATUS, id);
    std::cout << "got noprogress" << std::endl;
    id = env->GetStaticFieldID(clSTATUS, "Indeterminate", "Lcom/david/progresstaskbar/TaskBar$State;");
    jobject Indeterminate = env->GetStaticObjectField(clSTATUS, id);
    id = env->GetStaticFieldID(clSTATUS, "Normal", "Lcom/david/progresstaskbar/TaskBar$State;");
    jobject Normal = env->GetStaticObjectField(clSTATUS, id);
    id = env->GetStaticFieldID(clSTATUS, "Error", "Lcom/david/progresstaskbar/TaskBar$State;");
    jobject Error = env->GetStaticObjectField(clSTATUS, id);
    id = env->GetStaticFieldID(clSTATUS, "Paused", "Lcom/david/progresstaskbar/TaskBar$State;");
    jobject Paused = env->GetStaticObjectField(clSTATUS, id);

    TBPFLAG tstate = TBPF_NOPROGRESS;

    if (env->IsSameObject(NoProgress, state))
    {
    }
    else if (env->IsSameObject(Indeterminate, state))
    {
        tstate = TBPF_INDETERMINATE;
    }
    else if (env->IsSameObject(Error, state))
    {
        tstate = TBPF_ERROR;
    }
    else if (env->IsSameObject(Normal, state))
    {
        tstate = TBPF_NORMAL;
    }
    else if (env->IsSameObject(Paused, state))
    {
        tstate = TBPF_PAUSED;
    }


    ITaskbarList3* pTaskbarList = nullptr;
    HRESULT hr = CoCreateInstance(CLSID_TaskbarList, nullptr, CLSCTX_INPROC_SERVER, IID_PPV_ARGS(&pTaskbarList));
    if (SUCCEEDED(hr)) {
        hr = pTaskbarList->SetProgressState(hwnd, tstate);
        pTaskbarList->Release();
    }
}

JNIEXPORT jlong JNICALL Java_com_david_progresstaskbar_TaskBar_getHWND (JNIEnv *env, jobject obj, jstring name) {
    const jchar *cName = env->GetStringChars(name, NULL);
    const HWND hwnd = FindWindow(NULL, reinterpret_cast<LPCWSTR>(cName));
    env->ReleaseStringChars(name, cName);
    return jlong(hwnd);
}