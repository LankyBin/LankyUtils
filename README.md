# 简介

这是一个用于日常开发所需的一些Android工具类

## LankyUtils目前包含

1. LankyLog
   
   具备level过滤、文件行号详情的日志工具类

2. HiddenEntrance
   
   以顺序按键的方式进入隐藏入口的工具类

3. ViewUtil
   
   焦点/鼠标指针交互变化（突出当前焦点View）

4. SharedPreferenceUtil
   
   基础数据保存工具类

5. LankyToast
   
   代替原生Toast，以解决叠加显示和重复显示的问题

6. TODO

# LankyUtils

## 生成jar：

```
LankyUtils> .\gradlew makejar
Starting a Gradle Daemon, 4 busy and 2 incompatible Daemons could not be reused, use --status for details

BUILD SUCCESSFUL in 33s
63 actionable tasks: 18 executed, 45 up-to-date
```

## 生成到：

`LankyUtils/libs/com.lanky.utils.jar`

# 调试实用代码

获取当前方法运行时是被哪个文件的哪段代码调用：

```
    StackTraceElement[] sElements = new Throwable().getStackTrace();

    String mFileName = sElements[1].getFileName();

    int mLineNumber = sElements[1].getLineNumber();

    Log.i("lanky", "This method called by: " + mFileName + ":" + mLineNumber);

```
