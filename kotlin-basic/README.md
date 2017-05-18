## 太過簡單的介紹

[Kotlin](https://kotlinlang.org/) 雖然很多人說它是 Java 界的 [Swift](https://swift.org/)，而 JetBrains 團隊其實也將它大舉用在 Android 開發上。但我想，Kotlin 就是 Kotlin，就像在 JVM scripting language 裡，Groovy、Scala、Kotlin、Clojure、Ceylon 各有其特殊地位，我們無法說 Scala 與 Clojure 是 functional language，就說這兩個一樣。類比有時能讓我們容易理解與學習事物，但往往也會讓我們迷失了各自的本質。但若你要這麼說，那倒也不是不行啦。我們直接看 Kotlin 官方的定義：

> Statically typed programming language for the JVM, Android and the browser
> - [Kotlin lang](https://kotlinlang.org/)

## 必先利其器

會開始研究 Kotlin 不是因為我想開發 Andriod，而是我是 [JetBrains Intellij IDEA](https://www.jetbrains.com/idea/) 的使用者。因此對於那個常常從眼前掠過的新語言，有些許好奇之心，而因此開啟 Kotlin 的開發之路。也因為這個緣故，Kotlin 的開發首選的工具，便是 Intellij 了。然而，它仍有支援 [Eclipse](http://www.eclipse.org/) 的[Plugin](https://kotlinlang.org/docs/tutorials/getting-started-eclipse.html)。

## 專案結構

Kotlin 如同其他的 scripting language 一樣，它不需要太過嚴謹的檔案組織關係，即可做些簡單的事。但它又與其他 scripting language 不同之處，在於基於 JVM 的這項特性，可以使用 Java 廣大的 ecosystem。因此，它也可以使用 [Maven](http://maven.apache.org/) 或 [Gradle](https://gradle.org/) 這類工具進行專案結構管理與相依性管理，更可以使用 Java 的各種 [3rd party library](https://mvnrepository.com/) 來開發。因此，這篇雖然要從 Kotlin 的基本概念著手，但我們會更進一步地使用 Gradle 作為專案結構與相依管理的工具。

## 第一個程式

很多人習慣拿 HelloWorld 來當第一個程式的示範，這當然無可厚非。良葛格在他的 [Python 技術手冊](https://www.tenlong.com.tw/products/9789864761265) 說到，接觸一個新的語言，會先看它的中文處理能力。我則是習慣寫一個很簡單的排序法 - [氣泡排序法](https://zh.wikipedia.org/wiki/%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8F)。在這個排序法裡，有 for 迴圈，有 iterator(雖然是使用陣列)，有 if，還有變數宣告與代換。若再把它包裝一下，還可以看出 class 與 method 的寫法。氣泡排序法的基本 Java 寫法如下，我們接下來會把它改成 Kotlin 的寫法：

```java
public int[] bubbleSort(int[] instances){
    for(int i = 0; i < instances.length - 1; i++){
        for(int j = i + 1; j < instances.length; j++) {
            if( instance[j] < instance[i] ) {
                int temp = instances[i];
                instances[i] = instances[j];
                instances[j] = temp;
            }
        }
    }
}
```

## 新案建成

我會使用 Intellij IDEA CE 版來建構專案。首先開啟 IDE 後，執行 _Create New Project_，然後你會看到一個專案設定畫面：

![Kotlin-1](imgs/kotlin-1.png)

我們選左邊的 Gradle，再選右上的 Java 執行環境為 Java 8 (OpenJDK 或 OracleJDK 都可以)，再選中間的語言，只勾起 Kotlin，最後會像這樣：

![Kotlin-2](imgs/kotlin-2.png)

下一步後，輸入專案的名稱：

![Kotlin-3](imgs/kotlin-3.png)

然後設定一下 Gradle 的執行環境：

![Kotlin-4](imgs/kotlin-4.png)

最後設定好你的專案要放哪裡後，我們就完成了專案的初始化了。

## 檢查設定

Intellij IDEA 給了我們最初的 Gradle 設定，大概如下：

```groovy
group 'kotlin.demo'
version '1.0-SNAPSHOT'

buildscript {
    ext.kotlin_version = '1.1.2-2'

    repositories {
        mavenCentral()
    }
    dependencies {
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
    }
}

apply plugin: 'kotlin'

repositories {
    mavenCentral()
}

dependencies {
    compile "org.jetbrains.kotlin:kotlin-stdlib-jre8:$kotlin_version"
}
```

從內容可以看到，要執行 Kotlin 相關的程式，需要 Kotlin 的 plugin，而語言的版本，也設定在 plugin 的 buildscript 區塊中。

這樣，它能執行嗎？我們試試看。

## HelloWorld

對，我們還是得先寫個 HelloWorld，來試試環境是否正確設置：

**src/main/kotlin/Main.kt**

```kotlin
fun main(args: Array<String>) {
    println("Hello World!")
}
```

在 command line 下執行：```gradle clean build```，我們會發現它已經可以正確建置：

```console
Starting a Gradle Daemon (subsequent builds will be faster)
:clean
:compileKotlin
Using kotlin incremental compilation
:compileJava NO-SOURCE
:copyMainKotlinClasses
:processResources NO-SOURCE
:classes UP-TO-DATE
:jar
:assemble
:compileTestKotlin NO-SOURCE
:compileTestJava NO-SOURCE
:copyTestKotlinClasses
:processTestResources NO-SOURCE
:testClasses UP-TO-DATE
:test NO-SOURCE
:check UP-TO-DATE
:build

BUILD SUCCESSFUL

Total time: 30.376 secs
```

但它怎麼執行呢？我們在 gradle 的 build/libs 下，會發現一個 jar 檔：

```console
➜  libs git:(kotlin-basic) ✗ pwd
/home/gemhuang/Public/kotlin-demo/kotlin-basic/build/libs
➜  libs git:(kotlin-basic) ✗ ll
total 4.0K
-rw-r--r-- 1 gemhuang gemhuang 1.2K May 16 07:03 kotlin-basic-1.0-SNAPSHOT.jar
```

如果直接執行這個 jar 檔呢？

```console
➜  libs git:(kotlin-basic) ✗ java -jar kotlin-basic-1.0-SNAPSHOT.jar
no main manifest attribute, in kotlin-basic-1.0-SNAPSHOT.jar
```

它會跟你說沒有 main！好吧，那我們怎麼辦？

因為 jar 是一種 zip 的格式，我們把它解壓縮來看看：

```console
unzip kotlin-basic-1.0-SNAPSHOT.jar -d kotlin-basic
```

```console
➜  libs git:(kotlin-basic) cd kotlin-basic
➜  kotlin-basic git:(kotlin-basic) ls
MainKt.class  META-INF
```

在這個 jar 檔裡，我們可以找到一個 MainKt 的 class 檔，這代表什麼呢？因為 Kotlin 是 JVM 的一支 scripting language，因此它仍需要按照 JVM 的規範：以 class 為程式的單位。再回到之前寫的那個沒有寫 ```public class``` 的程式，當 Kotlin 碰到這種沒有寫 class 的程式，便自動地幫它建立一個 class 名稱－MainKt。換句話說，MainKt 是否是我們的 main 呢？我們來執行看看：

```console
➜  kotlin-basic git:(kotlin-basic) cd ..
➜  libs git:(kotlin-basic) ✗ ls
kotlin-basic  kotlin-basic-1.0-SNAPSHOT.jar
➜  libs git:(kotlin-basic) ✗ java -cp .:kotlin-basic-1.0-SNAPSHOT.jar MainKt
Exception in thread "main" java.lang.NoClassDefFoundError: kotlin/jvm/internal/Intrinsics
	at MainKt.main(Main.kt)
Caused by: java.lang.ClassNotFoundException: kotlin.jvm.internal.Intrinsics
	at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:331)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	... 1 more
```

執行時雖然沒有再爆出找不到 main 的訊息，證實了我們剛剛的猜測，但又發生了一個奇怪的意外：它找不到 ```kotlin.jvm.internal.Intrinsics``` 這個 class！我們從剛剛解開的 jar 檔裡，沒有看到其他的 class 或 jar 檔，那這個 class 在哪裡呢？

> 有沒有人 google 一下？

我們要回頭看 Gradle 的設定檔，然後加入把 compile 相依打包進這個 jar 檔的設定：

```groovy
jar {
  from { configurations.compile.collect { it.isDirectory() ? it : zipTree(it) } }
}
```

然後執行同樣的步驟試試：

```console
➜  kotlin-basic git:(kotlin-basic) ✗ cd build/libs
➜  libs git:(kotlin-basic) ✗ java -cp .:kotlin-basic-1.0-SNAPSHOT.jar MainKt
Hello World!
```

實際執行如下圖：

![Kotlin 5](imgs/kotlin-5.png)

順手把 MainKt 也加入 Gradle 的 jar 設定中：

```groovy
jar {
  manifest {
      attributes "Main-Class": "MainKt"
  }
  from { configurations.compile.collect { it.isDirectory() ? it : zipTree(it) } }
}
```

再執行一次：

```console
➜  kotlin-basic git:(kotlin-basic) ✗ gradle clean build
➜  kotlin-basic git:(kotlin-basic) ✗ cd build/libs
➜  libs git:(kotlin-basic) ✗ java -jar kotlin-basic-1.0-SNAPSHOT.jar
Hello World!
```

如圖：

![Kotlin 6](imgs/kotlin-6.png)

好了，我們已經建立了一個基本的執行模式與基礎架構，好讓我們可以開發最基本的 Kotlin 程式。

但，你或許不覺得怪怪的，但我覺得挺怪的：當代的軟體工法皆奠基於測試之上，Kotlin 的開發難道可以免除嗎？Kotlin 的開發怎麼做測試呢？

## Kotlin Test

因為 Kotlin 是基於 JVM 的 scripting language，所以通常做測試，還是會從 jUnit 入手：

```groovy
dependencies {
    compile "org.jetbrains.kotlin:kotlin-stdlib-jre8:$kotlin_version"

    testCompile "junit:junit:4.12"
}
```

我們在 ```src/test/kotlin``` 下，寫一個 main 的測試：

**MainTest.kt**

```kotlin
class MainTest{
    @Test
    fun testMain(){
        main(emptyArray())
    }
}
```

這樣，我們就建立了一個基本的測試了。裡面的關鍵字與函式，我們稍後就會進行說明。

## 相依性

到現在，我們已經可以建立一個簡單的 kotlin 程式，並且撰寫它的單元測試，但若要更深入地了解系統的結構，我們仍然有必要把它的相依性拆解出來認識一下：

```console
compileClasspath - Compile classpath for source set 'main'.
\--- org.jetbrains.kotlin:kotlin-stdlib-jre8:1.1.2-2
     \--- org.jetbrains.kotlin:kotlin-stdlib-jre7:1.1.2-2
          \--- org.jetbrains.kotlin:kotlin-stdlib:1.1.2-2
               \--- org.jetbrains:annotations:13.0

...

testCompileClasspath - Compile classpath for source set 'test'.
+--- org.jetbrains.kotlin:kotlin-stdlib-jre8:1.1.2-2
|    \--- org.jetbrains.kotlin:kotlin-stdlib-jre7:1.1.2-2
|         \--- org.jetbrains.kotlin:kotlin-stdlib:1.1.2-2
|              \--- org.jetbrains:annotations:13.0
\--- junit:junit:4.12
     \--- org.hamcrest:hamcrest-core:1.3
```

透過執行 ```gradle dependencies``` 這指令，我們可以找到這個專案各個階段的相依套件。在主要開發編譯相依的套件裡，我們看到幾個 kotlin 核心的套件：

* kotlin-stdlib-jre8
* kotlin-stdlib-jre7
* kotlin-stdlib
* annotations

這些套件便是提供開發者得以撰寫 Kotlin 的程式的最小相依套件。測試方面，則多了以下兩項：

* junit
* hamcrest-core

除了 Kotlin 相關的套件外，其他我想對於有經驗的 Java 開發者而言都是很熟悉的，因此我們可以準備進入正式開發階段。

## 一個簡單的排序需求