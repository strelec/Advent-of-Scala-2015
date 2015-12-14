println(io.Source.stdin.getLines.map { line =>
	val nums = line.split("x").map(_.toInt)
	nums.product + 2 * nums.sorted.take(2).sum
}.sum)
