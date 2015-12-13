val regex = raw"(.+) would (lose|gain) (\d+) happiness units by sitting next to (.+).".r

val distances = io.Source.stdin.getLines.map { case regex(a, sign, distance, b) =>
	(a, b) -> distance.toInt * (if (sign == "lose") -1 else 1)
}.toMap

println(distances.keys.flatMap {
	case (a, b) => Seq(a, b)
}.toVector.permutations.map { path =>
	val costs = (path :+ path.head).sliding(2).map { case Seq(a, b) =>
		distances(a, b) + distances(b, a)
	}.toVector
	costs.sum - costs.min
}.max)
