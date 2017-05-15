## 太過簡單的介紹

[Kotlin](https://kotlinlang.org/) 雖然很多人說它是 Java 界的 [Swift](https://swift.org/)，而 JetBrains 團隊其實也將它大舉用在 Android 開發上。但我想，Kotlin 就是 Kotlin，就像在 JVM scripting language 裡，Groovy、Scala、Kotlin、Clojure、Ceylon 各有其特殊地位，我們無法說 Scala 與 Clojure 是 functional language，就說這兩個一樣。但若你要這麼說，那倒也不是不行啦。我們直接看 Kotlin 官方的定義：

> Statically typed programming language for the JVM, Android and the browser
> - [Kotlin lang](https://kotlinlang.org/)

## 必先利其器

會開始研究 Kotlin 不是因為我想開發 Andriod，而是我是 [JetBrains Intellij IDEA](https://www.jetbrains.com/idea/) 的使用者。因此對於那個常常從眼前掠過的新語言，有些許好奇之心，而因此開啟 Kotlin 的開發之路。也因為這個緣故，Kotlin 的開發，首選的工具，便是 Intellij 了。然而，它仍有支援 [Eclipse](http://www.eclipse.org/) 的[Plugin](https://kotlinlang.org/docs/tutorials/getting-started-eclipse.html)。

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

```
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

```
➜  libs git:(kotlin-basic) ✗ pwd
/home/gemhuang/Public/kotlin-demo/kotlin-basic/build/libs
➜  libs git:(kotlin-basic) ✗ ll
total 4.0K
-rw-r--r-- 1 gemhuang gemhuang 1.2K May 16 07:03 kotlin-basic-1.0-SNAPSHOT.jar
```

如果直接執行這個 jar 檔呢？

```
➜  libs git:(kotlin-basic) ✗ java -jar kotlin-basic-1.0-SNAPSHOT.jar 
no main manifest attribute, in kotlin-basic-1.0-SNAPSHOT.jar
```

它會跟你說沒有 main！好吧，那我們怎麼辦？
