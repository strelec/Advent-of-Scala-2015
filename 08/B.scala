println(io.Source.stdin.getLines.map(
	_.count(Seq('\\', '"').contains) + 2
).sum)
