val maps = io.Source.stdin.getLines.map { line =>
	val Array(ex, v) = line.split(" -> ")
	v -> ex
}.toMap

var memo = Map.empty[String, Int]

def get(v: String): Int =
	memo.get(v) match {
		case Some(x) => x
		case None =>
			val res = if (v.head.isDigit)
				v.toInt
			else maps(v).split(" ") match {
				case Array(a, "AND", b) => get(a) & get(b)
				case Array(a, "OR", b) => get(a) | get(b)
				case Array("NOT", a) => ~get(a)
				case Array(a, "RSHIFT", b) => get(a) >> get(b)
				case Array(a, "LSHIFT", b) => get(a) << get(b)
				case Array(x) => get(x)
			}
			memo += (v -> res)
			res
	}

memo = Map("b" -> get("a"))
println(get("a"))
