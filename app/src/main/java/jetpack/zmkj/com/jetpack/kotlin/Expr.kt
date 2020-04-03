package jetpack.zmkj.com.jetpack.kotlin

sealed class Expr
data class Const(val number: Double) : Expr()
data class Sum(val e1: Expr, val e2: Expr) : Expr()
object NotANumber : Expr()


/**
 *密封类不允许有非-private 构造函数（其构造函数默认为 private）。

请注意，扩展密封类子类的类（间接继承者）可以放在任何位置，而无需在同一个文件中。

使用密封类的关键好处在于使用 when 表达式 的时候，如果能够验证语句覆盖了所有情况，就不需要为该语句再添加一个 else 子句了。当然，这只有当你用 when 作为表达式（使用结果）而不是作为语句时才有用。

fun eval(expr: Expr): Double = when(expr) {
is Const -> expr.number
is Sum -> eval(expr.e1) + eval(expr.e2)
NotANumber -> Double.NaN
// 不再需要 `else` 子句，因为我们已经覆盖了所有的情况
}
 */
