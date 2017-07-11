# 你為何要用 Kotlin?

嚴格來說，沒有為什麼。這或許是一個既生 J 何生 K 的問題，但實際上來說，舉凡是執行在 JVM 平台上的語言能做到的，用 Java 都能做到。這個推定，是 Java 這領域的基本共識。如同 Bjarne Stroustrup 在他的 The C++ Programming Language 裡所提到的，C++ 所作的事情，同樣能用 C 語言來完成，但問題在於使用 C 語言將花費更大的功夫才能完成。C 與 C++ 顯然是兩個極度不同的開發典範：結構化與物件導向。然而 Java 與 Kotlin 呢？我若在 JVM 平台上想要選擇一個與 Java 截然不同典範的語言，我不是應該去寫 Scala 或 Cloujure 嗎？為何要用 Kotlin 呢？我們即將探討這個問題。

## 收斂大哉問

如果你被人問到，為什麼要做這個工作？為什麼人要工作？這樣的大哉問，可能你會選擇不回答，或回答些高大上的想法，但面對範圍很大的問題，我們有兩種典型的處理方式：收斂與反詰。我們現在收斂一下上面的問題。或許可以這麼問：

# Kotlin 與 Java 有何不同？

## 重新開始

這個問題，或許你可以從 Kotlin 網站的列舉中看見。不過，我們用程式來實作，了解兩種語言編程思想的差異。

## 正規比較

根據 [Comparison to Java Programming Language](https://kotlinlang.org/docs/reference/comparison-to-java.html) 一文，我們可以列舉如下：

### Kotlin 補正了 Java 已有的問題

1. Kotlin 透過自己的 type system (型別系統) 來控制 null pointer (空指標) 的問題，簡而言之，在 Kotlin 裡呼叫物件時，會在語言層級防止 NullPointerException 的發生。
2. Kotlin 裡沒有 raw type (原生型別) 的使用，換句話說，在 Kotlin 的容器裡，必須明確指定型別，即使你的 List 裡，不知道該裝啥，你也應該指明是 Object (~那與 raw type 有何不同~)
3. 