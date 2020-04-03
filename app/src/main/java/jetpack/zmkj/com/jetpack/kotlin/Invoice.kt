package jetpack.zmkj.com.jetpack.kotlin

class Invoice{
    /**
     * 标记为 inner 的嵌套类能够访问其外部类的成员。内部类会带有一个对外部类的对象的引用：
     */
    private val bar: Int = 1
    inner class Inner {
        fun foo() = bar
    }


}