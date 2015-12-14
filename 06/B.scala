val regex = raw"(toggle|turn off|turn on) (\d+,\d+) through (\d+,\d+)".r

def coor(s: String) = {
	val Array(a,b) = s.split(",")
	a.toInt -> b.toInt
}

val a = Array.fill(1000, 1000)(0)
for {
	regex(op, c1, c2) <- io.Source.stdin.getLines
	(x1, y1) = coor(c1)
	(x2, y2) = coor(c2)
	x <- x1 to x2
	y <- y1 to y2
} op match {
	case "toggle" => a(x)(y) += 2
	case "turn off" => a(x)(y) = math.max(0, a(x)(y) - 1)
	case "turn on" => a(x)(y) += 1
}

println(a.flatten.sum)
