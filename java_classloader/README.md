# ClassLoader

## 什么是ClassLoader?

        当我们写好一个Java程序之后，不是管是CS还是BS应用，都是由若干个.class文件组织而成的一个完整的Java应用程序，
    当程序在运行时，即会调用该程序的一个入口函数来调用系统的相关功能，而这些功能都被封装在不同的class文件当中，
    所以经常要从这个class文件中要调用另外一个class文件中的方法，如果另外一个文件不存在的，则会引发系统异常。

        而程序在启动的时候，并不会一次性加载程序所要用的所有class文件，而是根据程序的需要，通过Java的类加载机制（ClassLoader）来动态加载某个class文件到内存当中的，
    从而只有class文件被载入到了内存之后，才能被其它class所引用。所以ClassLoader就是用来动态加载class文件到内存当中用的。

## Java默认提供的三个ClassLoader

* Bootstrap ClassLoader

        称为启动类加载器，是Java类加载层次中最顶层的类加载器，负责加载JDK中的核心类库

* Extension ClassLoader

        称为扩展类加载器，负责加载Java的扩展类库，默认加载JAVA_HOME/jre/lib/ext/目下的所有jar。

* App ClassLoader

        称为系统类加载器，负责加载应用程序classpath目录下的所有jar和class文件。