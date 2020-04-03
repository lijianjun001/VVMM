package jetpack.zmkj.com.jetpack.kotlin

class Person constructor(firstName: String) {
    //在 Kotlin 中的一个类可以有一个主构造函数以及一个或多个次构造函数。主构造函数是类头的一部分：它跟在类名（与可选的类型参数）后。
    //如果主构造函数没有任何注解或者可见性修饰符，可以省略这个 constructor 关键字。
    val firstProperty = "First property: $firstName".also(::println)

    var single: Single = Single

    init {
        println("first initializer block that prints ${firstName}")
    }

    constructor(firstName: String, lastName: String) : this(firstName) {//如果类有一个主构造函数，每个次构造函数需要委托给主构造函数， 可以直接委托或者通过别的次构造函数间接委托。委托到同一个类的另一个构造函数用 this 关键字即可：
        //请注意，初始化块中的代码实际上会成为主构造函数的一部分。委托给主构造函数会作为次构造函数的第一条语句，因此所有初始化块与属性初始化器中的代码都会在次构造函数体之前执行。即使该类没有主构造函数，这种委托仍会隐式发生，并且仍会执行初始化块
    }

    fun getFirstName(): String {
        return firstProperty
    }

    var age: Int = 0
        get() = field
        set(value) {//如果我们定义了一个自定义的 setter，那么每次给属性赋值时都会调用它
            field = value
        }

    var sex: Boolean = false
        get() = field
        set(value) {//field 标识符只能用在属性的访问器内。防止进入死循环
            field = value
        }

    lateinit var height: Invoice//该修饰符只能用于在类体中的属性（不是在主构造函数中声明的 var 属性，并且仅当该属性没有自定义 getter 或 setter 时），而自 Kotlin 1.2 起，也用于顶层属性与局部变量。该属性或变量必须为非空类型，并且不能是原生类型。

    fun getUser() {
        val jane = User("Jane", 35)
        val (name, age) = jane
        single.add(jane.name)
    }

}