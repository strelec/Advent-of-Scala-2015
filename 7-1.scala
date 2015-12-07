val wires = io.Source.stdin.getLines.map { line =>
	val Array(ex, v) = line.split(" -> ")
	v -> ex
}.toMap

var memo = Map.empty[String, Int]

def get(v: String): Int =
	memo.getOrElse(v, {
		val res = if (v.head.isDigit)
			v.toInt
		else wires(v).split(" ") match {
			case Array(a, "AND", b) => get(a) & get(b)
			case Array(a, "OR", b) => get(a) | get(b)
			case Array("NOT", a) => ~get(a)
			case Array(a, "RSHIFT", b) => get(a) >> get(b)
			case Array(a, "LSHIFT", b) => get(a) << get(b)
			case Array(x) => get(x)
		}
		memo += v -> res
		res
	})

println(get("a"))
