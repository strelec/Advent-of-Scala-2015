val regex = raw"(.+) to (.+) = (\d+)".r

val distances = io.Source.stdin.getLines.map { case regex(a, b, distance) =>
	(a, b) -> distance.toInt
}.toMap

println(distances.keys.flatMap {
	case (a, b) => Seq(a, b)
}.toVector.permutations.map( path =>
	path.sliding(2).map { case Seq(a, b) =>
		distances.getOrElse((a, b), distances(b, a))
	}.sum
).min)
