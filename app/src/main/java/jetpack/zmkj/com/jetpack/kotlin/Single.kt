package jetpack.zmkj.com.jetpack.kotlin

object Single {//这称为对象声明。并且它总是在 object 关键字后跟一个名称。 就像变量声明一样，对象声明不是一个表达式，不能用在赋值语句的右边。单例，对象声明的初始化过程是线程安全的并且在首次访问时进行


    var list: ArrayList<String>? = null

    init {
        list = ArrayList(10)
    }

    fun add(item: String) {
        list!!.add(item)
    }
}