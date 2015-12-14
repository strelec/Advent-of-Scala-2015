println(io.Source.stdin.getLines.map { line =>
	val nums = line.split("x").map(_.toInt)
	val Array(a, b, c) = nums
	2*(a*b + a*c + b*c) + nums.sorted.take(2).product
}.sum)
