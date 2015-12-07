val regex = raw"(toggle|turn off|turn on) (\d+,\d+) through (\d+,\d+)".r

def coor(s: String) = {
	val Array(a,b) = s.split(",")
	a.toInt -> b.toInt
}

val a = Array.fill(1000, 1000)(false)
for {
	regex(op, c1, c2) <- io.Source.stdin.getLines
	(x1, y1) = coor(c1)
	(x2, y2) = coor(c2)
	x <- x1 to x2
	y <- y1 to y2
} op match {
	case "toggle" => a(x)(y) = !a(x)(y)
	case "turn off" => a(x)(y) = false
	case "turn on" => a(x)(y) = true
}

println(a.flatten.count(identity))
