# mj_pluginsupport
主要是针对Shadow框架的三大模块（sample-loader,sample-runtime,sample-manager)，将它们集中放到一块

## 一、sample-host
用于快速验证插件包是否可以正常加载启动

## 二、sample-host-lib
为sample-host依赖库

## 三、sample-loader
用于加载插件比如pluginmanager.apk等的环境，与B包打成压缩包在一起

## 四、sample-runtime
插件运行时环境，也是在启动时，动态加载

## 五、sample-manager
用于管理插件